using ButopiaMysteries.Logic;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ButopiaMysteries.GraphicsUserInterface
{
    public enum PlanEnum
    {
        Penseur,
        Légat,
        Faiseur,
        Intégrateur,
        Commerçants,
    }
    /// <summary>
    /// Companion class for the enum above.
    /// </summary>
    public partial class Plan : Form
    {
        /// <summary>
        /// the sheet being formed
        /// </summary>
        private MysterySheet Sheet {  get; init; }
        /// <summary>
        /// Constructor
        /// </summary>
        /// <param name="sheet"></param>
        public Plan(MysterySheet sheet)
        {
            InitializeComponent();
            Sheet = sheet;
        }
        /// <summary>
        /// The (french) name of the plan as string
        /// </summary>
        /// <param name="planChosen">the plan</param>
        /// <returns>the name of the plan</returns>
        public static string NamePlan(PlanEnum planChosen)
        {
            return planChosen switch
            {
                PlanEnum.Penseur => "Prouesse",
                PlanEnum.Légat => "Légat",
                PlanEnum.Faiseur => "Faiseur",
                PlanEnum.Intégrateur => "Intégrateur",
                PlanEnum.Commerçants => "Commerçants",

                _ => string.Empty
            };
        }
        /// <summary>
        /// returns the list of the skills associated to the plan
        /// </summary>
        /// <param name="planChosen">the plan</param>
        /// <returns>the list of the skills associated to the plan</returns>
        public static List<Skill> SkillAssociate(PlanEnum planChosen)
        {
            return planChosen switch
            {
                PlanEnum.Penseur => new List<Skill> { Skill.Visualisation, Skill.Modélisation, Skill.Concentration, Skill.Abstraction },
                PlanEnum.Légat => new List<Skill> { Skill.Perrenite, Skill.Details, Skill.Perception, Skill.Memorisation },
                PlanEnum.Faiseur => new List<Skill> { Skill.Hability, Skill.Architecture, Skill.Organisation, Skill.Rectification },
                PlanEnum.Commerçants => new List<Skill> { Skill.Edurance, Skill.Finance, Skill.Expertise, Skill.Communication },
                PlanEnum.Intégrateur=> new List<Skill> { Skill.Proprioception, Skill.Liaison,Skill.Synesthesis,Skill.Compilation},
                _ => new List<Skill> { Skill.None },
            };
        }
        /// <summary>
        /// Returns the indicator associated to the plan
        /// </summary>
        /// <param name="planChosen">the plan</param>
        /// <returns>the indicator associated to the plan</returns>
        public static Indicator IndicatorAssociate(PlanEnum planChosen)
        {
            return planChosen switch
            {
                PlanEnum.Penseur => Indicator.Mind,
                PlanEnum.Légat => Indicator.Sense,
                PlanEnum.Faiseur => Indicator.Body,
                PlanEnum.Commerçants => Indicator.Sense,
                PlanEnum.Intégrateur => Indicator.Maximum,
                _ => Indicator.None,
            };
        }
        /// <summary>
        /// Chooses a plan when a button is clicked
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ButtonClick(object sender, EventArgs e)
        {
            {
                Button button = sender as Button;
                PlanEnum chosenSphere;
                if (button.Equals(buttonCommerçant))
                {
                    chosenSphere = PlanEnum.Commerçants;
                }
                else if (button.Equals(buttonFaiseur))
                {
                    chosenSphere = PlanEnum.Faiseur;
                }
                else if (button.Equals(buttonIntegrateur))
                {
                    chosenSphere = PlanEnum.Intégrateur;
                }
                else if (button.Equals(buttonLegat))
                {
                    chosenSphere = PlanEnum.Légat;
                }
                else
                {
                    chosenSphere = PlanEnum.Penseur;
                }
                foreach (Skill skill in SkillAssociate(chosenSphere))
                {
                    Sheet.Skills.Add(skill, Sheet.GenRandNum(0, 4));
                }
                Sphere sphere = new Sphere(Sheet);
                sphere.ShowDialog();
                Dispose();
            }
        }

    }
}
