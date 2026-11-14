using ButopiaMysteries.Logic;
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
    /// A basic dialog for character creation.
    /// </summary>
    public partial class NewCharacterDialog : Form
    {
        /// <summary>
        /// The name of the character.
        /// </summary>
        public string CharacterName { get { return nameTextBox.Text; } }
        /// <summary>
        /// The fact that this character is randomly created or not.
        /// </summary>
        public bool RandomGeneration { get { return randomCreationCheckBox.Checked; } }
        /// <summary>
        /// Constructor.
        /// </summary>
        public NewCharacterDialog()
        {
            InitializeComponent();
            okButton.Enabled = false;
        }
        /// <summary>
        /// When the textbox is double-clicked, it fills randomly with a name from the names base
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void NameTextBox_DoubleClick(object sender, EventArgs e)
        {
            nameTextBox.Text = Names.RandomName;
        }
        /// <summary>
        /// When the text of the box is changed, enable the ok button if there is text
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void NameTextBox_TextChanged(object sender, EventArgs e)
        {
            okButton.Enabled = nameLabel.Text.Length > 0;
        }
        /// <summary>
        /// When the ok button is clicked, close the dialog with an OK result
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OkButton_Click(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.OK;
            Close();
        }
    }
}