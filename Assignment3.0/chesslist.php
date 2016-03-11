
<?php
/**
 * Created by PhpStorm.
 * User: moons
 * Date: 3/11/2016
 * Time: 9:23 AM
 */

include 'parse.php';

for($i = 0; $i < sizeof($name); $i++) {
    if(strpos($name[$i], 'Assignment1.') !== false) {
        echo "$name[$i]<br>\n";
    }
}



