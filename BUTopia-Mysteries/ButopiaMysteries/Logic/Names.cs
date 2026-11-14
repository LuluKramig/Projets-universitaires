using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ButopiaMysteries.Logic
{
    /// <summary>
    /// Application data: some names
    /// </summary>
    public static class Names
    {
        /// <summary>
        /// A few stock names.
        /// </summary>
        public static List<string> NameList { get; } = ["Ana", "Brigitte", "Chacal", "D.Va", "Emre", "Freja", "Genji", "Hanzo", "Illari", "Juno",
        "Kiriko", "Lucio", "Mei", "Orisa", "Pharah", "Queen", "Reinhardt", "Sigma", "Torbjörn", "Uyang", "Venture", "Winston", "Xiopper", "Yetpack Cat", "Zenyatta"];
        /// <summary>
        /// Get a single random name.
        /// </summary>
        public static string RandomName => NameList[new Random().Next(NameList.Count)];
    }
}
