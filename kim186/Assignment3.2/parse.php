<?php

/**
 * Created by PhpStorm.
 * User: moons
 * Date: 3/11/2016
 * Time: 11:42 AM
 */


$xml = simplexml_load_file('svn_log.xml');
$svnlist = simplexml_load_file('svn_list.xml');
$date = array();
$time = array();
$msg = array();
$name = array();
$test = array();
$path = array();
$i = 0;

array_push($test, "hello");

foreach($xml->logentry as $log) {
    array_push($date, substr($log->date, 0, 10));
    array_push($time, substr($log->date, 11, 12));
    array_push($msg, $log->msg);
    array_push($path, $log->paths->path);
    //echo "$date[$i]: submitted on $time[$i] Commit Message : <b>$msg[$i]</b><br>\n";
    $i++;
}

$i = 0;
foreach($svnlist->list->entry as $entry) {
    array_push($name, $entry->name);
    //echo "$name[$i]<br>\n";
    $i++;
}

