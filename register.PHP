 <!DOCTYPE html>
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
            <h1> Register</h1>
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

    $sql = ("INSERT Into login(username,password) VALUES('$uname','$hash_pass')");

	if ($conn->query($sql)==TRUE) {
		echo "Account Created Successfully";
	} else {
		echo "there was an error please go back!";
	}
	}
    } catch(PDOException $e)
    {
    echo $e->getMessage();
    }
     $conn = null;   
?>
<p><a href="login.php">login</a></p>
</html>