<?php
    require '../connectdb/connect.php';
    require '../model/cart_model1.php';
    session_start();
    $con = ketnoi();
    $user_id = array();
    $user_id['userid']=$_SESSION['id'];
    $model = new cart_model1();
    $num = $model->getnumrowcart($user_id);
    $arrid = $model->getallidbyuser($user_id);
    $counter = $model->getfirstidbyuser($user_id);
    $dem = 1;
    while($num !=0){
       
        $qty = $_POST['qty-'.$dem];
        $idtemp = $arrid['id'.$counter];
        $query = "update cart set quantity=? where id=?";
        $stmt = mysqli_prepare($con, $query);
        mysqli_stmt_bind_param($stmt, "ii", $qty,$idtemp);
        mysqli_stmt_execute($stmt);
        $num--;
        $counter+=1;
        $dem+=1;
        /*$temp = $arrid;
        echo "<h2>$temp</h2>";
        $num--;*/
    }
    header('location:../giaodien/cart.php');
    
    /**/
?>

