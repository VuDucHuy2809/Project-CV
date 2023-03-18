<?php 
                                        if (isset($_POST['submit'])) {
                                           
                                            $check = 0;
                                            $email = mysqli_real_escape_string($con, $_POST['email']);
                                            $regex_email = "/^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[_a-z0-9-]+)*(\.[a-z]{2,3})$/";
                                            if (!preg_match($regex_email, $email)) {
                                                echo "<p class=\"error\">Email không hợp lệ</p><br>";
                                                $check++;
                                            }
                                            $password = mysqli_real_escape_string($con,$_POST['password']);
                                            if(strlen($password)<6){
                                                echo "<p class=\"error\">Password không hợp lệ, tối thiểu 6 kí tự</p><br>";
                                                $check++;
                                            }
                                            if($check == 0){
                                                $user_authentication_query = "select role,user_id,email from user where email='$email' and pass='$password'";
                                                $user_authentication_result = mysqli_query($con, $user_authentication_query) or die(mysqli_error($con));
                                                $rows_fetched = mysqli_num_rows($user_authentication_result);
                                                if($rows_fetched==0){
                                                    echo "<p class=\"error\">Sai email hoặc mật khẩu</p><br>";
                                                }
                                                else{
                                                    $row= mysqli_fetch_assoc($user_authentication_result);
                                                    if($row['role'] == 'admin'){
                                                        $_SESSION['email'] = $email;
                                                        $_SESSION['id'] = $row['user_id'];
                                                        $_SESSION['role'] = $row['role'];
                                                        header('location:admin.php');
                                                    }
                                                    else{
                                                        $_SESSION['email']=$email;
                                                        $_SESSION['id']=$row['user_id'];
                                                        $_SESSION['role'] = $row['role'];//user id
                                                        header('location:products.php');
                                                    }
                                                }
                                            }
                                        }
                                     ?>
