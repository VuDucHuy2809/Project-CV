<?php
    session_start();
    include '../connectdb/connect.php';
    require '../giaodien/check_if_added.php';
 
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
                require '../giaodien/header_products.php';
            ?>
            <!--<div class="container">
                <div class="jumbotron">
                    <h1>Welcome to our Projectworlds Store!</h1>
                    <p>We have the best cameras, watches and shirts for you. No need to hunt around, we have all in one place.</p>
                </div>
            </div>-->
            <div class="container">
                <?php require '../model/product_model.php';
                    $brand = $_GET['brand'];
                    $model = new product_model();
                    $result = $model->getProductsbybrand($brand);
                     
                ?>
                        <div class="result-sorting-wrapper">
                                <div class="sorting-count">
                                    <p><span class="brandname"><?php echo "Products of ".$brand." brand";?></span></p>
                                </div>
                        </div>
                <?php 
                    $row_count = ceil(mysqli_num_rows($result)/4);
                            //echo "<h2>$key</h2>";
                            while($row_count != 0){
                              
                      
                  ?>
                    <div class="row line">
                            <?php for($i = 0;$i<4;$i++) {
                                $row = mysqli_fetch_assoc($result);
                                if(!empty($row)){
                            ?>
                            <div class="col-md-3 col-sm-6 box">
                                <?php 
                                if(!isset($_SESSION['email'])){?>
                                   <a href="../giaodien/thongtinsp.php?shoeid=<?php echo $row["shoe_id"]?>">
                                        <img src="../<?php echo $row["image"];?>" >
                                    </a>
                                    <center>
                                        <div class="caption">
                                            <h3><?php echo $row["name"];?></h3>
                                            <p>Price: <?php echo $row["price"];?> Brand: <?php echo $row["brand"]?></p>

                                            <?php /*if(!isset($_SESSION['email'])){  ?>
                                            <p><a href="../giaodien/login.php" role="button" class="btn btn-primary btn-block">Buy Now</a></p>
                                                <?php
                                                }
                                                else{
                                                    if(check_if_added_to_cart(1)){
                                                        echo '<a href="#" class=btn btn-block btn-success disabled>Added to cart</a>';
                                                    }else{
                                                        ?>
                                                        <a href="../giaodien/cart_add.php?id=1" class="btn btn-block btn-primary" name="add" value="add" class="btn btn-block btr-primary">Add to cart</a>
                                                        <?php
                                                    }
                                                }*/
                                                ?>

                                        </div>
                                    </center>
                                <?php }
                                else {?>
                                    <a href="../giaodien/thongtinsp.php?shoeid=<?php echo $row["shoe_id"]?>">
                                        <img src="../<?php echo $row["image"];?>" >
                                    </a>
                                    <center>
                                        <div class="caption">
                                            <h3><?php echo $row["name"];?></h3>
                                            <p>Price: <?php echo $row["price"];?> Brand: <?php echo $row["brand"]?></p>

                                            <?php /*if(!isset($_SESSION['email'])){  ?>
                                            <p><a href="../giaodien/login.php" role="button" class="btn btn-primary btn-block">Buy Now</a></p>
                                                <?php
                                                }
                                                else{
                                                    if(check_if_added_to_cart(1)){
                                                        echo '<a href="#" class=btn btn-block btn-success disabled>Added to cart</a>';
                                                    }else{
                                                        ?>
                                                        <a href="../giaodien/cart_add.php?id=1" class="btn btn-block btn-primary" name="add" value="add" class="btn btn-block btr-primary">Add to cart</a>
                                                        <?php
                                                    }
                                                }*/
                                                ?>

                                        </div>
                                    </center>
                                <?php }?>
                            </div>

                                <?php }
                                    else{
                                        break;
                                    }
                                }?>
                        </div>
                    <?php 
                            $row_count--;
                        }
                        ?>        
            </div>
            <br><br><br><br><br><br><br><br>
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



