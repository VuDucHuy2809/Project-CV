<?php
class Users {
  // (A) CONSTRUCTOR - CONNECT TO THE DATABASE
  private $pdo = null;
  private $stmt = null;
  public $error;
  function __construct () {
    try {
      $this->pdo = new PDO(
        "mysql:host=". DB_HOST .";dbname=". DB_NAME .";charset=". DB_CHARSET,
        DB_USER, DB_PASSWORD, [
          PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
          PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
          PDO::ATTR_EMULATE_PREPARES => false
        ]
      );
    } catch (Exception $ex) { exit($ex->getMessage()); }
  }

  // (B) DESTRUCTOR - CLOSE DATABSE CONNECTION
  function __destruct () {
    if ($this->stmt !== null) { $this->stmt = null; }
    if ($this->pdo !== null) { $this->pdo = null; }
  }

  // (C) GET USER BY ID OR EMAIL
  function get ($id) {
    // (C1) SQL QUERY
    $sql = is_numeric($id) 
      ? "SELECT * FROM `users` WHERE `user_id`=?"
      : "SELECT * FROM `users` WHERE `user_email`=?" ;

    // (C2) GET USER
    $this->stmt = $this->pdo->prepare($sql);
    $this->stmt->execute([$id]);
    $entry = $this->stmt->fetchAll();
    return count($entry)==0 ? false : $entry[0] ;
  }

  // (D) GET ALL USERS
  function getAll () {
    $this->stmt = $this->pdo->prepare("SELECT * FROM `users`");
    $this->stmt->execute();
    $entry = $this->stmt->fetchAll();
    return count($entry)==0 ? false : $entry ;
  }
  
  // (E) VERIFY USER
  function verify ($email, $password, $session=true) {
    // (E1) GET USER
    $user = $this->get($email);
    $pass = $user !== false;

    // (E2) CHECK PASSWORD
    if ($pass) { $pass = password_verify($password, $user['user_password']); }

    // (E3) START SESSION?
    if ($pass && $session) {
      $_SESSION['user'] = [
        "id" => $user['user_id'],
        "name" => $user['user_name'],
        "email" => $user['user_email']
      ];
    }

    // (E4) RESULT
    if ($pass) { return true; }
    else {
      $this->error = "Invalid user/password";
      return false;
    }
  }
  
  // (F) SAVE USER (ADD OR EDIT)
  function save ($email, $name, $password, $id=null) {
    // (F1) SQL + DATA
    $sql = $id===null
      ? "INSERT INTO `users` (`user_email`, `user_name`, `user_password`) VALUES (?, ?, ?)"
      : "UPDATE `users` SET `user_email`=?, `user_name`=?, `user_password`=? WHERE `user_id`=?" ;
    $data = [$email, $name, password_hash($password, PASSWORD_DEFAULT)];
    if ($id!==null) { $data[] = $id; }
    
    // (F2) SAVE USER
    try {
      $this->stmt = $this->pdo->prepare($sql);
      $this->stmt->execute($data);
      return true;
    } catch (Exception $ex) {
      $this->error = $ex->getMessage();
      return false;
    }
  }

  // (G) DELETE USER
  function del ($id) {
    try {
      $this->stmt = $this->pdo->prepare("DELETE FROM `users` WHERE `user_id`=?");
      $this->stmt->execute([$id]);
      return true;
    } catch (Exception $ex) {
      $this->error = $ex->getMessage();
      return false;
    }
  }
}