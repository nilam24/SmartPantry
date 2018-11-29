<?php
require 'dbconnect.php';
$sql="select * from product_vegetable_tab";
$result=mysqli_query($db,$sql);
$response1=array();
while($row=mysqli_fetch_array($result))
{     	    
    array_push($response1,array('product_vege_id'=>$row['product_vege_id'],'product_vege_img'=>base64_encode($row['product_vege_img']),'product_vege_name'=>$row['product_vege_name'],'product_vege_quantity_in_gm'=>$row['product_vege_quantity_in_gm']));

}
die(print_r(json_encode($response1),true));
mysqli_close($db);
?>
