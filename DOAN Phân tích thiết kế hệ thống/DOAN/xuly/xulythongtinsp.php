<?php include_once '../model/product_model.php';
                    $id = intval($_GET['shoeid']);
                    $product = new product_model();
                    $stmt = $product->getProductbyid($id);
                    mysqli_stmt_bind_result($stmt, $qty38,$qty39,$qty40,$qty41,$image,$image2,$image3,$name,$price,$mota);
                    $sl38 = (int)$qty38;
                    $sl39 = (int)$qty39;
                    $sl40 = (int)$qty40;
                    $sl41 = (int)$qty41;
                    
                    while (mysqli_stmt_fetch($stmt)) {
                          ?>
        <div class="anh1"  id="a"> 
            <img src="../<?php echo $image;?>" >
        </div>
        <div  class="anhphai" id="a">
            <div class="anh2" >
                <img src="../<?php echo $image2;?>" >
            </div>
            <div class="anh3"  id="a">
                <img src="../<?php echo $image3;?>" >
            </div>
        </div>
        <div class="chu" id="a">
           <p id="a7"><?php echo $name;?></p><br>
            <p>Giá bán:<span id="gia"><?php echo $price;?></span></p><br>
            <p>Vận chuyển:   
                <select>
                    <option>Nhanh</option>
                    <option>Thông thường</option>
                </select><br>
               <span id="a1"> Miễn Phí Vận Chuyển khi đơn đạt giá trị tối thiểu  </span> 
            </p><br>
               <p id="a2">Size: 
                   <select id="sizegiay">
                       <?php if($qty38 == 0){
                        ?>
                                 <option id="38" selected="true" disabled="true">38</option>
                       <?php }else{?>
                                 <option id="38" selected="true">38</option>
                       <?php }?>
                       <?php if($qty39 == 0){
                        ?>
                                 <option id="39" disabled="true">39</option>
                       <?php }else{?>
                                 <option id="39">39</option>
                       <?php }?>
                       <?php if($qty40 == 0){
                        ?>
                                 <option id="40" disabled="true">40</option>
                       <?php }else{?>
                                 <option id="40">40</option>
                       <?php }?>
                       <?php if($qty41 == 0){
                        ?>
                                 <option id="41" disabled="true">41</option>
                       <?php }else{?>
                                 <option id="41">41</option>
                       <?php }?>
                    </select><br>
               </p><br>
               <!--<p id="a2">Màu sắc: <button type="button">�?en</button><button type="button">Trắng</button></p><br>-->
               
                    <p id="a3">Số lượng: 
                        <input onclick="var result = document.getElementById('quantity'); var qty = result.value; if( !isNaN(qty) &amp; qty > 1) result.value--;return false;" type='button' value='-' />
                        <input id='quantity' min='1' name='quantity' type='text' value='1' />
                         <input onclick="var result = document.getElementById('quantity'); var qty = result.value; if( !isNaN(qty)) result.value++;return false;" type='button' value='+' />
                    </p><br><br>
              
                <button id="a4">Thêm vào giỏ hàng</button>
                <p id="addsuccess">Thêm vào giỏ hàng thành công!</p>
         </div>
    </div>
    <div class="mota">

        <p id="b2">Mô tả sản phẩm</p><br>
        <p><?php echo $mota;
                    }
        ?> </p>

 
                     
    
  
