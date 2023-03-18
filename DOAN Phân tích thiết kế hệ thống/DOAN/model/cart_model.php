<?php
    
            require '../connectdb/connect.php';
            
            function getspdaco(){
                $con = ketnoi();
                $user = (int)$_POST['user'];
                $shoe = (int)$_POST['shoe'];
                $quantity = (int)$_POST['quantity'];
                $size = (int)$_POST['size'];
                $query2 = "select * from cart where user_id=$user and shoe_id=$shoe and size=$size and status='Added to cart'";
                $result = mysqli_query($con, $query2);
                $num_row = mysqli_num_rows($result);
                
                if($num_row!= 0){
                    while($row = mysqli_fetch_assoc($result)){
                        $qty = (int)$row["quantity"];
                        break;
                    }
                    return $qty;
                }
                
                return 0;
            }
            function updatecart(){
                $con = ketnoi();
                $user = (int)$_POST['user'];
                    $shoe = (int)$_POST['shoe'];
                    $quantity = (int)$_POST['quantity'];
                    $size = (int)$_POST['size'];
                    $newqty = getspdaco()+$quantity;
                    
                $query1 = "update cart set quantity=? where user_id=? and shoe_id=? and size=?";
                $stmt = mysqli_prepare($con, $query1);
                mysqli_stmt_bind_param($stmt,"iiii", $newqty,$user,$shoe,$size);
                mysqli_stmt_execute($stmt);
            }
            if(getspdaco() != 0){
                updatecart();
            }
            else{
                $con = ketnoi();
                $user = (int)$_POST['user'];
                    $shoe = (int)$_POST['shoe'];
                    $quantity = (int)$_POST['quantity'];
                    $size = (int)$_POST['size'];
                    date_default_timezone_set('Asia/Ho_Chi_Minh');
                    $date = date("Y-m-d H:i:s");
                $query = "insert into cart(user_id,shoe_id,size,quantity,status,add_date)"
                        . "values($user,$shoe,$size,$quantity,'Added to cart','$date')";
                mysqli_query($con, $query);
                /*$stmt = mysqli_prepare($con, $query);
                mysqli_stmt_bind_param($stmt, "iiiis", $user,$shoe,$quantity,$date);
                mysqli_stmt_execute($stmt);*/
            }
            echo json_encode(1);
            //$query = "insert into(name,brand,size,category,price,quantity_left,image)
        //values (ajsad,adidas,49,kjdkas,1000000,5,img/".tenhang."/".tenhinh.");"
?>
