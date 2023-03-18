<div id="main-content-wp" class="home-page">

        <!-- service area start -->
        <div class="service-area">
            <div class="container">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="single-service">
                            <div class="sirvice-img">
                                <img src="theme/img/service/icon-1.png" alt="">
                            </div>
                            <div class="service-info">
                                <h3>FREE SHIPPING</h3>
                                <p>Orders shipping to an eligible destination with at least the stated minimum threshold of eligible items, qualify for Free Shipping by James.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="single-service">
                            <div class="sirvice-img" style="width:25%;">
                                <img src="theme/img/service/icon-2.png"  alt="">
                            </div>
                            <div class="service-info">
                                <h3>24/7 Support</h3>
                                <p>We are always available to answer your questions</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="single-service">
                            <div class="sirvice-img">
                                <img src="theme/img/service/icon-1.png" alt="">
                            </div>
                            <div class="service-info">
                                <h3>FREE SHIPPING</h3>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- service area end -->

        <!-- new products area start -->
        <div class="new-product home2">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="product-title">
                            <h2>new products</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="features-home2-slider">
                        <?php
                      // $cat = $_GET['id'];
                    
                    include("config/dbconfig.php");
                    $sql = "SELECT * from tbl_product order by id desc limit 8";
                    $run = mysqli_query($conn, $sql);
                    $i = 0;
                    while ($row = mysqli_fetch_array($run)) {
                        $i++;
                        ;?>
                        <div class="col-md-12">
                            <div class="single-product">
                                <div class="level-pro-new">
                                    <span>new</span>
                                </div>
                                <div class="product-img">
                                    <a href="?page=detail_product&id=<?php echo $row['id'];?>" title="" class="thumb">
                                        <img src="index.php/../images/product/<?php echo $row['image']?>" class="primary-img-1" alt="">
                                        <?php 
                                        include("config/dbconfig.php");
                                         $id_temp = $row['id'];
                                        $sql_img = "SELECT file_name from tbl_img_product WHERE  id_product = '".$id_temp."' LIMIT 1" ;
                                        /*$sql_img = "SELECT file_name from tbl_img_product as A left JOIN tbl_product as B ON A.id_product=B.id LIMIT 2" ;*/
                                            $run_img = mysqli_query($conn, $sql_img);
                                            $i = 0; 
                                             while ($row2 = mysqli_fetch_array($run_img)) {
                                                $i++;
                                                ;?>
                                                <!-- <?php $array='primary-img-';?> -->
                                                <!-- <?php echo($array.$i) ?> -->
                                        <img src="index.php/../images/product/<?php echo $row2['file_name']?>" class="primary-img-2" alt="">
                                     <?php } ?>
                                    </a>
                                </div>
                                <div class="actions">
                                    <button onclick="location.href='?page=add_cart&id=<?php echo $row['id'] ?>'" type="submit" class="cart-btn" title="Add to cart">Buy Now</button>
                                    <ul class="add-to-link">
                                        <li><a class="modal-view" data-target="#productModal" data-toggle="modal" href="#"> <i class="fa fa-search"></i></a></li>
                                        <li><a href="#"> <i class="fa fa-heart-o"></i></a></li>
                                        <li><a href="#"> <i class="fa fa-refresh"></i></a></li>
                                    </ul>
                                </div>
                                <div class="product-price">
                                    <div class="product-name">
                                        <a href="?page=detail_product&id=<?php echo $row['id'];?>" title="" class="name-product"><?php echo $row['name']?></a>
                                    </div>
                                    <div class="price-rating">
                                        <span><?php echo number_format($row['sale']); ?></span>
                                        <small><?php echo number_format($row['price']); ?></small>
                                        <div class="ratings">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star-half-o"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    <?php } ?>

                    </div>


                 <?php
                  include("config/dbconfig.php");
                  $cat = "SELECT * from tbl_category order by id desc";
                  $runcat = mysqli_query($conn, $cat);
                  $c = 0;
                  while ($rowcat = mysqli_fetch_array($runcat)) {
                    $category =$rowcat['id'];
                    $c++;
                ;?>

                        <!-- feature products area start -->
                        <div class="features-product home2">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="product-title">
                                            <h2><?php echo $rowcat['title']?></h2>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="features-home2-slider">
                                         <?php
                                    include("config/dbconfig.php");
                                    $sql = "SELECT * from tbl_product where category = '$category' and amount > 0 order by id";
                                    $run = mysqli_query($conn, $sql);
                                    $i = 0;
                                    while ($row = mysqli_fetch_array($run)) {
                                        $i++;
                                        ;?>
                                        <div class="col-md-12">
                                            <div class="single-product">
                                                <div class="level-pro-new">
                                                    <span>new</span>
                                                </div>
                                                <div class="product-img">
                                                    <a href="?page=detail_product&id=<?php echo $row['id'];?>" title="" class="thumb">
                                                        <img src="index.php/../images/product/<?php echo $row['image']?>" class="primary-img-1" alt="">
                                                        <?php 
                                                        include("config/dbconfig.php");
                                                         $id_temp = $row['id']; /*echo $name_temp;*/
                                                        $sql_img = "SELECT file_name from tbl_img_product WHERE  id_product = '".$id_temp."' LIMIT 1" ;
                                                            $run_img = mysqli_query($conn, $sql_img);
                                                            $i = 0; 
                                                             while ($row2 = mysqli_fetch_array($run_img)) {
                                                                $i++;
                                                                ;?>
                                                        <img src="index.php/../images/product/<?php echo $row2['file_name']?>" class="primary-img-2" alt="">
                                                     <?php } ?>
                                                    </a>
                                                </div>
                                                <div class="actions">
                                                    <button onclick="location.href='?page=add_cart&id=<?php echo $row['id'] ?>'" type="submit" class="cart-btn" title="Add to cart">Buy Now</button>
                                                    <ul class="add-to-link">
                                                        <li><a class="modal-view" data-target="#productModal" data-toggle="modal" href="#"> <i class="fa fa-search"></i></a></li>
                                                        <li><a href="#"> <i class="fa fa-heart-o"></i></a></li>
                                                        <li><a href="#"> <i class="fa fa-refresh"></i></a></li>
                                                    </ul>
                                                </div>
                                                <div class="product-price">
                                                    <div class="product-name">
                                                        <a href="?page=detail_product&id=<?php echo $row['id'];?>" title="" class="name-product"><?php echo $row['name']?></a>
                                                    </div>
                                                    <div class="price-rating">
                                                        <span><?php echo number_format($row['sale']); ?></span>
                                                        <small><?php echo number_format($row['price']); ?></small>
                                                        <div class="ratings">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star-half-o"></i>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    <?php } ?>



                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- feature products area end -->


                <?php } ?>


                </div>
            </div>
        </div>
        <!-- new products area end -->

        

    <div style="margin-top: 30px;"></div>
</div>