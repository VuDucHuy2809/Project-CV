using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace chat.CustomEventArgs
{
    public class StickerArgs: EventArgs
    {
        public string Id { get; set; }
    }
}
