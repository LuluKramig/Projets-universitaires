using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ButopiaMysteries.GraphicsUserInterface
{
    /// <summary>
    /// Main class, sets some settings before the principal window
    /// </summary>
    public partial class Premenu : Form
    {
        /// <summary>
        /// The colour of the characters and text
        /// </summary>
        public static Color ColorDiag { get; set; }
        /// <summary>
        /// Background colour
        /// </summary>
        public static Color ColorDiag2 { get; set; }
        /// <summary>
        /// Number of characters
        /// </summary>
        public static int NombrePersonnage;
        /// <summary>
        /// The constructor
        /// </summary>
        public Premenu()
        {
            InitializeComponent();
            button2.Enabled = false;
            button3.Enabled = false;
        }
        /// <summary>
        /// When the character colour button is clicked, sets the values with a colour dialog and enables the second button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void Button1_Click(object sender, EventArgs e)
        {
            colorDialog1.ShowDialog();
            ColorDiag = colorDialog1.Color;
            button2.Enabled = true;
        }
        /// <summary>
        /// When the background colour button is clicked, sets the values with a colour dialog and enables the third button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void Button2_Click(object sender, EventArgs e)
        {
            colorDialog2.ShowDialog();
            ColorDiag2 = colorDialog2.Color;
            button3.Enabled = true;
        }
        /// <summary>
        /// Validates the colour settings and opens the character select form
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void Button3_Click(object sender, EventArgs e)
        {
            NombrePersonnage = (int)numericUpDown1.Value;
            CharacterSelect characterSelect = new CharacterSelect(NombrePersonnage);
            characterSelect.ShowDialog();
            Dispose();

        }
    }
}
