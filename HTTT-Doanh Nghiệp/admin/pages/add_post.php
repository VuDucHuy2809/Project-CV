<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../ckfinder/ckfinder.js"></script>
<div id="main-content-wp" class="add-cat-page">
<div class="section" id="title-page">
   <div class="clearfix">
      <a href="?page=add_post" title="" id="add-new" class="fl-left">Thêm mới</a>
      <h3 id="index" class="fl-left">Thêm mới bài viết</h3>
   </div>
</div>
<div class="wrap clearfix">
   <?php require 'inc/sidebar.php'; ?>
   <div id="content" class="fl-right">
      <div class="section" id="detail-page">
         <div class="section-detail">
            <form method="POST" action="pages/add_post_perform.php" enctype="multipart/form-data">
               <input type="hidden" name="author" value="<?php echo $row["name"];?>">
               <label for="title">Tiêu đề</label>
               <input type="text" name="title" id="title">
               <label for="desc">Mô tả</label>
               <textarea name="mota" id="content"></textarea>
               <label for="desc">Nội dung</label>
               <textarea name="content" id="content" class="ckeditor"></textarea>
               <label>Hình ảnh</label>
               <div id="uploadFile">
                  <input type="file" name="image" id="upload-thumb">
                  <button type="submit" name="btn-submit" id="btn-submit">Thêm mới</button>
            </form>
            </div>
         </div>
      </div>
   </div>
</div>