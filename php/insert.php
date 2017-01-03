<?php
include 'connect_db.php';
?>
<?php	

       $id=$_REQUEST['id1'];
	$name=$_REQUEST['name1'];

	$flag['code']=0;

	if($r=mysql_query("INSERT INTO `users`(`username`, `password`) VALUES ('$id','$name') ",$con))
              
	{
		$flag['code']=1;
		echo"hi";
	}

	print(json_encode($flag));
	mysql_close($con);
?>