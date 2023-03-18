<?php
// (A) REDIRECT TO LOGIN PAGE IF NOT SIGNED IN
$_ADMIN = isset($_SESSION['user']);
if (!$_ADMIN && basename($_SERVER["SCRIPT_FILENAME"], '.php')!="login") {
  header('Location: login.php');
  exit();
}
?>
<!DOCTYPE html>
<html>
  <head>
    <title>ADMIN PANEL</title>
    <meta name="robots" content="noindex, nofollow">
    <link href="public/admin.css" rel="stylesheet">
    <script src="public/admin.js"></script>
  </head>
  <body>
    <!-- (B) NOW LOADING SPINNER -->
    <div id="page-loader">
      <img id="page-loader-spin" src="public/cube-loader.svg">
    </div>

    <?php if ($_ADMIN) { ?>
    <!-- (C) SIDE BAR -->
    <nav id="page-sidebar">
      <a href="users.php">
        <span class="ico">&#9879;</span> Manage Users
      </a>
      <a href="#">
        <span class="ico">&#9880;</span> Add Modules Here
      </a>
    </nav>
    <?php } ?>

    <!-- (D) MAIN CONTENTS -->
    <div id="page-main">
      <?php if ($_ADMIN) { ?>
      <!-- (D1) NAVIGATION BAR -->
      <nav id="page-nav">
        <div id="page-button-side" onclick="admin.sidebar();">&#9776;</div>
        <div id="page-button-out" onclick="admin.bye();">&#9747;</div>
      </nav>
      <?php } ?>

      <!-- (D2) PAGE CONTENTS -->
      <main id="page-contents">