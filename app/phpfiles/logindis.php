<?php

require 'dbconnect.php';
//if($_SERVER['REQUEST_METHOD']=='GET'){

//	$pat_firstName=$_GET['pat_firstName'];
//	$pat_pass=$_GET['pat_pass'];

	$sql="select * from distributor_tab"; // where pat_firstName='".$pat_firstName."' and pat_pass='".$pat_pass."'"; 

$result=mysqli_query($db,$sql);
$response=array();
while($row=mysqli_fetch_array($result))
{
array_push($response,array('distributor_emailId'=>$row['distributor_emailId'],'distributor_pass'=>$row['distributor_pass']));


}

die(print_r(json_encode($response),true));

mysqli_close($db);
//}
?>
