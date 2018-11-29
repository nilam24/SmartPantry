<?php
 require 'dbconnect.php';

if($_SERVER['REQUEST_METHOD']=='GET'){
		
   $manager_emailId=$_GET['manager_emailId'];
   $manager_pass=$_GET['manager_pass'];
   $manager_firstName=$_GET['manager_firstName'];
   $manager_contact=$_GET['manager_contact'];
   
   
		//$sql1="INSERT INTO `userregister_tab`(`user_id`,`user_pass`,`user_name`,`user_contact`) VALUES ('$user_id','$user_pass','$user_name','$user_contact')";

$q1="UPDATE `manager_tab` SET `manager_pass`='$manager_pass' WHERE `manager_emailId`='$manager_emailId'";

  if(mysqli_query($db,$q1))

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
