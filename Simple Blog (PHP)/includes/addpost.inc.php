<?php

require '../config.php';

if (isset($_POST['post-submit'])) {

  $postTitle = $_POST['postTitle'];
  $postContent = $_POST['postContent'];
  $userName = $_SESSION['userName'];
  $postTime = date('Y-m-d H:i:s');
  $postImg = $_POST['postImg'];

  if ($_SESSION['userType'] == 'doctor') {
    $sql = 'INSERT INTO posts(post_author, post_title, post_content, post_date, post_img) VALUES (?,?,?,?,?);';
    $stmt = mysqli_stmt_init($conn);
    if (!mysqli_stmt_prepare($stmt, $sql)) {

      header("Location: error.php?error=mysqlerror");
      exit();
    } else {

      mysqli_stmt_bind_param($stmt, "sssss", $userName, $postTitle, $postContent, $postTime, $postImg);
      mysqli_stmt_execute($stmt);

      header('Location: ../pages/account.php?post=created');
      exit();
    }
  } else if ($_SESSION['userType'] == 'user') {
    $sql = 'INSERT INTO submissions(spost_author, spost_title, spost_content, spost_date) VALUES (?,?,?,?);';
    $stmt = mysqli_stmt_init($conn);
    if (!mysqli_stmt_prepare($stmt, $sql)) {

      header("Location: error.php?error=mysqlerror");
      exit();
    } else {

      mysqli_stmt_bind_param($stmt, "ssss", $userName, $postTitle, $postContent, $postTime);
      mysqli_stmt_execute($stmt);

      header('Location: ../pages/account.php?post=created');
      exit();
    }
  } else { }
}
