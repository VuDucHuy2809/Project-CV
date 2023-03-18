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
<?php $tongtien = 0; ?>
<div id="main-content-wp" class="checkout-page">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="location">
                            <ul>
                                <li><a href="index.html" title="go to homepage">Home<span>/</span></a>  </li>
                                <li><strong> checkout</strong></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
    <div class="container">
    <div id="wrapper" class="wp-inner clearfix">
        <div class="section" id="customer-info-wp">
            <div class="section-head">
                <h1 class="section-title">Thông tin khách hàng</h1>
            </div>
            <div class="section-detail">
                <form method="POST" action="pages/checkout_perform.php" name="form-checkout">
                    <div class="form-row clearfix">
                        <div class="form-col fl-left">
                            <label for="fullname">Họ tên</label>
                            <input type="text" name="tenkhachhang" id="fullname" required>
                        </div>
                        <div class="form-col fl-right">
                            <label for="email">Email</label>
                            <input type="email" name="email" id="email" required>
                        </div>
                    </div>
                    <div class="form-row clearfix">
                        <div class="form-col fl-left">
                            <label for="address">Địa chỉ</label>
                            <input type="text" name="diachi" id="address" required>
                        </div>
                        <div class="form-col fl-right">
                            <label for="phone">Số điện thoại</label>
                            <input type="tel" name="phone" id="phone" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-col">
                            <label for="notes">Ghi chú</label>
                            <textarea name="note"></textarea>
                        </div>
                    </div>
            </div>
        </div>
        <div class="section" id="order-review-wp">
            <div class="section-head">
                <h1 class="section-title">Thông tin đơn hàng</h1>
            </div>


            <div class="section-detail">
                <table class="shop-table">
                    <thead>
                        <tr>
                            <td>Sản phẩm</td>
                            <td>Tổng</td>
                        </tr>
                    </thead><?php 
                                    include("config/dbconfig.php");
                                    foreach ($_SESSION['cart'] as $idproduct=>$amounts) {
                                    $sql = "SELECT * from tbl_product where id=".$idproduct;
                                    $run = mysqli_query($conn, $sql);
                                    $i = 0;
                                    while ($row = mysqli_fetch_array($run)) {
                                        $i++;
                        ?>
                    <tbody>
                        <tr class="cart-item">
                            <td class="product-name"><?php echo $row['name']?><strong class="product-quantity">x <?php echo $amounts; ?></strong></td>
                            <td class="product-total"><?php $thanhtien = $amounts*$row['sale'];
                            echo number_format($thanhtien);$tongtien += $thanhtien;?></td>
                        </tr>
                    </tbody><?php } }?>
                    <tfoot>
                        <tr class="order-total">
                            <td>Tổng đơn hàng:</td>
                            <td><strong class="total-price"><?php echo number_format($tongtien); ?></strong> VNĐ</td>
                        </tr> 
                    </tfoot>
                </table>
                <div id="payment-checkout-wp">
                    <ul id="payment_methods">
                        <li>
                            <input type="radio" id="direct-payment" checked="checked" name="payment-method" value="Thanh toán tại cửa hàng">
                            <label for="direct-payment">Thanh Toán Khi Nhận Hàng</label>
                        </li>
                        <li>
                            <input type="radio" id="payment-home" name="payment-method" value="Thanh toán tại nhà">
                            <label for="payment-home">Thanh Toán Online</label>
                        </li>
                    </ul>
                </div>
                <div class="place-order-wp clearfix">
                    <input type="submit" id="order-now" value="Đặt hàng" name="ok">
                </div>
            </div>
                </form>
        </div>
    </div>
    </div>
    <br>
</div>