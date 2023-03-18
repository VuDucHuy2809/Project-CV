<?php 
   include("../config/dbconfig.php");
   $tongsoluong=0;
   if (isset($_POST['sm_status'])) {
   $tinhtrang = $_POST['status'];
   $id = $_GET['id'];
   $sql = "UPDATE tbl_oder SET tinhtrang = '$tinhtrang' WHERE id = '$id'";
   $run = mysqli_query($conn,$sql);
   }
   ?>
<div id="main-content-wp" class="list-product-page">
   <div class="section" id="title-page">
      <div class="clearfix">
         <a href="?page=add_product" title="" id="add-new" class="fl-left">Thêm mới</a>
         <h3 id="index" class="fl-left">Đơn hàng</h3>
      </div>
   </div>
   <div class="wrap clearfix">
      <?php require 'inc/sidebar.php'; ?>
      <div id="content" class="detail-exhibition fl-right">
         <div class="section" id="info">
            <div class="section-head">
               <h3 class="section-title">Thông tin đơn hàng</h3>
            </div>
            <?php
               // Bước 1: Kết nối đến CSDL
                include("../config/dbconfig.php");
                $id = $_GET["id"];
               //Bước 2: Hiển thị các dữ liệu trong bảng ra đây
                $sql = "select * from tbl_oder where id = ".$id;
                $run = mysqli_query($conn, $sql);
                         $i = 0;
                         while ($row = mysqli_fetch_array($run)) {
                           $i++;
               ?>
            <ul class="list-item">
               <li>
                  <h3 class="title">Tên khách hàng</h3>
                  <span class="detail"><?php echo $row["tenkhachhang"];?></span>
               </li>
               <li>
                  <h3 class="title">Mã đơn hàng</h3>
                  <span class="detail"><?php echo $row["id"];?></span>
               </li>
               <li>
                  <h3 class="title">Địa chỉ nhận hàng</h3>
                  <span class="detail"><?php echo $row["diachi"];?></span>
               </li>
               <li>
                  <h3 class="title">Thông tin vận chuyển</h3>
                  <span class="detail"><?php echo $row["hinhthuc"];?></span>
               </li>
               <li>
                  <h3 class="title">Ghi chú</h3>
                  <span class="detail"><?php echo $row["note"];?></span>
               </li>
               <form method="POST" action="">
                  <li>
                     <h3 class="title">Tình trạng đơn hàng</h3>
                     <select name="status">
                     <?php
                        $lst = array(
                            "Chờ duyệt",
                            "Đang vận chuyển",
                            "Thành công"
                        );
                        for ($i = 0; $i < count($lst); $i++) {
                            if ($lst[$i] == $row['tinhtrang']) {
                                echo "<option value='$lst[$i]' selected='selected'>$lst[$i]</option>";
                            } else {
                                echo "<option value='$lst[$i]'>$lst[$i]</option>";
                            }
                        }
                        ?>                           </select>
                     <input type="submit" name="sm_status" value="Cập nhật đơn hàng">
                  </li>
               </form>
            </ul>
         </div>
         <div class="section">
            <div class="section-head">
               <h3 class="section-title">Sản phẩm đơn hàng</h3>
            </div>
            <div class="table-responsive">
               <table class="table info-exhibition">
                  <thead>
                     <tr>
                        <td class="thead-text">STT</td>
                        <td class="thead-text">Ảnh sản phẩm</td>
                        <td class="thead-text">Tên sản phẩm</td>
                        <td class="thead-text">Đơn giá</td>
                        <td class="thead-text">Số lượng</td>
                        <td class="thead-text">Thành tiền</td>
                     </tr>
                  </thead>
                  <tbody>
                     <?php
                        $sql1 = "select * from tbl_oder_detail where maOder = ".$row['id'];
                        $run1 = mysqli_query($conn, $sql1);
                         $j = 0;
                         while ($row1 = mysqli_fetch_array($run1)) {
                           $j++;
                           
                            $sql2 = "select * from tbl_product where id = ".$row1['idproduct'];
                            $run2 = mysqli_query($conn, $sql2);
                             $k = 0;
                             while ($row2 = mysqli_fetch_array($run2)) {
                               $k++;
                        ?>
                     <tr>
                        <td class="thead-text"><?php echo $j; ?></td>
                        <td class="thead-text">
                           <div class="thumb">
                              <img src="index.php/../../images/product/<?php echo $row2["image"];?>" alt="">
                           </div>
                        </td>
                        <td class="thead-text"><?php echo $row2["name"];?></td>
                        <td class="thead-text"><?php echo number_format($row2["sale"]);?> VNĐ</td>
                        <td class="thead-text"><?php $tongsoluong+=$row1["soluong"]; echo $row1["soluong"];?></td>
                        <td class="thead-text"><?php echo(number_format($row2["sale"]*$row1["soluong"])) ?> VNĐ</td>
                     </tr>
                     <?php }} ?>
                  </tbody>
               </table>
            </div>
         </div>
         <div class="section">
            <h3 class="section-title">Giá trị đơn hàng</h3>
            <div class="section-detail">
               <ul class="list-item clearfix">
                  <li>
                     <span class="total-fee">Tổng số lượng</span>
                     <span class="total">Tổng đơn hàng</span>
                  </li>
                  <li>
                     <span class="total-fee"><?php echo $tongsoluong; ?> sản phẩm</span>
                     <span class="total"><?php echo number_format($row['tongtien']); ?> VNĐ</span>
                  </li>
                  <?php } ?>
               </ul>
            </div>
         </div>
      </div>
   </div>
</div>
</div>