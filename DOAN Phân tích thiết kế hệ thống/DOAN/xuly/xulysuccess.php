<?php
    session_start();
    require '../connectdb/connect.php';
    require '../model/cart_model1.php';
    require '../model/bill_model.php';
    require '../model/detailbill_model.php';
    if(!isset($_SESSION['email'])){
        header('location:index.php');
    }else{
        $con = ketnoi();
        $user_id = $_SESSION['id'];
        date_default_timezone_set('Asia/Ho_Chi_Minh');
        $_SESSION['paymenttime'] = date("Y-m-d H:i:s");
        $payment_time = $_SESSION['paymenttime'];
        $rcname = mysqli_real_escape_string($con,$_POST['rcname']);
        $rccontact = mysqli_real_escape_string($con,$_POST['rccontact']);
        $rcadd = mysqli_real_escape_string($con,$_POST['rcadd']);
        $confirm_query="update cart set status='Paid',payment_time='$payment_time',ten_nguoinhan=N'$rcname',sdt_nguoinhan='$rccontact',diachi_giaohang=N'$rcadd' "
                . "where user_id=? and status='Added to cart'";
        $stmt = mysqli_prepare($con, $confirm_query);
        //$confirm_query_result=mysqli_query($con,$confirm_query) or die(mysqli_error($con));
        mysqli_stmt_bind_param($stmt,"i", $user_id);
        mysqli_stmt_execute($stmt);
        //$date = date("Y-m-d");
        $total = $_SESSION['total'];
        $bill = new bill_model();
        $bill->insertbill($user_id, $payment_time, $total);
        $detailbill = new detailbill_model();
        $detailbill->insertdetailbill();
        if(mysqli_stmt_affected_rows($stmt) != 0){
            
    
?>
                
                     <script>alert("Đơn hàng của bạn đã được thanh toán. Cám ơn bạn đã mua sắm!");
                      window.location='../giaodien/products.php';
                     </script> 
                       
    <?php 
            $model = new cart_model1();
            /*$model->emptycart($user_id);*/
        }
        else{
          
    ?>
                      <script>alert("Đã xảy ra sự cố! Đơn hàng không thể thanh toán");
                      window.location='../giaodien/cart.php';
                      </script> 
    <?php }
    
        } ?>

