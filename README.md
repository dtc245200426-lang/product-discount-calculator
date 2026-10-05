# Product Discount Calculator

Bài tập Java Web: Java 17, Maven WAR, Jakarta Servlet 6.0, Tomcat 10.1.

Form index.jsp có Product Description, List Price, Discount Percent và gửi POST tới /display-discount.
DiscountServlet hiển thị dữ liệu nhập, Discount Amount và Discount Price.

- Discount Amount = List Price × Discount Percent × 0.01
- Discount Price = List Price − Discount Amount

Dùng BigDecimal để tính toán, kết quả tiền hiển thị hai chữ số thập phân, làm tròn HALF_UP. Giá không âm, phần trăm từ 0 đến 100, dữ liệu số nhập tối đa hai chữ số thập phân. Mô tả được escape HTML.

## Chạy

1. `mvn clean package`
2. Copy target/product-discount-calculator.war vào webapps của Tomcat 10.1 rồi khởi động server.
3. Mở http://localhost:8080/product-discount-calculator/.

Ví dụ: Headphones, 100, 20 → Discount Amount 20.00; Discount Price 80.00.
0% không giảm giá; 100% giá sau giảm bằng 0.00. Dữ liệu không hợp lệ trả HTTP 400.
