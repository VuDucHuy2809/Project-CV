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
        $sql="SELECT brand FROM `shoes` GROUP BY brand";
        $query=mysqli_query($con,$sql);      

        $id=$_GET['id'];
        $sql_up="select * from shoes where shoe_id=$id";
        $query_up=mysqli_query($con,$sql_up);
        $row_up= mysqli_fetch_assoc($query_up);
       
        ?>
        
<div class="them">
    <form method="POST" enctype="multipart/form-data" action="../xuly/xulysua.php">
        <input type="text" name="id" class="id" class="form-controll" required value="<?php echo $row_up['shoe_id']?>"><br> 
        <div class="themsp">
        <label >Tên sản phẩm</label><br>
        <input type="text" name="ipname"class="form-controll" required value="<?php echo $row_up['name']?>"><br> 
          <label >Ảnh sản phẩm</label><br>
         <label>Ảnh 1:</label>
         <input type="file" name="image"class="form-controll" >  <br>
           <label>Ảnh 2:</label>
         <input type="file" name="image2"class="form-controll" >  <br>
           <label>Ảnh 3:</label>
         <input type="file" name="image3"class="form-controll" >  <br>
         <label >Giá sản phẩm</label><br>
        <input type="text" name="ipprice" class="form-controll"  value="<?php echo $row_up['price']?>">  <br>
        <label >Thương hiệu sản phẩm</label><br>
        <select class="form-controll" name="brand_id">
            <?php
            while($row_brand=mysqli_fetch_assoc($query)){ ?>
            <option ><?php echo $row_brand['brand']?></option>
           <?php } ?>
        </select>
        <br>
         <label >Size</label><br>
         <input type="text" name="size" class="form-controll"  value="<?php echo $row_up['size']?>"> <br><br
         <label >Số lượng sản phẩm</label><br>
         <input type="number" name="ipquantity" class="form-controll"  value="<?php echo $row_up['quantity_left']?>" > <br><br>
         <button type="submit" class="sub" name="sub">Sửa</button>
 
         </div>
    </form>
</div>
    
</body>
</html>
