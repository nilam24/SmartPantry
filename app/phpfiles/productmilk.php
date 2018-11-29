<?php
require 'dbconnect.php';
$sql="select * from product_milk_tab";
$result=mysqli_query($db,$sql);
$response1=array();
while($row=mysqli_fetch_array($result))
{     	    
    array_push($response1,array('product_milk_id'=>$row['product_milk_id'],'product_milk_img'=>base64_encode($row['product_milk_img']),'product_milk_name'=>$row['product_milk_name'],'product_milk_quantity'=>$row['product_milk_quantity_in_gm']));

}
die(print_r(json_encode($response1),true));
mysqli_close($db);
?>
