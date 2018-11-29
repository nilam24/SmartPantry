<?php
 require 'dbconnect.php';

if($_SERVER['REQUEST_METHOD']=='GET'){
		
   $distributor_emailId=$_GET['distributor_emailId'];
   $distributor_pass=$_GET['distributor_pass'];
   $distributor_firstName=$_GET['distributor_firstName'];
   $distributor_contact=$_GET['distributor_contact'];
   
   
		//$sql1="INSERT INTO `userregister_tab`(`user_id`,`user_pass`,`user_name`,`user_contact`) VALUES ('$user_id','$user_pass','$user_name','$user_contact')";

$q1="UPDATE `distributor_tab` SET `distributor_pass`='$distributor_pass' WHERE `distributor_emailId`='$distributor_emailId'";

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
