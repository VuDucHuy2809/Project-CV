<?php
require '../connectdb/connect.php';
include "../model/product_model.php";
$b = new product_model();

if (isset($_POST['sub'])) {
    $id = $_POST['id'];
    $name = $_POST['ipname'];
    $price = $_POST['ipprice'];
    $brand = $_POST['brand_id'];
    $size38 = $_POST['size38'];
    $size39 = $_POST['size39'];
    $size40 = $_POST['size40'];
    $size41 = $_POST['size41'];
    //     if($_FILES['image']['name']==''){
    //        $file_name=$row_up['image'];
    //     }
    if (isset($_FILES['image'])) {
        $file = $_FILES['image'];
        $file_name = $file['name'];
        if($file_name != null){
            move_uploaded_file($file['tmp_name'], '../img/' . $brand . '/' . $file_name);
            $b->suahinh1($file_name, $brand,$id);
            
        }
        
    }
    if (isset($_FILES['image2'])) {
        $file2 = $_FILES['image2'];
        $file_name2 = $file2['name'];
        if($file_name2 != null){
            move_uploaded_file($file2['tmp_name'], '../img/' . $brand . '/' . $file_name2);
            $b->suahinh2($file_name2, $brand,$id);
           
        }
        
    }
    if (isset($_FILES['image3'])) {
        $file3 = $_FILES['image3'];
        $file_name3 = $file3['name'];
        if($file_name3 != null){
            move_uploaded_file($file3['tmp_name'], '../img/' . $brand . '/' . $file_name3);
            $b->suahinh3($file_name3, $brand,$id);
           
        }
        
    }
    header('location:../giaodien/admin.php');
    $b->Sua($name, $price, $brand, $size38,$size39,$size40,$size41, $id);
    
}

if (isset($_POST['sub2'])) {
    $id = $_POST['id'];
    //$user_id = $_POST['user_id'];
    $email = $_POST['email'];
    //$pass = $_POST['pass'];
    $sdt = $_POST['sdt'];
 
    $b->Sua_user($email, $sdt, $id);
    header('location:../giaodien/qlkh.php');
}
?>