<?php 
  include '../connectdb/connect.php';
    class product_model{
        private $con;
        public function __construct() {
        $this->con = ketnoi();
        }
        public function getAllProducts(){
            $query = "select * from shoes";
            $result = mysqli_query($this->con, $query);
            return $result;
        }
         function Them($name,$price,$brand,$size,$quantity,$file_name,$file_name2,$file_name3){
         $sql="INSERT INTO shoes (name,image,image2,image3,price, brand,size,quantity_left)
                   VALUES('$name','img/$brand/$file_name','img/$brand/$file_name2','img/$brand/$file_name3','$price','$brand','$size','$quantity')";
            $query=mysqli_query($this->con,$sql);
            return $query;
    }
     function Them_user($user_id,$email,$pass,$sdt){
         $sql="INSERT INTO user (user_id,email,pass,sdt)
                   VALUES('$user_id','$email','$pass','$sdt')";
            $query=mysqli_query($this->con,$sql);
            return $query;
    }
      function Sua($name,$price,$brand,$size,$quantity,$file_name,$file_name2,$file_name3,$id){

     $sql2="UPDATE shoes SET name='$name',image= 'img/$brand/$file_name',image2='img/$brand/$file_name2',image3='img/$brand/$file_name3', price= '$price', brand= '$brand',size= '$size',quantity_left= '$quantity'  WHERE shoe_id = '$id'";
            $query2=mysqli_query($this->con,$sql2);
            
      return $query2;
      }
      
     function Sua_user($user_id,$email,$pass,$sdt,$id){
     $sql2="UPDATE user SET user_id='$user_id',email='$email',pass='$pass', sdt='$sdt' WHERE user_id = '$id'";
            $query=mysqli_query($this->con,$sql2);
            return $query;
    }
      
      
      
         }
?>

