using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ButopiaMysteries.Logic
{
    /// <summary>
    /// A class stub for trials - dice rolls
    /// </summary>
    public static class Trial
    {
        /// <summary>
        /// For a given existing not empty list, and a skill value above 0, returns the sum of the elements of the list, else 0
        /// </summary>
        /// <param name="list">the list</param>
        /// <param name="skill">the skill value</param>
        /// <returns></returns>
        public static int NumericResult(List<int>? list, int skill=0)
        {
            if (skill == 0 || list == null || list.Count == 0)
            {
                return 0;
            }
            int result = 0;
            foreach (int item in list)
            {
                result += item;
            }
            return result;
        }
        /// <summary>
        /// Convert a difficulty into a score to beat
        /// </summary>
        /// <param name="difficulty"> the chosen difficulty</param>
        /// <returns>the score to beat.</returns>
        public static int Niveau(this Difficulty difficulty)
        {
            switch (difficulty)
            {
                case (Difficulty.Rien):
                    return 0;
                case (Difficulty.Trivial):
                    return 5;
                case (Difficulty.Facile):
                    return 10;
                case (Difficulty.Normal):
                    return 15;
                case (Difficulty.Complexe):
                    return 20;
                case (Difficulty.Délicat):
                    return 25;
                case (Difficulty.Défi):
                    return 30;
                case (Difficulty.Exploit):
                    return 50;
                case (Difficulty.Surhumain):
                    return 75;
                case (Difficulty.Impossible):
                    return 100;
                default: return 0;
            }
        }
        /// <summary>
        /// Convert a score into a difficulty
        /// </summary>
        /// <param name="score"> the score </param>
        /// <returns> the difficulty</returns>
        public static Difficulty DifficultéMax(int score)
        {
            switch (score)
            {
                case 0:
                    return Difficulty.Rien;
                case < 6:
                    return Difficulty.Trivial;
                case < 11:
                    return Difficulty.Facile;
                case < 16:
                    return Difficulty.Normal;
                case < 21:
                    return Difficulty.Complexe;
                case < 26:
                    return Difficulty.Délicat;
                case < 31:
                    return Difficulty.Défi;
                case < 51:
                    return Difficulty.Exploit;
                case < 76:
                    return Difficulty.Surhumain;
                case < 101:
                    return Difficulty.Impossible;
                default: return Difficulty.Rien;
            }
        }

        /// <summary>
        /// Draw a random number
        /// </summary>
        /// <param name="min">the minimum</param>
        /// <param name="max">the maximum</param>
        /// <returns> the draw number</returns>
        public static int GenRandNum(int min = 1, int max = 6)
        {
            Random random = new();
            return random.Next(min, max);
        }
        /// <summary>
        /// Make a list of number from a several roll of dice
        /// </summary>
        /// <param name="nombreDés"> number of dice to roll</param>
        /// <returns> a list</returns>
        public static List<int> TirageAléatoire(int nombreDés)
        {
            List<int> tableau = new List<int>();
            for (int i = 0; i < nombreDés; i++)
            {
                tableau.Add(GenRandNum());
            }
            return tableau;
        }

      /// <summary>
      /// Tell what difficulty the character succeed in a trial
      /// </summary>
      /// <param name="indicateur">the indicator</param>
      /// <param name="competence">the skill</param>
      /// <param name="personnage">the character</param>
      /// <returns>the maximum difficulty</returns>
        public static Difficulty EpreuveOuverte(int indicateur, Skill competence, MysterySheet personnage)
        {
            List<int> difficulteAtteinte = TirageAléatoire(indicateur);
            int palier = NumericResult(difficulteAtteinte, personnage.Skills[competence]);
            return DifficultéMax(palier);

        }

        /// <summary>
        /// Tell if the character pass or not a trial
        /// </summary>
        /// <param name="difficulteAtteindre"> the difficulty chosen</param>
        /// <param name="indicateur">the indicator</param>
        /// <param name="competence">the skill chosen</param>
        /// <param name="personnage"> the character</param>
        /// <returns> true if the character pass the trial, false otherwise</returns>
        public static Boolean EpreuveFermee(Difficulty difficulteAtteindre, int indicateur, Skill competence, MysterySheet personnage)
        {
            if (Niveau(EpreuveOuverte(indicateur, competence, personnage)) > Niveau(difficulteAtteindre))
            {
                return true;
            }
            return false;
        }

        public static Difficulty Name(string diff)
        {
            return diff switch
            {
                "Rien" => Difficulty.Rien,
                "Trivial" => Difficulty.Trivial,
                "Facile" => Difficulty.Facile,
                "Normal" => Difficulty.Normal,
                "Complexe" => Difficulty.Complexe,
                "Délicat" => Difficulty.Délicat,
                "Défi" => Difficulty.Défi,
                "Exploit" => Difficulty.Exploit,
                "Surhumain" => Difficulty.Surhumain,
                "Impossible" => Difficulty.Impossible,
                _ => Difficulty.Impossible,
            };
        }
    }
}

/*
 * Enumération avec l'ensemble des difficultés.
 */
public enum Difficulty
{
    Rien,
    Trivial,
    Facile,
    Normal,
    Complexe,
    Délicat,
    Défi,
    Exploit,
    Surhumain,
    Impossible,
}
