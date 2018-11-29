<?php
require 'dbconnect.php';
$sql="select * from product_oil_tab";
$result=mysqli_query($db,$sql);
$response1=array();
while($row=mysqli_fetch_array($result))
{     	    
    array_push($response1,array('product_oil_id'=>$row['product_oil_id'],'product_oil_img'=>base64_encode($row['product_oil_img']),'product_oil_name'=>$row['product_oil_name'],'product_oil_quantity'=>$row['product_oil_quantity']));

}
die(print_r(json_encode($response1),true));
mysqli_close($db);
?>
