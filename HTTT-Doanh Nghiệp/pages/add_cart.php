<?php
if (isset($_POST['submitcart'])) {
include("../config/dbconfig.php");
$idproduct = $_GET['id'];
$color    = $_POST['color'];
$size     = $_POST['size'];
$amounts   =  $_POST['select_amount'];

   class session
   {                                              
       function addElement($idproduct, $color, $size, $amounts)
       {   
          $this->idproduct=$idproduct;
          $this->color =  $color;
          $this->size =   $size;
          $this->amounts = $amounts;
       }
   }
$object_session = new session();

$array = array();
array_push($array,$object_session);	



$_SESSION['cartphp'] = $array;
if (isset($_SESSION['cart'][$idproduct])) {
        $amount += 1;
    } else {
        $amount = 1;
    }

$_SESSION['cart'][$idproduct] = $amount;
}
echo '
        <script type="text/javascript">
            window.location.href="' . $site_url . '?page=cart";
        </script>';
?>
