<?php
ob_start();
session_start();

//database handlers
$host = "localhost";
$dbUser = "root";
$dbPass = "tima_6991";
$dbName = "carebear";

$conn = mysqli_connect($host, $dbUser, $dbPass, $dbName);

//check connection
if (!$conn) {
  die("Connection Failed. Error: " . mysqli_connect_error());
}
