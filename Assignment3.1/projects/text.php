<?php
include ('connect.php');
$db = new connect();
$db->exec('CREATE TABLE bar (bar STRING)');
?>