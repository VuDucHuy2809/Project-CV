using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace chat
{
    public partial class StickerPicture : UserControl
    {
        public StickerPicture()
        {
            InitializeComponent();
        }

        public string Id { get; set; }

        public Image Body
        {
            set
            {
                pictureBox1.Image = value;
            }
            get {
                return pictureBox1.Image;
            }
        }

        public delegate void ImageClick(object sender, EventArgs e);

        public event ImageClick OnImageClick;

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            if (OnImageClick != null)
            {
                OnImageClick.Invoke(this, e);
            }
        }
    }
}
