<?php
$towns = "";
if (isset($_GET["lines"])) {
    $towns = explode("\n", $_GET["lines"]);
    $towns = array_map('trim', $towns);
    sort($towns, SORT_STRING);

    $towns = implode("\n", $towns);
}
?>

<form>
    <textarea rows="10" name="lines"><?= $towns?></textarea>
    <br />
    <input type="submit" value="Sort"/>
</form>