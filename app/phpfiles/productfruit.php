<?php
require 'dbconnect.php';
$sql="select * from product_fruit_tab";
$result=mysqli_query($db,$sql);
$response1=array();
while($row=mysqli_fetch_array($result))
{     	    
    array_push($response1,array('product_fruit_id'=>$row['product_fruit_id'],'product_fruit_img'=>base64_encode($row['product_fruit_img']),'product_fruit_name'=>$row['product_fruit_name'],'product_fruit_quantity_in_gm'=>$row['product_fruit_quantity_in_gm']));

}
die(print_r(json_encode($response1),true));
mysqli_close($db);
?>
