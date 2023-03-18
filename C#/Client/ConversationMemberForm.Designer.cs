namespace chat
{
    partial class ConversationMemberForm
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

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.xRails_Container1 = new XRails.Controls.XRails_Container();
            this.button1 = new System.Windows.Forms.Button();
            this.panel1 = new System.Windows.Forms.Panel();
            this.xRails_Panel1 = new XRails.Controls.XRails_Panel();
            this.modeLabel = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.btnSearch = new System.Windows.Forms.Button();
            this.xRails_TitleLabel1 = new XRails.Controls.XRails_TitleLabel();
            this.username = new XRails.Controls.XRails_TextBox();
            this.userListBox = new System.Windows.Forms.ListBox();
            this.xRails_Container1.SuspendLayout();
            this.panel1.SuspendLayout();
            this.xRails_Panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // xRails_Container1
            // 
            this.xRails_Container1.Controls.Add(this.button1);
            this.xRails_Container1.Controls.Add(this.panel1);
            this.xRails_Container1.Cursor = System.Windows.Forms.Cursors.Arrow;
            this.xRails_Container1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.xRails_Container1.DrawIcon = false;
            this.xRails_Container1.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.xRails_Container1.Location = new System.Drawing.Point(0, 0);
            this.xRails_Container1.MinimumSize = new System.Drawing.Size(100, 42);
            this.xRails_Container1.Name = "xRails_Container1";
            this.xRails_Container1.Padding = new System.Windows.Forms.Padding(0, 31, 0, 0);
            this.xRails_Container1.Size = new System.Drawing.Size(334, 450);
            this.xRails_Container1.TabIndex = 0;
            this.xRails_Container1.Text = "Thành viên cuộc trò chuyện";
            this.xRails_Container1.TextAlignment = XRails.Controls.XRails_Container.Alignment.Left;
            this.xRails_Container1.TitleBarTextColor = System.Drawing.Color.Gainsboro;
            // 
            // button1
            // 
            this.button1.Font = new System.Drawing.Font("Paytone One", 8.999999F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(45)))), ((int)(((byte)(45)))), ((int)(((byte)(45)))));
            this.button1.Image = global::chat.Properties.Resources.baseline_close_black_48dp;
            this.button1.Location = new System.Drawing.Point(304, 0);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(31, 31);
            this.button1.TabIndex = 7;
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(45)))), ((int)(((byte)(45)))), ((int)(((byte)(45)))));
            this.panel1.Controls.Add(this.xRails_Panel1);
            this.panel1.Location = new System.Drawing.Point(0, 31);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(480, 419);
            this.panel1.TabIndex = 1;
            // 
            // xRails_Panel1
            // 
            this.xRails_Panel1.Controls.Add(this.modeLabel);
            this.xRails_Panel1.Controls.Add(this.label1);
            this.xRails_Panel1.Controls.Add(this.btnSearch);
            this.xRails_Panel1.Controls.Add(this.xRails_TitleLabel1);
            this.xRails_Panel1.Controls.Add(this.username);
            this.xRails_Panel1.Controls.Add(this.userListBox);
            this.xRails_Panel1.Cursor = System.Windows.Forms.Cursors.Arrow;
            this.xRails_Panel1.Dock = System.Windows.Forms.DockStyle.Left;
            this.xRails_Panel1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(250)))), ((int)(((byte)(250)))), ((int)(((byte)(250)))));
            this.xRails_Panel1.Location = new System.Drawing.Point(0, 0);
            this.xRails_Panel1.Name = "xRails_Panel1";
            this.xRails_Panel1.Side = XRails.Controls.XRails_Panel.PanelSide.Left;
            this.xRails_Panel1.Size = new System.Drawing.Size(335, 419);
            this.xRails_Panel1.TabIndex = 2;
            // 
            // modeLabel
            // 
            this.modeLabel.AutoSize = true;
            this.modeLabel.Font = new System.Drawing.Font("Paytone One", 8.999999F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.modeLabel.Location = new System.Drawing.Point(52, 269);
            this.modeLabel.Name = "modeLabel";
            this.modeLabel.Size = new System.Drawing.Size(0, 19);
            this.modeLabel.TabIndex = 6;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(9, 271);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(48, 15);
            this.label1.TabIndex = 5;
            this.label1.Text = "Chế độ:";
            // 
            // btnSearch
            // 
            this.btnSearch.Font = new System.Drawing.Font("Paytone One", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSearch.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(45)))), ((int)(((byte)(45)))), ((int)(((byte)(45)))));
            this.btnSearch.Location = new System.Drawing.Point(256, 310);
            this.btnSearch.Name = "btnSearch";
            this.btnSearch.Size = new System.Drawing.Size(75, 51);
            this.btnSearch.TabIndex = 4;
            this.btnSearch.Text = "Mời";
            this.btnSearch.UseVisualStyleBackColor = true;
            this.btnSearch.Click += new System.EventHandler(this.btnSearch_Click);
            // 
            // xRails_TitleLabel1
            // 
            this.xRails_TitleLabel1.AutoSize = true;
            this.xRails_TitleLabel1.BackColor = System.Drawing.Color.Transparent;
            this.xRails_TitleLabel1.Cursor = System.Windows.Forms.Cursors.Arrow;
            this.xRails_TitleLabel1.Font = new System.Drawing.Font("Paytone One", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.xRails_TitleLabel1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(250)))), ((int)(((byte)(250)))), ((int)(((byte)(250)))));
            this.xRails_TitleLabel1.Location = new System.Drawing.Point(3, 12);
            this.xRails_TitleLabel1.Name = "xRails_TitleLabel1";
            this.xRails_TitleLabel1.Side = XRails.Controls.XRails_TitleLabel.PanelSide.LeftPanel;
            this.xRails_TitleLabel1.Size = new System.Drawing.Size(302, 48);
            this.xRails_TitleLabel1.TabIndex = 2;
            this.xRails_TitleLabel1.Text = "Quản lí thành viên:";
            this.xRails_TitleLabel1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.xRails_TitleLabel1.TextRenderingHint = System.Drawing.Text.TextRenderingHint.AntiAliasGridFit;
            this.xRails_TitleLabel1.UseCompatibleTextRendering = true;
            // 
            // username
            // 
            this.username.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(43)))), ((int)(((byte)(48)))), ((int)(((byte)(67)))));
            this.username.ColorBordersOnEnter = true;
            this.username.Font = new System.Drawing.Font("Paytone One", 9.749999F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.username.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(127)))), ((int)(((byte)(131)))), ((int)(((byte)(140)))));
            this.username.Image = null;
            this.username.Location = new System.Drawing.Point(0, 310);
            this.username.MaxLength = 32767;
            this.username.Multiline = false;
            this.username.Name = "username";
            this.username.ReadOnly = false;
            this.username.ShortcutsEnabled = true;
            this.username.ShowBottomBorder = true;
            this.username.ShowTopBorder = true;
            this.username.Size = new System.Drawing.Size(250, 51);
            this.username.TabIndex = 0;
            this.username.TextAlignment = System.Windows.Forms.HorizontalAlignment.Left;
            this.username.UseSystemPasswordChar = false;
            this.username.Watermark = "Tên người dùng";
            this.username.WatermarkColor = System.Drawing.Color.FromArgb(((int)(((byte)(116)))), ((int)(((byte)(120)))), ((int)(((byte)(129)))));
            // 
            // userListBox
            // 
            this.userListBox.Font = new System.Drawing.Font("Paytone One", 8.999999F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.userListBox.FormattingEnabled = true;
            this.userListBox.ItemHeight = 19;
            this.userListBox.Location = new System.Drawing.Point(0, 63);
            this.userListBox.Name = "userListBox";
            this.userListBox.Size = new System.Drawing.Size(334, 194);
            this.userListBox.TabIndex = 0;
            // 
            // ConversationMemberForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(334, 450);
            this.Controls.Add(this.xRails_Container1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.MaximumSize = new System.Drawing.Size(1920, 1032);
            this.Name = "ConversationMemberForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "ConversationCreateForm";
            this.TransparencyKey = System.Drawing.Color.Fuchsia;
            this.xRails_Container1.ResumeLayout(false);
            this.panel1.ResumeLayout(false);
            this.xRails_Panel1.ResumeLayout(false);
            this.xRails_Panel1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private XRails.Controls.XRails_Container xRails_Container1;
        private System.Windows.Forms.Panel panel1;
        private XRails.Controls.XRails_Panel xRails_Panel1;
        private XRails.Controls.XRails_TitleLabel xRails_TitleLabel1;
        private XRails.Controls.XRails_TextBox username;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label modeLabel;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnSearch;
        private System.Windows.Forms.ListBox userListBox;
    }
}