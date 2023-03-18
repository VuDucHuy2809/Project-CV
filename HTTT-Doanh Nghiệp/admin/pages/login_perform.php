	<?php
//Khai báo sử dụng session
session_start();
    //Kết nối tới database
include('../../config/dbconfig.php');

$email = $_POST['email'];
$password =  md5($_POST['password']);
$sql_check = mysqli_query($conn,"select * from tbl_user where email = '$email'");
$dem = mysqli_num_rows($sql_check);
if($dem == 0)
{
	$_SESSION['thongbaoloi'] = "Tài khoản không thồn tại";
	echo "
	<script language='javascript'>
		alert('Tài khoản không tồn tại');
		window.open('".$site_admin."?page=login','_self', 1);
	</script>
	";
}
else
{
	$sql_check2 = mysqli_query($conn,"select * from tbl_user where email = '$email' and password = '$password'");
	$dem2 = mysqli_num_rows($sql_check2);
	if($dem2 == 0)
		echo "
	<script language='javascript'>
		alert('Mật khẩu đăng nhập không đúng');
		window.open('".$site_admin."?page=login','_self', 1);
	</script>
	";
	else
	{
		$query = "select * from tbl_user where email = '$email' and password = '$password'";

        $execute = $conn->query($query);

        $row = mysqli_fetch_array($execute);

		$chuc_vu2 = $row['chuc_vu'];


		$_SESSION['email'] = $email;
		if($chuc_vu2=="client"){
			echo "
		<script language='javascript'>
		alert('welcome ".$chuc_vu2."');
		window.open('http://localhost:8080/shoe/?page=home','_self', 1);
		</script>
		";
		}
		else{
		echo "
		<script language='javascript'>
			alert('welcom ".$chuc_vu2."');
			window.open('".$site_admin."?page=list_order','_self', 1);
		</script>
		";
		}

	}
}
?>