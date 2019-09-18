<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Carebear</title>
  <link rel="stylesheet" href="../css/homepage.css" type="text/css">
  </script>
  <script language="JavaScript" type="text/javascript">
    function delpost(id, title) {
      if (confirm("Are you sure you want to delete '" + title.trim() + "'")) {
        window.location.href = 'account.php?delpost=' + id;
      }
    }
  </script>
</head>

<body>
  <header>
    <?php
    if ($_SESSION['userType'] == 'doctor') {
      echo '<h2>Carebear for Doctors</h2>';
    } else if ($_SESSION['userType'] == 'user') {
      echo '<h2>Carebear for Users</h2>';
    } else { }
    ?>
    <nav>
      <a href="homepage.php">homepage</a>
      <?php
      if ($_SESSION['userType'] == 'doctor') {
        echo '<a href="submission.php">Patient Problems</a>';
      } else if ($_SESSION['userType'] == 'user') {
        echo '<a href="submission.php">submission pool</a>';
      } else { }
      ?>

      <a href="account.php">Account</a>
      <a href="aboutus.php">About</a>
      <a href="logout.php">Log Out</a>
    </nav>
  </header>