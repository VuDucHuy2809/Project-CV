<html>
    <head>
        <link rel="stylesheet" href="../bootstrap/css/admin2.css">
    </head>
    <body>
       
        <div class="title_them">
            <br>
        <h2>Thêm sản phẩm</h2>
    </div>
        <?php
       
        include '../connectdb/connect.php';
        $sql="SELECT brand FROM `shoes` GROUP BY brand";
        $query=mysqli_query($con,$sql);      
        ?>
<div class="them">
    <form method="POST" enctype="multipart/form-data" action="../xuly/xulythem.php">
        <div class="themsp">
        <label >Tên sản phẩm</label><br>
        <input type="text" name="ipname"class="form-controll" ><br>
         <label >Ảnh sản phẩm</label><br>
         <label>Ảnh 1:</label>
         <input type="file" name="image"class="form-controll" >  <br>
           <label>Ảnh 2:</label>
         <input type="file" name="image2"class="form-controll" >  <br>
           <label>Ảnh 3:</label>
         <input type="file" name="image3"class="form-controll" >  <br>
         <label >Giá sản phẩm</label><br>
        <input type="text" name="ipprice" class="form-controll" >  <br>
        <label >Thương hiệu sản phẩm</label><br>
        <select class="form-controll" name="brand_id">
            <?php
            while($row_brand=mysqli_fetch_assoc($query)){ ?>
            <option ><?php echo $row_brand['brand']?></option>
           <?php } ?>
        </select>
        <br>
         <label >Size</label><br>
         <input type="text" name="size" class="form-controll" > <br><br
         <label >Số lượng sản phẩm</label><br>
         <input type="number" name="ipquantity" class="form-controll" > <br><br>
         <button type="submit" class="sub" name="sub">Thêm</button>
       
         </div>
    </form>
</div>
    
</body>
</html>
