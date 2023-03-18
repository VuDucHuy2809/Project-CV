<style type="text/css">
    .nivoSlider {
    position: relative;
    width: 100%;
    height: 292px;
    overflow: hidden;
}
#slider-direction-1 , #slider-direction-2{
    display: none!important;
}
.slider-content .title-container h1 ,.slider-content .title-container h2 ,.slider-content .title-container h3{
    display: none!important;
}
#main-content-wp{
    margin-top: -77px;
}

</style>
<?php
        include("config/dbconfig.php");
         $id = $_GET["id"];
         $sql = "select * from tbl_product where id = ".$id;
         $run = mysqli_query($conn,$sql);
         $row = mysqli_fetch_array($run);
         $cat = $row['category'];
?>

<div id="main-content-wp" class="detail-product-page">
            <!-- single product area start -->
        <div class="Single-product-location home2">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="location">
                            <ul>
                                <li><a href="?page=home" title="go to homepage">Home<span>/</span></a>  </li>
                                <li><strong> <?php echo $row["name"];?></strong></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- single product area end -->
        <!-- single product details start -->
        <div class="single-product-details">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="single-product-img tab-content">
                            <div class="single-pro-main-image tab-pane active" id="pro-large-img-1">
                                <a href="#">
                                    <img class="optima_zoom" src="index.php/../images/product/<?php echo $row["image"];?>"  data-zoom-image="index.php/../images/product/<?php echo $row["image"];?>">
                                </a>
                            </div>
                            <?php 
                                include("config/dbconfig.php");
                                $id = $_GET["id"];
                                $sql_img = "SELECT file_name from tbl_img_product WHERE  id_product =".$id ;
                                $run_img = mysqli_query($conn, $sql_img);
                                $i = 0; 
                                while ($row2 = mysqli_fetch_array($run_img)) {
                                $i++;
                                ;?>
                                <div class="single-pro-main-image tab-pane" id="pro-large-img-2">
                                    <a href="#">
                                    <img class="optima_zoom" src="index.php/../images/product/<?php echo $row2['file_name']?>" data-zoom-image="index.php/../images/product/<?php echo $row2['file_name']?>" alt="optima"/>
                                    </a>
                                </div>
                                <?php } ?>
                        </div>
                        <div class="product-page-slider">
                            <?php 
                                include("config/dbconfig.php");
                                $id = $_GET["id"];
                                $sql_img = "SELECT file_name from tbl_img_product WHERE  id_product =".$id ;
                                $run_img = mysqli_query($conn, $sql_img);
                                $i = 0; 
                                while ($row2 = mysqli_fetch_array($run_img)) {
                                $i++;
                                ;?>
                                <div class="single-product-slider">
                                <a href="#pro-large-img-1" data-toggle="tab">
                                    <img src="index.php/../images/product/<?php echo $row2['file_name']?>" alt="">
                                </a>
                                </div>
                                <?php } ?>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="single-product-details">
                            <a href="#" class="product-name"><?php echo $row["name"];?></a>
                            <div class="list-product-info">
                                <div class="price-rating">
                                    <div class="ratings">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star-half-o"></i>
                                        <a href="#" class="review">1 Review(s)</a>
                                        <a href="#" class="add-review">Add Your Review</a>
                                    </div>
                                </div>
                            </div>
                            <div class="avalable">
                                <p>Availability:<span> In stock</span></p>
                            </div>
                            <div class="item-price">
                                <span><?php echo number_format($row["sale"]);?>.$</span>
                                <span class="price-new" style="text-decoration: line-through;"><?php echo number_format($row["price"]);?>.$</span>


                            <form action="" method="POST">
                               <input type="hidden" name="namess" value="<?php echo $row["name"];?>">
                               <input type="hidden" name="idproductss" value="<?php echo number_format($row["id"]);?>">
                                <div class="select-catagory">
                                <div class="color-select">
                                    <label class="required">
                                        <em>*</em> Color
                                    </label>
                                    <div class="input-box">
                                        <select name="color" id="select-1">
                                            <option value="">-- Please Select --</option>
                                            <option value="Black">Black</option>
                                            <option value="Blue">Blue</option>
                                            <option value="Yellow">Yellow</option>
                                        </select>
                                    </div>
                                </div>
                               
                                <div class="size-select">
                                    <label class="required">
                                        <em>*</em> Size
                                    </label>
                                    <div class="input-box">
                                        <select name="size" id="select-2">
                                            <option value="">-- Please Select --</option>
                                            <option value="L">L</option>
                                            <option value="M">M</option>
                                        </select>
                                    </div>
                                </div>

                            </div>
                            <div class="cart-item">
                                <div class="single-cart">
                                    
                                        <label>Qty: </label>
                                        <select style="width: 100px; height: 50px;" name="select_amount" >
                                        <?php 
                                        include("config/dbconfig.php");
                                        $id = $_GET["id"];
                                        $sql_amount = "SELECT * from tbl_product where id=".$id;
                                        $run_amount = mysqli_query($conn, $sql_amount);
                                        $row_amount = mysqli_fetch_array($run_amount);
                                           $i=1;
                                           $amount = $row_amount["amount"];
                                           for ($i; $i <= $amount; $i++) {
                                                   echo "<option value='$i'>$i</option>";

                                           }
                                           ?>
                                        </select>
                                    <br>
                                    <input  id="add-to-cart" class="cart-btn" type="submit" name="submitcart" value="ADD TO CART">
                                    <input  id="buy-now" class="cart-btn" type="submit" name="buynow" value="BUY NOW">
                                    <!-- <a class="cart-btn" href="?page=add_cart&id=<?php echo $row['id'] ?>" title="" id="buy-now">BUY NOW</a> -->
                                </div>
                            </div>
                        </form>
                        <?php //session_destroy();?>
                                          <?php 
                                            if (isset($_POST['submitcart'])) {
                                                include("config/dbconfig.php");
                                                $idproductss =   (int)$_POST['idproductss'];
                                                $namess     = $_POST['namess'];
                                                $idproduct = $_GET['id'];
                                                $color    = $_POST['color'];
                                                $size     = $_POST['size'];
                                                $amounts   =  $_POST['select_amount'];

                                                class session
                                                {
                                                function addElement($idproduct,$color,$size,
                                                    $amounts)
                                                    {   
                                                       $this->idproduct=$idproduct;
                                                       $this->color =  $color;
                                                       $this->size =  $size;
                                                       $this->amounts = $amounts;
                                                    }
                                                }
                                                   $object_session = new session();
                                                   $object_session->addElement($idproduct, $color, $size, $amounts);
                                               if(!isset($_SESSION['cartphp']) || empty($_SESSION['cartphp'])){
                                                    $array = array();
                                                    array_push($array,$object_session);  
                                                    $_SESSION['cartphp']= $array;
                                                }else{
                                                    $array = $_SESSION['cartphp'];
                                                  array_push($array,$object_session);  
                                                  $_SESSION['cartphp']= $array;
                                                }
                                                if (isset($_SESSION['cart'][$idproduct])) {
                                                        $amount += 1;
                                                    } else {
                                                        $amount = 1;
                                                    }

                                                $_SESSION['cart'][$idproduct] = $amount;
                                               
                                            }
                                         ?> 

                                          <?php 
                                            if (isset($_POST['buynow'])) {
                                                include("config/dbconfig.php");
                                                $idproductss =   (int)$_POST['idproductss'];
                                                $namess     = $_POST['namess'];
                                                $idproduct = $_GET['id'];
                                                $color    = $_POST['color'];
                                                $size     = $_POST['size'];
                                                $amounts   =  $_POST['select_amount'];

                                                class session
                                                {
                                                    function addElement($idproduct, $color, $size, $amounts)
                                                    {   
                                                       $this->idproduct=$idproduct;
                                                       $this->color =  $color;
                                                       $this->size =   $size;
                                                       $this->amounts = $amounts;
                                                    }
                                                }
                                                $object_session = new session();
                                                   $object_session->addElement($idproduct, $color, $size, $amounts);
                                               if(!isset($_SESSION['cartphp']) || empty($_SESSION['cartphp'])){
                                                    $array = array();
                                                    array_push($array,$object_session);  
                                                    $_SESSION['cartphp']= $array;
                                                }else{
                                                    $array = $_SESSION['cartphp'];
                                                  array_push($array,$object_session);  
                                                  $_SESSION['cartphp']= $array;
                                                }
                                                if (isset($_SESSION['cart'][$idproduct])) {
                                                        $amount += 1;
                                                    } else {
                                                        $amount = 1;
                                                    }

                                                $_SESSION['cart'][$idproduct] = $amount;
                                               echo '
                                                <script type="text/javascript">
                                                    window.location.href="' . $site_url . '?page=cart";
                                                </script>';
                                            }
                                         ?> 
                            </div>
                            <div class="single-product-info">
                                <p><?php echo($row['description']);?></p>
                                <div class="share">
                                    <img src="public/img/product/share.png" alt="">
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- single product details end -->
        <!-- single product tab start -->
        <div class="single-product-tab-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="single-product-tab">
                            <ul class="single-product-tab-navigation" role="tablist">
                                <li role="presentation" class="active"><a href="#tab1" aria-controls="tab1" role="tab" data-toggle="tab">Product Description</a></li>
                                <li role="presentation"><a href="#tab2" aria-controls="tab2" role="tab" data-toggle="tab">comments</a></li>
                                <li role="presentation"><a href="#tab3" aria-controls="tab3" role="tab" data-toggle="tab">product tag</a></li>
                            </ul>

                            <!-- Tab panes -->
                            <div class="tab-content single-product-page">
                                <div role="tabpanel" class="tab-pane fade in active" id="tab1">
                                    <div class="single-p-tab-content">
                                        <p><?php echo($row['detail']);?></p>
                                    </div>
                                </div>
                                <div role="tabpanel" class="tab-pane fade" id="tab2">
                                    <div class="single-p-tab-content">
                                        <div class="row">
                                            <?php 
                                            include("config/dbconfig.php");
                                              $sql2 = "SELECT * from tbl_comment where idproduct=".$id;
                                              $run2 = mysqli_query($conn, $sql2);
                                              $i = 0;
                                              while ($row2 = mysqli_fetch_array($run2)) {
                                                $i++;
                                         ?>
                                         <div style="padding: 20px; border: 1px dotted gray; width: 100%; margin: 5px; border-radius: 10px;">
                                             <STRONG><?php echo $row2['namemember']; ?></STRONG>
                                             <hr>
                                             <p style="padding-left: 30px"><?php echo $row2['noidung']; ?></p>
                                         </div>
                                     <?php } ?>
                                        <form action="" method="POST" style="margin-top: 20px; border: 1px dotted gray; padding-left: 10px; padding-top: 5px; border-radius: 10px">
                                            <input style="margin-top: 10px;font-family: inherit; font-size: inherit; line-height: inherit; height: 40px;display: block;padding: 10px 10px;border: 1px solid #ddd;width: 35%;margin-bottom: 15px;" type="text" name="namemember" placeholder="Tên của bạn"><br>
                                            <textarea placeholder="Nội dung..." style="font-family: inherit; font-size: inherit; line-height: inherit; height: 50px;display: block;padding: 5px 10px;border: 1px solid #ddd;width: 95%;margin-bottom: 15px; resize: none;" name="noidung"></textarea><br>
                                            <input style="display: block;border: none;outline: none;background: #4fa327;color: #fff;padding: 8px 20px;margin-bottom: 50px;" type="submit" name="submitcomment" value="ADD COMMENT">
                                        </form>
                                        <?php 
                                            if (isset($_POST['submitcomment'])) {
                                                $idproduct = $row['id'];
                                                $namemember = $_POST['namemember'];
                                                $noidung = $_POST['noidung'];
                                                $sql1 = "insert into tbl_comment(idproduct, namemember, noidung) value('$idproduct', '$namemember', '$noidung')";
                                                $run1 = mysqli_query($conn, $sql1);
                                            }
                                         ?>
                                        </div>
                                    </div>
                                </div>
                                <div role="tabpanel" class="tab-pane fade" id="tab3">
                                    <div class="single-p-tab-content">
                                        <div class="add-tab-title">
                                            <p> add your tag </p>
                                        </div>
                                        <div class="add-tag">
                                            <form action="#">
                                                <input type="text">
                                                <button type="submit">add tags</button>
                                            </form>
                                        </div>
                                        <p class="tag-rules">Use spaces to separate tags. Use single quotes (') for phrases.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- single product tab end -->
        <!-- upsell product area start-->
        <div class="upsell-product home2">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="product-title">
                            <h2>new products</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="upsell-slider">
                        <?php 
                            include("config/dbconfig.php");
                            $sql_new = "SELECT * from tbl_product limit 6";
                            $run_new = mysqli_query($conn, $sql_new);
                            $i = 0;
                            while ($row_new = mysqli_fetch_array($run_new)) {
                            $i++;
                            ;?>
                            <div class="col-md-12">
                            <div class="single-product">
                                <div class="product-img">
                                    <a href="?page=detail_product&id=<?php echo $row_new['id'];?>">
                                        <img src="index.php/../images/product/<?php echo $row_new['image']?>" class="primary-img-1" alt="">
                                        <?php 
                                        include("config/dbconfig.php");
                                         $id_temp = $row_new['id'];
                                        $sql_img_new = "SELECT file_name from tbl_img_product WHERE  id_product = '".$id_temp."' LIMIT 1" ;
                                            $run_img_new = mysqli_query($conn, $sql_img_new);
                                            $i = 0; 
                                             while ($row_img_new = mysqli_fetch_array($run_img_new)) {
                                                $i++;
                                                ;?>
                                        <img src="index.php/../images/product/<?php echo $row_img_new['file_name']?>" class="primary-img-2" alt="">
                                     <?php } ?>
                                    </a>
                                </div>
                                <div class="list-product-info">
                                    <div class="price-rating">
                                        <div class="ratings">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star-half-o"></i>
                                            <a href="#" class="review">1 Review(s)</a>
                                            <a href="#" class="add-review">Add Your Review</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="product-price">
                                    <div class="product-name">
                                        <a href="?page=detail_product&id=<?php echo $row_new['id'];?>" title=""><?php echo $row_new['name']?></a>
                                    </div>
                                    <div class="price-rating">
                                        <span><?php echo number_format($row_new['sale']); ?>$</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <?php } ?>
                    </div>
                </div>
            </div>
        </div>
        <!-- upsell product area end-->
        <!-- related product area start-->
        <div class="related-product home2">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="product-title">
                            <h2>related products</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="related-slider">
                        <?php
                      include("config/dbconfig.php");
                      $sql_related = "SELECT * from tbl_product where category like '%$cat%'";
                      $run_related = mysqli_query($conn, $sql_related);
                      $i = 0;
                      while ($row_related = mysqli_fetch_array($run_related)) {
                        $i++;
                    ;?>
                    <div class="col-md-12">
                            <div class="single-product">
                                <div class="product-img">
                                    <a href="?page=detail_product&id=<?php echo $row1['id'];?>">
                                        <img src="index.php/../images/product/<?php echo $row_related['image']?>" class="primary-img-1" alt="">
                                        <?php 
                                        include("config/dbconfig.php");
                                         $id_temp = $row_related['id'];
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
                                <div class="list-product-info">
                                    <div class="price-rating">
                                        <div class="ratings">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star-half-o"></i>
                                            <a href="#" class="review">1 Review(s)</a>
                                            <a href="#" class="add-review">Add Your Review</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="product-price">
                                    <div class="product-name">
                                        <a href="?page=detail_product&id=<?php echo $row_related['id'];?>" title=""><?php echo $row_related['name']?></a>
                                    </div>
                                    <div class="price-rating">
                                        <span><?php echo number_format($row_related['sale']); ?>$</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <?php } ?>
                    </div>
                </div>
            </div>
        </div>
        <!-- related product area end-->
</div>