<?php
require '../config.php';
require 'header.php';

if (!isset($_SESSION['loggedIn'])) {
  header('Location: ../index.php');
  exit();
}
?>
<main>
  <div class="viewpost-container">
    <?php
    $postID = $_GET['id'];
    $_SESSION['postID'] = $postID;
    $sql = 'SELECT * FROM posts WHERE post_id=?';
    $stmt = mysqli_stmt_init($conn);
    if (!mysqli_stmt_prepare($stmt, $sql)) {

      header("Location: ../pages/error.php?error=mysqlerror");
      exit();
    } else {

      mysqli_stmt_bind_param($stmt, 's', $postID);
      mysqli_stmt_execute($stmt);
      $result = mysqli_stmt_get_result($stmt);
      echo '<div class="article">';
      while ($row = mysqli_fetch_assoc($result)) {

        echo '<div class="post-title">';
        echo '<h2><a href="viewpost.php?id=' . $row['post_id'] . '">' . $row['post_title'] . '</a></h2>';
        echo '</div>';
        echo '<div class="post-date">';
        echo '<p>Posted on :' . date('jS M Y H:i:s', strtotime($row['post_date'])) . '</p>';
        echo '</div>';
        echo '<div class="post-content">';
        echo $row['post_content'];
        echo '</div>';
      }
      echo '</div>';
      echo '<div class="comment-title">';
      echo '<h1>Comments</h1>';
      echo '</div>';
    }
    ?>
    <div class="addcomment-form">
      <form action="../includes/addcomment.inc.php" class="post-form" method="post">
        <textarea name="cmntContent" id="add-textarea" rows="10"></textarea>
        <br>
        <button type="submit" name="cmnt-submit">Submit</button>
      </form>
    </div>

    <?php
    $sql = 'SELECT * FROM comments WHERE cpost_id=?';
    $stmt = mysqli_stmt_init($conn);
    if (!mysqli_stmt_prepare($stmt, $sql)) {

      header("Location: ../pages/error.php?error=mysqlerror");
      exit();
    } else {

      mysqli_stmt_bind_param($stmt, 's', $postID);
      mysqli_stmt_execute($stmt);
      $result = mysqli_stmt_get_result($stmt);
      echo '<div class="comments">';
      while ($row = mysqli_fetch_assoc($result)) {

        echo '<div class="comment-date">';
        echo '<p> ' . $row['cuser_name'] . ' ___Posted on :' . date('jS M Y H:i:s', strtotime($row['cmnt_date'])) . '</p>';
        echo '</div>';

        echo '<div class="comment-content">';
        echo $row['cmnt_content'];
        echo '</div>';
      }

      //require 'footer.php';
      echo '</div>';
    }
    ?>
  </div>
</main>