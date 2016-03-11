<?php
/**
 * Created by PhpStorm.
 * User: moons
 * Date: 3/11/2016
 * Time: 10:46 AM
 */

$xml = simplexml_load_file('svn_log.xml') or die("Error: Cannot create Object");

foreach($xml->logentry as $log) {
    $date = substr($log->date, 0, 10);
    $time = substr($log->date, 11, 12);
    $path = $log->paths->path;
    $msg = $log->msg;
    $auth = $log->author;
    if(strpos($path, 'Assignment2.') !== false) {
        echo "$date: submitted on $time Commit Message : <b>$msg</b><br>\n";
    }

}