<div id="main-content-wp" class="info-account-page">
   <div class="section" id="title-page">
      <div class="clearfix">
         <a href="?page=add_product" title="" id="add-new" class="fl-left">Thêm mới</a>
         <h3 id="index" class="fl-left">Thông tin tài khoản</h3>
      </div>
   </div>
   <div class="wrap clearfix">
      <div id="sidebar" class="fl-left">
         <ul id="list-cat">
            <li>
               <a href="?page=change_pass" title="">Đổi mật khẩu</a>
            </li>
            <li>
               <a href="?page=login" title="">Thoát</a>
            </li>
         </ul>
      </div>
      <div id="content" class="fl-right">
         <div class="section" id="detail-page">
            <div class="section-detail">
               <form method="POST" action="?page=change_pass">
                  <?php
                      $email = $_SESSION['email'];
                      include("../config/dbconfig.php");
                      mysqli_set_charset($conn, 'UTF8');
                      $sql = "SELECT * from tbl_user where email = '$email'";
                      $run = mysqli_query($conn, $sql);
                      $i = 0;
                      while ($row = mysqli_fetch_array($run)) {
                       $i++;
                     ;?>
                  <label for="display-name">Tên hiển thị</label>
                  <input type="text" name="display-name" id="display-name" value="<?php echo $row["name"];?>" readonly="readonly" style="cursor: not-allowed; background: #f3f3f3;">
                  <label for="username">Tên đăng nhập</label>
                  <input type="text" name="username" id="username" placeholder="admin" readonly="readonly" value="<?php echo $row["username"];?>">
                  <label for="email">Email</label>
                  <input type="email" name="email" id="email" value="<?php echo $row["email"];?>" readonly="readonly" style="cursor: not-allowed; background: #f3f3f3;">
                  <label for="tel">Số điện thoại</label>
                  <input type="tel" name="tel" id="tel" value="<?php echo $row["phone"];?>" readonly="readonly" style="cursor: not-allowed; background: #f3f3f3;">
                  <label for="address">Địa chỉ</label>
                  <textarea name="address" id="address" readonly="readonly" style="cursor: not-allowed; background: #f3f3f3;"><?php echo $row["address"];?></textarea>
                  <?php } ?>
                  <button type="submit" name="btn-submit" id="btn-submit">Đổi mật khẩu</button>
               </form>
            </div>
         </div>
      </div>
   </div>
</div>