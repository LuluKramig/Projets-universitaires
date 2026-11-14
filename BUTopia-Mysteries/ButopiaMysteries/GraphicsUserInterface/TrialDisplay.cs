using ButopiaMysteries.Logic;

namespace ButopiaMysteries.GraphicsUserInterface
{
    public partial class TrialDisplay : Form
    {

        private readonly MysterySheet sheet;
        private readonly bool open;
        private readonly Skill skill;
        private readonly Indicator indicator;
        private Difficulty difficulty;
        /// <summary>
        /// the constructor
        /// </summary>
        /// <param name="aSheet">the sheet of the character</param>
        /// <param name="aSkill">the skill chosen</param>
        /// <param name="aDiff">the difficulty chosen or null</param>
        public TrialDisplay(MysterySheet aSheet, Skill aSkill, Difficulty? aDiff)
        {
            InitializeComponent();
            sheet = aSheet;
            labelName.Text = aSheet.Name;
            skill = aSkill;
            labelSkill.Text = Skill_Operations.Name(skill) + " : " + sheet.Skills[skill];
            indicator = Skill_Operations.GetIndicator(skill);
            labelIndic.Text = Indicator_Operations.Name(indicator) + " : " + sheet.Indicators[indicator];
            open = aDiff == null;
            labelLevel.Text = "Difficulté : ";
            if (!open)
            {
                labelDifficulty.Text = aDiff.ToString();
                difficulty = aDiff.Value;
            }
            else
            {
                labelDifficulty.Text = "épreuve ouverte";
            }
            labelResult.Visible = false;
        }
        /// <summary>
        /// When the start button is clicked, launches every trial with the right parameters and displays
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ButtonStart_Click(object sender, EventArgs e)
        {
            labelResult.Visible = true;
            string results = "";
            for (int i = 0; i < numericUpDownTrial.Value; i++)
            {
                if (open)
                {
                    results += "Vous avez atteint une difficulté : " + Trial.EpreuveOuverte(sheet.Indicators[indicator], skill, sheet).ToString() + "\n\n";
                }
                else
                {
                    string res = (Trial.EpreuveFermee(difficulty, sheet.Indicators[indicator], skill, sheet)) ? "Atteinte" : "Non atteinte";
                    results += "Difficulté " + difficulty.ToString() + " : " + res + "\n\n";
                    sheet.experience += (res == "Atteinte") ? 1 : 0;
                }
            }
            MessageBox.Show(results);
        }
        /// <summary>
        /// Closes the trial when the close button is clicked
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ButtonClose_Click(object sender, EventArgs e)
        {
            Dispose();
        }
    }
}
