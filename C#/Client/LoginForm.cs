using chat.CustomEventArgs;
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
    public partial class LoginForm : BeautyForm
    {
        public Boolean Logged = false;

        public event EventHandler<EventArgs> LoginCallback;
        public event EventHandler<EventArgs> RegisterRequestCallback;

        public LoginForm()
        {
            InitializeComponent();
        }

        private void xRails_Button1_Click(object sender, EventArgs e)
        {
            if (username.Text.Trim().Length == 0 || password.Text.Trim().Length == 0)
            {
                MessageBox.Show("Tên đăng nhập & mật khẩu không được bỏ trống");
                return;
            }
            var handler = this.LoginCallback;

            handler?.Invoke(this, new Logged
            {
                Username = username.Text,
                Password = password.Text,
            });

        }

        private void xRails_LinkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            var handler = this.RegisterRequestCallback;

            handler?.Invoke(this, e);
        }
    }
}
