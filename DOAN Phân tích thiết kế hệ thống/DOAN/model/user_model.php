<?php
   class user_model{
        private $con;
        public function __construct() {
            $this->con = ketnoi();
        }
        public function getInfo($userid){
            $query = "select * from user where user_id=$userid";
            $result = mysqli_query($this->con, $query);
           return $result;
        }
   }
?>

