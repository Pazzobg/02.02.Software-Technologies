<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
<form>
    N: <input type="text" name="num1" />
    М: <input type="text" name="num2" />
    <input type="submit" value="Изпращане" />
</form>

<?php
if (isset($_GET["num1"]) && isset($_GET["num2"])){
    $numberOne = intval($_GET["num1"]);
    $numberTwo = intval($_GET["num2"]);
    if ($numberTwo >= $numberOne){
        echo $numberOne * $numberTwo;
    } else {

        echo (float) $numberOne / $numberTwo;
    }
}
?>
</body>
</html>