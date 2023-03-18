<?php 
    session_start();
?>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>HTVC Admin</title>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
        <link rel="stylesheet" href="../bootstrap/css/admin.css">
        <link rel="stylesheet" href="../bootstrap/css/admin2.css">
        <!--<link rel="stylesheet" href="/font-awesome/css/all.css">-->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


    </head>

    <body style="background-color: #F0F0F0;" data-spy="scroll" data-target="#myScrollspy" data-offset="1">
        <?php require '../giaodien/admin_menu.php';?>
        <div class="main">

            <div class="aa">
                <h2 class="a0">Chi tiết đơn hàng</h2>
                <table class="aa1"  > 
                    <tr class="aa2">
                        <th>#</th>
                       
                        <th>id</th>
                        <th>Tên mặt hàng</th>
                        <th>Giá</th>
                        <th>Size</th>
                        <th>Số lượng</th>
                        <th>Ngày giờ thanh toán</th>
                        <th>Tên người nhận</th>
                        <th>SĐT người nhận</th>
                        <th>Địa chỉ giao hàng</th>
                    </tr>
                    <tbody>


                        <?php
                        include '../connectdb/connect.php';
                        $con = ketnoi();
                         $user_id=$_GET['user_id'];
                        $sql = "SELECT shoes.shoe_id,cart.size,cart.quantity,cart.payment_time,cart.ten_nguoinhan,cart.sdt_nguoinhan,cart.diachi_giaohang,shoes.name,shoes.price
                                FROM cart,shoes 
                                WHERE cart.shoe_id=shoes.shoe_id AND user_id=$user_id and status='Paid'";
                        $query = mysqli_query($con, $sql);

                        $i = 1;
                        while ($row = mysqli_fetch_assoc($query)) {
                            ?>
                            <tr id="a1">     

                                <td><?php echo $i++; ?></td>
                                <td><?php echo $row['shoe_id']; ?></td>
                                <td><?php echo $row['name']; ?></td>
                                <td><?php echo $row['price']; ?></td>
                                <td><?php echo $row['size']; ?></td>
                                 <td><?php echo $row['quantity']; ?></td>
                                 <td><?php echo $row['payment_time']; ?></td>
                                 <td><?php echo $row['ten_nguoinhan']; ?></td>
                                 <td><?php echo $row['sdt_nguoinhan']; ?></td>
                                 <td><?php echo $row['diachi_giaohang']; ?></td>
                            </tr>
                        <?php } ?>

                    </tbody>  
                </table>
            </div>


        </div>
        <div>
            <footer class="footer">
               <div class="container">
                <center>
                   <p style="padding-top: 20px;">Copyright &copy Store. All Rights Reserved.</p>
                   <br><br><br>
                   <!--<p>This website is developed by Yugesh Verma</p>-->
               </center>
               </div>
           </footer>
        </div>


    </body>

</html>