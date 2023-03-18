<?php
    
    require '../connectdb/connect.php';
    session_start();
    $con = ketnoi();
    if(!isset($_SESSION['email'])){
        header('location: login.php');
    }
    $user_id=$_SESSION['id'];
    $user_products_query="select c.shoe_id,s.name,s.brand,c.size,s.price,c.quantity
                        from cart as c join shoes as s 
                        on c.shoe_id=s.shoe_id 
                        where c.user_id=$user_id and c.status='Added to cart'";
    $user_products_result=mysqli_query($con,$user_products_query) or die(mysqli_error($con));
    $no_of_user_products= mysqli_num_rows($user_products_result);
    $sum=0;
    if($no_of_user_products!=0){
        
        //echo "Add items to cart first.";
    ?>
        <!--<script>
        window.alert("No items in the cart!!");
        </script>-->
        
    <?php
    
        while($row=mysqli_fetch_array($user_products_result)){
            $sum=$sum+$row['price']*$row['quantity']; 
       }
    }
?>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="../img/lifestyleStore.png" />
        <title>Projectworlds Store</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- latest compiled and minified CSS -->
        <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" type="text/css">
        <!-- jquery library -->
        <script type="text/javascript" src="../bootstrap/js/jquery-3.2.1.min.js"></script>
        <!-- Latest compiled and minified javascript -->
        <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
        <!-- External CSS -->
        <link rel="stylesheet" href="../css/style.css" type="text/css">
        <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
    </head>
    <body>
        <div>
            <?php 
               require '../giaodien/header.php';
            ?>
            <br>
            <div class="container">
                <?php require '../xuly/xulycart.php';?>
            </div>
            <br><br><br><br><br><br><br><br><br><br>
            <footer class="footer">
               <div class="container">
                <center>
                   <p>Copyright &copy Store. All Rights Reserved.</p>
                   <!--<p>This website is developed by Yugesh Verma</p>-->
               </center>
               </div>
           </footer>
        </div>
    </body>
    <script type="text/javascript">
        function thongbao(){
            alert("Thay đổi thành công!");
        }
        document.getElementById("cfchange").onclick = thongbao;
        </script>
</html>
