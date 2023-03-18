<html>
    <head>
        <link rel="stylesheet" href="../bootstrap/css/admin2.css"><!-- comment -->
    </head>
    <body>
       
        <div class="title_them">
            <br>
        <h2>Thêm tài khoản</h2>
    </div>
        <?php
       
        include '../connectdb/connect.php';
      
        ?>
<div class="them">
    <form method="POST" enctype="multipart/form-data" action="../xuly/xulythem.php">
        <div class="themsp">
        <label >User_id</label><br>
        <input type="text" name="user_id"class="form-controll" ><br>
         <label >email</label><br>
        <input type="text" name="email" class="form-controll" >  <br>
        <label >pass</label><br>
         <input type="text" name="pass" class="form-controll" > <br><br
         <label >SDT</label><br>
         <input type="text" name="sdt" class="form-controll" > <br><br>
         
         <button type="submit" class="sub" name="sub2">Thêm</button>
         </div>
       
    </form>
</div>
    
</body>
</html>
