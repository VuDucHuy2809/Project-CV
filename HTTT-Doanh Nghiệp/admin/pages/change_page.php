<?php
   // Kết nối đến CSDL
   include("../config/dbconfig.php");
   ?>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../ckfinder/ckfinder.js"></script>
<div id="main-content-wp" class="add-cat-page">
   <div class="section" id="title-page">
      <div class="clearfix">
         <a href="?page=add_page" title="" id="add-new" class="fl-left">Thêm mới</a>
         <h3 id="index" class="fl-left">Sửa trang</h3>
      </div>
   </div>
   <div class="wrap clearfix">
      <?php require 'inc/sidebar.php'; ?>
      <div id="content" class="fl-right">
         <div class="section" id="detail-page">
            <div class="section-detail">
               <form method="POST" action="pages/change_page_perform.php" enctype="multipart/form-data">
                  <?php
                     // Bước 1: Kết nối đến CSDL
                      include("../config/dbconfig.php");
                      $id = $_GET["id"];
                     //Bước 2: Hiển thị các dữ liệu trong bảng ra đây
                      $sql = "select * from tbl_page where id = ".$id;
                      $run = mysqli_query($conn,$sql);
                      $row = mysqli_fetch_array($run);
                     ?>
                  <input type="hidden" name="id" value='<?php echo $row["id"];?>'>
                  <label for="title">Tiêu đề</label>
                  <input type="text" name="title" id="title" value="<?php echo $row["title"];?>">
                  <label for="desc">Nội dung</label>
                  <textarea class="ckeditor" name="content" id="content" style="height: 3000px;"><?php echo $row["content"];?></textarea>
                  <label>Hình ảnh</label>
                  <div id="uploadFile">
                     <input type="file" name="image" id="upload-thumb">
                     <img src="index.php/../../images/page/<?php echo $row["image"];?>" alt="">
                  </div>
                  <button type="submit" name="btn-submit" id="btn-submit">Sửa</button>
               </form>
            </div>
         </div>
      </div>
   </div>
</div>