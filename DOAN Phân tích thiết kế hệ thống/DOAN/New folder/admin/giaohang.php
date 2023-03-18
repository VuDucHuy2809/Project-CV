<?php
   include '../connectdb/connect.php';
$user_id=$_GET['userid'];
 $sql="UPDATE cart SET status= 'Shipped'  WHERE user_id = '$user_id'";
            $query=mysqli_query($con,$sql);
            header('location:ttgh.php');
?>
