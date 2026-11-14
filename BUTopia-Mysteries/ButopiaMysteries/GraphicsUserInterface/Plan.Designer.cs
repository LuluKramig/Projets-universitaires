namespace ButopiaMysteries.GraphicsUserInterface
{
    partial class Plan
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
            buttonPenseur = new Button();
            label3 = new Label();
            buttonLegat = new Button();
            label4 = new Label();
            buttonFaiseur = new Button();
            label5 = new Label();
            buttonIntegrateur = new Button();
            label6 = new Label();
            buttonCommerçant = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 18F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label1.Location = new Point(267, 9);
            label1.Name = "label1";
            label1.Size = new Size(237, 32);
            label1.TabIndex = 0;
            label1.Text = "Choisissez votre Plan";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(35, 133);
            label2.Name = "label2";
            label2.Size = new Size(161, 15);
            label2.TabIndex = 1;
            label2.Text = "Penseurs : l'Esprit avant tout !";
            // 
            // buttonPenseur
            // 
            buttonPenseur.Location = new Point(35, 165);
            buttonPenseur.Name = "buttonPenseur";
            buttonPenseur.Size = new Size(148, 23);
            buttonPenseur.TabIndex = 2;
            buttonPenseur.Text = "Devenir un Penseur";
            buttonPenseur.UseVisualStyleBackColor = true;
            buttonPenseur.Click += ButtonClick;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(304, 133);
            label3.Name = "label3";
            label3.Size = new Size(149, 15);
            label3.TabIndex = 3;
            label3.Text = "Légats : le Sens avant tout !";
            // 
            // buttonLegat
            // 
            buttonLegat.Location = new Point(304, 165);
            buttonLegat.Name = "buttonLegat";
            buttonLegat.Size = new Size(128, 23);
            buttonLegat.TabIndex = 4;
            buttonLegat.Text = "Devenir un Légat";
            buttonLegat.UseVisualStyleBackColor = true;
            buttonLegat.Click += ButtonClick;

            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(539, 133);
            label4.Name = "label4";
            label4.Size = new Size(164, 15);
            label4.TabIndex = 5;
            label4.Text = "Faiseurs : le Corps avant tout !";
            // 
            // buttonFaiseur
            // 
            buttonFaiseur.Location = new Point(561, 165);
            buttonFaiseur.Name = "buttonFaiseur";
            buttonFaiseur.Size = new Size(127, 23);
            buttonFaiseur.TabIndex = 6;
            buttonFaiseur.Text = "Devenir un Faiseur";
            buttonFaiseur.UseVisualStyleBackColor = true;
            buttonFaiseur.Click += ButtonClick;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(112, 271);
            label5.Name = "label5";
            label5.Size = new Size(248, 15);
            label5.TabIndex = 7;
            label5.Text = "Intégrateurs : Pourquoi choisir je veux le Max !";
            // 
            // buttonIntegrateur
            // 
            buttonIntegrateur.Location = new Point(158, 299);
            buttonIntegrateur.Name = "buttonIntegrateur";
            buttonIntegrateur.Size = new Size(173, 23);
            buttonIntegrateur.TabIndex = 8;
            buttonIntegrateur.Text = "Devenir un Intégrateur";
            buttonIntegrateur.UseVisualStyleBackColor = true;
            buttonIntegrateur.Click += ButtonClick;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(455, 271);
            label6.Name = "label6";
            label6.Size = new Size(195, 15);
            label6.TabIndex = 9;
            label6.Text = "Commerçants : le Sens des affaires !";
            // 
            // buttonCommerçant
            // 
            buttonCommerçant.Location = new Point(473, 299);
            buttonCommerçant.Name = "buttonCommerçant";
            buttonCommerçant.Size = new Size(167, 23);
            buttonCommerçant.TabIndex = 10;
            buttonCommerçant.Text = "Devenir un Commerçants";
            buttonCommerçant.UseVisualStyleBackColor = true;
            buttonCommerçant.Click += ButtonClick;
            // 
            // Plan
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(buttonCommerçant);
            Controls.Add(label6);
            Controls.Add(buttonIntegrateur);
            Controls.Add(label5);
            Controls.Add(buttonFaiseur);
            Controls.Add(label4);
            Controls.Add(buttonLegat);
            Controls.Add(label3);
            Controls.Add(buttonPenseur);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "Plan";
            Text = "Plan";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Button buttonPenseur;
        private Label label3;
        private Button buttonLegat;
        private Label label4;
        private Button buttonFaiseur;
        private Label label5;
        private Button buttonIntegrateur;
        private Label label6;
        private Button buttonCommerçant;
    }
}