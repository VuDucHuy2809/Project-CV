<div id="main-content-wp" class="detail-news-page">
    <div class="section" id="breadcrumb-wp">
        <div class="wp-inner">
            <div class="section-detail clearfix">
                <h3 class="title fl-left">Thanh toán</h3>
                <ul class="list-breadcrumb fl-right">
                    <li>
                        <a href="?page=home" title="">Trang chủ</a>
                    </li>
                    <li>
                        <a href="" title="">Thanh toán</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div id="wrapper" class="wp-inner clearfix">
        <div id="content" class="fl-left">
            <div class="section" id="detail-news-wp">
                <div class="section-detail">
                    <?php 
                            include("config/dbconfig.php");
                          //Bước 2: Hiển thị các dữ liệu trong bảng ra đây
                            $id = $_GET['id'];
                           $sql = "select * from tbl_post where id = ".$id;
                           $run = mysqli_query($conn,$sql);
                           $row = mysqli_fetch_array($run);
                     ?>
                    <h3 class="title"><?php echo $row["title"];?></h3>
                    <div class="detail">
                        <?php echo $row["content"];?>
                    </div>
                </div>
            </div>
            <div class="section social-wp">
                <div class="section-detail">
                    <div class="fb-like" data-href="https://facebook.com/1707310909585150/" data-layout="button_count" data-action="like" data-size="small" data-show-faces="true" data-share="true"></div>
                    <div class="fb-comments" id="fb-comment" data-href="" data-numposts="5"></div>
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
                        </li><?php } ?>
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
                            $sql1 = "SELECT * from tbl_product limit 6";
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
                        </li><?php } ?>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>