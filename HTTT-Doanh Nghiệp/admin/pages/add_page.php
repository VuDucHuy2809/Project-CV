<?php
   // Kết nối đến CSDL
   include("../config/dbconfig.php");
   ?>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../ckfinder/ckfinder.js"></script>
<div id="main-content-wp" class="add-cat-page">
   <div class="section" id="title-page">
      <div class="clearfix">
         <a href="?page=add_product" title="" id="add-new" class="fl-left">Thêm mới</a>
         <h3 id="index" class="fl-left">Thêm trang</h3>
      </div>
   </div>
   <div class="wrap clearfix">
      <?php require 'inc/sidebar.php'; ?>
      <div id="content" class="fl-right">
         <div class="section" id="detail-page">
            <div class="section-detail">
               <form method="POST" action="pages/add_page_perform.php" enctype="multipart/form-data">
                  <label for="title">Tiêu đề</label>
                  <input type="text" name="title" id="title">
                  <label for="desc">Nội dung</label>
                  <textarea class="ckeditor" name="content" id="content"></textarea>
                  <label>Hình ảnh</label>
                  <div id="uploadFile">
                     <input type="file" name="image" id="upload-thumb">
                  </div>
                  <button type="submit" name="btn-submit" id="btn-submit">Đăng</button>
               </form>
            </div>
         </div>
      </div>
   </div>
</div>