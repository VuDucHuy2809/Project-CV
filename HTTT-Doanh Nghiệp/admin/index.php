<?php
session_start();
$page = isset($_GET['page']) ? $_GET['page'] : 'login';
$path = "./pages/{$page}.php";
if (file_exists($path)) {
	
		if($page == 'login'){
	    	require "{$path}";
		}else{
			if (isset($_SESSION['email'])) {
				require './inc/header.php';
				require "{$path}";
				require './inc/footer.php';
			}else{
				echo '<script type="text/javascript">
		                alert("Vui lòng đăng nhập để sử dụng");
		                window.location.href="'.$site_url.'?page=login";
		            </script>';
			}
		}
} else {
    require "./pages/404.php";
}
?>