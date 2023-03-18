
<?php
   include '../connectdb/connect.php';
$id=$_GET['user_id'];
$sql="DELETE FROM user WHERE user_id=$id";
$query= mysqli_query($con, $sql);

header('location:qlkh.php');
?>

