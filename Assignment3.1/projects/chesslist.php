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

<div id="wrapper3">
    <div id="content" class="container">
        <p><?php
            $svnlist = simplexml_load_file('../svn_list.xml') or die("Error: Cannot create Object");

            foreach($svnlist->list->entry as $entry) {
                $name = $entry->name;
                if(strpos($name, 'Assignment1.') !== false) {
                    echo "$name<br>\n";
                }

            }
            ?></p>
    </div>
</div>

<?php
include '../wrapper/footer.php';
?>
</body>
</html>

