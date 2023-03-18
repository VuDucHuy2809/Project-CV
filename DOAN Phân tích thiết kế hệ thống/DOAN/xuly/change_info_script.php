<?php
    session_start();
    require '../connectdb/connect.php';
    $con = ketnoi();
    if(!isset($_SESSION['email'])){
        header('location:index.php');
    }  
    $useremail= mysqli_real_escape_string($con,$_POST['useremail']);
    $usercontact= mysqli_real_escape_string($con,$_POST['usercontact']);
    $userid=$_SESSION['id'];
    //echo $email;
    $query="update user set email='$useremail', sdt='$usercontact' where user_id=$userid";
    $result=mysqli_query($con,$query) or die(mysqli_error($con));
    if(mysqli_affected_rows($con) > 0){
        ?>
        <script>
            window.alert("Change information successfully!");
        </script>
        <meta http-equiv="refresh" content="2;url=../giaodien/products.php" /> 
        <?php
    }
    else{
        ?>
        <script>
            window.alert("Fail to change information!");
        </script>
        <meta http-equiv="refresh" content="2;url=../giaodien/suattcanhan.php" />    
        <?php
    }
    
?>