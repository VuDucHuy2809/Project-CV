<?php

include "../model/product_model.php";
$b = new product_model();

if (isset($_POST['sub'])) {
    $id = $_POST['id'];
    $name = $_POST['ipname'];
    $price = $_POST['ipprice'];
    $brand = $_POST['brand_id'];
    $size = $_POST['size'];
    $quantity = $_POST['ipquantity'];
    //     if($_FILES['image']['name']==''){
    //        $file_name=$row_up['image'];
    //     }
    if (isset($_FILES['image'])) {
        $file = $_FILES['image'];
        $file_name = $file['name'];
        move_uploaded_file($file['tmp_name'], '../img/' . $brand . '/' . $file_name);
    }
    if (isset($_FILES['image2'])) {
        $file2 = $_FILES['image2'];
        $file_name2 = $file2['name'];
        move_uploaded_file($file2['tmp_name'], '../img/' . $brand . '/' . $file_name2);
    }
    if (isset($_FILES['image3'])) {
        $file3 = $_FILES['image3'];
        $file_name3 = $file3['name'];
        move_uploaded_file($file3['tmp_name'], '../img/' . $brand . '/' . $file_name3);
    }
    header('location:../giaodien/admin.php');
    $b->Sua($name, $price, $brand, $size, $quantity, $file_name, $file_name2, $file_name3, $id);
}

if (isset($_POST['sub2'])) {
    $id = $_POST['id'];
    $user_id = $_POST['user_id'];
    $email = $_POST['email'];
    $pass = $_POST['pass'];
    $sdt = $_POST['sdt'];
 header('location:../giaodien/qlkh.php');
    $b->Sua_user($user_id, $email, $pass, $sdt, $id);
}
?>