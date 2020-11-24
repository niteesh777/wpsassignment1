<?php

    $server="localhost";

    $user="root";

    $password="";

    $db="test";

    $con=mysqli_connect($server,$user,$password,$db);

    if($con)
    {
        echo "successful dbcon";
    }else{
        echo "Failed dbcon";
    }
?>