<?php
	echo "<table style'border: solid 2px blue;'>";
	echo "<tr><th>name</th><th>email</th><th>message</th></tr>";
	
	class TableRows extends RecursiveIteratorIterator {
	function __construct($m) {
		parent::__construct($m, self::LEAVES_ONLY);
	}
	function current() {
        return "<td style='width:150px;border:1px solid black;'>" . parent::current(). "</td>";
    }

    function beginChildren() { 
        echo "<tr>"; 
    } 

    function endChildren() { 
        echo "</tr>" . "\n";
    } 
} 
	$host="localhost";
        $user="root";
        $password="cold";
        $dbname="data";

        try{
    $conn = new PDO("mysql:host=$host;dbname=$dbname", $user, $password);
    $conn -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $stmt = $conn->prepare("Select * From store");
    $stmt->execute();

	  $result = $stmt->setFetchMode(PDO::FETCH_ASSOC); 
    foreach(new TableRows(new RecursiveArrayIterator($stmt->fetchAll())) as $k=>$v) { 
        echo $v;
    }
}
catch(PDOException $e)
    {
    echo $e->getMessage();
    }
     $conn = null;   
     echo "</table>";
     ?>
	