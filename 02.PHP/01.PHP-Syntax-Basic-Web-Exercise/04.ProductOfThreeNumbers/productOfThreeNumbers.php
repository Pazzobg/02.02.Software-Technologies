<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
<form>
    N1: <input type="text" name="num1" />
    N2: <input type="text" name="num2" />
    N3: <input type="text" name="num3" />
    <input type="submit" value="Изпращане" />
</form>

<?php
if (isset($_GET["num1"]) && isset($_GET["num2"]) && isset($_GET["num3"])){
    $numberOne = intval($_GET["num1"]);
    $numberTwo = intval($_GET["num2"]);
    $numberThree = intval($_GET["num3"]);
    $numbers = [$numberOne, $numberTwo, $numberThree];

    if ($numberTwo === 0 || $numberTwo === 0 || $numberThree === 0){
        echo "Positive";
    } else {
        $count = 0;

        for ($i = 0; $i < count($numbers); $i++){
            if ($numbers[$i] < 0) {
                $count++;
            }
        }

        if ($count % 2 != 0){
            echo "Negative";
        } else {
            echo "Positive";
        }
    }
}
?>
</body>
</html>