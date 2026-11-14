namespace ButopiaMysteries.GraphicsUserInterface
{
    partial class Sphere
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
            label4 = new Label();
            label5 = new Label();
            label6 = new Label();
            buttonAlgebra = new Button();
            buttonVerb = new Button();
            buttonTransition = new Button();
            buttonCreatif = new Button();
            buttonValorisation = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 18F);
            label1.Location = new Point(162, 5);
            label1.Margin = new Padding(2, 0, 2, 0);
            label1.Name = "label1";
            label1.Size = new Size(397, 32);
            label1.TabIndex = 0;
            label1.Text = "Quelle Sphère voulez-vous choisir ?";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(28, 70);
            label2.Margin = new Padding(2, 0, 2, 0);
            label2.Name = "label2";
            label2.Size = new Size(155, 15);
            label2.TabIndex = 1;
            label2.Text = "Algèbre : l'Esprit avant tout !";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(298, 70);
            label3.Margin = new Padding(2, 0, 2, 0);
            label3.Name = "label3";
            label3.Size = new Size(123, 30);
            label3.TabIndex = 2;
            label3.Text = "Donnez du Sens aux \r\nphrases avec un Verbe";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(592, 70);
            label4.Margin = new Padding(2, 0, 2, 0);
            label4.Name = "label4";
            label4.Size = new Size(114, 15);
            label4.TabIndex = 3;
            label4.Text = "Transition : Au Max !";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(141, 187);
            label5.Margin = new Padding(2, 0, 2, 0);
            label5.Name = "label5";
            label5.Size = new Size(160, 15);
            label5.TabIndex = 4;
            label5.Text = "Créatif : Le Corps avant tout !";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(500, 187);
            label6.Margin = new Padding(2, 0, 2, 0);
            label6.Name = "label6";
            label6.Size = new Size(140, 15);
            label6.TabIndex = 5;
            label6.Text = "Ici on se valorise au Max !";
            // 
            // buttonAlgebra
            // 
            buttonAlgebra.Location = new Point(36, 98);
            buttonAlgebra.Name = "buttonAlgebra";
            buttonAlgebra.Size = new Size(147, 23);
            buttonAlgebra.TabIndex = 6;
            buttonAlgebra.Text = "Devenir un Algèbre";
            buttonAlgebra.UseVisualStyleBackColor = true;
            buttonAlgebra.Click += ButtonClick;
            // 
            // buttonVerb
            // 
            buttonVerb.Location = new Point(298, 103);
            buttonVerb.Name = "buttonVerb";
            buttonVerb.Size = new Size(123, 23);
            buttonVerb.TabIndex = 7;
            buttonVerb.Text = "Devenir un Verbe";
            buttonVerb.UseVisualStyleBackColor = true;
            buttonVerb.Click += ButtonClick;
            // 
            // buttonTransition
            // 
            buttonTransition.Location = new Point(575, 98);
            buttonTransition.Name = "buttonTransition";
            buttonTransition.Size = new Size(151, 23);
            buttonTransition.TabIndex = 8;
            buttonTransition.Text = "Devenir une Transition";
            buttonTransition.UseVisualStyleBackColor = true;
            buttonTransition.Click += ButtonClick;
            // 
            // buttonCreatif
            // 
            buttonCreatif.Location = new Point(162, 205);
            buttonCreatif.Name = "buttonCreatif";
            buttonCreatif.Size = new Size(125, 23);
            buttonCreatif.TabIndex = 9;
            buttonCreatif.Text = "Devenir un Créatif";
            buttonCreatif.UseVisualStyleBackColor = true;
            buttonCreatif.Click += ButtonClick;
            // 
            // buttonValorisation
            // 
            buttonValorisation.Location = new Point(509, 205);
            buttonValorisation.Name = "buttonValorisation";
            buttonValorisation.Size = new Size(131, 23);
            buttonValorisation.TabIndex = 10;
            buttonValorisation.Text = "Devenir un Valorisé";
            buttonValorisation.UseVisualStyleBackColor = true;
            buttonValorisation.Click += ButtonClick;
            // 
            // Sphere
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(748, 301);
            Controls.Add(buttonValorisation);
            Controls.Add(buttonCreatif);
            Controls.Add(buttonTransition);
            Controls.Add(buttonVerb);
            Controls.Add(buttonAlgebra);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Margin = new Padding(2);
            Name = "Sphere";
            Text = "Sphere";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Label label6;
        private Button buttonAlgebra;
        private Button buttonVerb;
        private Button buttonTransition;
        private Button buttonCreatif;
        private Button buttonValorisation;
    }
}