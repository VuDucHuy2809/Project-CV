<?php
    session_start();
    require '../connectdb/connect.php';
    if(!isset($_SESSION['email'])){
        header('location:index.php');
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
                require '../model/user_model.php';
                $model = new user_model();
                $result = $model->getInfo(intval($_SESSION['id']));
                $row = mysqli_fetch_assoc($result);
            ?>
            <br>
            <div class="container">
                <div class="row">
                    <div class="col-xs-4 col-xs-offset-4">
                        <h1>Change Information</h1>
                        <form method="post" action="../xuly/change_info_script.php">
                            <div class="form-group">
                                <label for="useremail">Your email:</label>
                                <input id="useremail" type="email" class="form-control" name="useremail" required="true" value="<?php echo $row['email'];?>">
                            </div>
                            <div class="form-group">
                                <label for="contact">Your contact:</label>
                                <input id="contact" type="tel" class="form-control" name="usercontact" required="true" value="<?php echo $row['sdt'];?>">
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btn btn-primary" value="Change">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <br><br><br><br><br>
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
