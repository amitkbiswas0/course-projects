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
  $sql = 'SELECT * FROM posts ORDER BY post_date';
  $stmt = mysqli_stmt_init($conn);
  
  if (!mysqli_stmt_prepare($stmt, $sql)) {

    header("Location: ../pages/error.php?error=mysqlerror");
    exit();
  } else {

    mysqli_stmt_execute($stmt);
    $result = mysqli_stmt_get_result($stmt);

    while ($row = mysqli_fetch_assoc($result)) {

      echo '<article>';
      echo '<img class="article-img" src="../img/' . $row['post_img'] . '.jpg" alt="">';
      echo '<div class="post-title">';
      echo '<h1><a href="viewpost.php?id=' . $row['post_id'] . '">' . $row['post_title'] . '</a></h1>';
      echo '</div>';
      echo '<div class="post-date">';
      echo '<p>Posted on : ' . date('jS M Y H:i:s', strtotime($row['post_date'])) . '</p>';
      echo '</div>';
      echo '<div class="post-content">';
      $string = $row['post_content'];
      $string = strip_tags($string);
      if (strlen($string) > 500) {

        // truncate string
        $stringCut = substr($string, 0, 500);
        $endPoint = strrpos($stringCut, ' ');

        //if the string doesn't contain any space then it will cut without word basis.
        $string = $endPoint ? substr($stringCut, 0, $endPoint) : substr($stringCut, 0);
        $string .= '  .....' . '<a href="viewpost.php?id=' . $row['post_id'] . '">  Read More</a>';
      }
      echo $string;
      echo '</div>';
      echo '</article>';
    }
    require 'footer.php';
  }
  ?>
</main>