 <?php
        $host="localhost";
        $user="root";
        $password="cold";
        $dbname="data";

        try{
    $conn = new PDO("mysql:host=$host;dbname=$dbname", $user, $password);
    
    $conn -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    
      if (isset($_POST["submit"])) {
		$name = $_POST['name'];
		$email = $_POST['email'];
		$message = $_POST['message'];
                
        if (!$_POST['name']) {
			$errName = 'Please enter your name';
		}
        if (!$_POST['email'] || !filter_var($_POST['email'], FILTER_VALIDATE_EMAIL)) {
			$errEmail = 'Please enter a valid email address';
		}
       	if (!$_POST['message']) {
			$errMessage = 'Please enter your message';
		}
	$sql = "INSERT INTO store (name,email,message)
                VALUES ('$name','$email', '$message')";

	if ($conn->query($sql)==TRUE) {
		echo "ill be in touch!!";
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
<html>
    <p><a href="login.php">Click here if your an Admin</a></p>
</html>


