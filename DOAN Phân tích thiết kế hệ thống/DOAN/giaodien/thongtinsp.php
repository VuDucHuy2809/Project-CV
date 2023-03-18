<!DOCTYPE html>
<?php require '../connectdb/connect.php';
    session_start();
    
?>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
     <link rel="shortcut icon" href="../img/lifestyleStore.png" />
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min(1).css" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!--<link rel="stylesheet" href="../css/style.css" type="text/css">-->
    <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
</head>
<body>
    <?php require '../giaodien/header_products.php';?>

<br><br><br>

<div class="than">
    <div class="anh">
        <?php require '../xuly/xulythongtinsp.php';?>
        <!--<p> – Về mặt thiết kế: Với form dáng mạnh mẽ, linh hoạt và trẻ trung. Đối tượng hướng đến là khá đa dạng.</p>

        <p>– Chất lượng: Riêng về mặt chất lượng sẽ không bao giờ phải lo lắng khi lựa chọn. Nổi tiếng với sự gia công tinh xảo từ đường kim mũi chỉ đem lại cho người dùng trải nghiệm rất tốt. Sản phẩm này được sử dụng với khá nhiều mục đích như chơi thể thao, dạo phố….</p>-->



    </div>
    <div class="spkhac">
        <p id="c2">Sản phẩm liên quan</p><br><br>
        <table border="2" id="table">
            <tr>
                <td><a href="#"><img src="../img/hang-chinh-hang-nike-air-max-90-worldwide-white-gold-2021-da1342-170.jpeg" ><br><span id="c1">HÀNG CHÍNH HÃNG NIKE AIR FORCE 1 LOW WHITE</span></a></td>
                <td><a href="#"><img src="../img/hang-chinh-hang-adidas-solar-hu-glide-boost-pharrell-chinese-new-year-v-2021-ee8701.jpeg"><span id="c1">HÀNG CHÍNH HÃNG ADIDAS SOLAR HU GLIDE BOOST </span></td><a></td><td><a href="#"><img src="../img/hang-chinh-hang-adidas-x9000l2-black-2021-eh0030.jpeg"><span id="c1">HÀNG CHÍNH HÃNG ADIDAS X9000L2 BLACK 2021</span></td>
                <td><a href="#"><img src="../img/hang-chinh-hang-newbalance-abzorb-828-white-grey-logo-2021-mi828cb.jpeg"><span id="c1">HÀNG CHÍNH HÃNG NEWBALANCE ABZORB 828</span></a></td><td><a href="#"><img src="../img/hang-chinh-hang-nike-air-max-90-worldwide-white-gold-2021-da1342-170.jpeg"><span id="c1">HÀNG CHÍNH HÃNG MLB X NEW YORK YANKEES </span></a></td><td><a href="#"><img src="../img/hiemco-550k-tk-hang-chinh-hang-nike-air-force-1-low-white-2021-dd8959-100.jpeg"><span id="c1">HÀNG CHÍNH HÃNG NIKE AIR JORDAN 1 MID LASER </span></a></td>
            </tr>
        </table>

    </div>
</div>
<br><br><br><br><br><br><br><br>
<footer class="footer">
               <div class="container">
                <center>
                   <p>Copyright &copy Store. All Rights Reserved.</p>
                   <!--<p>This website is developed by Yugesh Verma</p>-->
               </center>
               </div>
           </footer>
</div>


</body>

<script type="text/javascript">
            $(document).ready(function(){
                //function checksize(){
                    //var sizedachon = document.getElementById('sizegiay').value;
                    //const arr = [38,39,40,41];
                    //alert(<?php //echo $temp = "document.write(sizedachon)";?>+'');
                    //for(var i=0;i<arr.length;i++){
                        //if(sizedachon == arr[i])
                        //document.getElementById('slconlai').innerHTML = "Số lượng còn lại: " + <?php //echo $arrsize[$temp];?>
                    //}
                //}
                function addcart(){
                     <?php if(isset($_SESSION['id'])){
                            $user = $_SESSION['id'];
                        }
                        else{
                            $user = "";
                        }
                     ?>
                    var userid = '<?php echo $user;?>';
                   
                    if(userid == ""){
                        window.location="http://localhost/DOAN/giaodien/login.php";
                    }
                    else{
                        
                        var shoeid = '<?php echo $_GET['shoeid'];?>';
                        var qty = document.getElementById('quantity').value;
                        var szgiay = document.getElementById('sizegiay').value;
                        $.ajax({
                            method: 'post',
                            url: '../model/cart_model.php',
                            datatype: "JSON",
                            data: {user: userid, shoe: shoeid, quantity: qty, size: szgiay},
                            success: function(response){
                                
                               if(response == 1)
                                    document.getElementById('addsuccess').style.display = "block";
                            }
                        });
                    }
            }
            document.getElementById("a4").onclick = addcart;
            //document.getElementById("sizegiay").onchange = checksize;
            });
            
        </script>
</html>