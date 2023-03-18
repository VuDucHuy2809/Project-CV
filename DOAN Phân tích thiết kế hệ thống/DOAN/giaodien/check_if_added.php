<?php 
        
    
    function check_if_added_to_cart($item_id){
        //session_start();    
        $con = ketnoi();
        $user_id=$_SESSION['id'];
        $product_check_query="select * from cart where shoe_id=? and user_id=? and status='Added to cart'";
        if($stmt = mysqli_prepare($con, $product_check_query)){
            mysqli_stmt_bind_param($stmt, "ii", $item_id,$user_id);
            if(mysqli_stmt_execute($stmt)){
                $num_rows= mysqli_stmt_num_rows($stmt);
            }
            else {
                $num_rows = 0;
            }
        }
        
        //$product_check_result=mysqli_query($con,$product_check_query) or die(mysqli_error($con));
        //$num_rows=mysqli_num_rows($product_check_result);
        if($num_rows>=1)return 1;
        return 0;
    }
?>