<?php
if (isset($_GET["num1"]) && isset($_GET["num2"])){
    $firstNum = intval($_GET["num1"]);
    $secondNum = intval($_GET["num2"]);

    $result = $firstNum + $secondNum;

    echo "$firstNum + $secondNum = $result";
}
?>

<form>
    <div>First Number: </div>
    <div><input type="text" name="num1" /></div>
    <div>Second Number: </div>
    <div><input type="text" name="num2" /></div>
    <div><input type="submit" /></div>
</form>