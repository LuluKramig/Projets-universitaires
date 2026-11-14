namespace ButopiaMysteries.GraphicsUserInterface
{
    partial class Premenu
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
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            button1 = new Button();
            button2 = new Button();
            button3 = new Button();
            numericUpDown1 = new NumericUpDown();
            colorDialog1 = new ColorDialog();
            colorDialog2 = new ColorDialog();
            ((System.ComponentModel.ISupportInitialize)numericUpDown1).BeginInit();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 14F);
            label1.Location = new Point(93, 47);
            label1.Name = "label1";
            label1.Size = new Size(626, 25);
            label1.TabIndex = 0;
            label1.Text = "Bienvenue sur Butopia ! Combien de personnages souhaitez-vous créer ?";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(93, 205);
            label2.Name = "label2";
            label2.Size = new Size(224, 15);
            label2.TabIndex = 1;
            label2.Text = "Personnalisez la couleur des personnages";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(513, 205);
            label3.Name = "label3";
            label3.Size = new Size(178, 15);
            label3.TabIndex = 2;
            label3.Text = "Personnalisez la couleur du fond";
            // 
            // button1
            // 
            button1.Location = new Point(129, 249);
            button1.Name = "button1";
            button1.Size = new Size(145, 23);
            button1.TabIndex = 3;
            button1.Text = "Choisissez la couleur !";
            button1.UseVisualStyleBackColor = true;
            button1.Click += Button1_Click;
            // 
            // button2
            // 
            button2.Location = new Point(531, 249);
            button2.Name = "button2";
            button2.Size = new Size(147, 23);
            button2.TabIndex = 4;
            button2.Text = "Choisissez la couleur !";
            button2.UseVisualStyleBackColor = true;
            button2.Click += Button2_Click;
            // 
            // button3
            // 
            button3.Location = new Point(302, 355);
            button3.Name = "button3";
            button3.Size = new Size(214, 23);
            button3.TabIndex = 5;
            button3.Text = "Entrez dans l'univers de Butopia !";
            button3.UseVisualStyleBackColor = true;
            button3.Click += Button3_Click;
            // 
            // numericUpDown1
            // 
            numericUpDown1.Location = new Point(333, 94);
            numericUpDown1.Maximum = new decimal(new int[] { 15, 0, 0, 0 });
            numericUpDown1.Minimum = new decimal(new int[] { 1, 0, 0, 0 });
            numericUpDown1.Name = "numericUpDown1";
            numericUpDown1.Size = new Size(120, 23);
            numericUpDown1.TabIndex = 6;
            numericUpDown1.Value = new decimal(new int[] { 1, 0, 0, 0 });
            // 
            // Premenu
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(numericUpDown1);
            Controls.Add(button3);
            Controls.Add(button2);
            Controls.Add(button1);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "Premenu";
            Text = "Pré-Menu";
            ((System.ComponentModel.ISupportInitialize)numericUpDown1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Button button1;
        private Button button2;
        private Button button3;
        private NumericUpDown numericUpDown1;
        private ColorDialog colorDialog1;
        private ColorDialog colorDialog2;
    }
}