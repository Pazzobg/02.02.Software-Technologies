<?php
function calculateFahrenheit(float $celsius) : float {
    return ($celsius * 1.8) + 32;
}

function calculateCelsius(float $fahrenheit) : float {
    return ($fahrenheit - 32) / 1.8;
}

$outputCelsius = "";
if (isset($_GET["cel"])){
    $celsius = floatval($_GET["cel"]);
    $result = calculateFahrenheit($celsius);
    $outputCelsius = "$celsius &deg;C = $result &deg;F";
}

$outputFahrenheit = "";
if (isset($_GET["fah"])){
    $fahrenheit = floatval($_GET["fah"]);
    $result = calculateCelsius($fahrenheit);
    $outputFahrenheit = "$fahrenheit &deg;F = $result &deg;C";
}
?>

<form>
    Celsius: <input type="text" name="cel"/>
    <input type="submit" />
    <?= $outputCelsius?>
</form>
<form>
    Fahrenheit: <input type="text" name="fah"/>
    <input type="submit" />
    <?= $outputFahrenheit?>
</form>
