<?php 
     class bill_model{
        private $con;
        public function __construct() {
            $this->con = ketnoi();
        }
        public function insertbill($user,$date,$total){
            $bill_query = "insert into bill(user,date,total)"
                . "values(?,?,?)";
            $stmt = mysqli_prepare($this->con,$bill_query);
            mysqli_stmt_bind_param($stmt,"isi", $user,$date,$total);
            mysqli_stmt_execute($stmt);
        }
        public function gettotalprice(){
            $query ="select sum(total) as totalprice from bill";
            $result = mysqli_query($this->con, $query);
            return $result;
        }
        public function getinfo(){
            $payment_time = $_SESSION['paymenttime'];
            $query ="select t.bill_id, t.shoe_id,t.quantity,s.price from (SELECT b.bill_id, c.shoe_id,c.quantity 
                    FROM bill as b join cart as c
                    on b.user=c.user_id and b.date=c.payment_time
                    where status='Paid' and payment_time='$payment_time') as t join shoes as s
                    on t.shoe_id=s.shoe_id";
            $result = mysqli_query($this->con, $query);
            return $result;
        }
     }
?>

