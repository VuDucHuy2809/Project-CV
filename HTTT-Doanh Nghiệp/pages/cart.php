<script type="text/javascript" src="pages/cart.js"></script>
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
 
<div id="main-content-wp" class="cart-page">
           <!-- cart item area start -->
        <div class="shopping-cart">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="location">
                            <ul>
                                <li><a href="index.html" title="go to homepage">Home<span>/</span></a>  </li>
                                <li><strong> Shopping cart</strong></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">


                            <table class="table-bordered table table-hover">
                              <?php 
                  if (!isset($_SESSION['cart'])) {
                      $flag = false;
                  }else {
                      $flag = true;
                  }
                  if ($flag == true) {
                                      
                  ?>
                            <thead>
                                    <tr>
                                        <th class="cart-item-img"></th>
                                        <th class="cart-product-name">Product Name</th>
                                        <th class="unit-price">Unit Price</th>
                                        <th class="quantity">Qty</th>
                                        <th class="quantity">Color</th>
                                        <th class="quantity">Size</th>
                                        <th class="subtotal">Subtotal</th>
                                        <th class="remove-icon"></th>
                                    </tr>
                                </thead>
                                <tbody class="text-center">
                  <tr>
                    

                     <?php 
                        include("config/dbconfig.php");
                        $tongtien = 0;
                        $x=-1;
                        foreach ($_SESSION['cart'] as $idproduct=>$amount) {
                        $x++;
                        $sql_cart = "SELECT * from tbl_product where id=".$idproduct;
                        $run_cart = mysqli_query($conn, $sql_cart);
                        $u = 0;
                        $e= -1;
                        while ($row_cart = mysqli_fetch_array($run_cart)) {
                            $u++;
                            $e++;
                            //$test = get_object_vars($_SESSION["cartphp"][$e]);
                        ?>
                       <!-- <?php $test = get_object_vars($_SESSION["cartphp"][$e]);?> --> 
                     <input type="hidden" name="id" value='<?php echo $row_cart["id"];?>'>
                     <td class="cart-item-img">
                        <a href="" title="" class="thumb">
                        <img src="index.php/../images/product/<?php echo $row_cart['image']?>" alt="">
                        </a>
                     </td>

                     <td class="cart-product-name">
                        <a href="?page=detail_product&id=<?php echo $row_cart["id"];?>" title="" class="name-product"><?php echo $row_cart['name']?>
                        </a>
                     </td>
                     <td><?php echo number_format($row_cart['sale'])?></td>
                     <td>
                        <select style="width: 50px; height: 50px;" name="slm" class="num-order" data-idproduct="<?php echo $row_cart['id']; ?>">
                        <?php 
                           $i=1;
                           $test = get_object_vars($_SESSION["cartphp"][$x]);
                           $idproduct = (int)$test["idproduct"];
                            if ($row_cart['id']==$idproduct) {
                              $sl = $test["amounts"];
                            } else{
                             $sl = 1;
                            }
                           //$sl = $test["amounts"];
                           for ($i; $i <= $row_cart['amount']; $i++) {
                               if ($i == $sl) {
                                   echo "<option value='$i' selected='selected'>$i</option>";
                               }else{
                                   echo "<option value='$i'>$i</option>";
                               }
                           }
                           ?>
                        </select>
                     </td>
                     <td> 
                      <?php
                      $test = get_object_vars($_SESSION["cartphp"][$x]);
                      $idproduct = (int)$test["idproduct"];
                         if ($row_cart['id']==$idproduct) {
                          echo $test["color"];
                         } else{
                          echo "Default";
                         }
                      ?>

                    </td>


                     <td><?php
                     $test = get_object_vars($_SESSION["cartphp"][$x]);
                      $idproduct = (int)$test["idproduct"];
                         if ($row_cart['id']==$idproduct) {
                          echo $test["size"];
                         } else{
                          echo "Default";
                         }
                      ?>
                     </td>
                     <td><?php 
                     $sl=$test["amounts"];
                        $thanhtien = $sl*$row_cart['sale'];
                        echo number_format($thanhtien); 
                        $tongtien += $thanhtien;
                        ?></td>
                     <td>
                        <form action="pages/delete_cart.php">
                           <input type="hidden" name="id" value="<?php echo($row_cart['id']);?>">
                           <input style="border: 0px;background: white;color: #b4666c;" type="submit" name="" class="del-product" value="Xóa">
                        </form>
                     </td>
                  </tr>
                  <?php } };?>
               </tbody>
               <tfoot style="display: none;">
                  <tr>
                     <td colspan="7">
                        <div class="clearfix">
                           <div class="fl-right">
                              <?php 
                                 echo "<a href='?page=cart' title='' id='update-cart'>Cập nhật giỏ hàng</a>";
                                 echo "<a href='?page=checkout' title='Thanh toán' id='checkout-cart'>Thanh toán</a>";
                                 }else {
                                     echo "<a href='#' title='Giỏ hàng trống' id='checkout-cart'>Giỏ hàng trống</a>";
                                 }
                                 ?>
                           </div>
                        </div>
                     </td>
                  </tr>
               </tfoot>
            </table>

                            <div class="shopping-button">
                                <div class="continue-shopping">
                                    <button id="btnred" type="submit" onclick="location.href='?page=home'" >continue shopping</button>
                                </div>
                                <div class="shopping-cart-left">
                                    <button  id="btnred" type="submit" onclick="location.href='?pages/home_delete.php'">Clear Shopping Cart</button>
                                    <button  id="btnred" type="submit" id="update-cart" onclick="location.href='?page=cart'">Update Shopping Cart</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4" style="float: right;">
                        <div class="totals">
                            <p>subtotal <span><?php echo number_format($tongtien);?></span> </p>
                            <h3>Grand Total <span><?php echo number_format($tongtien);?></span></h3>
                            <div class="shopping-button">
                                <button  id="btnred" onclick="location.href='?page=checkout'" type="submit">proceed to checkout</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

</div>     
<?php $_SESSION['tongtien']=$tongtien; ?> 