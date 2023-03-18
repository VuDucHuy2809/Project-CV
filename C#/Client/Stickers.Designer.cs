namespace chat
{
    partial class Stickers
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
            this.stickerPanel = new System.Windows.Forms.FlowLayoutPanel();
            this.SuspendLayout();
            // 
            // stickerPanel
            // 
            this.stickerPanel.AutoScroll = true;
            this.stickerPanel.Location = new System.Drawing.Point(0, 0);
            this.stickerPanel.Margin = new System.Windows.Forms.Padding(0);
            this.stickerPanel.Name = "stickerPanel";
            this.stickerPanel.Size = new System.Drawing.Size(420, 220);
            this.stickerPanel.TabIndex = 0;
            // 
            // Stickers
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(420, 220);
            this.Controls.Add(this.stickerPanel);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Stickers";
            this.Text = "Stickers";
            this.Deactivate += new System.EventHandler(this.Stickers_Deactivate);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.FlowLayoutPanel stickerPanel;
    }
}