package vn.edu.hcmut.cse.adse.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Dùng @Controller, không dùng @RestController
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.hcmut.cse.adse.lab.service.StudentService;
import vn.edu.hcmut.cse.adse.lab.entity.Student;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/students")
public class StudentWebController {
    @Autowired
    private StudentService service;

    @GetMapping
    public String getAllStudents(@RequestParam(required = false) String keyword, Model model) {
        // 1. Lấy dữ liệu từ Service
        List<Student> students ;
        if (keyword != null && !keyword.isEmpty()) {
            students = service.searchByName(keyword);
        } else {
            students = service.getAll();
        }
        // 2. Đưa dữ liệu vào "Model" để chuyển sang View HTML
        model.addAttribute("dsSinhVien", students);
        // 3. Trả về tên file HTML (src/main/resources/templates/students.html)
        return "students";
    }

    //  Hiển thị Form Thêm mới 
    @GetMapping("/new")
    public String showAddForm(Model model) {
        Student student = new Student();
        model.addAttribute("sinhVien", student); // Tạo đối tượng trống để liên kết với Form
        return "student-form"; 
    }

    // Xử lý lưu dữ liệu (Cả Thêm mới và Cập nhật) 
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("sinhVien") Student student) {
        service.save(student);
        // Sau khi lưu xong, điều hướng (redirect) về trang danh sách 
        return "redirect:/students";
    }

    //  Hiển thị Form Chỉnh sửa (đã điền sẵn thông tin) 
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Student student = service.getById(id);
        model.addAttribute("sinhVien", student);
        return "student-form"; // Dùng chung form với chức năng Thêm mới
    }

    //  Xử lý Xóa sinh viên 
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        service.deleteById(id);
        return "redirect:/students";
    }
}