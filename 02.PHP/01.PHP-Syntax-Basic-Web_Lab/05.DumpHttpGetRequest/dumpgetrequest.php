<form>
    <div>Name: </div><input type="text" name="person" />
    <div>Age: </div><input type="text" name="age" />
    <div>Town:</div>
    <select name="townName">
        <option value="10">Sofia</option>
        <option value="20">Plovdiv</option>
        <option value="30">Varna</option>
    </select>
    <div><input type="submit" /></div>
</form>
<?php
var_dump($_GET);
?>