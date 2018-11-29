<?php
 require 'dbconnect.php';

  $sqlSelect="select * from caterer_tab";

  $result=mysqli_query($db,$sqlSelect);
  $response=array();
  while($row=mysqli_fetch_array($result))
  {
  array_push($response,array('caterer_firstName'=>$row['caterer_firstName'],'caterer_lastName'=>$row['caterer_lastName'],'caterer_emailId'=>$row['caterer_emailId'],'caterer_pass'=>$row['caterer_pass'],'caterer_contact'=>$row['caterer_contact'],'caterer_city'=>$row['caterer_city'],'caterer_state'=>$row['caterer_state'],'caterer_country'=>$row['caterer_country']));
   

  }

   die(print_r(json_encode($response),true));
  
    mysqli_close($db);
?>
