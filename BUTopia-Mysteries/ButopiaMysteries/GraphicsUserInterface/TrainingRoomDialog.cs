using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.Button;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.Window;

namespace ButopiaMysteries.Logic
{
    /// <summary>
    /// An edit dialog with the training room.
    /// </summary>
    public partial class TrainingRoomDialog : Form
    {
        private string name = string.Empty;
        /// <summary>
        /// The value (start & end) = level.
        /// </summary>
        public int ValueSkill { get; private set; }
        /// <summary>
        /// The value (start & end) = level.
        /// </summary>
        public int ValueIndicator { get; private set; }
        /// <summary>
        /// The points available.
        /// </summary>
        public int PointsSkill { get; private set; }
        /// <summary>
        /// The points available.
        /// </summary>
        public int PointsIndicator { get; private set; }
        /// <summary>
        /// The sheet
        /// </summary>
        private MysterySheet Sheet { get; init; }
        /// <summary>
        /// Constructor: skill version
        /// </summary>
        /// <param name="sheet">the sheet</param>
        public TrainingRoomDialog(MysterySheet sheet)
        {
            InitializeComponent();
            Sheet = sheet;
            comboBoxSkill.Items.Clear();
            comboBoxIndic.Items.Clear();
            FillComboBoxes(Sheet);
            labelXpValue.Text = Sheet.experience.ToString();
            UpdateDisplay();
        }
        /// <summary>
        /// Gets the value of the selected skill
        /// </summary>
        /// <param name="name">the name</param>
        /// <returns></returns>
        private static Skill RecupValueSkill(string name)
        {
            return Skill_Operations.Name_Invert(name);
        }
        /// <summary>
        /// Gets the value of the selected indicator
        /// </summary>
        /// <param name="name">the name</param>
        /// <returns></returns>
        private static Indicator RecupValueIndic(string name)
        {
            return Indicator_Operations.Name_Invert(name);
        }
        /// <summary>
        /// Fills the combo boxes with the skills and the indicators of the sheet
        /// </summary>
        /// <param name="sheet"></param>
        private void FillComboBoxes(MysterySheet sheet)
        {
            foreach (Skill skill in sheet.Skills.Keys)
            {
                comboBoxSkill.Items.Add(Skill_Operations.Name(skill));
            }
            foreach (Indicator indicator in sheet.Indicators.Keys)
            {
                comboBoxIndic.Items.Add(Indicator_Operations.Name(indicator));
            }
        }
        /// <summary>
        /// When the value of the skill combo box is changes, updates to the modifications
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ComboBoxSkill_SelectedValueChanged(object sender, EventArgs e)
        {
            if (comboBoxSkill.SelectedItem != null)
            {
                comboBoxSkill.Text = comboBoxSkill.SelectedItem.ToString();
                ValueSkill = Sheet.Skills[RecupValueSkill(comboBoxSkill.Text)];
            }
            UpdateDisplay();
        }
        /// <summary>
        /// When the value of the skill combo box is changes, updates to the modifications
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ComboBoxIndic_SelectedValueChanged(object sender, EventArgs e)
        {
            if (comboBoxIndic.SelectedItem != null)
            { 
                comboBoxIndic.Text = comboBoxIndic.SelectedItem.ToString();
                ValueIndicator = Sheet.Indicators[RecupValueIndic(comboBoxIndic.Text)];
            }
            UpdateDisplay();
        }
        /// <summary>
        /// Updates the ability of the buttons and the labels
        /// </summary>
        private void UpdateDisplay()
        {
            buttonPlusIndic.Enabled = Sheet.experience >= Indicator_Operations.IndicatorPointsAtLevel(ValueIndicator + 1) && ValueIndicator < Indicator_Operations.MaxValue;
            buttonMinusIndic.Enabled = ValueIndicator > Indicator_Operations.MinValue;
            buttonPlusSkill.Enabled = Sheet.experience >= Skill_Operations.SkillPointsAtLevel(ValueSkill + 1) && ValueSkill < Skill_Operations.MaxValue;
            buttonMinusSkill.Enabled = ValueSkill > Skill_Operations.MinValue;
            labelIndicValue.Text = ValueIndicator.ToString();
            labelSkillValue.Text = ValueSkill.ToString();
            labelXpValue.Text = Sheet.experience.ToString();
        }
        /// <summary>
        /// When the indicator plus button is clicked, do the corresponding actions
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ButtonPlusIndic_Click(object sender, EventArgs e)
        {
            Sheet.experience -= Indicator_Operations.IndicatorPointsAtLevel(ValueIndicator + 1);
            ValueIndicator++;
            Sheet.Indicators[RecupValueIndic(comboBoxIndic.Text)] = ValueIndicator;
            UpdateDisplay();
        }
        /// <summary>
        /// When the skill plus button is clicked, do the corresponding actions
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ButtonPlusSkill_Click(object sender, EventArgs e)
        {
            Sheet.experience -= Skill_Operations.SkillPointsAtLevel(ValueSkill + 1);
            ValueSkill++;
            Sheet.Skills[RecupValueSkill(comboBoxSkill.Text)] = ValueSkill;
            UpdateDisplay();
        }
        /// <summary>
        /// When the skill minus button is clicked, do the corresponding actions
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ButtonMinusSkill_Click(object sender, EventArgs e)
        {
            Sheet.experience += Skill_Operations.SkillPointsAtLevel(ValueSkill);
            ValueSkill--;
            Sheet.Skills[RecupValueSkill(comboBoxSkill.Text)] = ValueSkill;
            UpdateDisplay();
        }
        /// <summary>
        /// When the indicator minus button is clicked, do the corresponding actions
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ButtonMinusIndic_Click(object sender, EventArgs e)
        {
            Sheet.experience += Indicator_Operations.IndicatorPointsAtLevel(ValueIndicator);
            ValueIndicator--;
            Sheet.Indicators[RecupValueIndic(comboBoxIndic.Text)] = ValueIndicator;
            UpdateDisplay();
        }
    }
}
