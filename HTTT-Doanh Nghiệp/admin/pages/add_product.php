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
         <h3 id="index" class="fl-left">Thêm sản phẩm</h3>
      </div>
   </div>
   <div class="wrap clearfix">
      <?php require 'inc/sidebar.php'; ?>
      <div id="content" class="fl-right">
         <div class="section" id="detail-page">
            <div class="section-detail">
               <form method="POST" action="pages/add_product_perform.php" enctype="multipart/form-data">
                  <label for="product-name">Tên sản phẩm</label>
                  <input type="text" name="name" id="name">
                  <label for="product-code">Số lượng</label>
                  <input type="text" name="soluong" id="masp">
                  <label for="price">Giá sản phẩm</label>
                  <input type="text" name="price" id="price">
                  <label for="price">Giá khuyến mại</label>
                  <input type="text" name="sale" id="price">
                  <label for="desc">Mô tả ngắn</label>
                  <textarea name="mota" id="desc"></textarea>
                  <label for="desc">Chi tiết</label>
                  <textarea name="chitiet" id="chitiet"></textarea>
                  <script>
                     var chitiet = CKEDITOR.replace('chitiet');
                  </script>
                  <label>Hình ảnh</label>
                  <div id="uploadFile">
                     <input type="file" name="image" id="upload-thumb">
                  </div>
                  <div id="uploadFile">
                     <input type="file" name="files[]" multiple  id="upload-thumb">
                  </div>
                  <label>Danh mục sản phẩm</label>
                  <select name="category">
                     <?php
                        $sql = "select * from tbl_category";
                        $run = mysqli_query($conn, $sql);
                        while ($row = mysqli_fetch_array($run)) {
                        ;
                    ?>
                     <option value="<?php echo $row["id"];?>"><?php echo $row["title"];?></option>
                     <?php
                        }
                        ;?>
                  </select>
                  <button type="submit" name="btn-submit" id="btn-submit">Thêm mới</button>
               </form>
            </div>
         </div>
      </div>
   </div>
</div>