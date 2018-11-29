<?php
 require 'dbconnect.php';

if($_SERVER['REQUEST_METHOD']=='GET'){
		
   $distributor_emailId=$_GET['distributor_emailId'];
   $distributor_firstName=$_GET['distributor_firstName'];
   $distributor_contact=$_GET['distributor_contact'];
   $food_category=$_GET['food_category'];
  
   
		$sql1="INSERT INTO `allocation_tab`(`distributor_emailId`,`distributor_firstName`,`distributor_contact`,`food_category`) VALUES ('$distributor_emailId','$distributor_firstName','$distributor_contact','$food_category')";

$q1="UPDATE `userregister_tab` SET `user_contact`='on' WHERE `user_name`='light'";

  if(mysqli_query($db,$sql1))

   {
 
 	$response['success'] = "200";
        
        //$response="success";
       die(print_r(json_encode($response),true));
  }
   else{
        $response="failed to register try again";
        die(print_r(json_encode($response),true));
    }
    mysqli_close($db);
}
?>
