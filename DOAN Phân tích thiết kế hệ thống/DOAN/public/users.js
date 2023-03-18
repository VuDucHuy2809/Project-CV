var usr = {
  // (A) SHOW ALL USERS
  list : function () {
    admin.ajax({
      url : "ajax-users.php",
      target : "container",
      data : { req : "list" }
    });
  },

  // (B) SHOW ADD/EDIT USER DOCKET
  addEdit : function (id) {
    admin.ajax({
      url : "ajax-users.php",
      target : "container",
      data : {
        req : "addEdit",
        id : id
      }
    });
  },

  // (C) SAVE USER
  save : function () {
    var id = document.getElementById("usr_id").value;
    admin.ajax({
      url : "ajax-users.php",
      data : {
        req : (id=="" ? "add" : "edit"),
        id : (id=="" ? null : id),
        name : document.getElementById("usr_name").value,
        email : document.getElementById("usr_email").value,
        password : document.getElementById("usr_password").value
      },
      ok : usr.list
    });
    return false;
  },

  // (D) DELETE USER
  del : function (id) { if (confirm("Delete user?")) {
    admin.ajax({
      url : "ajax-users.php",
      data : {
        req : "del",
        id : id
      },
      ok : usr.list
    });
  }}
};
window.addEventListener("DOMContentLoaded", usr.list);