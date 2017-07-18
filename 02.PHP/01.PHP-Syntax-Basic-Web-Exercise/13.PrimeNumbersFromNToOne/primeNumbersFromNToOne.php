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
        $primes = [];

        for ($i = $n; $i > 1; $i--){
            $currentNum = $i;

            $divider = 2;
            $maxDivider = (int) sqrt($currentNum);
            $prime = true;

            while ($prime && ($divider <= $maxDivider)){
                if ($currentNum % $divider == 0){
                    $prime = false;
                }

                $divider++;
            }

            if ($prime) {
                $primes[] = $currentNum;
            }
        }
    
        if (count($primes) > 0) {
            echo implode(" ", $primes);
        }
    }
    ?>
</body>
</html>