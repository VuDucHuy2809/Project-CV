<?php
//  Kết nối đến CSDL
include("../../config/dbconfig.php");

// Lấy các dữ liệu bên trang thêm mới
$title   = $_POST['title'];
$content = $_POST['content'];

// Chèn dữ liệu vào bảng tbl_category
$sql = "insert into tbl_category(title, content) value('$title', '$content')";

// Cho thực thi câu lệnh SQL trên
$run = mysqli_query($conn, $sql);
echo '
		<script type="text/javascript">
			alert("Thêm mới danh mục thành công!!!");
			window.location.href="' . $site_admin . '?page=list_cat";
		</script>';
;
?>