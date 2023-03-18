<?php 
    class detailbill_model{
        private $con;
        public function __construct() {
            $this->con = ketnoi();
        }
        public function insertdetailbill(){
            $bill = new bill_model();
            $result = $bill->getinfo();
            while ($row = mysqli_fetch_assoc($result)) {
                $bill_id = $row['bill_id'];
                $shoe_id = $row['shoe_id'];
                $quantity = $row['quantity'];
                $price = $row['price'];
                $query ="insert into detailbill(bill_id,shoe_id,quantity,price)"
                        . "values($bill_id,$shoe_id,$quantity,$price)";
                mysqli_query($this->con, $query);
                
            }
        }
     }
?>

