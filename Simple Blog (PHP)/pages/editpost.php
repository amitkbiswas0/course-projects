<?php
require '../config.php';
require 'header.php';

if (!isset($_SESSION['loggedIn'])) {
  header('Location: ../index.php');
  exit();
}
$_SESSION['postID'] = $_GET['id'];
?>
<main>
  <div class="center">
    <div class="addpost-form">
      <form action="../includes/editpost.inc.php" class="editpost-form" method="post">
        <label for="postTitle">Title</label><br>
        <input type="text" name="postTitle" placeholder="Enter title of the article" required>
        <br>
        <label for="postImg">Image</label><br>
        <input type="text" name="postImg" placeholder="Enter image name(without .jpg)" required>
        <br>
        <label for="postContent">Details</label><br>
        <textarea name="postContent" id="add-textarea" cols="60" rows="10"></textarea>
        <br>
        <button type="submit" name="editpost-submit">Submit</button>
      </form>
    </div>
  </div>
</main>
<?php
require 'footer.php';
?>