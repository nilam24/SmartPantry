<?php

require 'dbconnect.php';
//if($_SERVER['REQUEST_METHOD']=='GET'){

//	$pat_firstName=$_GET['pat_firstName'];
//	$pat_pass=$_GET['pat_pass'];

	$sql="select * from caterer_tab"; // where pat_firstName='".$pat_firstName."' and pat_pass='".$pat_pass."'"; 

$result=mysqli_query($db,$sql);
$response=array();
while($row=mysqli_fetch_array($result))
{
array_push($response,array('caterer_emailId'=>$row['caterer_emailId'],'caterer_pass'=>$row['caterer_pass']));


}

die(print_r(json_encode($response),true));

mysqli_close($db);
//}
?>
