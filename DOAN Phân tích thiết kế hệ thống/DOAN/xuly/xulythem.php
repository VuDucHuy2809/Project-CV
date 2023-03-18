
<?php
       
        include '../connectdb/connect.php';
      
        ?>
 <script>
     
    function abc(){
        
            if(confirm("Bấm vào nút OK để tiếp tục") == true){
            
    window.location='../giaodien/themuser.php';
            }else{
              alert("<?php echo " Mắc cười wá đi nha ^^ " ?>");
            }
        }

 function def(){
        
        alert("User_id này đã tồn tại");
            
    window.location='../giaodien/themuser.php';
           
        }
        function xyz(){
        
        alert("Tên sản phẩm này đã tồn tại");
            
    window.location='../giaodien/a.php?layout=them';
           
        }
        function jqka(){
         alert("Nhập lại password không khớp với password!");
         window.location = '../giaodien/themuser.php';
    }
 </script>
<?php

include "../model/product_model.php";
$b = new product_model();
$con = ketnoi();
if (isset($_POST['sub'])) {

    $name = $_POST['ipname'];
    $price = $_POST['ipprice'];
    $brand = $_POST['brand_id'];
    $size38 = $_POST['size38'];
    $size39 = $_POST['size39'];
    $size40 = $_POST['size40'];
    $size41 = $_POST['size41'];
    $file = $_FILES['image'];
    $file_name = $file['name'];
    $file2 = $_FILES['image2'];
    $file_name2 = $file2['name'];
    $file3 = $_FILES['image3'];
    $file_name3 = $file3['name'];
    
    $arrayhinh = array($file_name,$file_name2,$file_name3);
    $countarrayhinh = count($arrayhinh);
    $dem = 0;
    $check = 0;
    $thieuhinhmess = "";
    foreach($arrayhinh as $value){
        if($value == ""){
            $dem++;
            $check = 1;
            if($dem == $countarrayhinh){
                $thieuhinhmess = $thieuhinhmess."ảnh ".$dem;
            }
            else{
                 $thieuhinhmess = $thieuhinhmess."ảnh ".$dem.",";
            }
        }
    }
    if($thieuhinhmess != ""){
        ?>
        <script>
            alert("<?php echo $thieuhinhmess;?> trống, xin hãy bổ sung đầy đủ ảnh!");
         window.location='../giaodien/a.php?layout=them';        
         </script>
        <?php
    }
    else{
                move_uploaded_file($file['tmp_name'], '../img/' . $brand . '/' . $file_name);
                move_uploaded_file($file2['tmp_name'], '../img/' . $brand . '/' . $file_name2);
                move_uploaded_file($file3['tmp_name'], '../img/' . $brand . '/' . $file_name3);
    }
    
    
    
     $where = "SELECT * from shoes WHERE name = '" . $name . "'";
    $product = mysqli_query($con, $where);
    $num = mysqli_num_rows($product);
    if (mysqli_num_rows($product)== 0 && (empty($thieuhinhmess))) {
        header('location:../giaodien/admin.php');
       $b->Them($name, $price, $brand, $size38,$size39,$size40,$size41,$file_name,$file_name2,$file_name3);
    } else{
      echo '<script type="text/javascript">',
     'xyz();',
     '</script>'
;
    }
  
}


if (isset($_POST['sub2'])) {

        $user_id = $_POST['user_id'];
    $email = $_POST['email'];
    $pass = $_POST['pass'];
    $pass2 = $_POST['pass2'];
    $sdt = $_POST['sdt'];
    if($pass != $pass2){
        echo '<script type="text/javascript">','jqka();','</script>';
    }
    else{
        $where = "SELECT * from user WHERE user_id=".$user_id."";
    $product = mysqli_query($con, $where);
    $num = mysqli_num_rows($product);
    if (mysqli_num_rows($product)== 0) {
        $b->Them_user($user_id, $email, $pass, $sdt);
        header('location:../giaodien/qlkh.php');
    } else{
        echo '<script type="text/javascript">','def();','</script>';
    }
    }
     
   //echo "<h2>$num</h2>";
}
?>

