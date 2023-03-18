using chat.CustomEventArgs;
using Shared.Entity;
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
    public partial class ConversationMemberForm : Form
    {
        public event EventHandler<EventArgs> AddMemberCallback;
        public List<string> Members;

        public ConversationMemberForm()
        {
            InitializeComponent();
        }

        public void Show(List<string> members)
        {
            Members = members;
            userListBox.Items.Clear();
            userListBox.Items.AddRange(Members.ToArray());
            ItemChanged();
            username.ResetText();
            this.ShowDialog();
        }

        public void Update(List<string> members)
        {
            Members = members;
            userListBox.Items.Clear();
            userListBox.Items.AddRange(Members.ToArray());
            ItemChanged();
            username.ResetText();
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            if (username.Text.Trim().Length == 0)
            {
                MessageBox.Show("Tên người dùng không được để trống");
                return;
            }
            if (userListBox.Items.Contains(username.Text))
            {
                MessageBox.Show("Tên người dùng đã có trong danh sách");
                return;
            }

            AddMemberCallback?.Invoke(this, new ConversationAddMember
            {
                Username = username.Text
            });
        }

        //private void xRails_Button1_Click(object sender, EventArgs e)
        //{
        //    List<string> users = userListBox.Items.Cast<String>().ToList();

        //    if (userListBox.Items.Count == 0)
        //    {
        //        MessageBox.Show("Thành viên cuộc trò chuyện phải ít nhất 1 người và bạn");
        //        return;
        //    }

        //    var handler = this.SubmitCallback;

        //    handler?.Invoke(this, new ConversationCreate
        //    {
        //        Users = users
        //    });
        //}

        //private void btnDelete_Click(object sender, EventArgs e)
        //{
        //    if (userListBox.SelectedItem != null)
        //    {
        //        userListBox.Items.Remove(userListBox.SelectedItem);
        //        ItemChanged();
        //    }
        //    else
        //    {
        //        MessageBox.Show("Vui lòng chọn tên người dùng mời khỏi nhóm");
        //    }
        //}

        private void ItemChanged()
        {
            if (userListBox.Items.Count > 1)
                modeLabel.Text = "CUỘC TRÒ CHUYỆN NHÓM";
            else if (userListBox.Items.Count == 1)
                modeLabel.Text = "CUỘC TRÒ CHUYỆN RIÊNG TƯ";
            else
                modeLabel.Text = "";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Hide();
        }
    }
}
