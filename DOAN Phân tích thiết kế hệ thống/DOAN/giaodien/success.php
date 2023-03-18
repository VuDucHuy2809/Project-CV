
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
                <div class="row">
                    
                       
                            
                            
                                <!--<p>Your order is confirmed. Thank you for shopping with us. <a href="../giaodien/products.php">Click here</a> to purchase any other item.</p>-->
                                <?php //require '../xuly/xulysuccess.php';?>
                                <div class="col-xs-4 col-xs-offset-4">
                                    <h1>Nhập thông tin giao hàng</h1>
                                    <form method="post" action="../xuly/xulysuccess.php">
                                        <div class="form-group">
                                            <label for="rcname">Họ tên người nhận:</label>
                                            <input id="rcname" type="text" class="form-control" name="rcname" required="true">
                                        </div>
                                        <div class="form-group">
                                            <label for="rccontact">SĐT người nhận:</label>
                                            <input id="rccontact" type="tel" class="form-control" name="rccontact" required="true">
                                        </div>
                                        <div class="form-group">
                                            <label for="rcadd">Địa chỉ người nhận:</label>
                                            <input id="rcadd" type="text" class="form-control" name="rcadd" required="true">
                                        </div>
                                        <div class="form-group">
                                            <input type="submit" class="btn btn-primary" value="Xác nhận">
                                        </div>
                                    </form>
                                </div>
                            
                       
                   
                </div>
            </div>
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
</html>
