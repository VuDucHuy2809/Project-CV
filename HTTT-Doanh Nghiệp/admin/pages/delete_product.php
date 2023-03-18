<?php

$id = $_GET['id'];
include("../config/dbconfig.php");
// Xóa dữ liệu trong bảng		
$sql  = "DELETE from tbl_product where id = " . $id;
// Cho thực thi câu lệnh SQL trên
$sql2 = "DELETE from tbl_comment where idproduct = " . $id;
$run  = mysqli_query($conn, $sql);
$run2 = mysqli_query($conn, $sql2);

echo '
		<script type="text/javascript">
			alert("Xóa sản phẩm thành công!!!");
			window.location.href="' . $site_admin . '?page=list_product";
		</script>';
;
?>