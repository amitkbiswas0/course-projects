<?php

require '../config.php';

if (isset($_POST['editpost-submit'])) {

  $postTitle = $_POST['postTitle'];
  $postContent = $_POST['postContent'];
  $userID = $_SESSION['postID'];
  $userName = $_SESSION['userName'];
  $postImg = $_POST['postImg'];

  $sql = 'UPDATE posts SET post_author=?, post_title=?, post_content=?, post_date=?, post_img=? WHERE post_id=?';
  $stmt = mysqli_stmt_init($conn);
  if (!mysqli_stmt_prepare($stmt, $sql)) {
    echo 'here';
    header("Location: error.php?error=mysqlerror");
    exit();
  } else {
    mysqli_stmt_bind_param($stmt, "ssssss", $userName, $postTitle, $postContent, date('Y-m-d H:i:s'), $postImg, $userID);
    mysqli_stmt_execute($stmt);

    header('Location: ../pages/account.php?post=edited');
    exit();
  }
}
