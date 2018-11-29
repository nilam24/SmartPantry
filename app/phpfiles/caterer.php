<?php
 require 'dbconnect.php';

if($_SERVER['REQUEST_METHOD']=='GET'){
		
   $caterer_firstName=$_GET['caterer_firstName'];
   $caterer_lastName=$_GET['caterer_lastName'];
   $caterer_emailId=$_GET['caterer_emailId'];
   $caterer_pass=$_GET['caterer_pass'];
   $caterer_contact=$_GET['caterer_contact'];
   $caterer_city=$_GET['caterer_city'];
   $caterer_state=$_GET['caterer_state'];
   $caterer_country=$_GET['caterer_country'];
 
   $sql1="INSERT INTO `caterer_tab`(`caterer_firstName`,`caterer_lastName`,`caterer_emailId`,`caterer_pass`,`caterer_contact`,`caterer_city`,`caterer_state`,`caterer_country`) VALUES ('$caterer_firstName','$caterer_lastName','$caterer_emailId','$caterer_pass','$caterer_contact','$caterer_city','$caterer_state','$caterer_country')";

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
