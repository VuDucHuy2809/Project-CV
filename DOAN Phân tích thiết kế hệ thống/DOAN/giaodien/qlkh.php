<?php 
    session_start();
?>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>HTVC Admin</title>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
        <link rel="stylesheet" href="../bootstrap/css/admin.css">
        <link rel="stylesheet" href="../bootstrap/css/admin2.css">
        <!--<link rel="stylesheet" href="/font-awesome/css/all.css">-->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


    </head>

    <body style="background-color: #F0F0F0;" data-spy="scroll" data-target="#myScrollspy" data-offset="1">
        <?php require '../giaodien/admin_menu.php';?>
        <div class="main">
            
            <div class="aa">
                <!--<p class="aa0"><a href="../giaodien/themuser.php">Thêm tài khoản</a></p>-->
                <div class="header_search">
                    <form action="qlkh.php" method="post" id="header-search-form">
                        <input type="text" name="keyword" class="form-control searchbar" id="searchbox" placeholder="Search..">
                          <button type="submit" name="submit">
                             <i class="fa fa-search" aria-hidden="true"></i>
                          </button>
                    </form>
                </div>
                <table class="table"  >
                    <thead class="thead-dark">
                        <tr>
                        <th>STT</th>
                        <th>user_id</th>
                       
                        <th>Email</th>  
                        <th>SDT</th>
                         <!--<th>Sửa</th>-->
                        <th>Xóa</th>
                        </tr>
                    </thead>
                    <tbody>


                        <?php
                        include '../connectdb/connect.php';
                        $con = ketnoi();
                        if(isset($_POST['keyword'])){
                            $search=$_POST['keyword'];
                            $sql1 = "SELECT * FROM  user WHERE email LIKE '$search'";
                            $query = mysqli_query($con, $sql1);
                            $i = 1;
                            while ($row = mysqli_fetch_assoc($query)) {
                                ?>
                                <tr id="a1">     

                                    <td><?php echo $i++; ?></td>
                                    <td><?php echo $row['user_id']; ?></td>

                                    <td><?php echo $row['email']; ?></td> 
                                    <td><?php echo $row['sdt']; ?></td>  
                                    <!--<td><a href="../giaodien/sua_user.php?user_id=<?php //echo $row['user_id']; ?>">Sửa</a></td>-->
                                    <td><a onclick="return Del('<?php echo $row['email']; ?>')" href="../giaodien/xoa_user.php?user_id=<?php echo $row['user_id']; ?>">Xóa</a></td>
                                </tr>
                        <?php } 
                        } else {
                            $sql = "SELECT * FROM user";
                            $query = mysqli_query($con, $sql);
                            $i = 1;
                            while ($row = mysqli_fetch_assoc($query)) {
                                ?>
                                <tr id="a1">     

                                    <td><?php echo $i++; ?></td>
                                    <td><?php echo $row['user_id']; ?></td>

                                    <td><?php echo $row['email']; ?></td> 
                                    <td><?php echo $row['sdt']; ?></td>  
                                    <!--<td><a href="../giaodien/sua_user.php?user_id=<?php //echo $row['user_id']; ?>">Sửa</a></td>-->
                                    <td><a onclick="return Del('<?php echo $row['email']; ?>')" href="../giaodien/xoa_user.php?user_id=<?php echo $row['user_id']; ?>">Xóa</a></td>
                                </tr>
                        <?php 
                            }
                         }
                        ?>

                    </tbody>  
                </table>
            </div>


        </div>
        <div>
            <footer class="footer">
               <div class="container">
                <center>
                   <p style="padding-top: 20px;">Copyright &copy Store. All Rights Reserved.</p>
                   <br><br><br>
                   <!--<p>This website is developed by Yugesh Verma</p>-->
               </center>
               </div>
           </footer>
        </div>
        <script type="text/javascript">
                function Del(name) {
                    return confirm("Bạn có chắc chắn muốn xóa user có email là: " + name + " ?");
                }
        </script>
    </body>

</html>