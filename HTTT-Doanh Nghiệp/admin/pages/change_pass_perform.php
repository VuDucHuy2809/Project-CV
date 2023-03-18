<?php
//Khai báo sử dụng session
session_start();
//Kết nối tới database
include('../../config/dbconfig.php');

$email        = $_POST['email'];
$pass_old     = md5($_POST['pass_old']);
$pass_new     = md5($_POST['pass_new']);
$confirm_pass = md5($_POST['confirm_pass']);
$sql_check    = mysqli_query($conn, "select * from tbl_user where email = '$email'");
$dem          = mysqli_num_rows($sql_check);
if ($pass_new == '' || $confirm_pass == '') {
    echo "
	<script language='javascript'>
	alert('Vui lòng điền đầy đủ thông tin');
	window.open('" . $site_admin . "?page=change_pass','_self', 1);
	</script>
	";
} else {
    if ($dem == 0) {
        $_SESSION['thongbaoloi'] = "Sai email";
        echo "
		<script language='javascript'>
		alert('Tài khoản không tồn tại');
		window.open('" . $site_admin . "?page=change_pass','_self', 1);
		</script>
		";
    } else {
        $sql_check2 = mysqli_query($conn, "select * from tbl_user where email = '$email' and password = '$pass_old'");
        $dem2       = mysqli_num_rows($sql_check2);
        if ($dem2 == 0)
            echo "
		<script language='javascript'>
		alert('Mật khẩu cũ không đúng');
		window.open('" . $site_admin . "?page=change_pass','_self', 1);
		</script>
		";
        else {
            if ($pass_new != $confirm_pass) {
                echo "
				<script language='javascript'>
				alert('Mật khẩu không khớp');
				window.open('" . $site_admin . "?page=change_pass','_self', 1);
				</script>
				";
            } else {
                $sql = "UPDATE tbl_user SET password = '$pass_new' WHERE email = '$email'";
                $run = mysqli_query($conn, $sql);
                echo "
					<script language='javascript'>
						alert('Đổi mật khẩu thành công!');
						window.open('" . $site_admin . "?page=change_pass','_self', 1);
					</script>";
            }
            
        }
    }
}
?>