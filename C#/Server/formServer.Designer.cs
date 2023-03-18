namespace Server
{
    partial class Server
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
            this.components = new System.ComponentModel.Container();
            this.btnStart = new System.Windows.Forms.Button();
            this.lobbyLog = new System.Windows.Forms.TextBox();
            this.listBox1 = new System.Windows.Forms.ListBox();
            this.contextMenuStrip = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.disconnectToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.lblOnline = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.btnServerStop = new System.Windows.Forms.Button();
            this.conversationListBox = new System.Windows.Forms.ListBox();
            this.label3 = new System.Windows.Forms.Label();
            this.btnViewMember = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.reset = new System.Windows.Forms.Button();
            this.clientLog = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.clearLog = new System.Windows.Forms.Button();
            this.online = new System.Windows.Forms.ListBox();
            this.label6 = new System.Windows.Forms.Label();
            this.contextMenuStrip.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnStart
            // 
            this.btnStart.BackColor = System.Drawing.Color.MediumTurquoise;
            this.btnStart.FlatAppearance.BorderColor = System.Drawing.Color.Silver;
            this.btnStart.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnStart.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnStart.ForeColor = System.Drawing.Color.White;
            this.btnStart.Location = new System.Drawing.Point(859, 33);
            this.btnStart.Name = "btnStart";
            this.btnStart.Size = new System.Drawing.Size(126, 23);
            this.btnStart.TabIndex = 0;
            this.btnStart.Text = "Khởi động máy chủ";
            this.btnStart.UseVisualStyleBackColor = false;
            this.btnStart.Click += new System.EventHandler(this.btnStart_Click);
            // 
            // lobbyLog
            // 
            this.lobbyLog.BackColor = System.Drawing.Color.WhiteSmoke;
            this.lobbyLog.Font = new System.Drawing.Font("Paytone One", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lobbyLog.Location = new System.Drawing.Point(12, 62);
            this.lobbyLog.Multiline = true;
            this.lobbyLog.Name = "lobbyLog";
            this.lobbyLog.ReadOnly = true;
            this.lobbyLog.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.lobbyLog.Size = new System.Drawing.Size(654, 205);
            this.lobbyLog.TabIndex = 1;
            this.lobbyLog.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // listBox1
            // 
            this.listBox1.ContextMenuStrip = this.contextMenuStrip;
            this.listBox1.FormattingEnabled = true;
            this.listBox1.Location = new System.Drawing.Point(716, 124);
            this.listBox1.Name = "listBox1";
            this.listBox1.Size = new System.Drawing.Size(146, 160);
            this.listBox1.TabIndex = 3;
            // 
            // contextMenuStrip
            // 
            this.contextMenuStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.disconnectToolStripMenuItem});
            this.contextMenuStrip.Name = "contextMenuStrip1";
            this.contextMenuStrip.Size = new System.Drawing.Size(134, 26);
            // 
            // disconnectToolStripMenuItem
            // 
            this.disconnectToolStripMenuItem.Name = "disconnectToolStripMenuItem";
            this.disconnectToolStripMenuItem.Size = new System.Drawing.Size(133, 22);
            this.disconnectToolStripMenuItem.Text = "Disconnect";
            //this.disconnectToolStripMenuItem.Click += new System.EventHandler(this.disconnectToolStripMenuItem_Click);
            // 
            // lblOnline
            // 
            this.lblOnline.AutoSize = true;
            this.lblOnline.ForeColor = System.Drawing.Color.RoyalBlue;
            this.lblOnline.Location = new System.Drawing.Point(722, 104);
            this.lblOnline.Name = "lblOnline";
            this.lblOnline.Size = new System.Drawing.Size(62, 13);
            this.lblOnline.TabIndex = 4;
            this.lblOnline.Text = "Người dùng";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.DarkSlateBlue;
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(115, 18);
            this.label1.TabIndex = 5;
            this.label1.Text = "Máy chủ Ủn Ỉn";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Paytone One", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.RoyalBlue;
            this.label2.Location = new System.Drawing.Point(22, 42);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(64, 18);
            this.label2.TabIndex = 6;
            this.label2.Text = "ĐẠI SẢNH";
            // 
            // btnServerStop
            // 
            this.btnServerStop.BackColor = System.Drawing.Color.MediumTurquoise;
            this.btnServerStop.FlatAppearance.BorderColor = System.Drawing.Color.Silver;
            this.btnServerStop.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnServerStop.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnServerStop.ForeColor = System.Drawing.Color.White;
            this.btnServerStop.Location = new System.Drawing.Point(859, 62);
            this.btnServerStop.Name = "btnServerStop";
            this.btnServerStop.Size = new System.Drawing.Size(126, 23);
            this.btnServerStop.TabIndex = 7;
            this.btnServerStop.Text = "Tắt máy chủ";
            this.btnServerStop.UseVisualStyleBackColor = false;
            this.btnServerStop.Click += new System.EventHandler(this.btnServerStop_Click);
            // 
            // conversationListBox
            // 
            this.conversationListBox.FormattingEnabled = true;
            this.conversationListBox.Location = new System.Drawing.Point(868, 124);
            this.conversationListBox.Name = "conversationListBox";
            this.conversationListBox.Size = new System.Drawing.Size(249, 160);
            this.conversationListBox.TabIndex = 10;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.ForeColor = System.Drawing.Color.RoyalBlue;
            this.label3.Location = new System.Drawing.Point(879, 104);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(85, 13);
            this.label3.TabIndex = 11;
            this.label3.Text = "Cuộc trò chuyện";
            // 
            // btnViewMember
            // 
            this.btnViewMember.BackColor = System.Drawing.Color.MediumTurquoise;
            this.btnViewMember.FlatAppearance.BorderColor = System.Drawing.Color.Silver;
            this.btnViewMember.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnViewMember.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnViewMember.ForeColor = System.Drawing.Color.White;
            this.btnViewMember.Location = new System.Drawing.Point(868, 290);
            this.btnViewMember.Name = "btnViewMember";
            this.btnViewMember.Size = new System.Drawing.Size(126, 23);
            this.btnViewMember.TabIndex = 12;
            this.btnViewMember.Text = "Xem thành viên";
            this.btnViewMember.UseVisualStyleBackColor = false;
            this.btnViewMember.Click += new System.EventHandler(this.btnViewMember_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.ForeColor = System.Drawing.Color.RoyalBlue;
            this.label4.Location = new System.Drawing.Point(879, 9);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(58, 13);
            this.label4.TabIndex = 13;
            this.label4.Text = "Điều khiển";
            // 
            // reset
            // 
            this.reset.BackColor = System.Drawing.Color.MediumTurquoise;
            this.reset.FlatAppearance.BorderColor = System.Drawing.Color.Silver;
            this.reset.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.reset.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.reset.ForeColor = System.Drawing.Color.White;
            this.reset.Location = new System.Drawing.Point(991, 62);
            this.reset.Name = "reset";
            this.reset.Size = new System.Drawing.Size(126, 23);
            this.reset.TabIndex = 14;
            this.reset.Text = "Reset dữ liệu";
            this.reset.UseVisualStyleBackColor = false;
            this.reset.Click += new System.EventHandler(this.reset_Click);
            // 
            // clientLog
            // 
            this.clientLog.BackColor = System.Drawing.Color.WhiteSmoke;
            this.clientLog.Font = new System.Drawing.Font("Paytone One", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.clientLog.Location = new System.Drawing.Point(12, 317);
            this.clientLog.Multiline = true;
            this.clientLog.Name = "clientLog";
            this.clientLog.ReadOnly = true;
            this.clientLog.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.clientLog.Size = new System.Drawing.Size(654, 278);
            this.clientLog.TabIndex = 15;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Paytone One", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.ForeColor = System.Drawing.Color.RoyalBlue;
            this.label5.Location = new System.Drawing.Point(22, 290);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(99, 18);
            this.label5.TabIndex = 16;
            this.label5.Text = "CÁC MÁY KHÁCH";
            // 
            // clearLog
            // 
            this.clearLog.BackColor = System.Drawing.Color.MediumTurquoise;
            this.clearLog.FlatAppearance.BorderColor = System.Drawing.Color.Silver;
            this.clearLog.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.clearLog.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.clearLog.ForeColor = System.Drawing.Color.White;
            this.clearLog.Location = new System.Drawing.Point(991, 33);
            this.clearLog.Name = "clearLog";
            this.clearLog.Size = new System.Drawing.Size(126, 23);
            this.clearLog.TabIndex = 17;
            this.clearLog.Text = "Xóa bản ghi";
            this.clearLog.UseVisualStyleBackColor = false;
            this.clearLog.Click += new System.EventHandler(this.clearLog_Click);
            // 
            // online
            // 
            this.online.ContextMenuStrip = this.contextMenuStrip;
            this.online.FormattingEnabled = true;
            this.online.Location = new System.Drawing.Point(716, 317);
            this.online.Name = "online";
            this.online.Size = new System.Drawing.Size(146, 160);
            this.online.TabIndex = 18;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.ForeColor = System.Drawing.Color.RoyalBlue;
            this.label6.Location = new System.Drawing.Point(722, 295);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(37, 13);
            this.label6.TabIndex = 19;
            this.label6.Text = "Online";
            // 
            // Server
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.BackColor = System.Drawing.Color.White;
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.ClientSize = new System.Drawing.Size(1129, 607);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.online);
            this.Controls.Add(this.clearLog);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.clientLog);
            this.Controls.Add(this.reset);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.btnViewMember);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.conversationListBox);
            this.Controls.Add(this.btnServerStop);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.lblOnline);
            this.Controls.Add(this.listBox1);
            this.Controls.Add(this.lobbyLog);
            this.Controls.Add(this.btnStart);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MinimumSize = new System.Drawing.Size(501, 467);
            this.Name = "Server";
            this.Text = "Server";
            this.contextMenuStrip.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnStart;
        private System.Windows.Forms.TextBox lobbyLog;
        private System.Windows.Forms.ListBox listBox1;
        private System.Windows.Forms.Label lblOnline;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btnServerStop;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip;
        private System.Windows.Forms.ToolStripMenuItem disconnectToolStripMenuItem;
        private System.Windows.Forms.ListBox conversationListBox;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button btnViewMember;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button reset;
        private System.Windows.Forms.TextBox clientLog;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Button clearLog;
        private System.Windows.Forms.ListBox online;
        private System.Windows.Forms.Label label6;
    }
}

