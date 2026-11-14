using ButopiaMysteries.Logic;
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

namespace ButopiaMysteries.GraphicsUserInterface
{
    /// <summary>
    /// A simple edit dialog with limitations.
    /// </summary>
    public partial class SimpleEditDialog : Form
    {
        private string name = string.Empty;
        /// <summary>
        /// The value (start & end) = level.
        /// </summary>
        public int Value { get; private set; }
        /// <summary>
        /// The points available.
        /// </summary>
        public int Points { get; private set; }
        /// <summary>
        /// If we are editing an indicator
        /// </summary>
        private readonly bool indicator;
        /// <summary>
        /// Constructor: skill version
        /// </summary>
        /// <param name="skill">the skill</param>
        /// <param name="value">the value (start level)</param>
        /// <param name="points">the points (available before)</param>
        public SimpleEditDialog(Skill skill, int value, int points)
        {
            Construct(skill.Name(), value, points);
            this.indicator = false;
            ButtonUpdate(Points, this.indicator, Value);
        }
        /// <summary>
        /// Constructor: indicator version
        /// </summary>
        /// <param name="indicator">the indicator</param>
        /// <param name="value">the value (start level)</param>
        /// <param name="points">the points (available before)</param>
        public SimpleEditDialog(Indicator indicator, int value, int points)
        {
            Construct(indicator.Name(), value, points);
            this.indicator = true;
            ButtonUpdate(Points, this.indicator, Value);
        }
        /// <summary>
        /// Called by the constructors to construct the dialog when it does not depend on them
        /// </summary>
        /// <param name="name">name of the skill or indicator</param>
        /// <param name="value">value of the skill or indicator</param>
        /// <param name="points">amount of available points for skills or indicators</param>
        private void Construct(string name, int value, int points)
        {
            InitializeComponent();
            this.name = name;
            this.Value = value;
            this.Points = points;
            nameLabel.Text = name;
            CurrentValues();
        }
        /// <summary>
        /// Displays the current state of the value and the points
        /// </summary>
        private void CurrentValues()
        {
            currentValueLabel.Text = "Valeur actuelle : " + Value;
            pointsLabel.Text = "Points disponibles : " + Points;
        }
        /// <summary>
        /// When minus button is clicked, adds the points, decrease the value, updates buttons and displays
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void MinusClick(object sender, EventArgs e)
        {
            Points += indicator ? Indicator_Operations.IndicatorPointsAtLevel(Value) : Skill_Operations.SkillPointsAtLevel(Value);
            Value--;
            ButtonUpdate(Points, indicator, Value);
            CurrentValues();
        }
        /// <summary>
        /// When plus button is clicked, substracts the points, increase the value, updates buttons and displays
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void PlusClick(object sender, EventArgs e)
        {
            Points -= indicator ? Indicator_Operations.IndicatorPointsAtLevel(Value + 1) : Skill_Operations.SkillPointsAtLevel(Value + 1);
            Value++;
            ButtonUpdate(Points, indicator, Value);
            CurrentValues();
        }
        /// <summary>
        /// Updates the buttons' Enabled attribute to match the possible operations
        /// </summary>
        /// <param name="point">amount of available points for skills or indicators</param>
        /// <param name="indic">if we are editing an indicator</param>
        /// <param name="value">value of the skill or indicator</param>
        private void ButtonUpdate(int point, bool indic, int value)
        {
            if (indic)
            {
                plusButton.Enabled = point >= Indicator_Operations.IndicatorPointsAtLevel(Value + 1) && value < Indicator_Operations.MaxValue;
                minusButton.Enabled = value > Indicator_Operations.MinValue;
            }
            else
            {
                plusButton.Enabled = point >= Skill_Operations.SkillPointsAtLevel(Value + 1) && value < Skill_Operations.MaxValue;
                minusButton.Enabled = value > Skill_Operations.MinValue;
            }
        }

        private void SimpleEditDialog_Load(object sender, EventArgs e)
        {

        }
    }
}
