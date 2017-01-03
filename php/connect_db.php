<?php
error_reporting(0); 
$con=mysql_connect("localhost","root","");
if(!$con)
{
echo "not connected";

}

mysql_select_db("root1",$con);

?>

