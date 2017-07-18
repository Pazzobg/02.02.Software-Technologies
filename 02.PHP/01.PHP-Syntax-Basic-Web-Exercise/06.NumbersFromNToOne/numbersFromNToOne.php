<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
<form>
    N1: <input type="text" name="num" />
    <input type="submit" />
</form>

<?php
if (isset($_GET["num"])){
    $numberOne = intval($_GET["num"]);

    for ($i = $numberOne; $i >= 1; $i--){
        $numbers[] = $i;
    }

    echo implode(" ", $numbers);
};
?>
</body>
</html>