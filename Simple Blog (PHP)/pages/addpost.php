<?php
require '../config.php';
require 'header.php';

if (!isset($_SESSION['loggedIn'])) {
  header('Location: ../index.php');
  exit();
}
?>
<main>
  <div class="center">
    <div class="addpost-form">
      <form action="../includes/addpost.inc.php" class="post-form" method="post">
        <label for="postTitle">Title</label><br>
        <input type="text" name="postTitle" placeholder="Enter title of the article" required>
        <br>
        <label for="postImg">Image</label><br>
        <input type="text" name="postImg" placeholder="Enter image name(without .jpg)" required>
        <br>
        <label for="postContent">Details</label><br>
        <textarea name="postContent" id="add-textarea" cols="60" rows="10" placeholder="Enter post details"></textarea>
        <br>
        <button type="submit" name="post-submit">Submit</button>
      </form>
    </div>
  </div>
</main>