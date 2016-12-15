<?php
	$host="localhost";
        $user="root";
        $password="cold";
        $dbname="data";

        try{
	
    $conn = new PDO("mysql:host=$host;dbname=$dbname", $user, $password);
    $conn -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	 if(isset($_POST['submit']))
    {
	$salt = "12lasasasm%12s$";
	$uname = ($_POST['name']);
	$upass = ($_POST['password'].$salt);
	$hash_pass=md5($upass);

    $stmt = $conn->prepare("Select * FROM login Where username LIKE'$uname' AND password LIKE'$hash_pass'");
    $stmt->execute();
    $numRow=$stmt->fetch(PDO::FETCH_ASSOC);
    if($numRow!= 0)
	{
	  session_start();
	  $_SESSION['username']=$numRow['username'];
		
		header("Location: out.php");
	}
	else
	{
	echo "Invalid Username or Password!";
	}
}
   } catch(PDOException $e)
    {
    echo $e->getMessage();
    }
     $conn = null;   
?>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/bootstrap.css"/>
    </head>
    <body>
        
        <form class="form-horizontal" role="form" method="post" action="">
            <h1> Login</h1>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">UserName</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="name" name="name" placeholder="username" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">password</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="password" name="password" placeholder="password" value="">
		</div>
        </div>
	<div class="form-group">
		<div class="col-sm-10 col-sm-offset-2">
			<input id="submit" name="submit" type="submit" value="submit" class="btn btn-primary">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10 col-sm-offset-2">
			<! Will be used to display an alert to the user>
		</div>
	</div>
</form>
<p><a href="register.php">Click here to Register</a></p>
</html>