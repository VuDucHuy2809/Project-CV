<?php 
    session_start(); ?>
<!DOCTYPE html>
<html class="no-js" lang="">
<head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title> Home || James </title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- favicon
        ============================================ -->
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
        <!-- Bootstrap CSS
        ============================================ -->
        <link rel="stylesheet" href="public/css/bootstrap.min.css">
        <!-- Bootstrap CSS
        ============================================ -->
        <link rel="stylesheet" href="public/css/font-awesome.min.css">
        <!-- owl.carousel CSS
        ============================================ -->
        <link rel="stylesheet" href="public/css/owl.carousel.css">
        <link rel="stylesheet" href="public/css/owl.theme.css">
        <link rel="stylesheet" href="public/css/owl.transitions.css">
        <!-- jquery-ui CSS
        ============================================ -->
        <link rel="stylesheet" href="public/css/jquery-ui.css">
        <!-- meanmenu CSS
        ============================================ -->
        <link rel="stylesheet" href="public/css/meanmenu.min.css">
        <!-- nivoslider CSS
        ============================================ -->
        <link rel="stylesheet" href="public/lib/css/nivo-slider.css">
        <link rel="stylesheet" href="public/lib/css/preview.css">
        <!-- animate CSS
        ============================================ -->
        <link rel="stylesheet" href="public/css/animate.css">
        <!-- magic CSS
        ============================================ -->
        <link rel="stylesheet" href="public/css/magic.css">
        <!-- normalize CSS
        ============================================ -->
        <link rel="stylesheet" href="public/css/normalize.css">
        <!-- main CSS
        ============================================ -->
        <link rel="stylesheet" href="public/css/main.css">
        <!-- style CSS
        ============================================ -->
        <link rel="stylesheet" href="public/style.css">
        <!-- responsive CSS
        ============================================ -->
        <link rel="stylesheet" href="public/css/responsive.css">
        <!-- modernizr JS
        ============================================ -->
        <script src="theme/js/vendor/modernizr-2.8.3.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

    </head>
    <body>
        <!-- Add your site or application content here -->
        <!-- header area start -->
        <header>
            <div class="top-link">
                <div class="container">
                    <div class="row">
                        <div class="col-md-7 col-md-offset-3 col-sm-9 hidden-xs">
                            
                            <div class="call-support">
                                <p>Call support free: <span> 0868 31 32 05</span></p>
                            </div>
                        </div>
                        <div class="col-md-2 col-sm-3">
                            <div class="dashboard">
                                <div class="account-menu">
                                    <ul>
                                        <li class="search">
                                            <a href="#">
                                                <i class="fa fa-search"></i>
                                            </a>
                                            <ul class="search">
                                                <li>
                                                    <form action="#">
                                                        <input type="text">
                                                        <button type="submit"> <i class="fa fa-search"></i> </button>
                                                    </form>
                                                </li>
                                            </ul>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i class="fa fa-bars"></i>
                                            </a>
                                            <ul>
                                                <li><a href="#">my account</a></li>
                                                <li><a href="#">my wishlist</a></li>
                                                <li><a href="#">my cart</a></li>
                                                <li><a href="#">Checkout</a></li>
                                                <li><a href="#">Log in</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                                <div class="cart-menu">
                                    <ul>
                                        <li><a href="#"> <img src="theme/img/icon-cart.png" alt=""> <span>2</span> </a>
                                            <div class="cart-info">
                                                <ul>
                                                    <li>
                                                        <div class="cart-img">
                                                            <img src="theme/img/cart/1.png" alt="">
                                                        </div>
                                                        <div class="cart-details">
                                                            <a href="#">Fusce aliquam</a>
                                                            <p>1 x $174.00</p>
                                                        </div>
                                                        <div class="btn-edit"></div>
                                                        <div class="btn-remove"></div>
                                                    </li>
                                                    <li>
                                                        <div class="cart-img">
                                                            <img src="theme/img/cart/2.png" alt="">
                                                        </div>
                                                        <div class="cart-details">
                                                            <a href="#">Fusce aliquam</a>
                                                            <p>1 x $777.00</p>
                                                        </div>
                                                        <div class="btn-edit"></div>
                                                        <div class="btn-remove"></div>
                                                    </li>
                                                </ul>
                                                <h3>Subtotal: <span> $951.00</span></h3>
                                                <a href="#" class="checkout">checkout</a>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mainmenu-area home2 bg-color-tr product-items">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="logo">
                                <a href="?page=home">
                                    <img src="theme/img/logo.png" alt="">
                                </a>
                            </div>
                        </div>
                        <div class="col-md-9">
                            <div class="mainmenu">
                                <nav>
                                    <ul>
                                        <li><a href="?page=home">Home</a>
                                        </li>
                                        <li class="mega-women"><a href="#">Women</a>
                                            <div class="mega-menu women">
                                                <div class="part-1">
                                                    <?php
                                                      include("config/dbconfig.php");
                                                      $sql = "SELECT * from tbl_category";
                                                      $run = mysqli_query($conn, $sql);
                                                      $i = 0;
                                                      while ($row = mysqli_fetch_array($run)) {
                                                        $i++;
                                                    ;?>
                                                    <span>
                                                        <a href="?page=category_product&id=<?php echo $row['id']?>"><?php echo $row['title']?></a>
                                                    </span>
                                                    <?php } ?>
                                                </div>
                                                <div class="part-2">
                                                    <a href="#">
                                                        <img src="theme/img/banner/menu-banner.png" alt="">
                                                    </a>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="mega-men"><a href="#">Men</a>
                                             <div class="mega-menu women">
                                                <div class="part-1">
                                                    <?php
                                                      include("config/dbconfig.php");
                                                      $sql = "SELECT * from tbl_category";
                                                      $run = mysqli_query($conn, $sql);
                                                      $i = 0;
                                                      while ($row = mysqli_fetch_array($run)) {
                                                        $i++;
                                                    ;?>
                                                    <span>
                                                        <a href="?page=category_product&id=<?php echo $row['id']?>"><?php echo $row['title']?></a>
                                                    </span>
                                                    <?php } ?>
                                                </div>
                                                <div class="part-2">
                                                    <a href="#">
                                                        <img src="theme/img/banner/menu-banner.png" alt="">
                                                    </a>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="mega-footwear"><a href="#">Footwear</a>
                                            <div class="mega-menu footwear">
                                                <span>
                                                    <a href="#">Footwear Man</a>
                                                    <a href="#">gifts</a>
                                                </span>
                                                <span>
                                                    <a href="#">Footwear Womens</a>
                                                    <a href="#">boots</a>
                                                </span>
                                            </div>
                                        </li>
                                        <li class="mega-jewellery"><a href="#">Jewellery</a>
                                            <div class="mega-menu jewellery">
                                                <span>
                                                    <a href="#">Rings</a>
                                                </span>
                                            </div>
                                        </li>
                                        <li><a href="#">accessories</a></li>
                                        
                                    </ul>
                                </nav>
                            </div>
                        </div>
                        <div class="col-sm-12">
                            <div class="mobile-menu">
                                <nav>
                                    <ul>
                                        <li><a href="?page=home">Home</a>
                                        </li>
                                        <li><a href="#">Women</a>
                                            <ul>
                                                <li><a href="#">Dresses</a>
                                                    <ul>
                                                        <li><a href="#">Coctail</a></li>
                                                        <li><a href="#">day</a></li>
                                                        <li><a href="#">evening</a></li>
                                                        <li><a href="#">sports</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">shoes</a>
                                                    <ul>
                                                        <li><a href="#">Sports</a></li>
                                                        <li><a href="#">run</a></li>
                                                        <li><a href="#">sandals</a></li>
                                                        <li><a href="#">boots</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">handbags</a>
                                                    <ul>
                                                        <li><a href="#">Blazers</a></li>
                                                        <li><a href="#">table</a></li>
                                                        <li><a href="#">coats</a></li>
                                                        <li><a href="#">kids</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">clothing</a>
                                                    <ul>
                                                        <li><a href="#">T-shirts</a></li>
                                                        <li><a href="#">coats</a></li>
                                                        <li><a href="#">Jackets</a></li>
                                                        <li><a href="#">jeans</a></li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Men</a>
                                            <ul>
                                                <li><a href="#">Bags</a>
                                                    <ul>
                                                        <li><a href="#">Bootees bag</a></li>
                                                        <li><a href="#">Blazers</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">clothing</a>
                                                    <ul>
                                                        <li><a href="#">coats</a></li>
                                                        <li><a href="#">T-shirts</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">Lingerie</a>
                                                    <ul>
                                                        <li><a href="#">Bands</a></li>
                                                        <li><a href="#">Furniture</a></li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Foorwear</a>
                                            <ul>
                                                <li><a href="#">footwear men</a>
                                                    <ul>
                                                        <li><a href="#">gifts</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">footwear women</a>
                                                    <ul>
                                                        <li><a href="#">boots</a></li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Jewellery</a>
                                            <ul>
                                                <li><a href="#">Rings</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Accessories</a></li>
                                        
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </header>
        <!-- header area end -->
                            <!-- slider area start -->
        <div class="slider-area home2">
            <div class="bend niceties preview-2">
                <div id="nivoslider" class="slides">
                    <?php 
                        include("config/dbconfig.php");
                        $sql = "SELECT * from tbl_banner  where active = 1 limit 3";
                        $run = mysqli_query($conn, $sql);
                        $i = 0;
                        $array ='#slider-direction-';
                        while ($row = mysqli_fetch_array($run)) {
                        $i++; 
                        ;?>
                         <img src="index.php/../images/banner/<?php echo $row['image']?>" alt=""title="<?php echo($array.$i);?>">
                        
                         <?php } ?>
                </div>
                <!-- direction 1 -->
                <div id="slider-direction-1" class="t-cn slider-direction">
                    <div class="slider-progress"></div>
                    <div class="slider-content t-lfl s-tb slider-1">
                        <div class="title-container s-tb-c title-compress">
                            <img src="theme/img/slider/slider-logo.png" alt="">
                            <h1 class="title1">Academy of sport</h1>
                            <h2 class="title2" >sports center james</h2>
                            <h3 class="title3" >Lorem Ipsum is simply dummy text of the printing</h3>
                            <a href="#"><span>read more</span></a>
                        </div>
                    </div>
                </div>
                <!-- direction 2 -->
                <div id="slider-direction-2" class="slider-direction">
                    <div class="slider-progress"></div>
                    <div class="slider-content t-lfl s-tb slider-2">
                        <div class="title-container s-tb-c">
                            <img src="theme/img/slider/slider-logo.png" alt="">
                            <h1 class="title1">Academy of sport2</h1>
                            <h2 class="title2" >sports center james</h2>
                            <h3 class="title3" >Lorem Ipsum is simply dummy text of the printing</h3>
                            <a href="#"><span>read more</span></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- slider area end -->
        