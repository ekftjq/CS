<?php
/**
 * Created by PhpStorm.
 * User: moons
 * Date: 3/11/2016
 * Time: 10:46 AM
 */

include 'parse.php';

for($i = 0; $i < sizeof($path); $i++) {
    if(strpos($path[$i], 'Assignment1.') !== false) {
        echo "$date[$i]: submitted on $time[$i] Commit Message : <b>$msg[$i]</b><br>\n";
    }
}

