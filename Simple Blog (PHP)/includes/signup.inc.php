<?php

require '../config.php';

//check if submit clicked
if (isset($_POST["signup-submit"])) {

  $userName = $_POST["signup-name"];
  $userEmail = $_POST["signup-email"];
  $userPass = $_POST["signup-pwd"];
  $userPassRe = $_POST["signup-pwdre"];
  $firstName = $_POST['firstName'];
  $lastName = $_POST['lastName'];
  $bloodGroup = $_POST['bloodgroup'];
  $addr = $_POST['address'];
  $userType = strtolower($_POST['user-type']);


  //username format checking
  if (!preg_match("/^[a-zA-Z0-9]*$/", $userName)) {

    header("Location: ../pages/signup.php?error=illegalUsername");
    exit();
    //password repeat checking
  } elseif ($userPass !== $userPassRe) {

    header("Location: ../pages/signup.php?error=notSamePass");
    exit();
    //external checking done , this else for database handling
  } else {

    $sql = "SELECT * FROM users WHERE user_name=?;";
    $stmt = mysqli_stmt_init($conn);
    //if can't prepare stmt , sql error
    if (!mysqli_stmt_prepare($stmt, $sql)) {

      header("Location: ../pages/error.php?error=mysqlerror");
      exit();
    } else {

      mysqli_stmt_bind_param($stmt, "s", $userName);
      mysqli_stmt_execute($stmt);
      mysqli_stmt_store_result($stmt);

      $result = mysqli_stmt_num_rows($stmt);
      //checking if username already exists in database
      if ($result > 0) {
        header("Location: ../pages/signup.php?error=userNameExist");
        exit();
      } else {

        $sql = "INSERT INTO users(user_name, user_email, user_pass, user_first_name, user_last_name, user_blood, user_addr, user_or_doctor) VALUES(?,?,?,?,?,?,?,?);";
        $stmt = mysqli_stmt_init($conn);

        //if can't prepare stmt , sql error
        if (!mysqli_stmt_prepare($stmt, $sql)) {
          header("Location: ../pages/error.php?error=mysqlerror");
          exit();
        } else {

          $hashedPass = password_hash($userPass, PASSWORD_DEFAULT);
          mysqli_stmt_bind_param($stmt, "ssssssss", $userName, $userEmail, $hashedPass, $firstName, $lastName, $bloodGroup, $addr, $userType);
          mysqli_stmt_execute($stmt);

          //sessions for using across the website
          $_SESSION["loggedIn"] = true;
          $_SESSION['userName'] = $userName;
          $_SESSION['userType'] = $userType;

          header('Location: ../pages/homepage.php?login=success');
          exit();
        }
      }
    }
  }
} else {

  header("Location: ../index.php?error=signupNotSet");
  exit();
}
