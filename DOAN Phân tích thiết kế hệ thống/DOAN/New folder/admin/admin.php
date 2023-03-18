
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> HTVC Admin</title>
        <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">

        <link rel="stylesheet" href="../bootstrap/css/admin2.css">
        <link rel="stylesheet" href="/font-awesome/css/all.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   

    </head>

    <body style="background-color: #F0F0F0;" data-spy="scroll" data-target="#myScrollspy" data-offset="1">
        <div class="menu">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container">
                    <a class="navbar-brand" href="#"><img src="image/logo.png" alt="..." width="100px"></a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="index.php">Trang chủ</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="./admin.php" onclick="listsanpham();">Sản Phẩm</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="./ttgh.php" ;>Đơn Hàng</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="./qlkh.php" ">Khách Hàng</a>
                            </li>
                        </ul>

                        <ul class="navbar-nav px-3">
                            <li class="nav-item text-nowrap">
                                <a class="nav-link" href="">Xin Chào Quản Trị Viên</a>
                            </li>
                            <li class="nav-item text-nowrap">
                                <!-- Nếu chưa đăng nhập thì hiển thị nút Đăng nhập -->
                                <a type="button" class="btn btn-outline-info btn-md btn-rounded btn-navbar waves-effect waves-light" href="./dangxuat.php">Đăng Xuất</a>
                            </li>
                        </ul>
                    </div>
            </nav>
        </div>
        <!-- Navbar -->

        <?php
        include '../connectdb/connection.php';

        $sql = "SELECT * FROM shoes";
        $query = mysqli_query($con, $sql);
        ?>
        <div class="container-fluid" style="width: 100%;">
            <div class="col">
                <div class="container-fluid" id="cacsanpham">
                    <div class="card">
                        <div class="abc">

                            <table class="def"  >
                                <tr>  
                                    <td ><a href="a.php?layout=them" id="def1">Thêm sản phẩm</a></td>
                                    <td><a href="qlkh.php">Quản lí khách hàng</a></td>
                                    <td><a href="ttgh.php">Thông tin giao hàng</a> </td>
                                    <td><a href="thongke.php">Thống kê </a></td>
                                    <td><a href="#">Đăng xuất </a></td>
                                </tr>
                            </table>
                        </div>
                        <div class="card-header">
                            <h2>Danh sách sản phẩm</h2>
                        </div>
                        <br>

                        <div class="card-body">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>#</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Hình ảnh</th>
                                        <th>Thể loại</th>
                                        <th>Giá</th>
                                        <th>Sửa</th>
                                        <th>Xóa</th>
                                    </tr>
                                </thead>
                                <tbody>


                                    <?php
                                    $i = 1;
                                    while ($row = mysqli_fetch_assoc($query)) {
                                        ?>
                                        <tr id="a1">     

                                            <td><?php echo $i++; ?></td>
                                            <td><?php echo $row['name']; ?></td>
                                            <td><img src="../<?php echo $row["image"]; ?>" ></td>     
                                            <td><?php echo $row['brand']; ?></td>
                                            <td><?php echo $row['price']; ?></td>
                                            <td><a href="a.php?layout=sua&id=<?php echo $row['shoe_id']; ?>">Sửa</a></td>
                                            <td><a onclick="return Del('<?php echo $row['name']; ?>')" href="a.php?layout=xoa&id=<?php echo $row['shoe_id']; ?>">Xóa</a></td>
                                        </tr>
                                    <?php } ?>

                                </tbody>            
                            </table>
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
       <p>Copyright &copy <a>Projectworlds</a> Store. All Rights Reserved.</p>
       <p>This website is developed by Yugesh Verma</p>
       <br>
   </center>
   </div>
</footer>
</div>
            <script type="text/javascript" src="js/bootstrap.js"></script>
            <script src="js/script.js"></script>
            <script>
                                            function Del(name) {
                                                return confirm("Bạn có chắc chắn muốn xóa sản phẩm: " + name + " ?");
                                            }
            </script>
    </body>

</html>