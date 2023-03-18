<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!--<link rel="stylesheet" href="../css/style.css" type="text/css">-->      
        <title>Thi Web 2</title>
    </head>
    <body>
        
        
        <form action="" method="post" class="col-md-3" onchange="check();">
                <h3>Category Name:</h3>
                <input type="checkbox" class="cbox">
                <label for="fruit">Fruit</label><br>
                <input type="checkbox" class="cbox">
                <label for="greenvege">Green Vegetables</label><br>
                <input type="checkbox" class="cbox">
                <label for="spices">Spices</label><br>
                <button class="btn btn-primary">Filter</button>
                <button class="btn btn-primary">Filter</button>
        </form>
        
        
    </body>
    <script type="text/javascript">
        function disableall(){
            var btns = document.getElementsByClassName("btn");
            for(var i=0; i < btns.length; i++){
                btns[i].disabled = true;
            }
        }
        function enableall(){
            var btns = document.getElementsByClassName("btn");
            for(var i=0; i < btns.length; i++){
                btns[i].disabled = false;
            }
        }
        function check(){
            var flag  = 0;
            var arr = document.getElementsByClassName("cbox");
            var btns = document.getElementsByClassName("btn");
            for(var i =0; i< arr.length ; i++){
               if(arr[i].checked == true){
                  flag = 1;
                  break;
               }
            }
            if(flag == 1) enableall();
            else disableall();
        }
    </script>
</html>
