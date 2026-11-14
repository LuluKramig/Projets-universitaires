namespace ButopiaMysteries.Logic
{
    partial class TrainingRoomDialog
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
            comboBoxSkill = new ComboBox();
            comboBoxIndic = new ComboBox();
            okButton = new Button();
            buttonPlusSkill = new Button();
            buttonMinusSkill = new Button();
            buttonPlusIndic = new Button();
            buttonMinusIndic = new Button();
            labelXpText = new Label();
            labelXpValue = new Label();
            labelSkill = new Label();
            labelSkillValue = new Label();
            labelIndic = new Label();
            labelIndicValue = new Label();
            SuspendLayout();
            // 
            // comboBoxSkill
            // 
            comboBoxSkill.FormattingEnabled = true;
            comboBoxSkill.Items.AddRange(new object[] { "Prouesse", "Esquive", "Conception", "Synthèse", "Analyse", "Expression", "Survie", "Séduction", "Concentration", "Abstraction", "Visualisation", "Modélisation", "Perrenite", "Perception", "Details", "Memorisation", "Hability", "Architecture", "Organisation", "Rectification", "Proprioception", "Liaison", "Synesthesis", "Compilation", "Edurance", "Finance", "Expertise", "Communication", "Jonction", "Induction", "Equation", "Fonctionnal", "Injonction", "Formulation", "Poetic", "Object", "Disconstruction", "Anticipation", "Argumentation", "Optimisation", "Ajustement", "Conception", "Narration", "Data", "Destruction", "Intendance", "Conviction", "Test" });
            comboBoxSkill.Location = new Point(32, 26);
            comboBoxSkill.Name = "comboBoxSkill";
            comboBoxSkill.Size = new Size(121, 23);
            comboBoxSkill.TabIndex = 0;
            comboBoxSkill.Text = "Compétence";
            comboBoxSkill.SelectedValueChanged += ComboBoxSkill_SelectedValueChanged;
            // 
            // comboBoxIndic
            // 
            comboBoxIndic.FormattingEnabled = true;
            comboBoxIndic.Items.AddRange(new object[] { "Corps", "Esprit", "Sens", "Maximum" });
            comboBoxIndic.Location = new Point(32, 79);
            comboBoxIndic.Name = "comboBoxIndic";
            comboBoxIndic.Size = new Size(121, 23);
            comboBoxIndic.TabIndex = 1;
            comboBoxIndic.Text = "Indicateur";
            comboBoxIndic.SelectedValueChanged += ComboBoxIndic_SelectedValueChanged;
            // 
            // okButton
            // 
            okButton.DialogResult = DialogResult.OK;
            okButton.Location = new Point(378, 124);
            okButton.Name = "okButton";
            okButton.Size = new Size(75, 23);
            okButton.TabIndex = 7;
            okButton.Text = "Confirmer";
            okButton.UseVisualStyleBackColor = true;
            // 
            // buttonPlusSkill
            // 
            buttonPlusSkill.Location = new Point(327, 25);
            buttonPlusSkill.Name = "buttonPlusSkill";
            buttonPlusSkill.Size = new Size(75, 23);
            buttonPlusSkill.TabIndex = 8;
            buttonPlusSkill.Text = "Plus";
            buttonPlusSkill.UseVisualStyleBackColor = true;
            buttonPlusSkill.Click += ButtonPlusSkill_Click;
            // 
            // buttonMinusSkill
            // 
            buttonMinusSkill.Location = new Point(433, 25);
            buttonMinusSkill.Name = "buttonMinusSkill";
            buttonMinusSkill.Size = new Size(75, 23);
            buttonMinusSkill.TabIndex = 9;
            buttonMinusSkill.Text = "Moins";
            buttonMinusSkill.UseVisualStyleBackColor = true;
            buttonMinusSkill.Click += ButtonMinusSkill_Click;
            // 
            // buttonPlusIndic
            // 
            buttonPlusIndic.Location = new Point(327, 78);
            buttonPlusIndic.Name = "buttonPlusIndic";
            buttonPlusIndic.Size = new Size(75, 23);
            buttonPlusIndic.TabIndex = 10;
            buttonPlusIndic.Text = "Plus";
            buttonPlusIndic.UseVisualStyleBackColor = true;
            buttonPlusIndic.Click += ButtonPlusIndic_Click;
            // 
            // buttonMinusIndic
            // 
            buttonMinusIndic.Location = new Point(433, 78);
            buttonMinusIndic.Name = "buttonMinusIndic";
            buttonMinusIndic.Size = new Size(75, 23);
            buttonMinusIndic.TabIndex = 11;
            buttonMinusIndic.Text = "Moins";
            buttonMinusIndic.UseVisualStyleBackColor = true;
            buttonMinusIndic.Click += ButtonMinusIndic_Click;
            // 
            // labelXpText
            // 
            labelXpText.AutoSize = true;
            labelXpText.Location = new Point(31, 124);
            labelXpText.Name = "labelXpText";
            labelXpText.Size = new Size(115, 15);
            labelXpText.TabIndex = 12;
            labelXpText.Text = "Points d'expérience :";
            // 
            // labelXpValue
            // 
            labelXpValue.AutoSize = true;
            labelXpValue.Location = new Point(152, 124);
            labelXpValue.Name = "labelXpValue";
            labelXpValue.Size = new Size(13, 15);
            labelXpValue.TabIndex = 13;
            labelXpValue.Text = "0";
            // 
            // labelSkill
            // 
            labelSkill.AutoSize = true;
            labelSkill.Location = new Point(184, 29);
            labelSkill.Name = "labelSkill";
            labelSkill.Size = new Size(45, 15);
            labelSkill.TabIndex = 14;
            labelSkill.Text = "Valeur :";
            // 
            // labelSkillValue
            // 
            labelSkillValue.AutoSize = true;
            labelSkillValue.Location = new Point(246, 29);
            labelSkillValue.Name = "labelSkillValue";
            labelSkillValue.Size = new Size(13, 15);
            labelSkillValue.TabIndex = 15;
            labelSkillValue.Text = "0";
            // 
            // labelIndic
            // 
            labelIndic.AutoSize = true;
            labelIndic.Location = new Point(184, 82);
            labelIndic.Name = "labelIndic";
            labelIndic.Size = new Size(45, 15);
            labelIndic.TabIndex = 16;
            labelIndic.Text = "Valeur :";
            // 
            // labelIndicValue
            // 
            labelIndicValue.AutoSize = true;
            labelIndicValue.Location = new Point(246, 82);
            labelIndicValue.Name = "labelIndicValue";
            labelIndicValue.Size = new Size(13, 15);
            labelIndicValue.TabIndex = 17;
            labelIndicValue.Text = "0";
            // 
            // TrainingRoomDialog
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(547, 158);
            Controls.Add(labelIndicValue);
            Controls.Add(labelIndic);
            Controls.Add(labelSkillValue);
            Controls.Add(labelSkill);
            Controls.Add(labelXpValue);
            Controls.Add(labelXpText);
            Controls.Add(buttonMinusIndic);
            Controls.Add(buttonPlusIndic);
            Controls.Add(buttonMinusSkill);
            Controls.Add(buttonPlusSkill);
            Controls.Add(okButton);
            Controls.Add(comboBoxIndic);
            Controls.Add(comboBoxSkill);
            Name = "TrainingRoomDialog";
            Text = "Salle d'entraînement";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ComboBox comboBoxSkill;
        private ComboBox comboBoxIndic;
        private Button okButton;
        private Button buttonPlusSkill;
        private Button buttonMinusSkill;
        private Button buttonPlusIndic;
        private Button buttonMinusIndic;
        private Label labelXpText;
        private Label labelXpValue;
        private Label labelSkill;
        private Label labelSkillValue;
        private Label labelIndic;
        private Label labelIndicValue;
    }
}