<?php
require 'dbconnect.php';
$sql="select * from product_non_veg_tab";
$result=mysqli_query($db,$sql);
$response1=array();
while($row=mysqli_fetch_array($result))
{     	    
    array_push($response1,array('product_non_veg_id'=>$row['product_non_veg_id'],'product_non_veg_img'=>base64_encode($row['product_non_veg_img']),'product_non_veg_name'=>$row['product_non_veg_name'],'product_non_veg_quantity'=>$row['product_non_veg_quantity_in_gm']));

}
die(print_r(json_encode($response1),true));
mysqli_close($db);
?>
