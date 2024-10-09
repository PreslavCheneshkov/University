<?php
    $host = "localhost:3306";
    $user_name = "root";
    $password = "";
    $db = "moviedb";

    $sql = mysqli_connect($host, $user_name, $password);
    $connectionSuccessful = mysqli_select_db($sql, $db);
?>