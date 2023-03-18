<?php 
    session_start();
?>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> HTVC Admin</title>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
        <!--<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" type="text/css">-->
        <link rel="stylesheet" href="../bootstrap/css/admin2.css">
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
    </head>

    <body style="background-color: #F0F0F0;" data-spy="scroll" data-target="#myScrollspy" data-offset="1">
        <?php require '../giaodien/admin_menu.php';?>
        <!-- Navbar -->

        <?php
        include '../connectdb/connect.php';

        ?>
        <div class="container-fluid" style="width: 100%;">
            <div class="col">
                <div class="container-fluid" id="cacsanpham">
                    <div class="card">
                        <div class="abc">

                            <table class="def">
                                <?php if(isset($_SESSION['email']) && $_SESSION['role'] == 'admin'){?>
                                <tr>  
                                    <td ><a href="../giaodien/a.php?layout=them" id="def1">Thêm sản phẩm</a></td>
                                    <td><a href="../giaodien/qlkh.php">Quản lí khách hàng</a></td>
                                    <td><a href="../giaodien/ttgh.php">Thông tin giao hàng</a> </td>
                                    <td><a href="../giaodien/thongke.php">Thống kê </a></td>
                                    
                                </tr>
                                <?php }?>
                            </table>
                        </div>
                        <div class="card-header">
                            <h2>Danh sách sản phẩm</h2>
                        </div>
                        <br>

                        <div class="card-body">
                            <div class="header_search">
                                <form action="../giaodien/admin.php" method="post" id="header-search-form">
                                        <input type="text" name="keyword" class="form-control searchbar" placeholder="Search..">
                                    
                                        <button type="submit" name="submit">
                                            <i class="fa fa-search" aria-hidden="true"></i>
                                        </button>
                                    </form>
                            </div>
                            <?php require '../xuly/xulyadminsearch.php';?>
                        </div>
                    </div>
                </div>
            </div>
            </div>
 <div>
<footer class="footer">
   <div class="container">
    <center>
        <br>
       <p>Copyright &copy Store. All Rights Reserved.</p>
       
       <br>
   </center>
   </div>
</footer>
</div>
            <script type="text/javascript" src="../js/bootstrap.js"></script>
            <script src="../js/script.js"></script>
            <script>
                                            function Del(name) {
                                                return confirm("Bạn có chắc chắn muốn xóa sản phẩm: " + name + " ?");
                                            }
            </script>
    </body>

</html>