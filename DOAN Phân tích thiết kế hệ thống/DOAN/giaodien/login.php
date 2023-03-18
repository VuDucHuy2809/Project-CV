<?php
    require '../connectdb/connect.php';
    $con = ketnoi();
    session_start();
?>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="../img/lifestyleStore.png" />
        <title>Projectworlds Store</title>
        <meta charset="uft8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- latest compiled and minified CSS -->
        <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" type="text/css">
        <!-- jquery library -->
        <script type="text/javascript" src="../bootstrap/js/jquery-3.2.1.min.js"></script>
        <!-- Latest compiled and minified javascript -->
        <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
        <!-- External CSS -->
        <link  type="text/css" rel="stylesheet" href="../css/style.css">
        <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
    </head>
    <body>
        <div>
            <?php
                require '../giaodien/header.php';
            ?>
            <br><br><br>
           <div class="container">
                <div class="row">
                    <div class="col-xs-6 col-xs-offset-3">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3>LOGIN</h3>
                            </div>
                            <div class="panel-body">
                                <p>Login to make a purchase.</p>
                                <form method="post" action="">
                                    <div class="form-group">
                                        <input id="m" type="text" class="form-control" name="email" placeholder="Email" onclick="clearerror()">
                                    </div>
                                    
                                    
                                    <div class="form-group">
                                        <input id="p" type="password" class="form-control" name="password" placeholder="Password(min. 6 characters)" onclick="clearerror()">
                                    </div>
                                    
                                    <div class="form-group">
                                        <input type="submit" name="submit" value="Login" class="btn btn-primary">
                                    </div>
                                    
                                    <?php require '../xuly/xulylogin.php';?>
                                </form>
                            </div>
                            <div class="panel-footer">Don't have an account yet? <a href="../giaodien/signup.php">Register</a></div>
                        </div>
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
        <script type="text/javascript">
            function clearerror(){
                arr = document.getElementsByClassName("error");
                for(var i=0;i<arr.length;i++){
                    arr[i].style.display = "none";
                }
                //alert("jdkajdsa");
            }
            //document.getElementById("m").click = clearerror;
            //document.getElementById("p").click = clearerror;
        </script>
    </body>
</html>
