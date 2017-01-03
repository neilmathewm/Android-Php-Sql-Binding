<?php
include 'connect_db.php';
?>
<?php	

       $id=$_REQUEST['id1'];
	$name=$_REQUEST['name1'];
        $nam="ppp";
	

	$r=mysql_query("SELECT PASSWORD FROM  `users` WHERE username ='$name'");
          while($ar=mysql_fetch_array($r))    
	{
                
		  
                 
		$flag[name2]=$ar[PASSWORD];
                
		
	}

	print(json_encode($flag));
	mysql_close($con);
?>