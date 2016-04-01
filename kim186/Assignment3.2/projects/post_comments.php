<?php
require ('connect.php');
$name = $_POST['name1'];
$comment = $_POST['comment1'];

$badwords = array("bad". "verybad", "superbad", "nono", "yesyes");
$rebad = str_replace($badwords, "****", $comment);
$db ->exec("INSERT INTO comments (user_name, content) VALUES ('$name', '$rebad')");

echo $name . '<br />' . '<br />'  . $rebad . '<br />' . '<br />' . '<hr width = "500px"/>';

/*
$select = $db->query('SELECT user_name, content FROM comments WHERE user_name = $name and content = $comment');
if($rows = $select->fetchArray()) {

    $num = $rows['post_num'];
    $name = $rows['user_name'];
    $comment = $rows['content'];

    echo $name . '<br />' . '<br />'  . $comment . '<br />' . '<br />' . '<hr width = "500px"/>';
}
*/

/*
if($submit) {
    if($name && $comment) {
        $badwords = array("bad". "verybad", "superbad", "nono", "yesyes");
        $rebad = str_replace($badwords, "****", $comment);
        $db ->exec("INSERT INTO comments (user_name, content) VALUES ('$name', '$rebad')");
    }
    else {
        echo "Please fill out all the fields";
    }
}
*/


?>