<?php
//  Kết nối đến CSDL
include("../../config/dbconfig.php");

//Lấy các dữ liệu bên trang Thêm mới bài viết
$name     = $_POST['name'];
$soluong  = $_POST['soluong'];
$price    = $_POST['price'];
$sale     = $_POST['sale'];
$category = $_POST['category'];
$chitiet  = $_POST['chitiet'];
$mota     = $_POST['mota'];

// Upload hình ảnh
$image      = $_FILES["image"]["name"];
$fileanhtam = $_FILES["image"]["tmp_name"];
$result     = move_uploaded_file($fileanhtam, '../../images/product/' . $image);
if (!$result) {
    $image = NULL;
}

// Chèn dữ liệu vào bảng tbl_product
$sql = "insert into tbl_product (name,code,amount,price,image,category, detail,sale, description,uploaded_on) value('$name','$name','$soluong','$price','$image','$category','$chitiet', '$sale', '$mota' ,NOW())";

// Cho thực thi câu lệnh SQL trên
$run = mysqli_query($conn, $sql);

    // upload multi image
    $targetDir = "../../images/product/";
    $allowTypes = array('jpg','png','jpeg','gif');
    $idproduct = mysqli_insert_id($conn);
    $statusMsg = $errorMsg = $insertValuesSQL = $errorUpload = $errorUploadType = '';
    if(!empty(array_filter($_FILES['files']['name']))){
        foreach($_FILES['files']['name'] as $key=>$val){
            // File upload path
            $fileName = basename($_FILES['files']['name'][$key]);
            $targetFilePath = $targetDir . $fileName;
            
            // Check whether file type is valid
            $fileType = pathinfo($targetFilePath,PATHINFO_EXTENSION);
            if(in_array($fileType, $allowTypes)){
                // Upload file to server
                if(move_uploaded_file($_FILES["files"]["tmp_name"][$key], $targetFilePath)){
                    // Image db insert sql
                    $insertValuesSQL .= "('".$idproduct."','".$fileName."', NOW()),";
                }else{
                    $errorUpload .= $_FILES['files']['name'][$key].', ';
                }
            }else{
                $errorUploadType .= $_FILES['files']['name'][$key].', ';
            }
        }
        
        if(!empty($insertValuesSQL)){
            $insertValuesSQL = trim($insertValuesSQL,',');
            $sql_img = "INSERT INTO tbl_img_product (id_product, file_name, uploaded_on) VALUES $insertValuesSQL";
			$run_img = mysqli_query($conn, $sql_img);

            if($insert){
                $errorUpload = !empty($errorUpload)?'Upload Error: '.$errorUpload:'';
                $errorUploadType = !empty($errorUploadType)?'File Type Error: '.$errorUploadType:'';
                $errorMsg = !empty($errorUpload)?'<br/>'.$errorUpload.'<br/>'.$errorUploadType:'<br/>'.$errorUploadType;
                $statusMsg = "Files are uploaded successfully.".$errorMsg;
            }else{
                $statusMsg = "Sorry, there was an error uploading your file.";
            }
        }
    }else{
        $statusMsg = 'Please select a file to upload.';
    }

echo '
		<script type="text/javascript">
			alert("Thêm mới sản phẩm thành công!!!");
			window.location.href="' . $site_admin . '?page=list_product";
		</script>';
;
?>
