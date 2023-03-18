<?php
include("../../config/dbconfig.php");
$id         = $_POST['id'];
$title      = $_POST['title'];
$content    = $_POST['content'];
$mota       = $_POST['mota'];
// Upload hình ảnh
$image      = $_FILES["image"]["name"];
$fileanhtam = $_FILES["image"]["tmp_name"];
$result     = move_uploaded_file($fileanhtam, '../../images/post/' . $image);
// Bước 2: Chèn dữ liệu vào bảng
if ($title == '' || $content == '') {
    echo '
		<script type="text/javascript">
			alert("Sửa bài viết lỗi. Vui lòng điền đầy đủ thông tin!!!");
			window.location.href="' . $site_admin . '?page=change_post&id=$id";
		</script>';
} else {
    if ($image == NULL) {
        $sql = "UPDATE tbl_post SET title = '$title', content = '$content', mota = '$mota'  WHERE id = '$id'";
    } else {
        $sql = "UPDATE tbl_post SET title = '$title', content = '$content', image = '$image', mota = '$mota' WHERE id = '$id'";
    }
}
// Cho thực thi câu lệnh SQL trên
$run = mysqli_query($conn, $sql);
echo '
		<script type="text/javascript">
			alert("Sửa bài viết thành công!!!");
			window.location.href="' . $site_admin . '?page=list_post";
		</script>';
;
?>