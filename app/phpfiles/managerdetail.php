<?php
 require 'dbconnect.php';

  $sqlSelect="select * from manager_tab";

  $result=mysqli_query($db,$sqlSelect);
  $response=array();
  while($row=mysqli_fetch_array($result))
  {
  array_push($response,array('manager_firstName'=>$row['manager_firstName'],'manager_lastName'=>$row['manager_lastName'],'manager_emailId'=>$row['manager_emailId'],'manager_pass'=>$row['manager_pass'],'manager_contact'=>$row['manager_contact'],'manager_city'=>$row['manager_city'],'manager_state'=>$row['manager_state'],'manager_country'=>$row['manager_country']));
   

  }

   die(print_r(json_encode($response),true));
  
    mysqli_close($db);
?>
