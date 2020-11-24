

<?php
	include 'db.php';
	$a=$_POST['url1'];
    $b=$_POST['desc1'];
	
	$sql = "insert into wpsa3q2 VALUES ('$a','$b')";
	$query=mysqli_query($con,$sql);
    if($query)
    {
       echo "successful";
    }
    else
    {
       echo "Failed";
    }
?>
 