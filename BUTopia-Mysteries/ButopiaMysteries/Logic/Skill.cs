using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Policy;
using System.Text;
using System.Threading.Tasks;

namespace ButopiaMysteries.Logic
{
    /// <summary>
    /// Enum for all skills.
    /// </summary>
    public enum Skill
    {
        None,
        Feat,
        Dodge,
        Design,
        Synthesis,
        Analysis,
        Expression,
        Survival,
        Seduction,
        /// Skill of the "Penseur"
        Concentration,
        Abstraction,
        Visualisation,
        Modélisation,

        //Skill of the "Légats"
        Perrenite,
        Perception,
        Details,
        Memorisation,


        //Skill of the "Faiseurs"
        Hability,
        Architecture,
        Organisation,
        Rectification,

        //Skill of the "Intégrateurs"
        Proprioception,
        Liaison,
        Synesthesis,
        Compilation,

        //Skill of the "Commerçants"
        Edurance,
        Finance,
        Expertise,
        Communication,

        //Skill of the "Algèbre"
        Jonction,
        Induction,
        Equation,
        Fonctionnal,

        //Skill of the "Verbe"
        Injonction,
        Formulation,
        Poetic,
        Object,

        //Skill of the "Transition"
        Disconstruction,
        Anticipation,
        Argumentation,
        Optimisation,

        //Skill of the "Création"
        Ajustement,
        Conception,
        Narration,
        Data,

        //Skill of the "Valorisation"
        Destruction,
        Intendance,
        Conviction,
        Test,
    }


    /// <summary>
    /// Companion class for the enum above.
    /// </summary>
    public static class Skill_Operations
    {
        /// <summary>
        /// The Name associated to the skill.
        /// </summary>
        /// <param name="skill">skill to examine</param>
        /// <returns>the name (in French)</returns>
        public static string Name(this Skill skill)
        {
            return skill switch
            {
                Skill.Feat => "Prouesse",
                Skill.Dodge => "Esquive",
                Skill.Design => "Conception",
                Skill.Synthesis => "Synthèse",
                Skill.Analysis => "Analyse",
                Skill.Expression => "Expression",
                Skill.Survival => "Survie",
                Skill.Seduction => "Séduction",
                Skill.Concentration => "Concentration",
                Skill.Abstraction => "Abstraction",
                Skill.Visualisation => "Visualisation",
                Skill.Modélisation => "Modélisation",
                Skill.Perrenite => "Perrénité",
                Skill.Perception => "Perception",
                Skill.Details => "Détail",
                Skill.Memorisation => "Mémorisation",
                Skill.Hability => "Habilité",
                Skill.Architecture => "Architecture",
                Skill.Organisation => "Organisation",
                Skill.Rectification => "Rectification",

                //Skill of the "Intégrateurs"
                Skill.Proprioception => "Proprioception",
                Skill.Liaison => "Liaison",
                Skill.Synesthesis => "Synesthésie",
                Skill.Compilation => "Compilation",

                //Skill of the "Commerçants"
                Skill.Edurance => "Endurance",
                Skill.Finance => "Finance",
                Skill.Expertise => "Expertise",
                Skill.Communication => "Communication",

                //Skill of the "Algèbre"
                Skill.Jonction => "Jonction",
                Skill.Induction => "Induction",
                Skill.Equation => "Equation",
                Skill.Fonctionnal => "Fonctionnel",

                //Skill of the "Verbe"
                Skill.Injonction => "Injonction",
                Skill.Formulation => "Formulation",
                Skill.Poetic => "Poétique",
                Skill.Object => "Objet",
                Skill.Disconstruction => "Disconstruction",
                Skill.Anticipation => "Anticipation",
                Skill.Argumentation => "Argumentation",
                Skill.Optimisation => "Optimisation",

                //Skill of the "Création"
                Skill.Ajustement => "Ajustement",
                Skill.Conception => "Conceptions",
                Skill.Narration => "Narration",
                Skill.Data => "Données",

                //Skill of the "Valorisation"
                Skill.Destruction => "Destruction",
                Skill.Intendance => "Intendance",
                Skill.Conviction => "Conviction",
                Skill.Test => "Test",
                _ => string.Empty
            };
        }

        /// <summary>
        /// The Name associated to the skill.
        /// </summary>
        /// <param name="skill">skill to examine</param>
        /// <returns>the name (in French)</returns>
        public static Skill Name_Invert(string skill)
        {
            return skill switch
            {
                "Prouesse" => Skill.Feat,
                "Esquive" => Skill.Dodge,
                "Conception" => Skill.Design,
                "Synthèse" => Skill.Synthesis,
                "Analyse" => Skill.Analysis,
                "Expression" => Skill.Expression,
                "Survie" => Skill.Survival,
                "Séduction" => Skill.Seduction,
                "Concentration" => Skill.Concentration,
                "Abstraction" => Skill.Abstraction,
                "Visualisation" => Skill.Visualisation,
                "Modélisation" => Skill.Modélisation,
                "Perrénité" => Skill.Perrenite,
                "Perception" => Skill.Perception,
                "Détail" => Skill.Details,
                "Mémorisation" => Skill.Memorisation,
                "Habilité" => Skill.Hability,
                "Architecture" => Skill.Architecture,
                "Organisation" => Skill.Organisation,
                "Rectificiation" => Skill.Rectification,
                "Proprioception" => Skill.Proprioception,
                "Liaison" => Skill.Liaison,
                "Synesthésie" => Skill.Synesthesis,
                "Compilation" => Skill.Compilation,
                "Endurance" => Skill.Edurance,
                "Finance" => Skill.Finance,
                "Expertise" => Skill.Expertise,
                "Communication" => Skill.Communication,
                "Jonction" => Skill.Jonction,
                "Induction" => Skill.Induction,
                "Equation" => Skill.Equation,
                "Fonctionnel" => Skill.Fonctionnal,
                "Injonction" => Skill.Injonction,
                "Formulation" => Skill.Formulation,
                "Poétique" => Skill.Poetic,
                "Objet" => Skill.Object,
                "Disconstruction" => Skill.Disconstruction,
                "Anticipation" => Skill.Anticipation,
                "Argumentation" => Skill.Argumentation,
                "Optimisation" => Skill.Optimisation,
                "Ajustement" => Skill.Ajustement,
                "Conceptions" => Skill.Conception,
                "Narration" => Skill.Narration,
                "Données" => Skill.Data,
                "Destruction" => Skill.Destruction,
                "Intendance" => Skill.Intendance,
                "Conviction" => Skill.Conviction,
                "Test" => Skill.Test,
                _ => Skill.None,
            };
        }

        /// <summary>
        /// Match a description with the level of the skill
        /// </summary>
        /// <param name="niveau">the level of the skill</param>
        /// <returns> the matching description</returns>
        public static string DescriptionSkill(int niveau)
        {
            return niveau switch
            {
                0 => "Incompétent",
                1 => "Amateur",
                2 => "Apprenti",
                3 => "Compagnon",
                4 => "Maître",
                5 => "Agrégé",
                6 => "Ministre",
                _ => string.Empty
            };
        }

        /// <summary>
        /// The Indicator associated to the skill.
        /// </summary>
        /// <param name="skill">skill to examine</param>
        /// <returns>the indicator (or null)</returns>

        public static Indicator GetIndicator(this Skill skill)
        {
            return skill switch
            {
                Skill.Feat => Indicator.Body,
                Skill.Dodge => Indicator.Body,
                Skill.Design => Indicator.Mind,
                Skill.Synthesis => Indicator.Mind,
                Skill.Analysis => Indicator.Sense,
                Skill.Expression => Indicator.Sense,
                Skill.Survival => Indicator.Maximum,
                Skill.Seduction => Indicator.Maximum,
                //Skill of the "Penseur"
                Skill.Concentration => Indicator.Mind,
                Skill.Abstraction => Indicator.Mind,
                Skill.Visualisation => Indicator.Mind,
                Skill.Modélisation => Indicator.Mind,

                Skill.Perrenite => Indicator.Sense,
                Skill.Perception => Indicator.Sense,
                Skill.Details => Indicator.Sense,
                Skill.Memorisation => Indicator.Sense,
                Skill.Hability => Indicator.Body,
                Skill.Architecture => Indicator.Body,
                Skill.Organisation => Indicator.Body,
                Skill.Rectification => Indicator.Body,

                //Skill of the "Intégrateurs"
                Skill.Proprioception => Indicator.Maximum,
                Skill.Liaison => Indicator.Maximum,
                Skill.Synesthesis => Indicator.Maximum,
                Skill.Compilation => Indicator.Maximum,

                //Skill of the "Commerçants"
                Skill.Edurance => Indicator.Sense,
                Skill.Finance => Indicator.Sense,
                Skill.Expertise => Indicator.Sense,
                Skill.Communication => Indicator.Sense,

                //Skill of the "Algèbre"
                Skill.Jonction => Indicator.Mind,
                Skill.Induction => Indicator.Mind,
                Skill.Equation => Indicator.Mind,
                Skill.Fonctionnal => Indicator.Mind,

                //Skill of the "Verbe"
                Skill.Injonction => Indicator.Sense,
                Skill.Formulation => Indicator.Sense,
                Skill.Poetic => Indicator.Sense,
                Skill.Object => Indicator.Sense,
                Skill.Disconstruction => Indicator.Maximum,
                Skill.Anticipation => Indicator.Maximum,
                Skill.Argumentation => Indicator.Maximum,
                Skill.Optimisation => Indicator.Maximum,

                //Skill of the "Création"
                Skill.Ajustement => Indicator.Body,
                Skill.Conception => Indicator.Body,
                Skill.Narration => Indicator.Body,
                Skill.Data => Indicator.Body,

                //Skill of the "Valorisation"
                Skill.Destruction => Indicator.Maximum,
                Skill.Intendance => Indicator.Maximum,
                Skill.Conviction => Indicator.Maximum,
                Skill.Test => Indicator.Maximum,
                _ => Indicator.None,
            };
        }
        /// <summary>
        /// Gives all skills satisfying a specified condition.
        /// </summary>
        /// <param name="predicate">the predicate to check</param>
        /// <returns>the constructed list</returns>
        public static List<Skill> AllSkillsSuchAs(Predicate<Skill> predicate)
        {
            List<Skill> allSkills = [Skill.Feat, Skill.Dodge, Skill.Design, Skill.Synthesis,
                Skill.Analysis, Skill.Expression, Skill.Survival, Skill.Seduction];
            return allSkills.FindAll(predicate);
        }
        /// <summary>
        /// The absolute lower bound for skills.
        /// </summary>
        public static int MinValue { get; } = 0;
        /// <summary>
        /// The absolute upper bound for skills.
        /// </summary>
        public static int MaxValue { get; } = 6;
        /// <summary>
        /// The maximum value at creation for a skill.
        /// </summary>
        public static int CreationThreshold { get; } = 4;
        /// <summary>
        /// The basic value for fixed creation.
        /// </summary>
        public static int BasicValue { get; } = 2;
        /// <summary>
        /// A formula yielding the skill points necessary for a skill level.
        /// </summary>
        /// <param name="level">the target level</param>
        /// <returns>the corresponding skill points</returns>
        public static int SkillPointsAtLevel(int level) => level;
    }
}
