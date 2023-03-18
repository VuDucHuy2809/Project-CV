<?php
   // Kết nối đến CSDL
   include("../config/dbconfig.php");
   ?>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<div id="main-content-wp" class="add-cat-page">
   <div class="section" id="title-page">
      <div class="clearfix">
         <a href="?page=add_product" title="" id="add-new" class="fl-left">Thêm mới</a>
         <h3 id="index" class="fl-left">Thêm banner</h3>
      </div>
   </div>
   <div class="wrap clearfix">
      <?php require 'inc/sidebar.php'; ?>
      <div id="content" class="fl-right">
         <div class="section" id="detail-page">
            <div class="section-detail">
               <form method="POST" action="pages/add_banner_perform.php" enctype="multipart/form-data">
                  <label for="title">Tiêu Đề</label>
                  <input type="text" name="title" id="title">
                  <label>Hình ảnh</label>
                  <div id="uploadFile">
                     <input type="file" name="image" id="upload-thumb">
                  </div>
                  <label for="active">Hiển thị</label>
                  <select name="active" id="active">
                     <option value="0">Không</option>
                     <option value="1">Có</option>
                  </select>
                  <button type="submit" name="btn-submit" id="btn-submit">Thêm mới</button>
               </form>
            </div>
         </div>
      </div>
   </div>
</div>