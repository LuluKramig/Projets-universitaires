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
    public enum SphereEnum
    {
        Algebra,
        Verb,
        Transition,
        Creation,
        Valorisation,
    }
    /// <summary>
    /// Companion class for the enum above.
    /// </summary>
    public partial class Sphere : Form
    {
        /// <summary>
        /// the sheet being formed
        /// </summary>
        private MysterySheet Sheet {  get; init; }
        /// <summary>
        /// Constructor
        /// </summary>
        /// <param name="sheet"></param>
        public Sphere(MysterySheet sheet)
        {
            InitializeComponent();
            Sheet = sheet;
        }
        /// <summary>
        /// The (french) name of the sphere as string
        /// </summary>
        /// <param name="chosenSphere">the sphere</param>
        /// <returns>the name of the sphere</returns>
        public string NameSphere(SphereEnum chosenSphere)
        {
            return chosenSphere switch
            {
                SphereEnum.Algebra => "Algèbre",
                SphereEnum.Verb => "Verbe",
                SphereEnum.Transition => "Transition",
                SphereEnum.Valorisation => "Valorisation",
                SphereEnum.Creation => "Création",
                _ => string.Empty,
            };
        }
        /// <summary>
        /// returns the list of the skills associated to the sphere
        /// </summary>
        /// <param name="chosenSphere">the sphere</param>
        /// <returns>the list of the skills associated to the sphere</returns>
        public List<Skill> SkillAssociate(SphereEnum chosenSphere)
        {
            return chosenSphere switch
            {
                SphereEnum.Algebra => new List<Skill> { Skill.Jonction, Skill.Induction, Skill.Equation, Skill.Fonctionnal },
                SphereEnum.Verb => new List<Skill> { Skill.Injonction, Skill.Formulation, Skill.Poetic, Skill.Object },
                SphereEnum.Transition => new List<Skill> { Skill.Disconstruction, Skill.Anticipation, Skill.Argumentation, Skill.Optimisation },
                SphereEnum.Creation => new List<Skill> { Skill.Ajustement, Skill.Conception, Skill.Narration, Skill.Data },
                SphereEnum.Valorisation => new List<Skill> { Skill.Destruction, Skill.Intendance, Skill.Conviction, Skill.Data },
                _ => new List<Skill> { Skill.None },
            };
        }
        /// <summary>
        /// Returns the indicator associated to the sphere
        /// </summary>
        /// <param name="chosenSphere">the sphere</param>
        /// <returns>the indicator associated to the sphere</returns>
        public static Indicator IndicatorAssociate(SphereEnum chosenSphere)
        {
            return chosenSphere switch
            {
                SphereEnum.Algebra => Indicator.Mind,
                SphereEnum.Verb => Indicator.Sense,
                SphereEnum.Transition => Indicator.Maximum,
                SphereEnum.Creation => Indicator.Body,
                SphereEnum.Valorisation => Indicator.Maximum,
                _ => Indicator.None,
            };
        }
        /// <summary>
        /// Chooses a sphere when a button is clicked
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ButtonClick(object sender, EventArgs e)
        {   
            Button button = sender as Button;
            SphereEnum chosenSphere;
            if (button.Equals(buttonAlgebra))
            {
                chosenSphere = SphereEnum.Algebra;
            }
            else if (button.Equals(buttonVerb))
            {
                chosenSphere = SphereEnum.Verb;
            }
            else if (button.Equals(buttonTransition))
            {
                chosenSphere = SphereEnum.Transition;
            }
            else if (button.Equals(buttonCreatif))
            {
                chosenSphere = SphereEnum.Creation;
            }
            else {
                chosenSphere = SphereEnum.Valorisation;
            }
            foreach (Skill skill in SkillAssociate(chosenSphere))
            {
                Sheet.Skills.Add(skill, Sheet.GenRandNum(0, 4));
            }
            Dispose();
        }
    }
}
