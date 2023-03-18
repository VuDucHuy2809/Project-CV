using chat.CustomEventArgs;
using chat.Properties;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Printing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.StartPanel;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.Window;

namespace chat
{
    public partial class Stickers : Form
    {
        public event EventHandler<EventArgs> ChoosenCallback;
        public Stickers()
        {
            InitializeComponent();
            StartPosition = FormStartPosition.Manual;

            for (int i = 1; i < 73; i++)
            {
                var sticker = new StickerPicture
                {
                    Id = i.ToString(),
                    Body = Resources.ResourceManager.GetObject($"ami_{i}") as Bitmap,
                };
                sticker.OnImageClick += OnChoosen;
                stickerPanel.Controls.Add(sticker);
            }
        }

        public void OnChoosen(object sender, EventArgs eventArgs)
        {
            var sticker = sender as StickerPicture;
            var handler = this.ChoosenCallback;
            handler?.Invoke(sender, new StickerArgs
            {
                Id = sticker.Id
            });
                
        }

        public void Show(Point location)
        {
            this.Location = location;
            this.Show();
        }


        private void Stickers_Deactivate(object sender, EventArgs e)
        {
            this.Hide();
        }
    }
}
