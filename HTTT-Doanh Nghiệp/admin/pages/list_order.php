
<div id="main-content-wp" class="list-product-page">
    <div class="section" id="title-page">
        <div class="clearfix">
            <a href="?page=add_product" title="" id="add-new" class="fl-left">Thêm mới</a>
            <h3 id="index" class="fl-left">Đơn hàng</h3>
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
                                <?php echo mysqli_num_rows(mysqli_query($conn, "select * from tbl_oder")); ?>
                            )</span> đơn hàng
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
                                <tr>
                                    <td><span class="thead-text">STT</span></td>
                                    <td><span class="thead-text">Mã đơn hàng</span></td>
                                    <td><span class="thead-text">Họ và tên</span></td>
                                    <td><span class="thead-text">Số sản phẩm</span></td>
                                    <td><span class="thead-text">Tổng giá</span></td>
                                    <td><span class="thead-text">Trạng thái</span></td>
                                    <td><span class="thead-text">Chi tiết</span></td>
                                </tr>
                            </thead>
                            <tbody>
                                <?php
                              // Bước 1: Kết nối đến CSDL
                                include("../config/dbconfig.php");
                                if (isset($_POST['s'])) {
                                    if ($_POST['s'] != '') {
                                        $s = $_POST['s'];
                                        $sql = "select * from tbl_oder where id LIKE '%$s%' or tenkhachhang LIKE '%$s%' order by id desc limit $trang,8";
                                    }else {
                                        $sql = "select * from tbl_oder order by id desc limit $trang,8";
                                    }
                                }else{
                                    $sql = "select * from tbl_oder order by id desc limit $trang,8"; 
                                    }
                                $run = mysqli_query($conn, $sql);
                                $i = 0;
                                while ($row = mysqli_fetch_array($run)) {
                                  $i++;
                                ?>
                                <tr>
                                    <td><span class="tbody-text"><?php echo $i; ?></span>
                                    <td><span class="tbody-text"><?php echo $row["id"];?></span>
                                    <td>
                                        <div class="tb-title fl-left">
                                            <a href="?page=detail_order&id=<?php echo $row["id"];?>" title=""><?php echo $row["tenkhachhang"];?></a>
                                        </div>
                                        
                                    </td>
                                    <td><span class="tbody-text"><?php  
                                            $maOder = $row['id'];
                                            $sql2 = "select * from tbl_oder_detail where maOder = ".$maOder;; 
                                          //Bước 2: Hiển thị các dữ liệu trong bảng ra đây
                                            $run2 = mysqli_query($conn, $sql2);
                                            $j = 0;
                                            $tongsl=0;
                                            while ($row2 = mysqli_fetch_array($run2)) {
                                              $j++;
                                              $tongsl += $row2['soluong'];
                                          }
                                              echo $tongsl;
                                    ?></span></td>
                                    <td><span class="tbody-text"><?php echo number_format($row["tongtien"]);?></span></td>
                                    <td><span class="tbody-text"><?php echo $row['tinhtrang']; ?></span></td>
                                    <td><a href="?page=detail_order&id=<?php echo $row['id']; ?>" title="" class="tbody-text">Chi tiết</a></td>
                                </tr>
                            <?php } ?>
                            </tbody>
                            <tfoot style="font-weight: bold">
                                <tr>
                                    <td><span class="thead-text">STT</span></td>
                                    <td><span class="thead-text">Mã đơn hàng</span></td>
                                    <td><span class="thead-text">Họ và tên</span></td>
                                    <td><span class="thead-text">Số sản phẩm</span></td>
                                    <td><span class="thead-text">Tổng giá</span></td>
                                    <td><span class="thead-text">Trạng thái</span></td>
                                    <td><span class="thead-text">Chi tiết</span></td>
                                </tr>
                            </tfoot>
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
                            $sql_trang = "select * from tbl_oder";
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
                                echo '<li><a href="?page=list_oder&trang='.$b.'" style="text-decoration:none">'.' '.$b.' '.'</a></li>';
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