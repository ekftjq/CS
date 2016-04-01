<?php

/**
 * Created by PhpStorm.
 * User: moons
 * Date: 3/11/2016
 * Time: 1:35 PM
 */

include 'parse.php';


class parseTest extends PHPUnit_Framework_TestCase
{
    public function testName($name) {
        if($name[0] == "Assignment0") {
            return true;
        }
        return false;
    }

    public function testDate($date) {
        if($date[0] == "2016-03-04") {
            return true;
        }
        return false;
    }

    public function testPath($path) {
        if($path[0] == "/kim186/Assignment2.0/CSAir/main.rb") {
            return true;
        }
        return false;
    }

    public function testMsg($msg) {
        if($msg[0] == "") {
            return true;
        }
        return false;
    }
}
