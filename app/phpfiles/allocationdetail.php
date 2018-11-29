<?php
 require 'dbconnect.php';

  $sqlSelect="select * from allocation_tab";

  $result=mysqli_query($db,$sqlSelect);
  $response=array();
  while($row=mysqli_fetch_array($result))
  {
  array_push($response,array('distributor_emailId'=>$row['distributor_emailId'],'distributor_firstName'=>$row['distributor_firstName'],'distributor_contact'=>$row['distributor_contact'],'food_category'=>$row['food_category']));
   

  }

   die(print_r(json_encode($response),true));
  
    mysqli_close($db);
?>
