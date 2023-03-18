<div id="main-content-wp" class="list-post-page">
    <div class="section" id="title-page">
        <div class="clearfix">
            <a href="?page=add_page" title="" id="add-new" class="fl-left">Thêm mới</a>
            <h3 id="index" class="fl-left">Danh sách trang</h3>
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
                                <?php echo mysqli_num_rows(mysqli_query($conn, "select * from tbl_page")); ?>
                            )</span> trang
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
                                    <td><span class="thead-text">ID</span></td>
                                    <td><span class="thead-text">Tiêu đề</span></td>
                                </tr>
                            </thead>
                            <tbody> 
                                <?php
                              // Bước 1: Kết nối đến CSDL
                                include("../config/dbconfig.php");
                                if (isset($_POST['s'])) {
                                    if ($_POST['s'] != '') {
                                    $s = $_POST['s'];
                                    $sql = "select * from tbl_page where id LIKE '%$s%' or title LIKE '%$s%' order by id desc limit $trang,8";
                                    }
                                    }else{
                                    $sql = "select * from tbl_page order by id desc limit $trang,8"; 
                                    }
                                $run = mysqli_query($conn, $sql);
                                $i = 0;
                                while ($row = mysqli_fetch_array($run)) {
                                  $i++;
                                  ;?>
                                <tr>
                                    <th scope="row"><?php echo $i;?></th>
                                    <td><span class="tbody-text"><?php echo $row["id"];?></h3></span>
                                    <td class="clearfix">
                                        <div class="tb-title fl-left">
                                            <a href="" title=""><?php echo $row["title"];?></a>
                                        </div>
                                        <ul class="list-operation fl-right">
                                            <li><a href="?page=change_page&id=<?php echo $row['id'];?>" title="Sửa" class="edit"><i class="fa fa-pencil" aria-hidden="true"></i></a></li>
                                            <li><a href="?page=delete_page&id=<?php echo $row['id'];?>" title="Xóa" class="delete"><i class="fa fa-trash" aria-hidden="true"></i></a></li>
                                        </ul>
                                    </td>
                                    
                                </tr>
                            <?php } ?>
                            </tbody>
                            <thead>
                                <tr style="font-weight: bold;">
                                    <td><span class="thead-text">STT</span></td>
                                    <td><span class="thead-text">ID</span></td>
                                    <td><span class="thead-text">Tiêu đề</span></td>
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
                            $sql_trang = "select * from tbl_page";
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
                                echo '<li><a href="?page=list_page&trang='.$b.'" style="text-decoration:none">'.' '.$b.' '.'</a></li>';
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