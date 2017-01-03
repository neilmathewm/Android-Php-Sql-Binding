<?php
error_reporting(0); 
$con=mysql_connect("SERVER IP","YOUR USERNAME","YOUR PASSWORD");
if(!$con)
{
echo "not connected";

}

mysql_select_db("root1",$con);

?>

