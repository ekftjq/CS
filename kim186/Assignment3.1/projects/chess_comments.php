

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : MetroBiz
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20140207

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
    <link href="../css/templated-metrobiz/default.css" rel="stylesheet" type="text/css" media="all" />
    <link href="../css/templated-metrobiz/fonts.css" rel="stylesheet" type="text/css" media="all" />

    <!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
<?php
include '../wrapper/project_header.php';
?>

<!-- Comment box code was written by looking at the tutorial on
     https://www.youtube.com/watch?v=CS45YAqCgX8
-->
<?php
require ('connect.php');
$name = $_POST['name'];
$comment = $_POST['comment'];
$submit = $_POST['submit'];

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
?>

<div id="wrapper3">
    <div id="content" class="container">
        <form action="chess_comments.php" method="post">
            <table>
                <tr><td>User Name:</td><td><input type="text" name="name" /> </td></tr>
                <tr><td colspan="2">Comment:</td></tr>
                <tr><td colspan="2"><textarea name="comment"></textarea></td></tr>
                <tr><td colspan="2"><input type="submit" name="submit" value="Comment" /></textarea></td></tr>
            </table>
        </form>


        <?php

        $get_query = $db->query('SELECT * FROM comments');
        while($rows = $get_query->fetchArray()) {

            $num = $rows['post_num'];
            $name = $rows['user_name'];
            $comment = $rows['content'];

            echo $name . '<br />' . '<br />'  . $comment . '<br />' . '<br />' . '<hr width = "500px"/>';
        }

        ?>

    </div>
</div>

<?php
include '../wrapper/footer.php';
?>
</body>
</html>

