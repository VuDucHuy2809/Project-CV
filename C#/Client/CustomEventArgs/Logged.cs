using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace chat.CustomEventArgs
{
    public class Logged: EventArgs
    {
        public string Username { get; set; }
        public string Password { get; set; }    
    }
}
