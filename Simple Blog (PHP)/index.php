<?php
/*
config.php is added at the top of pages to
start sessions everywhere and get the database
handler files.
*/
require 'config.php';
?>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Welcome to Carebear</title>
  <link rel="stylesheet" href="css/index.css" type="text/css">
</head>

<body>

  <header>
    <div class="logo">
      <h2> <a href="../index.php">Carebear</a></h2>
    </div>
    <a href="pages/aboutus.php">About Us</a>
  </header>

  <main>
    <div class="form">
      <form action="includes/login.inc.php" class="login-form" method="post">
        <?php
        if (isset($_GET['error']) && $_GET['error'] == 'mysqlerror') {
          echo '<p class="errormsg">SQL error</p>';
          unset($_GET['error']);
        }
        if (isset($_GET['error']) && $_GET['error'] == 'nouser') {
          echo '<p class="errormsg">No user found</p>';
          unset($_GET['error']);
        }
        if (isset($_GET['error']) && $_GET['error'] == 'passNotMatch') {
          echo '<p class="errormsg">Password doesn\'t match</p>';
          unset($_GET['error']);
        } else { }
        ?>
        <input type="text" placeholder="username" name="login-name" required>
        <input type="password" placeholder="password" name="login-pwd" required>
        <button type="submit" name="login-submit">Login</button>
        <p class="bottom">Not registered? <a href="pages/signup.php">Create an account</a></p>
      </form>
    </div>
    <aside>
      <h2>QUOTE OF THE DAY</h2>
      <p>"Thousands of candles can be lighted from a single candle, and the life of the candle will not be shortened. Happiness never decreases by being shared"<br>- Buddha</p>
    </aside>
  </main>
</body>

</html>