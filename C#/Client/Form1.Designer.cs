namespace chat
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.panel1 = new System.Windows.Forms.Panel();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.panel2 = new System.Windows.Forms.Panel();
            this.showConversationCreateForm = new System.Windows.Forms.Button();
            this.conversationList = new System.Windows.Forms.Panel();
            this.helloLabel = new System.Windows.Forms.Label();
            this.panel3 = new System.Windows.Forms.Panel();
            this.typingBox1 = new chat.TypingBox();
            this.chatZone = new System.Windows.Forms.Panel();
            this.meBubble2 = new chat.MeBubble();
            this.youBubble1 = new chat.YouBubble();
            this.meBubble1 = new chat.MeBubble();
            this.meBubble3 = new chat.MeBubble();
            this.meBubble4 = new chat.MeBubble();
            this.meBubble5 = new chat.MeBubble();
            this.chatHeader1 = new chat.ChatHeader();
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            this.panel3.SuspendLayout();
            this.chatZone.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.label2);
            this.panel1.Controls.Add(this.label1);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel1.Location = new System.Drawing.Point(3, 3);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(974, 24);
            this.panel1.TabIndex = 0;
            this.panel1.MouseDown += new System.Windows.Forms.MouseEventHandler(this.OnMouseDownMoveForm);
            // 
            // label2
            // 
            this.label2.Cursor = System.Windows.Forms.Cursors.Hand;
            this.label2.Dock = System.Windows.Forms.DockStyle.Right;
            this.label2.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.label2.Location = new System.Drawing.Point(904, 0);
            this.label2.Name = "label2";
            this.label2.Padding = new System.Windows.Forms.Padding(0, 0, 0, 11);
            this.label2.Size = new System.Drawing.Size(35, 24);
            this.label2.TabIndex = 1;
            this.label2.Text = "__";
            this.label2.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.label2.Click += new System.EventHandler(this.label2_Click);
            // 
            // label1
            // 
            this.label1.Cursor = System.Windows.Forms.Cursors.Hand;
            this.label1.Dock = System.Windows.Forms.DockStyle.Right;
            this.label1.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.label1.Location = new System.Drawing.Point(939, 0);
            this.label1.Name = "label1";
            this.label1.Padding = new System.Windows.Forms.Padding(0, 0, 0, 5);
            this.label1.Size = new System.Drawing.Size(35, 24);
            this.label1.TabIndex = 0;
            this.label1.Text = "X";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.showConversationCreateForm);
            this.panel2.Controls.Add(this.conversationList);
            this.panel2.Controls.Add(this.helloLabel);
            this.panel2.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel2.Location = new System.Drawing.Point(3, 27);
            this.panel2.Name = "panel2";
            this.panel2.Padding = new System.Windows.Forms.Padding(2, 0, 2, 5);
            this.panel2.Size = new System.Drawing.Size(206, 674);
            this.panel2.TabIndex = 1;
            // 
            // showConversationCreateForm
            // 
            this.showConversationCreateForm.BackColor = System.Drawing.Color.DodgerBlue;
            this.showConversationCreateForm.Font = new System.Drawing.Font("Paytone One", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.showConversationCreateForm.ForeColor = System.Drawing.SystemColors.HighlightText;
            this.showConversationCreateForm.Image = global::chat.Properties.Resources.twotone_question_answer_black_24dp;
            this.showConversationCreateForm.Location = new System.Drawing.Point(5, 626);
            this.showConversationCreateForm.Name = "showConversationCreateForm";
            this.showConversationCreateForm.Padding = new System.Windows.Forms.Padding(3);
            this.showConversationCreateForm.Size = new System.Drawing.Size(195, 40);
            this.showConversationCreateForm.TabIndex = 2;
            this.showConversationCreateForm.Text = "Thêm cuộc trò chuyện";
            this.showConversationCreateForm.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.showConversationCreateForm.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.showConversationCreateForm.UseVisualStyleBackColor = false;
            this.showConversationCreateForm.Click += new System.EventHandler(this.showConversationCreateForm_Click);
            // 
            // conversationList
            // 
            this.conversationList.Dock = System.Windows.Forms.DockStyle.Top;
            this.conversationList.Location = new System.Drawing.Point(2, 42);
            this.conversationList.Name = "conversationList";
            this.conversationList.Padding = new System.Windows.Forms.Padding(0, 5, 0, 10);
            this.conversationList.Size = new System.Drawing.Size(202, 578);
            this.conversationList.TabIndex = 1;
            // 
            // helloLabel
            // 
            this.helloLabel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(102)))), ((int)(((byte)(102)))));
            this.helloLabel.Dock = System.Windows.Forms.DockStyle.Top;
            this.helloLabel.Font = new System.Drawing.Font("Arial", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.helloLabel.ForeColor = System.Drawing.Color.Silver;
            this.helloLabel.Location = new System.Drawing.Point(2, 0);
            this.helloLabel.Name = "helloLabel";
            this.helloLabel.Padding = new System.Windows.Forms.Padding(5, 5, 0, 0);
            this.helloLabel.Size = new System.Drawing.Size(202, 42);
            this.helloLabel.TabIndex = 0;
            this.helloLabel.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // panel3
            // 
            this.panel3.Controls.Add(this.typingBox1);
            this.panel3.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.panel3.Location = new System.Drawing.Point(209, 663);
            this.panel3.Name = "panel3";
            this.panel3.Padding = new System.Windows.Forms.Padding(5, 0, 5, 5);
            this.panel3.Size = new System.Drawing.Size(768, 38);
            this.panel3.TabIndex = 3;
            // 
            // typingBox1
            // 
            this.typingBox1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(102)))), ((int)(((byte)(102)))));
            this.typingBox1.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.typingBox1.Location = new System.Drawing.Point(5, 0);
            this.typingBox1.Name = "typingBox1";
            this.typingBox1.Size = new System.Drawing.Size(758, 33);
            this.typingBox1.TabIndex = 0;
            this.typingBox1.Value = "Type here...";
            this.typingBox1.OnEmojiClicked += new chat.TypingBox.EmojiClicked(this.typingBox1_OnEmojiClicked);
            this.typingBox1.OnAttachmentClicked += new chat.TypingBox.AttachmentClicked(this.typingBox1_OnAttachmentClicked);
            this.typingBox1.OnHitEnter += new chat.TypingBox.HitEnter(this.typingBox1_OnHitEnter);
            // 
            // chatZone
            // 
            this.chatZone.AutoScroll = true;
            this.chatZone.Controls.Add(this.meBubble2);
            this.chatZone.Controls.Add(this.youBubble1);
            this.chatZone.Controls.Add(this.meBubble1);
            this.chatZone.Controls.Add(this.meBubble3);
            this.chatZone.Controls.Add(this.meBubble4);
            this.chatZone.Controls.Add(this.meBubble5);
            this.chatZone.Dock = System.Windows.Forms.DockStyle.Fill;
            this.chatZone.Location = new System.Drawing.Point(209, 69);
            this.chatZone.Name = "chatZone";
            this.chatZone.Size = new System.Drawing.Size(768, 594);
            this.chatZone.TabIndex = 4;
            // 
            // meBubble2
            // 
            this.meBubble2.AutoSize = true;
            this.meBubble2.BackColor = System.Drawing.Color.Transparent;
            this.meBubble2.Body = " This is a sample text message. This is a sample text message. This is a sample t" +
    "ext message. \r\n\r\nThis is a sample text message. \r\n";
            this.meBubble2.ChatImageCursor = System.Windows.Forms.Cursors.Default;
            this.meBubble2.ChatTextCursor = System.Windows.Forms.Cursors.IBeam;
            this.meBubble2.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.meBubble2.Location = new System.Drawing.Point(0, 24);
            this.meBubble2.MinimumSize = new System.Drawing.Size(0, 95);
            this.meBubble2.MsgColor = System.Drawing.Color.DodgerBlue;
            this.meBubble2.MsgTextColor = System.Drawing.SystemColors.ControlLightLight;
            this.meBubble2.Name = "meBubble2";
            this.meBubble2.Padding = new System.Windows.Forms.Padding(0, 5, 0, 5);
            this.meBubble2.Size = new System.Drawing.Size(768, 95);
            this.meBubble2.Status = chat.MessageStatus.Custom;
            this.meBubble2.StatusImage = ((System.Drawing.Image)(resources.GetObject("meBubble2.StatusImage")));
            this.meBubble2.TabIndex = 2;
            this.meBubble2.Time = "11:44 PM";
            this.meBubble2.TimeColor = System.Drawing.Color.White;
            this.meBubble2.UserImage = ((System.Drawing.Image)(resources.GetObject("meBubble2.UserImage")));
            // 
            // youBubble1
            // 
            this.youBubble1.BackColor = System.Drawing.Color.Transparent;
            this.youBubble1.Body = " This is a sample text message. This is a sample text message. This is a sample t" +
    "ext message. \n\nThis is a sample text message. ";
            this.youBubble1.ChatImageCursor = System.Windows.Forms.Cursors.Default;
            this.youBubble1.ChatTextCursor = System.Windows.Forms.Cursors.IBeam;
            this.youBubble1.Creator = "Người dùng";
            this.youBubble1.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.youBubble1.File = null;
            this.youBubble1.FileType = null;
            this.youBubble1.Location = new System.Drawing.Point(0, 119);
            this.youBubble1.MinimumSize = new System.Drawing.Size(0, 95);
            this.youBubble1.MsgColor = System.Drawing.Color.FromArgb(((int)(((byte)(244)))), ((int)(((byte)(244)))), ((int)(((byte)(244)))));
            this.youBubble1.MsgTextColor = System.Drawing.SystemColors.ControlDarkDark;
            this.youBubble1.Name = "youBubble1";
            this.youBubble1.Padding = new System.Windows.Forms.Padding(0, 5, 0, 5);
            this.youBubble1.Size = new System.Drawing.Size(768, 95);
            this.youBubble1.Status = chat.MessageStatus.Custom;
            this.youBubble1.StatusImage = null;
            this.youBubble1.TabIndex = 1;
            this.youBubble1.Time = "11:46 PM";
            this.youBubble1.TimeColor = System.Drawing.Color.White;
            this.youBubble1.UserImage = global::chat.Properties.Resources._2_32;
            // 
            // meBubble1
            // 
            this.meBubble1.AutoSize = true;
            this.meBubble1.BackColor = System.Drawing.Color.Transparent;
            this.meBubble1.Body = " This is a sample text message. This is a sample text message. This is a sample t" +
    "ext message. \r\n\r\nThis is a sample text message. \r\n";
            this.meBubble1.ChatImageCursor = System.Windows.Forms.Cursors.Default;
            this.meBubble1.ChatTextCursor = System.Windows.Forms.Cursors.IBeam;
            this.meBubble1.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.meBubble1.Location = new System.Drawing.Point(0, 214);
            this.meBubble1.MinimumSize = new System.Drawing.Size(0, 95);
            this.meBubble1.MsgColor = System.Drawing.Color.DodgerBlue;
            this.meBubble1.MsgTextColor = System.Drawing.SystemColors.ControlLightLight;
            this.meBubble1.Name = "meBubble1";
            this.meBubble1.Padding = new System.Windows.Forms.Padding(0, 5, 0, 5);
            this.meBubble1.Size = new System.Drawing.Size(768, 95);
            this.meBubble1.Status = chat.MessageStatus.Custom;
            this.meBubble1.StatusImage = ((System.Drawing.Image)(resources.GetObject("meBubble1.StatusImage")));
            this.meBubble1.TabIndex = 0;
            this.meBubble1.Time = "11:50 PM";
            this.meBubble1.TimeColor = System.Drawing.Color.White;
            this.meBubble1.UserImage = ((System.Drawing.Image)(resources.GetObject("meBubble1.UserImage")));
            // 
            // meBubble3
            // 
            this.meBubble3.AutoSize = true;
            this.meBubble3.BackColor = System.Drawing.Color.Transparent;
            this.meBubble3.Body = " This is a sample text message. This is a sample text message. This is a sample t" +
    "ext message. \r\n\r\nThis is a sample text message. \r\n";
            this.meBubble3.ChatImageCursor = System.Windows.Forms.Cursors.Default;
            this.meBubble3.ChatTextCursor = System.Windows.Forms.Cursors.IBeam;
            this.meBubble3.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.meBubble3.Location = new System.Drawing.Point(0, 309);
            this.meBubble3.MinimumSize = new System.Drawing.Size(0, 95);
            this.meBubble3.MsgColor = System.Drawing.Color.DodgerBlue;
            this.meBubble3.MsgTextColor = System.Drawing.SystemColors.ControlLightLight;
            this.meBubble3.Name = "meBubble3";
            this.meBubble3.Padding = new System.Windows.Forms.Padding(0, 5, 0, 5);
            this.meBubble3.Size = new System.Drawing.Size(768, 95);
            this.meBubble3.Status = chat.MessageStatus.Custom;
            this.meBubble3.StatusImage = ((System.Drawing.Image)(resources.GetObject("meBubble3.StatusImage")));
            this.meBubble3.TabIndex = 3;
            this.meBubble3.Time = "11:52 PM";
            this.meBubble3.TimeColor = System.Drawing.Color.White;
            this.meBubble3.UserImage = ((System.Drawing.Image)(resources.GetObject("meBubble3.UserImage")));
            // 
            // meBubble4
            // 
            this.meBubble4.AutoSize = true;
            this.meBubble4.BackColor = System.Drawing.Color.Transparent;
            this.meBubble4.Body = " This is a sample text message. This is a sample text message. This is a sample t" +
    "ext message. \r\n\r\nThis is a sample text message. \r\n";
            this.meBubble4.ChatImageCursor = System.Windows.Forms.Cursors.Default;
            this.meBubble4.ChatTextCursor = System.Windows.Forms.Cursors.IBeam;
            this.meBubble4.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.meBubble4.Location = new System.Drawing.Point(0, 404);
            this.meBubble4.MinimumSize = new System.Drawing.Size(0, 95);
            this.meBubble4.MsgColor = System.Drawing.Color.DodgerBlue;
            this.meBubble4.MsgTextColor = System.Drawing.SystemColors.ControlLightLight;
            this.meBubble4.Name = "meBubble4";
            this.meBubble4.Padding = new System.Windows.Forms.Padding(0, 5, 0, 5);
            this.meBubble4.Size = new System.Drawing.Size(768, 95);
            this.meBubble4.Status = chat.MessageStatus.Custom;
            this.meBubble4.StatusImage = ((System.Drawing.Image)(resources.GetObject("meBubble4.StatusImage")));
            this.meBubble4.TabIndex = 4;
            this.meBubble4.Time = "11:52 PM";
            this.meBubble4.TimeColor = System.Drawing.Color.White;
            this.meBubble4.UserImage = ((System.Drawing.Image)(resources.GetObject("meBubble4.UserImage")));
            // 
            // meBubble5
            // 
            this.meBubble5.AutoSize = true;
            this.meBubble5.BackColor = System.Drawing.Color.Transparent;
            this.meBubble5.Body = " This is a sample text message. This is a sample text message. This is a sample t" +
    "ext message. \r\n\r\nThis is a sample text message. \r\n";
            this.meBubble5.ChatImageCursor = System.Windows.Forms.Cursors.Default;
            this.meBubble5.ChatTextCursor = System.Windows.Forms.Cursors.IBeam;
            this.meBubble5.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.meBubble5.Location = new System.Drawing.Point(0, 499);
            this.meBubble5.MinimumSize = new System.Drawing.Size(0, 95);
            this.meBubble5.MsgColor = System.Drawing.Color.DodgerBlue;
            this.meBubble5.MsgTextColor = System.Drawing.SystemColors.ControlLightLight;
            this.meBubble5.Name = "meBubble5";
            this.meBubble5.Padding = new System.Windows.Forms.Padding(0, 5, 0, 5);
            this.meBubble5.Size = new System.Drawing.Size(768, 95);
            this.meBubble5.Status = chat.MessageStatus.Custom;
            this.meBubble5.StatusImage = ((System.Drawing.Image)(resources.GetObject("meBubble5.StatusImage")));
            this.meBubble5.TabIndex = 5;
            this.meBubble5.Time = "11:52 PM";
            this.meBubble5.TimeColor = System.Drawing.Color.White;
            this.meBubble5.UserImage = ((System.Drawing.Image)(resources.GetObject("meBubble5.UserImage")));
            // 
            // chatHeader1
            // 
            this.chatHeader1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(102)))), ((int)(((byte)(102)))));
            this.chatHeader1.Dock = System.Windows.Forms.DockStyle.Top;
            this.chatHeader1.Location = new System.Drawing.Point(209, 27);
            this.chatHeader1.Name = "chatHeader1";
            this.chatHeader1.Padding = new System.Windows.Forms.Padding(0, 1, 0, 1);
            this.chatHeader1.Size = new System.Drawing.Size(768, 42);
            this.chatHeader1.TabIndex = 2;
            this.chatHeader1.UserImage = global::chat.Properties.Resources.twotone_explore_black_48dp;
            this.chatHeader1.UserStatusText = "Tạo hoặc chọn cuộc trò chuyện đển nhắn tin";
            this.chatHeader1.UserTitle = "Chào mừng đến với Ủn Ỉn";
            this.chatHeader1.OnMenuDotClick += new chat.ChatHeader.MenuDotClick(this.chatHeader1_OnMenuDotClick);
            // 
            // Form1
            // 
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(80)))), ((int)(((byte)(80)))), ((int)(((byte)(80)))));
            this.ClientSize = new System.Drawing.Size(980, 704);
            this.Controls.Add(this.chatZone);
            this.Controls.Add(this.panel3);
            this.Controls.Add(this.chatHeader1);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Form1";
            this.Padding = new System.Windows.Forms.Padding(3);
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Load += new System.EventHandler(this.Form1_Load);
            this.panel1.ResumeLayout(false);
            this.panel2.ResumeLayout(false);
            this.panel3.ResumeLayout(false);
            this.chatZone.ResumeLayout(false);
            this.chatZone.PerformLayout();
            this.ResumeLayout(false);

        }


        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
        private ChatHeader chatHeader1;
        private System.Windows.Forms.Panel panel3;
        private TypingBox typingBox1;
        private System.Windows.Forms.Panel chatZone;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label helloLabel;
        private System.Windows.Forms.Panel conversationList;
        private MeBubble meBubble2;
        private YouBubble youBubble1;
        private MeBubble meBubble1;
        private MeBubble meBubble3;
        private MeBubble meBubble4;
        private MeBubble meBubble5;
        private System.Windows.Forms.Button showConversationCreateForm;
    }
}