<?php 
	$slm = $_POST['slm'];
	$idproduct = $_POST['idproduct'];
	$_SESSION['cart'][$idproduct] = $slm;
 ?>