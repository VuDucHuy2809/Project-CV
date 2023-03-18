<html>
    <head>
        <link rel="stylesheet" href="../bootstrap/css/admin2.css">
    </head>
    <body>
       <?php require '../giaodien/admin_menu.php';?>
        <div class="title_them">
        
            <br>
        <h2>Thêm sản phẩm</h2>
    </div>
        <?php
       
     
        $con = ketnoi();
        $sql="SELECT brand FROM `shoes` GROUP BY brand";
        $query=mysqli_query($con,$sql);      
        ?>
<div class="them">
    <form method="POST" enctype="multipart/form-data" action="../xuly/xulythem.php">
        <div class="themsp">
        <label >Tên sản phẩm</label><br>
        <input type="text" name="ipname"class="form-controll" required="true"><br>
         <label >Ảnh sản phẩm</label><br>
         <label>Ảnh 1:</label>
         <input type="file" name="image"class="form-controll" >  <br>
           <label>Ảnh 2:</label>
         <input type="file" name="image2"class="form-controll" >  <br>
           <label>Ảnh 3:</label>
         <input type="file" name="image3"class="form-controll" >  <br>
         <label >Giá sản phẩm</label><br>
        <input type="number" name="ipprice" class="form-controll" min="0" required="true">  <br>
        <label >Thương hiệu sản phẩm</label><br>
        <select class="form-controll" name="brand_id">
            <?php
            while($row_brand=mysqli_fetch_assoc($query)){ ?>
            <option ><?php echo $row_brand['brand']?></option>
           <?php } ?>
        </select>
        <br>
         <label>Số lượng size 38 (bỏ qua nếu không thêm size 38):</label>
         <input type="number" name="size38" class="form-controll-qty-size" min="0" value="0" required="true"> <br><br>
         <label>Số lượng size 39 (bỏ qua nếu không thêm size 39):</label>
         <input type="number" name="size39" class="form-controll-qty-size" min="0" value="0"> <br><br>
         <label>Số lượng size 40 (bỏ qua nếu không thêm size 40):</label>
         <input type="number" name="size40" class="form-controll-qty-size" min="0" value="0"> <br><br>
         <label>Số lượng size 41 (bỏ qua nếu không thêm size 41):</label>
         <input type="number" name="size41" class="form-controll-qty-size" min="0" value="0"> <br><br>
         <button type="submit" class="sub" name="sub">Thêm</button>
       
         </div>
    </form>
</div>
    
</body>
</html>
