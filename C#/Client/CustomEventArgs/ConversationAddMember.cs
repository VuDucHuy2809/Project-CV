using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace chat.CustomEventArgs
{
    public class ConversationAddMember: EventArgs
    {
        public string Username { get; set; }
    }
}
