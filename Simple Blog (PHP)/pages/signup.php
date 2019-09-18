<?php
require '../config.php';
?>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Sign Up Here</title>
  <link rel="stylesheet" href="../css/signup.css" type="text/css">
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
      <form action="../includes/signup.inc.php" method="post" id="form">
        <div class="left">
          <?php
          if (isset($_GET['error']) && $_GET['error'] == 'illegalUsername') {
            echo '<p class="errormsg">Wrong Username Format</p>';
            unset($_GET['error']);
          }
          if (isset($_GET['error']) && $_GET['error'] == 'notSamePass') {
            echo '<p class="errormsg">Enter same password Twice</p>';
            unset($_GET['error']);
          }
          if (isset($_GET['error']) && $_GET['error'] == 'userNameExist') {
            echo '<p class="errormsg">User name exists</p>';
            unset($_GET['error']);
          } else {
            echo "";
          }
          ?>
        </div>
        <div class="mid">
          <input type="text" placeholder="username" name="signup-name" required>
          <input type="email" placeholder="email" name="signup-email" required>
          <input type="password" placeholder="password" name="signup-pwd" required>
          <input type="password" placeholder="repeat password" name="signup-pwdre" required>
          <input type="text" name="firstName" placeholder="First Name" required>
          <input type="text" name="lastName" placeholder="Last Name" required>
        </div>
        <div class="right">
          <input type="text" name="bloodgroup" placeholder="Blood Group" required>
          <input type="text" name="address" placeholder="Address" required>
          <input type="text" name="user-type" placeholder="user / doctor" required>
          <button type="submit" name="signup-submit">Submit</button>
        </div>
      </form>
    </div>
  </main>
</body>

</html>