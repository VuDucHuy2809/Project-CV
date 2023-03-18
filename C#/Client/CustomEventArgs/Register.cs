using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace chat.CustomEventArgs
{
    public class Register: EventArgs
    {
        public string Username { get; set; }
        public string Password { get; set; }
        public string CPassword { get; set; }
    }
}
