<?php

/**
 * Created by PhpStorm.
 * User: moons
 * Date: 3/18/2016
 * Time: 9:22 AM
 */
class MyDB extends SQLite3
{
    function __construct()
    {
        $this->open('comment_database.db');
    }
}

$db = new MyDB();

$db->exec('CREATE TABLE foo (bar STRING)');
$db->exec("INSERT INTO foo (bar) VALUES ('This is a test')");

$result = $db->query('SELECT bar FROM foo');
var_dump($result->fetchArray());
?>