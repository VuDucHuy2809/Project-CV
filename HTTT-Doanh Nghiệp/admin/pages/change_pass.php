<div id="main-content-wp" class="change-pass-page">
   <div class="section" id="title-page">
      <div class="clearfix">
         <a href="?page=add_product" title="" id="add-new" class="fl-left">Thêm mới</a>
         <h3 id="index" class="fl-left">Cập nhật tài khoản</h3>
      </div>
   </div>
   <div class="wrap clearfix">
      <div id="sidebar" class="fl-left">
         <ul id="list-cat">
            <li>
               <a href="?page=info_account" title="">Chi tiết thông tin</a>
            </li>
            <li>
               <a href="?page=login" title="">Thoát</a>
            </li>
         </ul>
      </div>
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
      <div id="content" class="fl-right">
         <div class="section" id="detail-page">
            <div class="section-detail">
               <form method="POST" action="pages/change_pass_perform.php">
                  <label for="old-pass">Email</label>
                  <input type="text" name="email" id="email" style="display: block;padding: 5px 10px;border: 1px solid #ddd;width: 35%;margin-bottom: 15px;" value="<?php echo $row["email"];?>" readonly><?php } ?>
                  <label for="old-pass">Mật khẩu cũ</label>
                  <input type="password" name="pass_old" id="pass-old">
                  <label for="new-pass">Mật khẩu mới</label>
                  <input type="password" name="pass_new" id="pass-new">
                  <label for="confirm-pass">Xác nhận mật khẩu</label>
                  <input type="password" name="confirm_pass" id="confirm-pass">
                  <button type="submit" name="btn-submit" id="btn-submit">Cập nhật</button>
               </form>
            </div>
         </div>
      </div>
   </div>
</div>