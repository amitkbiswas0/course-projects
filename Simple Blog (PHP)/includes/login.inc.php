<?php
require '../config.php';

//check if submit clicked
if (isset($_POST["login-submit"])) {

  $userName = $_POST["login-name"];
  $userPass = $_POST["login-pwd"];

  $sql = "SELECT * FROM users WHERE user_name=?;";
  $stmt = mysqli_stmt_init($conn);

  //if can't prepare stmt , sql error
  if (!mysqli_stmt_prepare($stmt, $sql)) {

    header("Location: ../pages/error.php?error=mysqlerror");
    exit();
  } else {

    mysqli_stmt_bind_param($stmt, "s", $userName);
    mysqli_stmt_execute($stmt);
    $result = mysqli_stmt_get_result($stmt);
    $row = mysqli_fetch_assoc($result);

    //checking if user exists
    if ($row !== null) {
      $pwdcheck = password_verify($userPass, $row['user_pass']);
      //if password matches
      if ($pwdcheck) {

        $_SESSION["loggedIn"] = true;
        $_SESSION['userName'] = $row['user_name'];
        $_SESSION['userType'] = $row['user_or_doctor'];

        header("Location: ../pages/homepage.php?login=success");
        mysqli_stmt_close($stmt);
        mysqli_close($conn);
        exit();
      } else {
        header("Location: ../index.php?error=passNotMatch");
        exit();
      }
    } else {
      header("Location: ../index.php?error=nouser");
      exit();
    }
  }
} else {
  header("Location: ../index.php?error=loginNotSubmit");
  exit();
}
