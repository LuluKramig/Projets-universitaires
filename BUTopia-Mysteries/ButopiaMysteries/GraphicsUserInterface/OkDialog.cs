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
    /// A basic dialog for character deletion confirmation.
    /// </summary>
    public partial class OkDialog : Form
    {
        /// <summary>
        /// Constructor of the dialog
        /// </summary>
        /// <param name="name">the name of the character in potential deletion</param>
        public OkDialog(String name)
        {
            InitializeComponent();
            labelStatement.Text += name + " ?";
        }

        private void OkDialog_Load(object sender, EventArgs e)
        {

        }
    }
}
