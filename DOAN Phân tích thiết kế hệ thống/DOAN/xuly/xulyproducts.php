<?php
        include_once '../model/product_model.php';
                    $product = new product_model();
                    $list = $product->getAllProducts();
                    $row_count = ceil(mysqli_num_rows($list)/4);
                    
                    while($row_count != 0){
                       
                    ?>
                        <div class="row line">
                            <?php for($i = 0;$i<4;$i++) {
                                $row = mysqli_fetch_assoc($list);
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
                    <?php $row_count--;
                    }
                    ?>

