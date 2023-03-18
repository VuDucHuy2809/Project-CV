<?php
   // Kết nối đến CSDL
   include("../config/dbconfig.php");
   ?>
<div id="main-content-wp" class="add-cat-page">
   <div class="section" id="title-page">
      <div class="clearfix">
         <a href="?page=add_product" title="" id="add-new" class="fl-left">Thêm mới</a>
         <h3 id="index" class="fl-left">Sửa Banner</h3>
      </div>
   </div>
   <div class="wrap clearfix">
      <?php require 'inc/sidebar.php'; ?>
      <div id="content" class="fl-right">
         <div class="section" id="detail-page">
            <div class="section-detail">
               <form method="POST" action="pages/change_banner_perform.php" enctype="multipart/form-data">
                  <?php
                     // Bước 1: Kết nối đến CSDL
                      include("../config/dbconfig.php");
                      $id = $_GET["id"];
                     //Bước 2: Hiển thị các dữ liệu trong bảng ra đây
                      $sql = "select * from tbl_banner where id = ".$id;
                      $run = mysqli_query($conn,$sql);
                      $row = mysqli_fetch_array($run);
                     ?>
                  <input type="hidden" name="id" value='<?php echo $row["id"];?>'>
                  <label for="title">Tiêu Đề</label>
                  <input type="text" name="title" id="title" value="<?php echo $row["title"];?>">
                  <label>Hình ảnh</label>
                  <div id="uploadFile">
                     <input type="file" name="image" id="upload-thumb" >
                     <img style="width: 1600px; height: 400px" src="index.php/../../images/banner/<?php echo $row["image"];?>" alt="">
                  </div>
                  <label for="price">Thực Hiện</label>
                  <select name="active" id="active">
                <?php
                    for ($i = 0; $i <= 1; $i++) {
                        if ($i == $row["active"]) {
                            echo "<option value='$i' selected='selected'>$i</option>";
                        } else {
                            echo "<option value='$i'>$i</option>";
                        }
                    }
                ?>
                  </select>
                  <button type="submit" name="btn-submit" id="btn-submit">Sửa đổi</button>
               </form>
            </div>
         </div>
      </div>
   </div>
</div>