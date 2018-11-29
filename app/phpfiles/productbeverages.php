<?php
require 'dbconnect.php';
$sql="select * from product_beverages_tab";
$result=mysqli_query($db,$sql);
$response1=array();
while($row=mysqli_fetch_array($result))
{     	    
    array_push($response1,array('product_beverage_id'=>$row['product_beverage_id'],'product_beverage_img'=>base64_encode($row['product_beverage_img']),'product_beverage_name'=>$row['product_beverage_name'],'product_beverage_quantity_in_gm'=>$row['product_beverage_quantity_in_gm']));

}
die(print_r(json_encode($response1),true));
mysqli_close($db);
?>
