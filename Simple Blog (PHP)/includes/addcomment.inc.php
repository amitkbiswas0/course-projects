<?php

require '../config.php';

if (isset($_POST['cmnt-submit'])) {

  $postContent = $_POST['cmntContent'];
  $userName = $_SESSION['userName'];
  $postTime = date('Y-m-d H:i:s');
  $postID = $_SESSION['postID'];

  $sql = 'INSERT INTO comments(cuser_name, cpost_id, cmnt_content, cmnt_date) VALUES (?,?,?,?);';
  $stmt = mysqli_stmt_init($conn);
  if (!mysqli_stmt_prepare($stmt, $sql)) {

    header("Location: error.php?error=mysqlerror");
    exit();
  } else {

    mysqli_stmt_bind_param($stmt, "ssss", $userName, $postID, $postContent, $postTime);
    mysqli_stmt_execute($stmt);

    header('Location: ../pages/viewpost.php?id=' . $postID);
    exit();
  }
}
