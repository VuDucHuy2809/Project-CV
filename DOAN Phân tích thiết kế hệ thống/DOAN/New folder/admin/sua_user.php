<html>
    <head>
        <link rel="stylesheet" href="../bootstrap/css/admin2.css"><!-- comment -->
    </head>
    <body>
        <style>
            .id{
                display: none;
            }
            
        </style>
        <div class="title_them">
            <br>
        <h2>Sửa sản phẩm</h2>
    </div>
        <?php

       
        include '../connectdb/connect.php';
      

        $user_id=$_GET['user_id'];
        $sql_up="select * from user where user_id=$user_id";
        $query_up=mysqli_query($con,$sql_up);
        $row_up= mysqli_fetch_assoc($query_up);
       
        ?>
        
<div class="them">
    <form method="POST" enctype="multipart/form-data" action="../xuly/xulysua.php">
        <input type="text" name="id" class="id" class="form-controll" required value="<?php echo $row_up['user_id']?>"><br> 
        <div class="themsp">
        <label >User_id</label><br>
        <input type="text" name="user_id"class="form-controll" required value="<?php echo $row_up['user_id']?>"><br> 
          <label >Email</label><br>
           <input type="text" name="email" class="form-controll"  value="<?php echo $row_up['email']?>">  <br>
         <label >Password</label><br>
        <input type="text" name="pass" class="form-controll"  value="<?php echo $row_up['pass']?>">  <br>
         <label >SDT</label><br>
         <input type="text" name="sdt" class="form-controll"  value="<?php echo $row_up['sdt']?>"> <br><br>
       
         <button type="submit" class="sub" name="sub2">Sửa</button>
 
         </div>
    </form>
</div>
    
</body>
</html>
