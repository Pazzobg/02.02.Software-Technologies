<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
<form>
    N: <input type="text" name="num" />
    <input type="submit" />
</form>
<?php
if (isset($_GET["num"])){
    $n = intval($_GET["num"]);
    $notDivisors = [];

    for ($i = $n-1; $i > 1; $i--){
        if (!is_int($n / $i)){
            $notDivisors[] = $i;
        }
    }

    if (count($notDivisors) > 0) {
        echo implode(" ", $notDivisors);
    }
}
?>
</body>
</html>