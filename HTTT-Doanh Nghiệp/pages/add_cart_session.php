<?php
//  Kết nối đến CSDL
include("../../config/dbconfig.php");
$idproduct =  $_GET['id'];
$name     = $_POST['name_product_session'];
$color    = $_POST['color'];
$size    = $_POST['size'];

// Chèn dữ liệu vào bảng tbl_product
$sql = "insert into tbl_order_session (idproduct,name,color,size) value('$idproduct','$name','$color','$size'";

// Cho thực thi câu lệnh SQL trên
$run = mysqli_query($conn, $sql);
echo '
        <script type="text/javascript">
            window.location.href="' . $site_url . '?page=cart";
        </script>';
?>
