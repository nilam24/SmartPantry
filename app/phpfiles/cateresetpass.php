<?php
 require 'dbconnect.php';

if($_SERVER['REQUEST_METHOD']=='GET'){
		
   $caterer_emailId=$_GET['caterer_emailId'];
   $caterer_pass=$_GET['caterer_pass'];
   $caterer_firstName=$_GET['caterer_firstName'];
   $caterer_contact=$_GET['caterer_contact'];
   
   
		//$sql1="INSERT INTO `userregister_tab`(`user_id`,`user_pass`,`user_name`,`user_contact`) VALUES ('$user_id','$user_pass','$user_name','$user_contact')";

$q1="UPDATE `caterer_tab` SET `caterer_pass`='$caterer_pass' WHERE `caterer_emailId`='$caterer_emailId'";

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
