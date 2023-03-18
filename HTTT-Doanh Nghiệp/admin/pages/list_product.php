<div id="main-content-wp" class="list-product-page">
    <div class="section" id="title-page">
        <div class="clearfix">
            <a href="?page=add_product" title="" id="add-new" class="fl-left">Thêm mới</a>
            <h3 id="index" class="fl-left">Danh sách sản phẩm</h3>
        </div>
    </div>
    <div class="wrap clearfix">
        <?php require 'inc/sidebar.php'; ?>
        <div id="content" class="fl-right">                       
            <div class="section" id="detail-page">
                <div class="section-detail">
                    <div class="filter-wp clearfix">
                        <ul class="post-status fl-left">
                            <li class="all">Tất cả <span class="count">(
                                <b style="color: #4fa327"><?php echo mysqli_num_rows(mysqli_query($conn, "select * from tbl_product")); ?></b>
                            )</span> mặt hàng
                            <li class="all"> | <span class="count">(<b style="color: #4fa327">
                                <?php 
                                    $tongsoluong = 0;
                                    $run0=mysqli_query($conn, "SELECT SUM(amount) as tongsoluong FROM tbl_product");
                                    $i = 0;
                                    while ($row0 = mysqli_fetch_array($run0)) {
                                  $i++; $tongsoluong += $row0['tongsoluong'];}echo $tongsoluong;
                                ?></b>
                            )</span> sản phẩm
                        </ul>
                        <form method="POST" action="" class="form-s fl-right">
                            <input type="text" name="s" id="s">
                            <input type="submit" name="sm_s" value="Tìm kiếm">
                        </form>
                    </div>
                                <?php
                                if(isset($_GET['trang'])){
                                    $get_trang = $_GET['trang'];
                                }
                                else{
                                    $get_trang = '';
                                }
                                if ($get_trang == '' || $get_trang == 1){
                                    $trang = 0;
                                }
                                else
                                {
                                    $trang = ($get_trang*8)-8;
                                }

                                ?>
                    <div class="table-responsive">
                        <table class="table list-table-wp">
                            <thead>
                                <tr style="color: #6603ff">
                                    <td><span class="thead-text"></span></td>
                                    <td><span class="thead-text">STT</span></td>
                                    <td><span class="thead-text">ID</span></td>
                                    <td><span class="thead-text">Số lượng</span></td>
                                    <td><span class="thead-text">Hình ảnh</span></td>
                                    <td><span class="thead-text">Tên sản phẩm</span></td>
                                    <td><span class="thead-text">Giá</span></td>
                                    <td><span class="thead-text">Danh mục</span></td>
                                </tr>
                            </thead>
                            <tbody>
    
                                 <?php
                              // Bước 1: Kết nối đến CSDL
                                include("../config/dbconfig.php");
                                

                              //Bước 2: Hiển thị các dữ liệu trong bảng ra đây
                                            
                                if (isset($_POST['s'])) {
                                    if ($_POST['s'] != '') {
                                    $s = $_POST['s'];
                                        $sql = "SELECT * from tbl_product where id like '%$s%' or name LIKE '%$s%' order by amount asc limit $trang,8";
                                    }
                                    }else{
                                        $sql = "SELECT * from tbl_product order by amount asc limit $trang,8"; 
                                    }
                                   $run = mysqli_query($conn,$sql);
                                   $i = 0; 
                                  while ($row = mysqli_fetch_array($run)) {
                                  $i++;
                                  ;?>

                                <tr>
                                    <td style="width: 7%;">
                                        <ul class="list-operation fl-left">
                                                <li><a href="?page=change_product&id=<?php echo $row['id'];?>" title="Sửa" class="edit"><i class="fa fa-pencil" aria-hidden="true"></i></a></li>
                                                <li><a href="?page=delete_product&id=<?php echo $row['id'];?>" title="Xóa" class="delete"><i class="fa fa-trash" aria-hidden="true"></i></a></li>
                                            </ul>
                                    </td>
                                    <th scope="row" style="width: 3%;"><?php echo $i;?></th>
                                    <td style="width: 3%;"><span class="tbody-text"><?php echo $row["id"];?></h3></span>
                                    <td><span class="tbody-text"><?php echo $row["amount"];?></h3></span>
                                    <td>
                                        <div class="tbody-thumb">
                                            <a href="?page=change_product&id=<?php echo $row['id'];?>">
                                            <img src="index.php/../../images/product/<?php echo $row['image']?>" alt="">
                                            </a>
                                        </div>
                                    </td>
                                    <td class="clearfix">
                                        <div class="tb-title fl-left">
                                            <a style="color: red;" href="?page=change_product&id=<?php echo $row['id'];?>" title=""><?php echo $row["name"];?></a>
                                        </div>
                                    </td>
                                    <td><span class="tbody-text"><?php echo $row["price"];?></span></td>
                                    <td><span class="tbody-text">
                                        <?php
                                           $sql1 = "SELECT * from tbl_category where id = ".$row["category"];
                                           $run1 = mysqli_query($conn,$sql1);
                                           $row1 = mysqli_fetch_array($run1);
                                            echo $row1['title'];
                                        ?>
                                    </span></td>
                                </tr>
                                  <?php
                              }
                              ;?>

                             
                            </tbody>
                            <thead>
                                <tr>
                                    <td></td>
                                    <td><span class="thead-text">STT</span></td>
                                    <td><span class="thead-text">ID</span></td>
                                    <td><span class="thead-text">Mã sản phẩm</span></td>
                                    <td><span class="thead-text">Hình ảnh</span></td>
                                    <td><span class="thead-text">Tên sản phẩm</span></td>
                                    <td><span class="thead-text">Giá</span></td>
                                    <td><span class="thead-text">Danh mục</span></td>
                                </tr>
                            </thead>
                        </table>
                       
                    </div>
                </div>
            </div>
            <div class="section" id="paging-wp">
                <div class="section-detail clearfix">
                    <ul id="list-paging" class="fl-right">
                        <li>
                            <a href="" title=""><</a>
                        </li>
                        <?php
                            $sql_trang = "select * from tbl_product order by amount asc";
                            $run_trang = mysqli_query($conn,$sql_trang);
                            $sosanpham = mysqli_num_rows($run_trang);
                            $sotrang = ceil($sosanpham/8);
                            if ($sotrang == 0){
                                echo ' Không có sản phẩm nào!';
                            }
                            else{ 
                                echo ' ';
                            }
                            for($b=1;$b<=$sotrang;$b++){
                                echo '<li><a href="?page=list_product&trang='.$b.'" style="text-decoration:none">'.' '.$b.' '.'</a></li>';
                            }
                            ?>
                        <li>
                            <a href="" title="">></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>