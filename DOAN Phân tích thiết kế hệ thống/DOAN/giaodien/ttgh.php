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
        <link rel="stylesheet" href="../bootstrap/css/admin.css">
        <link rel="stylesheet" href="../bootstrap/css/admin2.css">
        <!--<link rel="stylesheet" href="/font-awesome/css/all.css">-->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


    </head>

    <body style="background-color: #F0F0F0;" data-spy="scroll" data-target="#myScrollspy" data-offset="1">
        <?php require '../giaodien/admin_menu.php';?>
        <div class="main">

            <div class="aa">
                <h2 class="a0">Thông tin giao hàng</h2>
              
                <table class="aa1"  > 
                    <tr class="aa2">
                        <th>#</th>
                        <th>user_id</th>
                        <th>email</th>
                        <th>SDT</th>
                        <th>Chi tiết</th>
                        <th>Giao</th>

                    </tr>
                    <tbody>


                        <?php
                        include '../connectdb/connect.php';
                        $con = ketnoi();
                        $sql = "select u.user_id,u.email,u.sdt,c.status from user as u, cart as c where u.user_id=c.user_id and c.status='Paid' group by c.user_id";
                        $query = mysqli_query($con, $sql);

                        $i = 1;
                        while ($row = mysqli_fetch_assoc($query)) {
                            ?>
                            <tr id="a1">     
                              
                                
                                <td><?php echo $i++; ?></td>
                                <td><?php echo $row['user_id']; ?></td>
                                <td><?php echo $row['email']; ?></td>
                                <td><?php echo $row['sdt']; ?></td>
                                <td><a href="../giaodien/chitiet.php?user_id=<?php echo $row['user_id']; ?>"><button class="x1"> Chi tiết</button></a></td>
                                <td><a onclick="return giao()" href="../giaodien/giaohang.php?userid=<?php echo $row['user_id']; ?>"><input type="button" name="giao" id="giao" class="x1" value="Giao hàng"></button></a></td>

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
                   <p style="padding-top: 20px;">Copyright &copy Store. All Rights Reserved.</p>
                   <br><br><br>
                   <!--<p>This website is developed by Yugesh Verma</p>-->
               </center>
               </div>
           </footer>
        </div>
               <script>
              
                                            function giao() {
                                                return alert("Giao hàng thành công!!");
                                            }
             
             
            </script>   
                
    </body>

</html>