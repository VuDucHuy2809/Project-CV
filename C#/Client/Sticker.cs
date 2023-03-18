using chat.Properties;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace chat
{
    public class Sticker
    {
        public string Id { get; set; }

        public Bitmap getBitmap()
        {
            return Resources.ResourceManager.GetObject($"ami_{Id}.gif") as Bitmap;
        }
    }
}
