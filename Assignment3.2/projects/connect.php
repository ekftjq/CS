<?php

/**
 * Created by PhpStorm.
 * User: moons
 * Date: 3/18/2016
 * Time: 2:34 AM
 */
class connect extends SQLite3
{
    function __construct()
    {
        $this->open('comment_database.db');
    }
}

$db = new connect();
if(!$db) {
    echo $db -> lastErrorMsg();
}
else {
    //echo "Opened database successfully\n";
}
?>
