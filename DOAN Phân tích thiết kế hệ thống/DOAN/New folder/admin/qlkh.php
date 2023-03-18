
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>BookStore Admin</title>
        <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
        <link rel="stylesheet" href="../bootstrap/css/admin.css">
        <link rel="stylesheet" href="../bootstrap/css/admin2.css">
        <link rel="stylesheet" href="/font-awesome/css/all.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


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
                                <a class="nav-link" href="./qlkh.php">Khách Hàng</a>
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
        <div class="main">

            <div class="aa">
                <p class="aa0"><a href="themuser.php">Thêm tài khoản</a></p>
                <table class="aa1"  > 
                    <tr class="aa2">
                        <th>#</th>
                        <th>user_id</th>
                        <th>pass</th>
                        <th>Email</th>  
                        <th>SDT</th>
                         <th>Sửa</th>
                        <th>Xóa</th>
                    </tr>
                    <tbody>


                        <?php
                        include '../connectdb/connection.php';

                        $sql = "SELECT * FROM user";
                        $query = mysqli_query($con, $sql);

                        $i = 1;
                        while ($row = mysqli_fetch_assoc($query)) {
                            ?>
                            <tr id="a1">     

                                <td><?php echo $i++; ?></td>
                                <td><?php echo $row['user_id']; ?></td>
                                <td><?php echo $row['pass']; ?></td>
                                <td><?php echo $row['email']; ?></td> 
                                <td><?php echo $row['sdt']; ?></td>  
                                <td><a href="sua_user.php?user_id=<?php echo $row['user_id']; ?>">Sửa</a></td>
                                <td><a href="xoa_user.php?user_id=<?php echo $row['user_id']; ?>">Xóa</a></td>
                            </tr>
                        <?php } ?>

                    </tbody>  
                </table>
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


    </body>

</html>