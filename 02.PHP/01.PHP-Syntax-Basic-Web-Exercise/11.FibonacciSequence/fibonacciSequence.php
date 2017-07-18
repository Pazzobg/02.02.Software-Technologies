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
    $fibonacciRow = [1];

    if ($n == 0 || $n == 1){
        echo "1";
    } else {

        $foreLast = 1;
        $last = 1;
        $currentFibonacci = 1;

        for ($i = 1; $i < $n; $i++) {
            $fibonacciRow[] = $currentFibonacci;

            $currentFibonacci = $foreLast + $last;

            $foreLast = $last;
            $last = $currentFibonacci;
        }

        if (count($fibonacciRow) > 0){
            echo implode(" ", $fibonacciRow);
        }
    }
}
?>
</body>
</html>