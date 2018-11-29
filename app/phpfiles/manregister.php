<?php
 require 'dbconnect.php';

if($_SERVER['REQUEST_METHOD']=='GET'){
		
   $manager_firstName=$_GET['manager_firstName'];
   $manager_lastName=$_GET['manager_lastName'];
   $manager_emailId=$_GET['manager_emailId'];
   $manager_pass=$_GET['manager_pass'];
   $manager_contact=$_GET['manager_contact'];
   $manager_city=$_GET['manager_city'];
   $manager_state=$_GET['manager_state'];
   $manager_country=$_GET['manager_country'];

   
$sql1="INSERT INTO  
`manager_tab`(`manager_firstName`,`manager_lastName`,`manager_emailId`,`manager_pass`,`manager_contact`,`manager_city`,`manager_state`,`manager_country`) VALUES ('$manager_firstName','$manager_lastName','$manager_emailId','$manager_pass','$manager_contact','$manager_city','$manager_state','$manager_country')";

$q1="UPDATE `device_status_tab` SET `device_status`='on' WHERE `device_name`='light'";

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
