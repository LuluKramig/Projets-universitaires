namespace ButopiaMysteries.GraphicsUserInterface
{
    partial class OkDialog
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
            buttonNo = new Button();
            buttonYes = new Button();
            labelStatement = new Label();
            SuspendLayout();
            // 
            // buttonNo
            // 
            buttonNo.DialogResult = DialogResult.Cancel;
            buttonNo.Location = new Point(205, 65);
            buttonNo.Name = "buttonNo";
            buttonNo.Size = new Size(75, 23);
            buttonNo.TabIndex = 0;
            buttonNo.Text = "Non";
            buttonNo.UseVisualStyleBackColor = true;
            // 
            // buttonYes
            // 
            buttonYes.DialogResult = DialogResult.OK;
            buttonYes.Location = new Point(50, 65);
            buttonYes.Name = "buttonYes";
            buttonYes.Size = new Size(75, 23);
            buttonYes.TabIndex = 1;
            buttonYes.Text = "Oui";
            buttonYes.UseVisualStyleBackColor = true;
            // 
            // labelStatement
            // 
            labelStatement.AutoSize = true;
            labelStatement.Location = new Point(50, 27);
            labelStatement.Name = "labelStatement";
            labelStatement.Size = new Size(167, 15);
            labelStatement.TabIndex = 2;
            labelStatement.Text = "Êtes-vous sûr(e) de supprimer ";
            // 
            // OkDialog
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(334, 100);
            Controls.Add(labelStatement);
            Controls.Add(buttonYes);
            Controls.Add(buttonNo);
            Name = "OkDialog";
            Text = "Confirmation de l'action";
            Load += OkDialog_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button buttonNo;
        private Button buttonYes;
        private Label labelStatement;
    }
}