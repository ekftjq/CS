<?php
$current = basename($_SERVER['PHP_SELF']);
?>

<div id="header-wrapper">
    <div id="header" class="container">
        <div id="logo">
            <h1><a href="#">Moon Seop Kim's Portfolio</a></h1>
            <span>Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a></span>
        </div>
        <div id="menu">
            <ul>
                <li <?php if($current == 'index.php') {echo 'class="current_page_item"';} ?>><a href="../index.php" accesskey="1" title="">Homepage</a></li>
                <li <?php if($current == 'aboutme.php') {echo 'class="current_page_item"';} ?>><a href="../aboutme.php" accesskey="2" title="">About Me</a></li>
                <li <?php if($current == 'svndata.php') {echo 'class="current_page_item"';} ?>><a href="../svndata.php" accesskey="3" title="">SVN Data</a></li>
                <li class="current_page_item"><a href="../projects.php" accesskey="4" title="">Projects</a></li>
                <li <?php if($current == 'contact.php') {echo 'class="current_page_item"';} ?>><a href="../contact.php" accesskey="5" title="">Contact Me!</a></li>
            </ul>
        </div>
    </div>
</div>