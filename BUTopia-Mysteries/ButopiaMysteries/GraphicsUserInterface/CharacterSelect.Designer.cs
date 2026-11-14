namespace ButopiaMysteries.GraphicsUserInterface
{
    partial class CharacterSelect
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            createButton = new Button();
            quitButton = new Button();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            comboBoxSkill = new ComboBox();
            comboBoxDiff = new ComboBox();
            SuspendLayout();
            // 
            // createButton
            // 
            createButton.Location = new Point(652, 12);
            createButton.Name = "createButton";
            createButton.Size = new Size(136, 23);
            createButton.TabIndex = 1;
            createButton.Text = "Nouveau mystère...";
            createButton.UseVisualStyleBackColor = true;
            createButton.Click += CreateButton_Click;
            // 
            // quitButton
            // 
            quitButton.Location = new Point(713, 402);
            quitButton.Name = "quitButton";
            quitButton.Size = new Size(75, 23);
            quitButton.TabIndex = 2;
            quitButton.Text = "Quitter";
            quitButton.UseVisualStyleBackColor = true;
            quitButton.Click += QuitButton_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(626, 55);
            label1.Name = "label1";
            label1.Size = new Size(120, 15);
            label1.TabIndex = 6;
            label1.Text = "Salle Auto-Evaluation";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(626, 167);
            label2.Name = "label2";
            label2.Size = new Size(85, 15);
            label2.TabIndex = 7;
            label2.Text = "Salle d'Examen";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(627, 284);
            label3.Name = "label3";
            label3.Size = new Size(115, 15);
            label3.TabIndex = 8;
            label3.Text = "Salle d'entraînement";
            // 
            // comboBoxSkill
            // 
            comboBoxSkill.FormattingEnabled = true;
            comboBoxSkill.Items.AddRange(new object[] { "Prouesse", "Esquive", "Conception", "Synthèse", "Analyse", "Expression", "Survie", "Séduction", "Concentration", "Abstraction", "Visualisation", "Modélisation", "Perrenite", "Perception", "Details", "Memorisation", "Hability", "Architecture", "Organisation", "Rectification", "Proprioception", "Liaison", "Synesthesis", "Compilation", "Edurance", "Finance", "Expertise", "Communication", "Jonction", "Induction", "Equation", "Fonctionnal", "Injonction", "Formulation", "Poetic", "Object", "Disconstruction", "Anticipation", "Argumentation", "Optimisation", "Ajustement", "Conception", "Narration", "Data", "Destruction", "Intendance", "Conviction", "Test" });
            comboBoxSkill.Location = new Point(339, 402);
            comboBoxSkill.Name = "comboBoxSkill";
            comboBoxSkill.Size = new Size(121, 23);
            comboBoxSkill.TabIndex = 9;
            comboBoxSkill.Text = "Compétence";
            // 
            // comboBoxDiff
            // 
            comboBoxDiff.FormattingEnabled = true;
            comboBoxDiff.Items.AddRange(new object[] { "Rien", "Trivial", "Facile", "Normal", "Complexe", "Délicat", "Défi", "Exploit", "Surhumain", "Impossible" });
            comboBoxDiff.Location = new Point(505, 402);
            comboBoxDiff.Name = "comboBoxDiff";
            comboBoxDiff.Size = new Size(121, 23);
            comboBoxDiff.TabIndex = 10;
            comboBoxDiff.Text = "Difficulté";
            // 
            // CharacterSelect
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(comboBoxDiff);
            Controls.Add(comboBoxSkill);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(quitButton);
            Controls.Add(createButton);
            DoubleBuffered = true;
            Name = "CharacterSelect";
            Text = "Sélection";
            Load += CharacterSelect_Load;
            Paint += CharacterSelect_Paint;
            MouseDown += CharacterSelect_MouseDown;
            MouseMove += CharacterSelect_MouseMove;
            MouseUp += CharacterSelect_MouseUp;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion
        private Button createButton;
        private Button quitButton;
        private Label label1;
        private Label label2;
        private Label label3;
        private ComboBox comboBoxSkill;
        private ComboBox comboBoxDiff;
    }
}
