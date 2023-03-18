<?php
    function ketnoi(){
        $server = "localhost";
        $username = "root";
        $password = "";
        $dbname = "test";
        $con = mysqli_connect($server,$username,$password);
        mysqli_set_charset($con,"uft8");
        if(!$con){
            echo "Ket noi khong thanh cong";
        }
        else{
            mysqli_select_db($con, $dbname);
            return $con;
        }
    }
?>

