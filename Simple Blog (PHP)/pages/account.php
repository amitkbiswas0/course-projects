<?php
require '../config.php';
require 'header.php';

if (!isset($_SESSION['loggedIn'])) {
  header('Location: ../index.php?error=notLoggedIn');
  exit();
}
if (isset($_GET['delpost'])) {

  if ($_SESSION['userType'] == 'doctor') {
    $sql = 'DELETE FROM posts WHERE post_id=?';
    $stmt = mysqli_stmt_init($conn);
    if (!mysqli_stmt_prepare($stmt, $sql)) {

      header("Location: ../pages/error.php?error=mysqlerror");
      exit();
    } else {
      mysqli_stmt_bind_param($stmt, "s", $_GET['delpost']);
      mysqli_stmt_execute($stmt);
      header('Location: account.php?action=deleted');
      exit();
    }
  } else if ($_SESSION['userType'] == 'user') {
    $sql = 'DELETE FROM submissions WHERE spost_id=?';
    $stmt = mysqli_stmt_init($conn);
    if (!mysqli_stmt_prepare($stmt, $sql)) {

      header("Location: ../pages/error.php?error=mysqlerror");
      exit();
    } else {
      mysqli_stmt_bind_param($stmt, "s", $_GET['delpost']);
      mysqli_stmt_execute($stmt);
      header('Location: account.php?action=deleted');
      exit();
    }
  } else { }
}
?>


<main>
  <div class="account-container">
    <div class="post-table">
      <table id="post-table">
        <tr>
          <th>Post Title</th>
          <th>Date</th>
          <th>Action</th>
        </tr>

        <?php

        if ($_SESSION['userType'] == 'doctor') {

          $sql = 'SELECT * FROM posts WHERE post_author=?';
          $stmt = mysqli_stmt_init($conn);
          if (!mysqli_stmt_prepare($stmt, $sql)) {
            header("Location: ../pages/error.php?error=mysqlerror");
            exit();
          } else {
            mysqli_stmt_bind_param($stmt, "s", $_SESSION['userName']);
            mysqli_stmt_execute($stmt);
            $result = mysqli_stmt_get_result($stmt);
            while ($row = mysqli_fetch_assoc($result)) {

              echo '<tr>';
              echo '<td>' . $row['post_title'] . '</td>';
              echo '<td>' . date('jS M Y', strtotime($row['post_date'])) . '</td>';
              echo '<td>';
              echo '<a href="editpost.php?id=' . $row['post_id'] . '">Edit</a>';
              echo '  |  '; ?>
              <a href="javascript:delpost('
                                          <?php echo $row['post_id'] ?> ',' 
                                          <?php echo trim($row['post_title']) ?> ')">Delete</a>
              </td>
            <?php
          }
        }
      } else if ($_SESSION['userType'] == 'user') {

        $sql = 'SELECT * FROM submissions WHERE spost_author=?';
        $stmt = mysqli_stmt_init($conn);
        if (!mysqli_stmt_prepare($stmt, $sql)) {
          header("Location: ../pages/error.php?error=mysqlerror");
          exit();
        } else {
          mysqli_stmt_bind_param($stmt, "s", $_SESSION['userName']);
          mysqli_stmt_execute($stmt);
          $result = mysqli_stmt_get_result($stmt);
          while ($row = mysqli_fetch_assoc($result)) {

            echo '<tr>';
            echo '<td>' . $row['spost_title'] . '</td>';
            echo '<td>' . date('jS M Y', strtotime($row['spost_date'])) . '</td>';
            echo '<td>';
            ?>
              <a href="javascript:delpost('
                                          <?php echo $row['spost_id'] ?> ',' 
                                          <?php echo trim($row['spost_title']) ?> ')">Delete</a>
              </td>
            <?php
          }
        }
      } else {
        echo '<p>Problem with user/doctor</p>';
      }
      ?>

      </table>
    </div>

    <aside>
      <a href="addpost.php">Add Post</a>
    </aside>
  </div>
</main>