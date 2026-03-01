Dự Án Quản Lý Sinh Viên
1. Thông tin nhóm
   Phạm Nguyễn Thế Anh - 2310143
   
2. Link ứng dụng (Public URL):
   https://www.google.com/search?q=https://student-management-0tpy.onrender.com/students
   
3. Hướng dẫn chạy dự án:
a. Chạy dưới local (Maven):
- Cấu hình các biến môi trường trong file .env có nội dung như sau:
DATABASE_URL=jdbc:postgresql://neondb_owner:npg_2ad3CIuiyJEr@ep-nameless-term-a1xvcgzf-pooler.ap-southeast-1.aws.neon.tech/neondb?sslmode=require&channel_binding=require
DB_USERNAME=neondb_owner 
DB_PASSWORD=npg_2ad3CIuiyJEr
- Mở terminal tại thư mục gốc và chạy lệnh: ./mvnw spring-boot:run
- Truy cập: http://localhost:8080/students
b. Chạy bằng Docker:
- Build image: docker build -t student-management .
- Chạy container: docker run -p 8080:8080 student-management

4. Trả lời câu hỏi lý thuyết:
Lab 1: Khởi tạo dự án & Spring Boot cơ bản
Câu hỏi: Tại sao nên sử dụng Maven thay vì tải các file thư viện (.jar) thủ công?
Trả lời: Maven giúp quản lý các phụ thuộc (dependencies) một cách tự động thông qua file pom.xml, giúp tránh xung đột phiên bản và giảm kích thước mã nguồn khi lưu trữ trên Git.
Câu hỏi: Spring Initializr đóng vai trò gì?
Trả lời: Đây là công cụ giúp tạo nhanh cấu trúc dự án Spring Boot với các cấu hình cơ bản và thư viện cần thiết để bắt đầu lập trình ngay lập tức.
Lab 2: Kiến trúc MVC & Cơ sở dữ liệu SQLite
Câu hỏi: Kiến trúc MVC (Model-View-Controller) giúp ích gì trong việc phát triển phần mềm?
Trả lời: MVC giúp tách biệt rõ ràng giữa logic xử lý (Controller), dữ liệu (Model) và giao diện người dùng (View), giúp mã nguồn dễ bảo trì và mở rộng.
Câu hỏi: Tại sao chọn SQLite cho giai đoạn phát triển ban đầu?
Trả lời: SQLite là hệ quản trị cơ sở dữ liệu dạng file đơn giản, không cần cài đặt server phức tạp, phù hợp cho việc demo và phát triển nhanh dưới môi trường local.
Lab 3: Spring Data JPA & Chức năng Tìm kiếm
Câu hỏi: Cơ chế Derived Query Methods trong Spring Data JPA là gì?
Trả lời: Đây là cơ chế cho phép Spring tự động sinh ra câu lệnh SQL dựa trên tên hàm khai báo trong Repository (ví dụ: findByNameContainingIgnoreCase), giúp giảm thiểu việc viết SQL thủ công.
Câu hỏi: @RequestParam khác gì so với @PathVariable?
Trả lời: @RequestParam dùng để lấy tham số từ query string (ví dụ: ?keyword=abc), thường dùng cho tìm kiếm; trong khi @PathVariable dùng để lấy tham số trực tiếp từ đường dẫn (ví dụ: /edit/123), thường dùng để định danh tài nguyên.
Lab 4: PostgreSQL & Bảo mật thông tin cấu hình
Câu hỏi: Tại sao cần chuyển từ SQLite sang PostgreSQL khi triển khai thực tế?
Trả lời: PostgreSQL trên Cloud (như Neon.tech) cung cấp khả năng lưu trữ mạnh mẽ, hỗ trợ nhiều kết nối đồng thời và đảm bảo dữ liệu không bị mất khi ứng dụng khởi động lại trên server.
Câu hỏi: Tác dụng của file .env và biến môi trường là gì?
Trả lời: Giúp tách biệt thông tin nhạy cảm (mật khẩu database) khỏi mã nguồn, ngăn chặn việc lộ thông tin khi đẩy code lên GitHub.
Lab 5: Docker & Cloud Deployment
Câu hỏi: Docker giải quyết vấn đề "It works on my machine" như thế nào?
Trả lời: Docker đóng gói ứng dụng cùng toàn bộ môi trường chạy (JRE, thư viện) vào một container, đảm bảo ứng dụng chạy đồng nhất trên mọi nền tảng từ máy cá nhân đến Cloud (Render).
Câu hỏi: Tại sao nên dùng Multi-stage build trong Dockerfile?
Trả lời: Giúp tách biệt quá trình biên dịch (Build stage) và quá trình chạy (Run stage), từ đó tạo ra Image cuối cùng có kích thước nhỏ gọn và bảo mật hơn.

5. Hình ảnh minh họa (Screenshots Lab 4)
- Ảnh danh sách sinh viên và tìm kiếm:
  <img width="2559" height="1465" alt="image" src="https://github.com/user-attachments/assets/2bad9492-32c9-44ad-885f-c9939188b9d5" />
- Ảnh thêm sinh viên mới và danh sách sinh viên sau khi thêm:
  <img width="2556" height="1474" alt="image" src="https://github.com/user-attachments/assets/fcdce694-29f4-4207-98e5-ee090eac25a0" />
  <img width="2559" height="1468" alt="image" src="https://github.com/user-attachments/assets/d7c91470-c268-4d58-87cc-5cfb6f017deb" />
- Ảnh chỉnh sửa cập nhật thông tin sinh viên ( Lê Bảo ) và danh sách sau chỉnh sửa:
  <img width="2559" height="1469" alt="image" src="https://github.com/user-attachments/assets/9e69700d-59ed-46da-a02a-13cad957094e" />
  <img width="2559" height="1465" alt="image" src="https://github.com/user-attachments/assets/57179759-a3c9-4c3d-b182-3171bb9984e1" />
- Ảnh xóa sinh viên (Hoàng Minh) và danh sách sau khi xóa:
  <img width="2559" height="1404" alt="image" src="https://github.com/user-attachments/assets/d0ae7b3a-c67f-4efd-8c80-23a7fafa4a06" />
  <img width="2559" height="1453" alt="image" src="https://github.com/user-attachments/assets/81aa0e9e-4987-40f9-ae57-afa0830e6b9f" />







