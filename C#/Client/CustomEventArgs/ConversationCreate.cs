using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace chat.CustomEventArgs
{
    public class ConversationCreate: EventArgs
    {
        public List<String> Users { get; set; }
    }
}
