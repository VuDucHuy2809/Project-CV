<table class="table table-bordered table-striped">
                        <tbody>
                           <?php 
                             require '../connectdb/connect.php';
                                $con = ketnoi();
                                if(!isset($_SESSION['email'])){
                                    header('location: login.php');
                                }
                                $user_id=$_SESSION['id'];
                                $user_products_query="select s.name,c.quantity,c.size,c.add_date,c.status,s.price
                                                        from cart as c join shoes as s 
                                                        on c.shoe_id=s.shoe_id 
                                                        where c.user_id=$user_id and status not like 'Added to cart'";
                            $user_products_result=mysqli_query($con,$user_products_query) or die(mysqli_error($con));
                            if(mysqli_num_rows($user_products_result)!=0){
                                ?>
                                <tr>
                                    <th>Name</th>
                                    <th>Size</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                    <th>Add Cart Date</th>
                                    <th>Status</th>

                                </tr>
                           <?php 
                                while($row=mysqli_fetch_assoc($user_products_result)){

                             ?>
                            <tr>
                                
                                <th><?php echo $row['name']?></th>
                                <th><?php echo $row['size']?></th>
                                <th><?php echo $row['quantity']?></th>
                                <th><?php echo $row['price']?></th>
                                <th><?php echo $row['add_date']?></th>
                                <th style="color:#92f200;"><?php echo $row['status']?></th>
                            </tr>
                           <?php }
                            }
                            else{
                           ?>
                        <h3>There is no history at here!Go to <a href="../giaodien/products.php">shopping</a></h3>
                            <?php }?>
                        </tbody>
                    </table>
