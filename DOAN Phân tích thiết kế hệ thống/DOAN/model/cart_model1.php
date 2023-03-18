<?php 
    class cart_model1{
        private $con;
        public function __construct() {
            $this->con = ketnoi();
        }
        public function getnumrowcart($user_id){
            $query = "select * from cart where user_id=".$user_id['userid']." and status='Added to cart'";
            $result = mysqli_query($this->con, $query);
            $num = mysqli_num_rows($result);
            return $num;
        }
        public function getfirstidbyuser($user_id){
            $query = "select id from cart where user_id=".$user_id['userid']." and status='Added to cart'";
            $result = mysqli_query($this->con, $query);
            
            while($row = mysqli_fetch_assoc($result)){
                $data = $row['id']; 
                break;
            }
            return $data;
        }
        public function getallidbyuser($user_id){
            $query = "select id from cart where user_id=".$user_id['userid']." and status='Added to cart'";
            $result = mysqli_query($this->con, $query);
            $counter = $this->getfirstidbyuser($user_id);
            $data = array();
            while($row = mysqli_fetch_assoc($result)){
                $data['id'.$counter] = $row['id'];
                $counter+=1;
            }
            return $data;
        }
        public function emptycart($user_id){
            $query = "delete from cart where user_id=?";
            $stmt = mysqli_prepare($this->con, $query);
            mysqli_stmt_bind_param($stmt, "i", $user_id);
            mysqli_stmt_execute($stmt);
            /*if(mysqli_stmt_affected_rows($stmt) != 0){
                return true;
            }
            else{
                return false;
            }*/
        }
    }
?>

