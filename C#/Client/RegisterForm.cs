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
    public partial class RegisterForm : BeautyForm
    {
        public Boolean Logged = false;

        public event EventHandler<EventArgs> RegisterCallback;
        public event EventHandler<EventArgs> LoginRequestCallback;
        public RegisterForm()
        {
            InitializeComponent();
        }

        private void xRails_Button1_Click(object sender, EventArgs e)
        {
            if (username.Text.Trim().Length == 0 || password.Text.Trim().Length == 0 || cpassword.Text.Trim().Length == 0 )
            {
                MessageBox.Show("Tên đăng nhập & mật khẩu không được bỏ trống");
                return;
            }
            var handler = this.RegisterCallback;

            handler?.Invoke(this, new Register
            {
                Username = username.Text,
                Password = password.Text,
                CPassword = cpassword.Text,
            });
        }

        private void xRails_LinkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            var handler = this.LoginRequestCallback;

            handler?.Invoke(this, e);
        }
    }
}
