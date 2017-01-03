<?php
include 'connect_db.php';
?>
<?php
  $e=$_POST['name'];
    $f=$_POST['age'];
    $g=$_POST['address'];
    $h=$_POST['dob'];
    $i=$_POST['gen'];
   $a="abcdef";
   $b="123"; 
mysql_query("INSERT INTO `users`(`username`, `password`) VALUES ('$a','$b')");    

?>
