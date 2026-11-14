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
    /// A class to view/edit a Mystery Sheet
    /// </summary>
    public partial class SheetView : Form
    {
        private MysterySheet Sheet { get; init; }
        private readonly Dictionary<Indicator, Label> indicatorLabels = [];
        private readonly Dictionary<Skill, Label> skillLabels = [];
        private bool edit = false;
        private int indicatorPoints = 0;
        private int skillPoints = 0;
        /// <summary>
        /// Constructor.
        /// </summary>
        /// <param name="mysterySheet">the sheet to display/edit</param>
        public SheetView(MysterySheet mysterySheet)
        {
            InitializeComponent();
            Sheet = mysterySheet;
            nameLabel.Text = Sheet.Name;
            indicatorLabels.Add(Indicator.Body, indicLabel1);
            indicatorLabels.Add(Indicator.Mind, indicLabel2);
            indicatorLabels.Add(Indicator.Sense, indicLabel3);
            indicatorLabels.Add(Indicator.Maximum, indicLabel4);
            skillLabels.Add(Skill.Feat, skillLabel1);
            skillLabel2.Text = Skill_Operations.DescriptionSkill(Sheet.Skills[Skill.Feat]);
            skillLabels.Add(Skill.Design, skillLabel3);
            skillLabel4.Text = Skill_Operations.DescriptionSkill(Sheet.Skills[Skill.Design]);
            skillLabels.Add(Skill.Analysis, skillLabel5);
            skillLabel6.Text = Skill_Operations.DescriptionSkill(Sheet.Skills[Skill.Analysis]);
            skillLabels.Add(Skill.Survival, skillLabel7);
            skillLabel8.Text = Skill_Operations.DescriptionSkill(Sheet.Skills[Skill.Survival]);
            skillLabels.Add(Skill.Dodge, skillLabel9);
            skillLabel10.Text = Skill_Operations.DescriptionSkill(Sheet.Skills[Skill.Dodge]);
            skillLabels.Add(Skill.Synthesis, skillLabel11);
            skillLabel12.Text = Skill_Operations.DescriptionSkill(Sheet.Skills[Skill.Synthesis]);
            skillLabels.Add(Skill.Expression, skillLabel13);
            skillLabel14.Text = Skill_Operations.DescriptionSkill(Sheet.Skills[Skill.Expression]);
            skillLabels.Add(Skill.Seduction, skillLabel15);
            skillLabel16.Text = Skill_Operations.DescriptionSkill(Sheet.Skills[Skill.Seduction]);
            DisplayControls();

        }
        /// <summary>
        /// Displays the controls on the tool strip
        /// </summary>
        private void DisplayControls()
        {
            if (edit)
            {
                modeToolStripButton.Text = "Edit Mode";
                indicatorPointsToolStripLabel.Visible = true;
                indicatorPointsToolStripLabel.Text = "PI: " + indicatorPoints;
                skillPointsToolStripLabel.Visible = true;
                skillPointsToolStripLabel.Text = "PC: " + skillPoints;
            }
            else
            {
                theToolStrip.Visible = true;
                modeToolStripButton.Text = "View Mode";
                indicatorPointsToolStripLabel.Visible = false;
                skillPointsToolStripLabel.Visible = false;
            }
            foreach (Skill skill in skillLabels.Keys)
            {
                skillLabels[skill].Text = DisplaySkill(skill);
            }
            foreach (Indicator indicator in indicatorLabels.Keys)
            {
                indicatorLabels[indicator].Text = DisplayIndicator(indicator);
            }
            buttonEndCreation.Visible = Sheet.creation;
            labelXp.Text = "Points d'expérience : " + Sheet.experience;
        }
        /// <summary>
        /// Returns a string to display the name of a given skill and the associated points in the sheet
        /// </summary>
        /// <param name="skill">the skill to display</param>
        /// <returns>the displayable string with the infos</returns>
        private string DisplaySkill(Skill skill)
        {
            return skill.Name() + " : " + Sheet.Skills[skill];
        }
        /// <summary>
        /// Returns a string to display the name of a given indicator and the associated points in the sheet
        /// </summary>
        /// <param name="indicator">the indicator to display</param>
        /// <returns>the displayable string with the infos</returns>
        private string DisplayIndicator(Indicator indicator)
        {
            return indicator.Name() + " : " + Sheet.Indicators[indicator];
        }
        /// <summary>
        /// Quits the form if CloseButton is clicked
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void CloseButton_Click(object sender, EventArgs e)
        {
            Dispose();
        }
        /// <summary>
        /// When the edit button is clicked, swaps in and out of the edit mode, and updates display of controls
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ModeToolStripButton_Click(object sender, EventArgs e)
        {
            edit = !edit;
            DisplayControls();
        }

        /// <summary>
        /// When a label is clicked, if in edition mode, opens the corresponding dialog to edit the skill or indicator
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void Label_MouseClick(object sender, MouseEventArgs e)
        {
            if (!edit)
            {
                return;
            }
            if (sender is Label label)
            {
                Indicator indicator = indicatorLabels.Keys.FirstOrDefault(i => indicatorLabels[i].Equals(label), Indicator.None);
                if (indicator != Indicator.None && indicator != Indicator.Maximum)
                {
                    IndicatorEdit(indicator);
                }
                else
                {
                    Skill skill = skillLabels.Keys.FirstOrDefault(s => skillLabels[s].Equals(label), Skill.None);
                    if (skill != Skill.None)
                    {
                        SkillEdit(skill);
                    }
                }
            }
        }
        /// <summary>
        /// Opens the edit dialog of the given skill and updates modifications
        /// </summary>
        /// <param name="skill">the skill</param>
        private void SkillEdit(Skill skill)
        {
            SimpleEditDialog dialog = new(skill, Sheet.Skills[skill], skillPoints);
            if (dialog.ShowDialog() == DialogResult.OK)
            {
                skillPoints = dialog.Points;
                Sheet.Skills[skill] = dialog.Value;
                DisplayControls();
            }
        }
        /// <summary>
        /// Opens the edit dialog of the given indicator and updates modifications
        /// </summary>
        /// <param name="skill">the indicator</param>
        private void IndicatorEdit(Indicator indicator)
        {
            SimpleEditDialog dialog = new(indicator, Sheet.Indicators[indicator], indicatorPoints);
            if (dialog.ShowDialog() == DialogResult.OK)
            {
                indicatorPoints = dialog.Points;
                Sheet.Indicators[indicator] = dialog.Value;
                IndicatorMaxUpdate();
                DisplayControls();
            }
        }
        /// <summary>
        /// Sets the Maximum Indicator to the maximum value of every other
        /// </summary>
        private void IndicatorMaxUpdate()
        {
            Sheet.Indicators[Indicator.Maximum] = Sheet.Indicators[Indicator.Body];
            if (Sheet.Indicators[Indicator.Sense] > Sheet.Indicators[Indicator.Maximum])
            {
                Sheet.Indicators[Indicator.Maximum] = Sheet.Indicators[Indicator.Sense];
            }
            if (Sheet.Indicators[Indicator.Mind] > Sheet.Indicators[Indicator.Maximum])
            {
                Sheet.Indicators[Indicator.Maximum] = Sheet.Indicators[Indicator.Mind];
            }
        }

        private void SheetView_Load(object sender, EventArgs e)
        {

        }

        /// <summary>
        /// Goes from the creation state to the formation state when buttonEndCreation is clicked
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ButtonEndCreation_Click(object sender, EventArgs e)
        {
            buttonEndCreation.Visible = false;
            Sheet.creation = false;
            Plan plan = new(Sheet);
            plan.ShowDialog();
        }
    }
}
