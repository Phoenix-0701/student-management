package vn.edu.hcmut.cse.adse.lab.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import vn.edu.hcmut.cse.adse.lab.repository.StudentRepository;
import vn.edu.hcmut.cse.adse.lab.entity.Student;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Student> searchByName(String keyword) {
        return repository.findByNameContainingIgnoreCase(keyword);
    }

    // Hàm dùng chung cho cả THÊM MỚI và CHỈNH SỬA
    public void save(Student student) {
        repository.save(student); 
    }

    // Hàm xử lý XÓA sinh viên theo ID.
    public void deleteById(String id) {
        repository.deleteById(id); 
    }



}
