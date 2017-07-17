<?php
if (isset($_GET["person"])){
    $currentPerson = htmlspecialchars($_GET["person"]);
    echo "Hello $currentPerson!";
}
?>
<form>
    Name: <input type="text" name="person" />
    <input type="submit" />
</form>