<div id="main-content-wp" class="category-product-page">
   <div class="section" id="breadcrumb-wp">
      <div class="wp-inner">
         <div class="section-detail clearfix">
            <?php
               // $cat = $_GET['id'];
               $id = $_GET['id'];
               include("config/dbconfig.php");
               $sql = "SELECT * from tbl_category where id like '%$id%'";
               
               $run = mysqli_query($conn, $sql);
               $i = 0;
               while ($row = mysqli_fetch_array($run)) {
                 $i++;
               ;?>
            <h3 class="title fl-left"><?php echo $row['title']?></h3>
            <?php } ?>
            <ul class="list-breadcrumb fl-right">
               <li>
                  <a href="?page=home" title="">Trang chủ</a>
               </li>
               <?php
                  // $cat = $_GET['id'];
                  $id = $_GET['id'];
                  include("config/dbconfig.php");
                  $sql = "SELECT * from tbl_category where id like '%$id%'";
                  $run = mysqli_query($conn, $sql);
                  $i = 0;
                  while ($row = mysqli_fetch_array($run)) {
                    $i++;
                  ;?>
               <li>
                  <a title=""><?php echo $row['title']?></a>
               </li>
               <?php } ?>
            </ul>
         </div>
      </div>
   </div>
   <div class="section" id="filter-wp">
      <div class="wp-inner">
         <div class="section-detail">
            <ul class="list-item clearfix">
               <li>
                  <form method="POST" action="">
                     <select name="filter_price">
                        <option value="1">Lọc theo giá</option>
                        <option value="2">100.000đ - 200.000đ</option>
                        <option value="3">200.000đ - 300.000đ</option>
                        <option value="4">300.000đ - 400.000đ</option>
                        <option value="5">Trên 400.000đ</option>
                     </select>
                     <button type="submit" name="btn-filter-price" id="btn-filter-price">Lọc</button>
                  </form>
               </li>
               <li>
                  <form method="POST" action="" id="form-s-product">
                     <input type="text" name="s-product" id="s-product" placeholder="Tìm kiếm">
                     <button type="submit" name="btn-s-product" id="btn-s-product"><i class="fa fa-search" aria-hidden="true"></i></button>
                  </form>
               </li>
            </ul>
         </div>
      </div>
   </div>
   <?php
    if (isset($_GET['trang'])) {
        $get_trang = $_GET['trang'];
    } else {
        $get_trang = '';
    }
    if ($get_trang == '' || $get_trang == 1) {
        $trang = 0;
    } else {
        $trang = ($get_trang * 8) - 8;
    }


    ?>
   <div class="section" id="list-product-wp">
      <div class="wp-inner">
         <div class="section-detail">
            <ul class="list-item clearfix">
               <?php
                    $id = $_GET['id'];
                    include("config/dbconfig.php");
                    if (isset($_POST['filter_price'])) {
                        if (isset($_POST['s-product'])) {
                            if ($_POST['s-product'] != '') {
                                $s = $_POST['s-product'];
                                switch ($_GET['filter_price']) {
                                    case "1":
                                        $sql = "select * FROM tbl_product WHERE name like $s and soluong > 0  order by price desc limit $trang,8";
                                        break;
                                    case "2":
                                        $sql = "select * FROM tbl_product WHERE name like $s and soluong > 0   and price between 100000 and 200000 order by price desc limit $trang,8";
                                        break;
                                    case "3":
                                        $sql = "select * FROM tbl_product WHERE name like $s  and soluong > 0  and price between 200000 and 300000 order by price desc limit $trang,8";
                                        break;
                                    case "4":
                                        $sql = "select * FROM tbl_product WHERE name like $s and soluong > 0  and price between 300000 and 400000 order by price desc limit $trang,8";
                                        break;
                                    case "5":
                                        $sql = "select * FROM tbl_product WHERE name like $s and soluong > 0  and price price >= 500000 order by price desc limit $trang,8";
                                        break;
                                    default:
                                        $sql = "select * FROM tbl_product WHERE name like $s and soluong > 0  and order by price desc limit $trang,8";
                                        break;
                                }
                            }
                        } else {
                            switch ($_POST['filter_price']) {
                                case "1":
                                    $sql = "select * FROM tbl_product WHERE  price between 0 and 100000  and soluong > 0  order by price desc limit $trang,8";
                                    break;
                                case "2":
                                    $sql = "select * FROM tbl_product WHERE  price between 100000 and 200000  and soluong > 0 order by price desc limit $trang,8";
                                    break;
                                case "3":
                                    $sql = "select * FROM tbl_product WHERE  price between 200000 and 300000  and soluong > 0 order by price desc limit $trang,8";
                                    break;
                                case "4":
                                    $sql = "select * FROM tbl_product WHERE  price between 300000 and 400000  and soluong > 0 order by price desc limit $trang,8";
                                    break;
                                case "5":
                                    $sql = "select * FROM tbl_product WHERE  price >= 500000  and soluong > 0 order by price desc limit $trang,8";
                                    break;
                                default:
                                    $sql = "select * FROM tbl_product WHERE category like $id and soluong > 0  order by price desc limit $trang,8";
                                    break;
                            }
                        }
                    } else {
                        if (isset($_POST['s-product'])) {
                            if ($_POST['s-product'] != '') {
                                $s   = $_POST['s-product'];
                                $sql = "select * from tbl_product where id LIKE '%$s%' or name LIKE '%$s%'  and soluong > 0 order by price desc limit $trang,8";
                            }
                        } else {
                            $sql = "SELECT * from tbl_product where category like '%$id%' and soluong > 0  order by price asc  limit $trang,8";
                        }
                    }
                      $run = mysqli_query($conn, $sql);
                      $i = 0;
                      while ($row = mysqli_fetch_array($run)) {
                          $i++;
              ;?>
               <li>
                  <a href="?page=detail_product&id=<?php echo $row['id'];?>" title="" class="thumb">
                  <img src="index.php/../images/product/<?php echo $row['image']?>" alt="">
                  </a>
                  <div class="info">
                     <a href="" title="" class="name-product"><?php echo $row['name']?></a>
                     <div class="price-wp">
                        <span class="new"><?php echo number_format($row['sale']); ?></span>
                        <span class="old"><?php echo number_format($row['price']);?></span>
                     </div>
                     <a href="?page=add_cart&id=<?php echo $row['id'] ?>" title="" class="buy-now">Mua ngay</a>
                  </div>
               </li>
               <?php } ?>
            </ul>
         </div>
      </div>
   </div>
   <div class="section" id="pagination-wp">
      <div class="wp-inner">
         <div class="pagination">
            <?php
                $run_trang = mysqli_query($conn, "select * from tbl_product where category = $id and soluong > 0 ");
                $sosanpham = mysqli_num_rows($run_trang);
                $sotrang   = ceil($sosanpham / 8);
                if ($sotrang == 0) {
                    echo 'Không có sản phẩm nào!';
                } else {
                    echo '';
                    
                    for ($b = 1; $b <= $sotrang; $b++) {
                        echo '<a href="?page=category_product&id=' . $id = $_GET['id'] . '&trang=' . $b . '" style="text-decoration:none">' . '' . $b . '' . '</a>&ensp;';
                    }
                }
            ?>                      
         </div>
      </div>
   </div>
</div>