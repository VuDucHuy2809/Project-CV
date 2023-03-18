<?php
    require '../connectdb/connect.php';
    session_start();
    $con = ketnoi();
    $item_id=$_GET['id'];
    $user_id=$_SESSION['id'];
    $delete_query="delete from cart where user_id=$user_id and shoe_id=$item_id";
    $delete_query_result=mysqli_query($con,$delete_query) or die(mysqli_error($con));
    header('location: ../giaodien/cart.php');
?>