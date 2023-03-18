<?php
include("../../config/dbconfig.php");
$id      = $_POST['id'];
$title   = $_POST['title'];
$content = $_POST['content'];

// Bước 2: Chèn dữ liệu vào bảng
if ($id == '' || $title == '' || $content == '') {
    echo '
		<script type="text/javascript">
			alert("Sửa danh mục lỗi. Vui lòng điền đầy đủ thông tin!!!");
			window.location.href="' . $site_admin . '?page=change_cat&id=$id";
		</script>';
} else {
    $sql = "UPDATE tbl_category SET title = '$title', content = '$content' WHERE id = '$id'";
}
// Cho thực thi câu lệnh SQL trên
$run = mysqli_query($conn, $sql);
echo '
		<script type="text/javascript">
			alert("Sửa danh mục thành công!!!");
			window.location.href="' . $site_admin . '?page=list_cat";
		</script>';
;
?>