<?php 
    session_start();
?>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> HTVC Admin</title>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
        <link rel="stylesheet" href="../bootstrap/css/admin.css">
        <link rel="stylesheet" href="../bootstrap/css/admin2.css">
        <link rel="stylesheet" href="/font-awesome/css/all.css">
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
                <h2 class="a0">Danh sách các hoá đơn đã thanh toán</h2>
                <table class="aa1"  > 
                    <tr class="aa2">
                        <th>#</th>
                        <th>User_id</th>
                        <th>Bill_id</th>
                        <th>Date</th>
                        <th>Total</th>
                    </tr>
                    <tbody>


                        <?php
                        include '../connectdb/connect.php';
                        $con = ketnoi();
                        //$sql = "SELECT shoes.shoe_id,SUM(cart.quantity),shoes.name,shoes.price FROM cart,shoes WHERE cart.shoe_id=shoes.shoe_id AND (cart.status='Paid' or cart.status='Shipped') GROUP BY shoe_id order by sum(cart.quantity) desc";
                        $sql = "select * from bill";
                        $query = mysqli_query($con, $sql);

                        $i = 1;
                        while ($row = mysqli_fetch_assoc($query)) {
                            ?>
                            <tr id="a1">     

                                <td><?php echo $i++; ?></td>
                                <td><?php echo $row['user']; ?></td>
                                <td><?php echo $row['bill_id']; ?></td>
                                <td><?php //echo $row['SUM(cart.quantity']; 
                                        echo $row['date'];?>
                                </td>
                                <td><?php echo $row['total']; ?></td>
                             
                            </tr>
                        <?php } ?>

                    </tbody>  
                </table>
            </div>
            <h4 class="total">
                <?php require '../model/bill_model.php';
                    $bill = new bill_model();
                    $result = $bill->gettotalprice();
                    while ($row = mysqli_fetch_assoc($result)) {
                        $total = $row['totalprice'];
                    }
                    echo "Tổng doanh thu:$total VNĐ";
                ?>
            </h4>

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