<?php
require '../config.php';
require 'header.php';

if (!isset($_SESSION['loggedIn'])) {
  header('Location: ../index.php');
  exit();
}
?>
<main>
  <?php

  if ($_SESSION['userType'] == 'doctor') {
    $sql = 'SELECT * FROM submissions ORDER BY spost_date';
    $stmt = mysqli_stmt_init($conn);
    if (!mysqli_stmt_prepare($stmt, $sql)) {

      header("Location: error.php?error=mysqlerror");
      exit();
    } else {

      mysqli_stmt_execute($stmt);
      $result = mysqli_stmt_get_result($stmt);

      while ($row = mysqli_fetch_assoc($result)) {

        echo '<article>';
        echo '<div class="post-title">';
        echo '<h1><a href="viewpost.php?id=' . $row['spost_id'] . '">' . $row['spost_title'] . '</a></h1>';
        echo '</div>';
        echo '<div class="post-date">';
        echo '<p>Posted on : ' . date('jS M Y H:i:s', strtotime($row['post_date'])) . '</p>';
        echo '</div>';
        echo '<div class="post-content">';
        echo $row['spost_content'];
        echo '</div>';
        echo '</div>';
        echo '</article>';
      }
    }
  } else if ($_SESSION['userType'] == 'user') {

    $userName = $_SESSION['userName'];
    $sql = 'SELECT * FROM submissions WHERE spost_author=? ORDER BY spost_date';
    $stmt = mysqli_stmt_init($conn);
    if (!mysqli_stmt_prepare($stmt, $sql)) {

      header("Location: error.php?error=mysqlerror");
      exit();
    } else {

      mysqli_stmt_bind_param($stmt, "s", $userName);
      mysqli_stmt_execute($stmt);
      $result = mysqli_stmt_get_result($stmt);

      while ($row = mysqli_fetch_assoc($result)) {

        echo '<article>';
        echo '<div class="post-title">';
        echo '<h2>' . $row['spost_title'] . '</h2>';
        echo '</div>';
        echo '<div class="post-date">';
        echo '<p>Posted on :' . date('jS M Y H:i:s', strtotime($row['spost_date'])) . '</p>';
        echo '</div>';
        echo '<div class="post-content">';
        echo $row['spost_content'];
        echo '</div>';
        echo '</div>';
        echo '</article>';
      }
    }
  } else { }
  ?>
</main>