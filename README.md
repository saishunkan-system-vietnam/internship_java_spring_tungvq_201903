# internship_java_spring_tungvq_201903
Thực tập Java Spring - Web Bất động sản - Vũ Quang Tùng - 201903

2019/03/14
+ Thực hiện tạo controller view thông tin dự án (Tên dự án, Ngày dự định, Ngày thực hiện, Nội dung, Những người tham gia)
+ Tìm hiểu Thymleaf, xây dựng màn hình hiển thị thông tin dự án
+ Xây dựng màn hình insert, update, delete thông tin dự án


2019/03/25
+ Hoàn thành xử lý để hiển thị danh sách project, chi tiết project,thêm project, sửa project, xóa project
+ Xây dựng màn hình danh sách project, chi tiết project, thêm project, sửa project
+ Từ danh sách project có thể xóa project. . Cần có alert để xác nhận là có xóa hay không? . Xóa xong sẽ trở lại danh sách project
+ Từ danh sách project thêm button thêm project để sang trang thêm project
+ Từ danh sách project chèn thêm link vào tên project để có thể xem được chi tiết thông tin project
+ Trong chi tiết project thêm button sửa để sang trang sửa project, thêm button quay lại để quay lại danh sách project
+ Trong màn hình thêm project có button quay lại danh sách project và button lưu project
+ Trong màn hình sửa project có button quay lại chi tiết project và button lưu project

=============================================================================
CÔNG VIỆC NGHIỆM THU

Tạo 2 bảng trong cơ sở dữ liệu

[project]
id int tự tăng
name varchar(1000)
start_date timestamp
end_date timestamp
building_id int

[building]
id int tự tăng
name varchar(1000)
area float
floor int

Yêu cầu:
Tạo màn hình thêm, sửa, xóa building
Tạo màn hình danh sách building có chức năng tìm kiếm theo:
 + tên
 + diện tích from to (2 ô input)
 + số tầng from to (2 ô input)

Tạo màn hình thêm, sửa, xóa project
Thêm liên kết building với project thông qua building_id (nâng cao)
Tạo màn hình danh sách project có chức năng tìm kiếm theo 
 + tên
 + ngày bắt đầu
 + ngày kết thúc
 + tên building (nâng cao)

=============================================================================
Tiếp tục trainning API (2019/04/10)


+ Tạo API tìm kiếm trên danh sách project
+ Tạo API thêm, sửa, xóa building
+ Tạo API thêm, sửa, xóa project
