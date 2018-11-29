<?php
 require 'dbconnect.php';

  $sqlSelect="select * from distributor_tab";

  $result=mysqli_query($db,$sqlSelect);
  $response=array();
  while($row=mysqli_fetch_array($result))
  {
  array_push($response,array('distributor_firstName'=>$row['distributor_firstName'],'distributor_lastName'=>$row['distributor_lastName'],'distributor_emailId'=>$row['distributor_emailId'],'distributor_pass'=>$row['distributor_pass'],'distributor_contact'=>$row['distributor_contact'],'distributor_city'=>$row['distributor_city'],'distributor_state'=>$row['distributor_state'],'distributor_country'=>$row['distributor_country']));
   

  }

   die(print_r(json_encode($response),true));
  
    mysqli_close($db);
?>
