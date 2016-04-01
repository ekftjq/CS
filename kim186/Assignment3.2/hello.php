<?php
/**
 * Created by PhpStorm.
 * User: moons
 * Date: 3/11/2016
 * Time: 8:01 AM
 */

echo "Hello World!";
$dbhost = "engr-cpanel-mysql.engr.illinois.edu";
$dbuser = "kim186_admin";
$dbpwd = "12345";
$db = "kim186_cs242";

// Create connection
$conn = new mysqli($dbhost, $dbuser, $dbpwd, $db);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}