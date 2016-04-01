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
<html xmlns="http://www.w3.org/1999/xhtml" xmlns="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
    <link href="../css/templated-metrobiz/default.css" rel="stylesheet" type="text/css" media="all" />
    <link href="../css/templated-metrobiz/fonts.css" rel="stylesheet" type="text/css" media="all" />

    <!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

    <script type="text/javascript">
        pageExecute.init();
    </script>

</head>
<body>
<?php
include '../wrapper/project_header.php';
?>

<script type="text/javascript"> alert(pageExecute.fileContents); </script>
<div id="wrapper3">
    <div id="content" class="container">

        <script src="../jquery.js"></script>
        <script>
            $(document).ready(function(){
                $("button").click(function(){
                    $("#div1").load("../chessfiles/everything.java #p2");
                    $("#div2").load("../chessfiles/everything.java #p2");
                    //$("#div1").load("../chessfiles/Block.java");

                });
            });
        </script>

        <div id="div1"><h2>Board.java</h2></div>
        <button>Board.java</button>

        <!--
        <div id="div2"><h2>Board.java</h2></div>
        <button>Board.java</button>
        <div id="div3"><h2>BoardTest.java</h2></div>
        <button>BoardTest.java</button>
        <div id="div4"><h2>EndGame.java</h2></div>
        <button>EndGame.java</button>
        <div id="div5"><h2>GameMain.java</h2></div>
        <button>GameMain.java</button>
        <div id="div6"><h2>Player.java</h2></div>
        <button>Player.java</button>
        -->
    </div>
</div>

<?php
include '../wrapper/footer.php';
?>
</body>
</html>

