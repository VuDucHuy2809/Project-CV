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
        <?php require '../giaodien/admin_menu.php';?>
        <div class="title_them">
            <br>
        <h2>Sửa sản phẩm</h2>
        </div>
        <?php

       
       
        $con = ketnoi();
        $sql="SELECT brand FROM `shoes` GROUP BY brand";
        $query=mysqli_query($con,$sql);      

        $id=$_GET['id'];
        $sql_up="select * from shoes where shoe_id=$id";
        $query_up=mysqli_query($con,$sql_up);
        $row_up= mysqli_fetch_assoc($query_up);
        $spbrand = $row_up['brand'];
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
            <option class="brandselect"><?php echo $row_brand['brand']?></option>
           <?php } ?>
        </select>
        <br>
         <label>Số lượng size 38 (bỏ qua nếu không sửa):</label>
         <input type="number" name="size38" class="form-controll-qty-size" min="0" value="<?php echo $row_up['qty38'];?>"> <br><br>
         <label>Số lượng size 39 (bỏ qua nếu không sửa):</label>
         <input type="number" name="size39" class="form-controll-qty-size" min="0" value="<?php echo $row_up['qty39'];?>"> <br><br>
         <label>Số lượng size 40 (bỏ qua nếu không sửa):</label>
         <input type="number" name="size40" class="form-controll-qty-size" min="0" value="<?php echo $row_up['qty40'];?>"> <br><br>
         <label>Số lượng size 41 (bỏ qua nếu không sửa):</label>
         <input type="number" name="size41" class="form-controll-qty-size" min="0" value="<?php echo $row_up['qty41'];?>"> <br><br>
         <button type="submit" class="sub" name="sub">Sửa</button>
 
         </div>
    </form>
</div>
    
</body>
<script type="text/javascript">

        function changebrand(){
        var arr = document.getElementsByClassName("brandselect");
        for(var i=0;i<arr.length;i++){
            if(arr[i].value == '<?php echo $spbrand;?>'){
                arr[i].selected='selected';
            }
        }
            //console.log(arr[1].value);
        }
        changebrand();
  
    
</script>
</html>
