

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
 </script>
<?php

include "../model/product_model.php";
$b = new product_model();

if (isset($_POST['sub'])) {

    $name = $_POST['ipname'];
    $price = $_POST['ipprice'];
    $brand = $_POST['brand_id'];
    $size = $_POST['size'];
    $quantity = $_POST['ipquantity'];
    if (isset($_FILES['image'])) {
        $file = $_FILES['image'];
        $file_name = $file['name'];
        move_uploaded_file($file['tmp_name'], '../img/' . $brand . '/' . $file_name);
    }
    if (isset($_FILES['image2'])) {
        $file2 = $_FILES['image2'];
        $file_name2 = $file2['name'];
        move_uploaded_file($file2['tmp_name'], '../img/' . $brand . '/' . $file_name2);
    }
    if (isset($_FILES['image'])) {
        $file3 = $_FILES['image3'];
        $file_name3 = $file3['name'];
        move_uploaded_file($file3['tmp_name'], '../img/' . $brand . '/' . $file_name3);
    }
     $where = "SELECT * from shoes WHERE name = '" . $name . "'";
    $product = mysqli_query($con, $where);
    if (mysqli_num_rows($product)== 0) {
        header('location:../giaodien/admin.php');
    $b->Them($name, $price, $brand, $size, $quantity, $file_name, $file_name2, $file_name3);
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
    $sdt = $_POST['sdt'];
     $where = "SELECT * from user WHERE user_id = '" . $user_id . "'";
    $product = mysqli_query($con, $where);
    if (mysqli_num_rows($product)== 0) {
        $b->Them_user($user_id, $email, $pass, $sdt);
        header('location:../giaodien/qlkh.php');
    } else{
        echo '<script type="text/javascript">',
     'def();',
     '</script>'
;
  
    }
   
}
?>

