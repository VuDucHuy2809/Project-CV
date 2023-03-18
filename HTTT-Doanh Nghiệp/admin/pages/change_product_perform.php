<?php
include("../../config/dbconfig.php");
$id         = $_POST['id'];
//$id_product = $_POST['id_product'];
$name       = $_POST['name'];
$soluong    = $_POST['soluong'];
$price      = $_POST['price'];
$sale       = $_POST['sale'];
$category   = $_POST['category'];
$chitiet    = $_POST['chitiet'];
$mota       = $_POST['mota'];
// Upload hình ảnh
$image      = $_FILES["image"]["name"];
$fileanhtam = $_FILES["image"]["tmp_name"];
$result     = move_uploaded_file($fileanhtam, '../../images/product/' . $image);
if (!$result) {
    $image = NULL;
}
// Bước 2: Chèn dữ liệu vào bảng
if ($id == '' || $name == '' || $price == '' || $category == '') {
    echo '
		<script type="text/javascript">
			alert("Sửa bài viết lỗi. Vui lòng điền đầy đủ thông tin!!!");
			window.location.href="' . $site_admin . '?page=change_product&id=$id";
		</script>';
} else {
    if ($image == NULL) {
        $sql = "UPDATE tbl_product SET name = '$name', price = '$price', category = '$category', sale = '$sale', detail = '$chitiet', description = '$mota', amount = '$soluong' , uploaded_on=NOW() WHERE id = '$id'";



    // upload multi image
    $targetDir = "../../images/product/";
    $allowTypes = array('jpg','png','jpeg','gif');
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
                    $insertValuesSQL .= "('".$fileName."', NOW()),";
                }else{
                    $errorUpload .= $_FILES['files']['name'][$key].', ';
                }
            }else{
                $errorUploadType .= $_FILES['files']['name'][$key].', ';
            }
        }
        
        if(!empty($insertValuesSQL)){
            $insertValuesSQL = trim($insertValuesSQL,',');
            $sql_img = "UPDATE tbl_img_product SET file_name='$fileName', uploaded_on=NOW() WHERE id_product= '".$id."' AND idpost='".$id_product."' ";
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





    } else {
        $sql = "UPDATE tbl_product SET name = '$name', price = '$price', category = '$category', image = '$image', sale = '$sale', detail = '$chitiet', description = '$mota', amount = '$soluong' ,uploaded_on=NOW() WHERE id = '$id'";




    // upload multi image
    $targetDir = "../../images/product/";
    $allowTypes = array('jpg','png','jpeg','gif');
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
                    $insertValuesSQL .= "('".$fileName."', NOW()),";
                }else{
                    $errorUpload .= $_FILES['files']['name'][$key].', ';
                }
            }else{
                $errorUploadType .= $_FILES['files']['name'][$key].', ';
            }
        }
        
        if(!empty($insertValuesSQL)){
            $insertValuesSQL = trim($insertValuesSQL,',');
            $sql_img = "UPDATE tbl_img_product SET file_name='$fileName', uploaded_on=NOW() WHERE id_product= '".$id."' AND idpost='".$id_product."' ";
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


    }
}
// Cho thực thi câu lệnh SQL trên
$run = mysqli_query($conn, $sql);
echo '
		<script type="text/javascript">
			alert("Sửa sản phẩm thành công!!!");
			window.location.href="' . $site_admin . '?page=list_product";
		</script>';
;
?>