using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace chat
{
    public partial class Menu : Form
    {
        public event EventHandler<EventArgs> ViewMemberCallback;
        public event EventHandler<EventArgs> LeaveConversationCallback;
        public Menu()
        {
            InitializeComponent();

            StartPosition = FormStartPosition.Manual;
        }

        public Menu(Point location) : this()
        {
            this.Location = location;
        }

        public void Show(Point location)
        {
            this.Location = location;
            this.Show();
        }

        private void option_SelectedIndexChanged(object sender, EventArgs e)
        {
            switch(option.SelectedIndex)
            {
                case 0:
                    this.ViewMemberCallback?.Invoke(this, new EventArgs());
                    break;
                case 1:
                    this.LeaveConversationCallback?.Invoke(this, new EventArgs());
                    break;
                default:
                    break;
            }

            
        }

        private void Menu_Deactivate(object sender, EventArgs e)
        {
            if (option.SelectedIndex == -1)
            {
                option.ClearSelected();
                this.Hide();
            }
            
        }
    }
}
