
<?php
/**
 * Created by PhpStorm.
 * User: moons
 * Date: 3/11/2016
 * Time: 9:23 AM
 */
$svnlist = simplexml_load_file('svn_list.xml') or die("Error: Cannot create Object");

foreach($svnlist->list->entry as $entry) {
    $name = $entry->name;
    if(strpos($name, 'Assignment2.') !== false) {
        echo "$name<br>\n";
    }

}



