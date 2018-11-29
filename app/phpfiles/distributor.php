<?php
 require 'dbconnect.php';

if($_SERVER['REQUEST_METHOD']=='GET'){
		
   $distributor_firstName=$_GET['distributor_firstName'];
   $distributor_lastName=$_GET['distributor_lastName'];
   $distributor_emailId=$_GET['distributor_emailId'];
   $distributor_pass=$_GET['distributor_pass'];
   $distributor_contact=$_GET['distributor_contact'];
   $distributor_city=$_GET['distributor_city'];
   $distributor_state=$_GET['distributor_state'];
   
   $distributor_country=$_GET['distributor_country'];
 
   $sql1="INSERT INTO `distributor_tab`(`distributor_firstName`,`distributor_lastName`,`distributor_emailId`,`distributor_pass`,`distributor_contact`,`distributor_city`,`distributor_state`,`distributor_country`) VALUES ('$distributor_firstName','$distributor_lastName','$distributor_emailId','$distributor_pass','$distributor_contact','$distributor_city','$distributor_state','$distributor_country')";

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
