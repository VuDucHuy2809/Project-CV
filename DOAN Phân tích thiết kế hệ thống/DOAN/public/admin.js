var admin = {
	// (A) SHOW/HIDE "NOW LOADING" BLOCK
	loading : function (show) {
    var block = document.getElementById("page-loader");
    if (show) { block.classList.add("active"); }
    else { block.classList.remove("active"); }
	},

  // (B) TOGGLE SIDE BAR
	sidebar : function () {
    document.getElementById("page-sidebar").classList.toggle("active");
	},

  // (C) DO AJAX CALL
  /* -- AJAX OPTIONS --
   *  url : target URL
   *  data : data to send
   *  target : (optional) put server response into this HTML element
   *  ok : function to run on success
   *  error : function to run on failure
   *  debug : console log response if set to true
   */
  ajax : function (opt) {
    // (C1) FORM DATA
    var data = new FormData();
    if (opt.data) { for (let key in opt.data) {
      data.append(key, opt.data[key]);
    }}

    // (C2) AJAX
    var xhr = new XMLHttpRequest();
    xhr.open('POST', opt.url);
    xhr.onload = function(){
      // DONE - HIDE "NOW LOADING"
      admin.loading(0);

      // DEBUG MODE
      if (opt.debug) { console.log(this.response); }

      // BAD SERVER RESPONSE
      if (this.status != 200) {
        alert(`Cannot access ${opt.url} - Server response code ${this.status}`);
      }

      // SERVER RESPONSE OK
      else {
        // PUT SERVER RESPONSE INTO HTML ELEMENT
        if (opt.target) {
          document.getElementById(opt.target).innerHTML = this.response;
          if (typeof opt.ok == "function") { opt.ok(this.response); }
        }

        // JUST RUN "POST REQUEST" FUNCTIONS
        else {
          if (this.response == "OK") {
            if (typeof opt.ok == "function") { opt.ok(this.response); }
          } else {
            alert(this.response);
            if (typeof opt.error == "function") { opt.error(this.response); }
          }
        }
      }
    };

    // (C3) SHOW "NOW LOADING" + GO!
    admin.loading(1);
    xhr.send(data);
  },

  // (D) SIGN OFF
	bye : function () { if (confirm("Sign off?")) {
    admin.ajax({
      url : "ajax-session.php",
      data : { req : "out" },
      ok : function () { location.reload(); }
    });
  }}
};