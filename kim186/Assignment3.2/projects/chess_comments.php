

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

<div id="wrapper3">
    <div id="content" class="container">
        <form id="form">
            <table>
                <tr><td>User Name:</td><td><input type="text" id="name" /> </td></tr>
                <tr><td colspan="2">Comment:</td></tr>
                <tr><td colspan="2"><textarea id="comment" type="text"></textarea></td></tr>
                <tr><td colspan="2"><input type="submit" id="submit" name="submit" value="Comment" /></textarea></td></tr>
            </table>

            <script src="../jquery.js"></script>
            <script>
                $(document).ready(function(){
                    $("#submit").click(function(){
                        var name = $("#name").val();
                        var comment = $("#comment").val();
                        var dataString = 'name1='+ name + '&comment1='+ comment;
                        // AJAX Code To Submit Form.
                        $.ajax({
                            type: "POST",
                            url: "post_comments.php",
                            data: dataString,
                            cache: false,
                            success: function(response){
                                document.getElementById("all_comments").innerHTML=response+document.getElementById("all_comments").innerHTML;
                                document.getElementById("comment").value="";
                                document.getElementById("name").value="";
                            }
                        });
                        return false;
                    });
                });
            </script>


            <div id="all_comments">
                <?php
                include 'connect.php';
                $get_query = $db->query('SELECT * FROM comments ORDER BY post_num DESC');
                while($rows = $get_query->fetchArray()) {

                    $num = $rows['post_num'];
                    $name = $rows['user_name'];
                    $comment = $rows['content'];

                    echo $name . '<br />' . '<br />'  . $comment . '<br />' . '<br />' . '<hr width = "500px"/>';
                }

                ?>

            </div>
        </form>
        

    </div>
</div>







<?php
include '../wrapper/footer.php';
?>
</body>
</html>

