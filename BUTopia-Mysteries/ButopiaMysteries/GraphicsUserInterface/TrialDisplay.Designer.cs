namespace ButopiaMysteries.GraphicsUserInterface
{
    partial class TrialDisplay
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
            buttonStart = new Button();
            buttonClose = new Button();
            labelName = new Label();
            labelSkill = new Label();
            labelIndic = new Label();
            labelLevel = new Label();
            labelDifficulty = new Label();
            labelResult = new Label();
            numericUpDownTrial = new NumericUpDown();
            ((System.ComponentModel.ISupportInitialize)numericUpDownTrial).BeginInit();
            SuspendLayout();
            // 
            // buttonStart
            // 
            buttonStart.Location = new Point(121, 225);
            buttonStart.Name = "buttonStart";
            buttonStart.Size = new Size(75, 23);
            buttonStart.TabIndex = 0;
            buttonStart.Text = "Start";
            buttonStart.UseVisualStyleBackColor = true;
            buttonStart.Click += ButtonStart_Click;
            // 
            // buttonClose
            // 
            buttonClose.Location = new Point(281, 225);
            buttonClose.Name = "buttonClose";
            buttonClose.Size = new Size(75, 23);
            buttonClose.TabIndex = 1;
            buttonClose.Text = "Close";
            buttonClose.UseVisualStyleBackColor = true;
            buttonClose.Click += ButtonClose_Click;
            // 
            // labelName
            // 
            labelName.AutoSize = true;
            labelName.Location = new Point(27, 27);
            labelName.Name = "labelName";
            labelName.Size = new Size(38, 15);
            labelName.TabIndex = 2;
            labelName.Text = "label1";
            // 
            // labelSkill
            // 
            labelSkill.AutoSize = true;
            labelSkill.Location = new Point(27, 92);
            labelSkill.Name = "labelSkill";
            labelSkill.Size = new Size(38, 15);
            labelSkill.TabIndex = 3;
            labelSkill.Text = "label2";
            // 
            // labelIndic
            // 
            labelIndic.AutoSize = true;
            labelIndic.Location = new Point(27, 125);
            labelIndic.Name = "labelIndic";
            labelIndic.Size = new Size(38, 15);
            labelIndic.TabIndex = 4;
            labelIndic.Text = "label3";
            // 
            // labelLevel
            // 
            labelLevel.AutoSize = true;
            labelLevel.Location = new Point(216, 27);
            labelLevel.Name = "labelLevel";
            labelLevel.Size = new Size(38, 15);
            labelLevel.TabIndex = 5;
            labelLevel.Text = "label4";
            // 
            // labelDifficulty
            // 
            labelDifficulty.AutoSize = true;
            labelDifficulty.Location = new Point(349, 27);
            labelDifficulty.Name = "labelDifficulty";
            labelDifficulty.Size = new Size(38, 15);
            labelDifficulty.TabIndex = 6;
            labelDifficulty.Text = "label5";
            // 
            // labelResult
            // 
            labelResult.AutoSize = true;
            labelResult.Location = new Point(216, 73);
            labelResult.Name = "labelResult";
            labelResult.Size = new Size(117, 15);
            labelResult.TabIndex = 7;
            labelResult.Text = "Nombre d'épreuves :";
            // 
            // numericUpDownTrial
            // 
            numericUpDownTrial.Location = new Point(225, 106);
            numericUpDownTrial.Maximum = new decimal(new int[] { 8, 0, 0, 0 });
            numericUpDownTrial.Minimum = new decimal(new int[] { 1, 0, 0, 0 });
            numericUpDownTrial.Name = "numericUpDownTrial";
            numericUpDownTrial.Size = new Size(120, 23);
            numericUpDownTrial.TabIndex = 8;
            numericUpDownTrial.Value = new decimal(new int[] { 1, 0, 0, 0 });
            // 
            // TrialDisplay
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(466, 267);
            Controls.Add(numericUpDownTrial);
            Controls.Add(labelResult);
            Controls.Add(labelDifficulty);
            Controls.Add(labelLevel);
            Controls.Add(labelIndic);
            Controls.Add(labelSkill);
            Controls.Add(labelName);
            Controls.Add(buttonClose);
            Controls.Add(buttonStart);
            Name = "TrialDisplay";
            Text = "Épreuves";
            ((System.ComponentModel.ISupportInitialize)numericUpDownTrial).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button buttonStart;
        private Button buttonClose;
        private Label labelName;
        private Label labelSkill;
        private Label labelIndic;
        private Label labelLevel;
        private Label labelDifficulty;
        private Label labelResult;
        private NumericUpDown numericUpDownTrial;
    }
}