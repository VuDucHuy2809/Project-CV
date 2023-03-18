<div id="main-content-wp" class="category-news-page">
   <div class="section" id="breadcrumb-wp">
      <div class="wp-inner">
         <div class="section-detail clearfix">
            <h3 class="title fl-left">Bài viết mới</h3>
            <ul class="list-breadcrumb fl-right">
               <li>
                  <a href="?page=home" title="">Trang chủ</a>
               </li>
               <li>
                  <a href="" title="">Bài viết mới</a>
               </li>
            </ul>
         </div>
      </div>
   </div>
   <div id="wrapper" class="wp-inner clearfix">
      <div id="content" class="fl-left">
         <div class="section" id="list-news-wp">
            <div class="section-detail">
               <?php 
                  include("config/dbconfig.php");
                  //Bước 2: Hiển thị các dữ liệu trong bảng ra đây
                  $sql = "select * from tbl_post";
                  $run = mysqli_query($conn, $sql);
                      $i = 0;
                      while ($row = mysqli_fetch_array($run)) {
                        $i++;
                  ?>
               <ul class="list-item">
                  <li class="clearfix">
                     <a href="?page=detail_news&id=<?php echo $row['id']; ?>" title="" class="thumb fl-left">
                     <img src="index.php/../images/post/<?php echo $row['image'] ?>" alt="">
                     </a>
                     <div class="info fl-right">
                        <a href="?page=detail_news&id=<?php echo $row['id']; ?>" title="" class="title"><?php echo $row['title'] ?></a>
                        <p class="desc"><?php echo $row['mota']; ?></p>
                     </div>
                  </li>
               </ul>
               <?php } ?>
            </div>
         </div>
      </div>
      <div id="sidebar" class="fl-right">
         <div class="section" id="category-wp">
            <div class="section-head">
               <h3 class="section-title">Danh mục</h3>
            </div>
            <div class="section-detail">
               <ul class="list-item">
                  <?php
                     // $cat = $_GET['id'];
                     
                     include("config/dbconfig.php");
                     $sql = "SELECT * from tbl_category";
                     $run = mysqli_query($conn, $sql);
                     $i = 0;
                     while ($row = mysqli_fetch_array($run)) {
                       $i++;
                     ;?>
                  <li>
                     <a href="?page=category_product&id=<?php echo $row['id']?>" title=""><?php echo $row['title']?></a>
                  </li>
                  <?php } ?>
               </ul>
            </div>
         </div>
         <div class="section" id="list-popular-wp">
            <div class="section-head">
               <h1 class="section-title">Sản phẩm mới</h1>
            </div>
            <div class="section-detail">
               <ul class="list-item">
                  <?php 
                     include("config/dbconfig.php");
                     $sql1 = "SELECT * from tbl_product order by id desc limit 6";
                     $run1 = mysqli_query($conn, $sql1);
                     $i = 0;
                     while ($row1 = mysqli_fetch_array($run1)) {
                     $i++;
                     ;?>
                  <li class="clearfix">
                     <a href="?page=detail_product&id=<?php echo $row1['id'];?>" title="" class="thumb fl-left">
                     <img src="index.php/../images/product/<?php echo $row1['image']?>" alt="">
                     </a>
                     <div class="info fl-right">
                        <a href="?page=detail_product&id=<?php echo $row1['id'];?>" title="" class="product-name"><?php echo $row1['name']?></a>
                        <span class="fee"><?php echo number_format($row1['sale']); ?> đ</span>
                        <a href="?page=detail_product&id=<?php echo $row1['id'];?>" title="" class="more">Xem chi tiết</a>
                     </div>
                  </li>
                  <?php } ?>
               </ul>
            </div>
         </div>
      </div>
   </div>
</div>