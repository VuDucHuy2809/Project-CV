<?php

include("../../config/dbconfig.php");
$id     = $_POST['id'];
$title  = $_POST['title'];
$active = $_POST['active'];


$image      = $_FILES["image"]["name"];
$fileanhtam = $_FILES["image"]["tmp_name"];
$result     = move_uploaded_file($fileanhtam, '../../images/banner/' . $image);
if (!$result) {
    $image = NULL;
}

if ($id == '' || $title == '' || $active == '') {
    echo '
		<script type="text/javascript">
			alert("Sửa bài viết lỗi. Vui lòng điền đầy đủ thông tin!!!");
			window.location.href="' . $site_admin . 'page=change_banner&id=$id";
		</script>';
} else {
    if ($image == NULL) {
        $sql = "UPDATE tbl_banner SET title = '$title', active = '$active'  WHERE id = '$id'";
    } else {
        $sql = "UPDATE tbl_banner SET title = '$title', active = '$active', image = '$image' WHERE id = '$id'";
    }
}

$run = mysqli_query($conn, $sql);
echo '
		<script type="text/javascript">
			alert("Sửa banner thành công!!!");
			window.location.href="' . $site_admin . '?page=list_banner";
		</script>';
;
?>