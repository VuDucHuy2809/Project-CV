
<?php

   $con = ketnoi();
$id=$_GET['id'];
$sql="DELETE FROM shoes WHERE shoe_id=$id";
$query= mysqli_query($con, $sql);
//echo $id;
header('location:admin.php');
?>
