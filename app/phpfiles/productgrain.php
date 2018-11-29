<?php
require 'dbconnect.php';
$sql="select * from product_grain_tab";
$result=mysqli_query($db,$sql);
$response1=array();
while($row=mysqli_fetch_array($result))
{     	    
    array_push($response1,array('product_grain_id'=>$row['product_grain_id'],'product_grain_img'=>base64_encode($row['product_grain_img']),'product_grain_name'=>$row['product_grain_name'],'product_grain_quantity_in_gm'=>$row['product_grain_quantity_in_gm']));

}
die(print_r(json_encode($response1),true));
mysqli_close($db);
?>
