using ButopiaMysteries.Logic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ButopiaMysteries_Test
{
    internal class SkillTests
    {
        /// <summary>
        /// Tests the coherence of the name of the skills
        /// </summary>
        [Test]
        public void NameTest()
        {
            Skill skillPerrenite = Skill.Perrenite;
            Assert.That(Skill_Operations.Name(skillPerrenite), Is.EqualTo("Perrénité"));
            Skill skillProuesse = Skill.Feat;
            Assert.That(Skill_Operations.Name(skillProuesse), Is.EqualTo("Prouesse"));
            Skill skillEsquive = Skill.Dodge;
            Assert.That(Skill_Operations.Name(skillEsquive), Is.EqualTo("Esquive"));
            Skill skillConception = Skill.Design;
            Assert.That(Skill_Operations.Name(skillConception), Is.EqualTo("Conception"));
            Skill skillSynthese = Skill.Synthesis;
            Assert.That(Skill_Operations.Name(skillSynthese), Is.EqualTo("Synthèse"));
            Skill skillAnalyse = Skill.Analysis;
            Assert.That(Skill_Operations.Name(skillAnalyse), Is.EqualTo("Analyse"));
            Skill skillExpression = Skill.Expression;
            Assert.That(Skill_Operations.Name(skillExpression), Is.EqualTo("Expression"));
            Skill skillSurvival = Skill.Survival;
            Assert.That(Skill_Operations.Name(skillSurvival), Is.EqualTo("Survie"));
            Skill skillSeduction = Skill.Seduction;
            Assert.That(Skill_Operations.Name(skillSeduction), Is.EqualTo("Séduction"));
            Skill skillPerception = Skill.Perception;
            Assert.That(Skill_Operations.Name(skillPerception), Is.EqualTo("Perception"));
            Skill skillDetails = Skill.Details;
            Assert.That(Skill_Operations.Name(skillDetails), Is.EqualTo("Détail"));
            Skill skillMemorisation = Skill.Memorisation;
            Assert.That(Skill_Operations.Name(skillMemorisation), Is.EqualTo("Mémorisation"));
            Skill skillHabilite = Skill.Hability;
            Assert.That(Skill_Operations.Name(skillHabilite), Is.EqualTo("Habilité"));
            Skill skillArchitecture = Skill.Architecture;
            Assert.That(Skill_Operations.Name(skillArchitecture), Is.EqualTo("Architecture"));
            Skill skillOrganisation = Skill.Organisation;
            Assert.That(Skill_Operations.Name(skillOrganisation), Is.EqualTo("Organisation"));
            Skill skillRectification = Skill.Rectification;
            Assert.That(Skill_Operations.Name(skillRectification), Is.EqualTo("Rectification"));
            Skill skillProprioception = Skill.Proprioception;
            Assert.That(Skill_Operations.Name(skillProprioception), Is.EqualTo("Proprioception"));
            Skill skillLiaison = Skill.Liaison;
            Assert.That(Skill_Operations.Name(skillLiaison), Is.EqualTo("Liaison"));
            Skill skillSynesthesis = Skill.Synesthesis;
            Assert.That(Skill_Operations.Name(skillSynesthesis), Is.EqualTo("Synesthésie"));
            //Refactoring - possibilité de le faire en une seule ligne...
            Assert.That(Skill_Operations.Name(Skill.Compilation), Is.EqualTo("Compilation"));
            Assert.That(Skill_Operations.Name(Skill.Edurance), Is.EqualTo("Endurance"));
            Assert.That(Skill_Operations.Name(Skill.Finance), Is.EqualTo("Finance"));
            Assert.That(Skill_Operations.Name(Skill.Expertise), Is.EqualTo("Expertise"));
            Assert.That(Skill_Operations.Name(Skill.Communication), Is.EqualTo("Communication"));
            Assert.That(Skill_Operations.Name(Skill.Jonction), Is.EqualTo("Jonction"));
            Assert.That(Skill_Operations.Name(Skill.Induction), Is.EqualTo("Induction"));
            Assert.That(Skill_Operations.Name(Skill.Equation), Is.EqualTo("Equation"));
            Assert.That(Skill_Operations.Name(Skill.Fonctionnal), Is.EqualTo("Fonctionnel"));
            Assert.That(Skill_Operations.Name(Skill.Injonction), Is.EqualTo("Injonction"));
            Assert.That(Skill_Operations.Name(Skill.Formulation), Is.EqualTo("Formulation"));
            Assert.That(Skill_Operations.Name(Skill.Poetic), Is.EqualTo("Poétique"));
            Assert.That(Skill_Operations.Name(Skill.Object), Is.EqualTo("Objet"));
            Assert.That(Skill_Operations.Name(Skill.Disconstruction), Is.EqualTo("Disconstruction"));
            Assert.That(Skill_Operations.Name(Skill.Anticipation), Is.EqualTo("Anticipation"));
            Assert.That(Skill_Operations.Name(Skill.Argumentation), Is.EqualTo("Argumentation"));
            Assert.That(Skill_Operations.Name(Skill.Optimisation), Is.EqualTo("Optimisation"));
            Assert.That(Skill_Operations.Name(Skill.Ajustement), Is.EqualTo("Ajustement"));
            Assert.That(Skill_Operations.Name(Skill.Conception), Is.EqualTo("Conceptions"));
            Assert.That(Skill_Operations.Name(Skill.Narration), Is.EqualTo("Narration"));
            Assert.That(Skill_Operations.Name(Skill.Data), Is.EqualTo("Données"));
            Assert.That(Skill_Operations.Name(Skill.Destruction), Is.EqualTo("Destruction"));
            Assert.That(Skill_Operations.Name(Skill.Intendance), Is.EqualTo("Intendance"));
            Assert.That(Skill_Operations.Name(Skill.Conviction), Is.EqualTo("Conviction"));
            Assert.That(Skill_Operations.Name(Skill.Test), Is.EqualTo("Test"));

        }
        /// <summary>
        /// Tests the coherence of the skills from a skill name
        /// </summary>
        [Test]
        public void NameInvertTest()
        {
            Assert.That(Skill_Operations.Name_Invert("Prouesse"), Is.EqualTo(Skill.Feat));
            Assert.That(Skill_Operations.Name_Invert("Esquive"), Is.EqualTo(Skill.Dodge));
            Assert.That(Skill_Operations.Name_Invert("Conception"), Is.EqualTo(Skill.Design));
            Assert.That(Skill_Operations.Name_Invert("Synthèse"), Is.EqualTo(Skill.Synthesis));
            Assert.That(Skill_Operations.Name_Invert("Analyse"), Is.EqualTo(Skill.Analysis));
            Assert.That(Skill_Operations.Name_Invert("Expression"), Is.EqualTo(Skill.Expression));
            Assert.That(Skill_Operations.Name_Invert("Survie"), Is.EqualTo(Skill.Survival));
            Assert.That(Skill_Operations.Name_Invert("Séduction"), Is.EqualTo(Skill.Seduction));
            Assert.That(Skill_Operations.Name_Invert("Perrénité"), Is.EqualTo(Skill.Perrenite));
            Assert.That(Skill_Operations.Name_Invert("Perception"), Is.EqualTo(Skill.Perception));
            Assert.That(Skill_Operations.Name_Invert("Détail"), Is.EqualTo(Skill.Details));
            Assert.That(Skill_Operations.Name_Invert("Mémorisation"), Is.EqualTo(Skill.Memorisation));
            Assert.That(Skill_Operations.Name_Invert("Habilité"), Is.EqualTo(Skill.Hability));
            Assert.That(Skill_Operations.Name_Invert("Architecture"), Is.EqualTo(Skill.Architecture));
            Assert.That(Skill_Operations.Name_Invert("Organisation"), Is.EqualTo(Skill.Organisation));
            Assert.That(Skill_Operations.Name_Invert("Rectificiation"), Is.EqualTo(Skill.Rectification));
            Assert.That(Skill_Operations.Name_Invert("Proprioception"), Is.EqualTo(Skill.Proprioception));
            Assert.That(Skill_Operations.Name_Invert("Liaison"), Is.EqualTo(Skill.Liaison));
            Assert.That(Skill_Operations.Name_Invert("Synesthésie"), Is.EqualTo(Skill.Synesthesis));
            Assert.That(Skill_Operations.Name_Invert("Compilation"), Is.EqualTo(Skill.Compilation));
            Assert.That(Skill_Operations.Name_Invert("Endurance"), Is.EqualTo(Skill.Edurance));
            Assert.That(Skill_Operations.Name_Invert("Finance"), Is.EqualTo(Skill.Finance));
            Assert.That(Skill_Operations.Name_Invert("Expertise"), Is.EqualTo(Skill.Expertise));
            Assert.That(Skill_Operations.Name_Invert("Communication"), Is.EqualTo(Skill.Communication));
            Assert.That(Skill_Operations.Name_Invert("Jonction"), Is.EqualTo(Skill.Jonction));
            Assert.That(Skill_Operations.Name_Invert("Prouesse"), Is.EqualTo(Skill.Feat));
            Assert.That(Skill_Operations.Name_Invert("Induction"), Is.EqualTo(Skill.Induction));
            Assert.That(Skill_Operations.Name_Invert("Equation"), Is.EqualTo(Skill.Equation));
            Assert.That(Skill_Operations.Name_Invert("Fonctionnel"), Is.EqualTo(Skill.Fonctionnal));
            Assert.That(Skill_Operations.Name_Invert("Injonction"), Is.EqualTo(Skill.Injonction));
            Assert.That(Skill_Operations.Name_Invert("Formulation"), Is.EqualTo(Skill.Formulation));
            Assert.That(Skill_Operations.Name_Invert("Poétique"), Is.EqualTo(Skill.Poetic));
            Assert.That(Skill_Operations.Name_Invert("Objet"), Is.EqualTo(Skill.Object));
            Assert.That(Skill_Operations.Name_Invert("Disconstruction"), Is.EqualTo(Skill.Disconstruction));
            Assert.That(Skill_Operations.Name_Invert("Anticipation"), Is.EqualTo(Skill.Anticipation));
            Assert.That(Skill_Operations.Name_Invert("Conceptions"), Is.EqualTo(Skill.Conception));
            Assert.That(Skill_Operations.Name_Invert("Narration"), Is.EqualTo(Skill.Narration));
            Assert.That(Skill_Operations.Name_Invert("Données"), Is.EqualTo(Skill.Data));
            Assert.That(Skill_Operations.Name_Invert("Destruction"), Is.EqualTo(Skill.Destruction));
            Assert.That(Skill_Operations.Name_Invert("Intendance"), Is.EqualTo(Skill.Intendance));
            Assert.That(Skill_Operations.Name_Invert("Conviction"), Is.EqualTo(Skill.Conviction));
            Assert.That(Skill_Operations.Name_Invert("Test"), Is.EqualTo(Skill.Test));
            Assert.That(Skill_Operations.Name_Invert("null"), Is.EqualTo(Skill.None));
        }
        /// <summary>
        /// Tests the coherence of the description of a skill
        /// </summary>
        [Test]
        public void DescriptionSkillTest()
        {
            Assert.That(Skill_Operations.DescriptionSkill(0), Is.EqualTo("Incompétent"));
            Assert.That(Skill_Operations.DescriptionSkill(1), Is.EqualTo("Amateur"));
            Assert.That(Skill_Operations.DescriptionSkill(2), Is.EqualTo("Apprenti"));
            Assert.That(Skill_Operations.DescriptionSkill(3), Is.EqualTo("Compagnon"));
            Assert.That(Skill_Operations.DescriptionSkill(4), Is.EqualTo("Maître"));
            Assert.That(Skill_Operations.DescriptionSkill(5), Is.EqualTo("Agrégé"));
            Assert.That(Skill_Operations.DescriptionSkill(6), Is.EqualTo("Ministre"));
        }
        /// <summary>
        /// Tests the skill assications with indicators
        /// </summary>
        [Test]
        public void GetIndicatorTest()
        {
            Assert.That(Skill_Operations.GetIndicator(Skill.Feat), Is.EqualTo(Indicator.Body));
            Assert.That(Skill_Operations.GetIndicator(Skill.Dodge), Is.EqualTo(Indicator.Body));
            Assert.That(Skill_Operations.GetIndicator(Skill.Design), Is.EqualTo(Indicator.Mind));
            Assert.That(Skill_Operations.GetIndicator(Skill.Synesthesis), Is.EqualTo(Indicator.Mind));
            Assert.That(Skill_Operations.GetIndicator(Skill.Analysis), Is.EqualTo(Indicator.Sense));
            Assert.That(Skill_Operations.GetIndicator(Skill.Expression), Is.EqualTo(Indicator.Sense));
            Assert.That(Skill_Operations.GetIndicator(Skill.Survival), Is.EqualTo(Indicator.Maximum));
            Assert.That(Skill_Operations.GetIndicator(Skill.Seduction), Is.EqualTo(Indicator.Maximum));
            //Indicator for the Penseur
            Assert.That(Skill_Operations.GetIndicator(Skill.Concentration), Is.EqualTo(Indicator.Mind));
            Assert.That(Skill_Operations.GetIndicator(Skill.Abstraction), Is.EqualTo(Indicator.Mind));
            Assert.That(Skill_Operations.GetIndicator(Skill.Visualisation), Is.EqualTo(Indicator.Mind));
            Assert.That(Skill_Operations.GetIndicator(Skill.Modélisation), Is.EqualTo(Indicator.Mind));
            //Indicator for the Légat
            Assert.That(Skill_Operations.GetIndicator(Skill.Perrenite), Is.EqualTo(Indicator.Sense));
            Assert.That(Skill_Operations.GetIndicator(Skill.Perception), Is.EqualTo(Indicator.Sense));
            Assert.That(Skill_Operations.GetIndicator(Skill.Details), Is.EqualTo(Indicator.Sense));
            Assert.That(Skill_Operations.GetIndicator(Skill.Memorisation), Is.EqualTo(Indicator.Sense));
            //Indicator for the 
            Assert.That(Skill_Operations.GetIndicator(Skill.Hability), Is.EqualTo(Indicator.Body));
            Assert.That(Skill_Operations.GetIndicator(Skill.Architecture), Is.EqualTo(Indicator.Body));
            Assert.That(Skill_Operations.GetIndicator(Skill.Organisation), Is.EqualTo(Indicator.Body));
            Assert.That(Skill_Operations.GetIndicator(Skill.Rectification), Is.EqualTo(Indicator.Body));
            //Skill for the Intégrateurs
            Assert.That(Skill_Operations.GetIndicator(Skill.Proprioception), Is.EqualTo(Indicator.Maximum));
            Assert.That(Skill_Operations.GetIndicator(Skill.Liaison), Is.EqualTo(Indicator.Maximum));
            Assert.That(Skill_Operations.GetIndicator(Skill.Synesthesis), Is.EqualTo(Indicator.Maximum));
            Assert.That(Skill_Operations.GetIndicator(Skill.Compilation), Is.EqualTo(Indicator.Maximum));
            //Skill for the Commerçants
            Assert.That(Skill_Operations.GetIndicator(Skill.Edurance), Is.EqualTo(Indicator.Sense));
            Assert.That(Skill_Operations.GetIndicator(Skill.Finance), Is.EqualTo(Indicator.Sense));
            Assert.That(Skill_Operations.GetIndicator(Skill.Expertise), Is.EqualTo(Indicator.Sense));
            Assert.That(Skill_Operations.GetIndicator(Skill.Communication), Is.EqualTo(Indicator.Sense));
            //Skill for the Algèbre
            Assert.That(Skill_Operations.GetIndicator(Skill.Jonction), Is.EqualTo(Indicator.Mind));
            Assert.That(Skill_Operations.GetIndicator(Skill.Induction), Is.EqualTo(Indicator.Mind));
            Assert.That(Skill_Operations.GetIndicator(Skill.Equation), Is.EqualTo(Indicator.Mind));
            Assert.That(Skill_Operations.GetIndicator(Skill.Fonctionnal), Is.EqualTo(Indicator.Mind));
            //Skill for the Verbe
            Assert.That(Skill_Operations.GetIndicator(Skill.Injonction), Is.EqualTo(Indicator.Sense));
            Assert.That(Skill_Operations.GetIndicator(Skill.Formulation), Is.EqualTo(Indicator.Sense));
            Assert.That(Skill_Operations.GetIndicator(Skill.Poetic), Is.EqualTo(Indicator.Sense));
            Assert.That(Skill_Operations.GetIndicator(Skill.Object), Is.EqualTo(Indicator.Sense));
            //Skill for the 
            Assert.That(Skill_Operations.GetIndicator(Skill.Disconstruction), Is.EqualTo(Indicator.Maximum));
            Assert.That(Skill_Operations.GetIndicator(Skill.Anticipation), Is.EqualTo(Indicator.Maximum));
            Assert.That(Skill_Operations.GetIndicator(Skill.Argumentation), Is.EqualTo(Indicator.Maximum));
            Assert.That(Skill_Operations.GetIndicator(Skill.Optimisation), Is.EqualTo(Indicator.Maximum));
            //Skill for the Creation
            Assert.That(Skill_Operations.GetIndicator(Skill.Ajustement), Is.EqualTo(Indicator.Body));
            Assert.That(Skill_Operations.GetIndicator(Skill.Conception), Is.EqualTo(Indicator.Body));
            Assert.That(Skill_Operations.GetIndicator(Skill.Narration), Is.EqualTo(Indicator.Body));
            Assert.That(Skill_Operations.GetIndicator(Skill.Data), Is.EqualTo(Indicator.Body));
            //Skill for the Valorisation
            Assert.That(Skill_Operations.GetIndicator(Skill.Destruction), Is.EqualTo(Indicator.Maximum));
            Assert.That(Skill_Operations.GetIndicator(Skill.Intendance), Is.EqualTo(Indicator.Maximum));
            Assert.That(Skill_Operations.GetIndicator(Skill.Conviction), Is.EqualTo(Indicator.Maximum));
            Assert.That(Skill_Operations.GetIndicator(Skill.Test), Is.EqualTo(Indicator.Maximum));
        }

    }
}

