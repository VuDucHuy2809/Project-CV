<?php
//  Kết nối đến CSDL
include("../../config/dbconfig.php");

$title   = $_POST['title'];
$content = $_POST['content'];

// Upload hình ảnh
$image      = $_FILES["image"]["name"];
$fileanhtam = $_FILES["image"]["tmp_name"];
$result     = move_uploaded_file($fileanhtam, '../../images/page/' . $image);
if (!$result) {
    $image = NULL;
}

$sql = "insert into tbl_page (title,content,image) value('$title','$content','$image')";

$run = mysqli_query($conn, $sql);
echo '
		<script type="text/javascript">
			alert("Thêm mới trang thành công!!!");
			window.location.href="' . $site_admin . '?page=list_page";
		</script>';
;
?>