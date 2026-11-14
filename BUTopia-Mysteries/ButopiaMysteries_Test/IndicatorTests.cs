using ButopiaMysteries.Logic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ButopiaMysteries_Test
{
    internal class IndicatorTests
    {
        /// <summary>
        /// Tests the name of the indicators
        /// </summary>
        [Test]
        public void NameTest()
        {
            Assert.That(Indicator_Operations.Name(Indicator.Sense), Is.EqualTo("Sens"));
            Assert.That(Indicator_Operations.Name(Indicator.Body), Is.EqualTo("Corps"));
            Assert.That(Indicator_Operations.Name(Indicator.Maximum), Is.EqualTo("Max"));
            Assert.That(Indicator_Operations.Name(Indicator.Mind), Is.EqualTo("Esprit"));
        }
        /// <summary>
        /// Tests the indicators got from a name
        /// </summary>
        public void NameInvertTest()
        {
            Assert.That(Indicator_Operations.Name_Invert("Sens"), Is.EqualTo(Indicator.Sense));
            Assert.That(Indicator_Operations.Name_Invert("Max"), Is.EqualTo(Indicator.Maximum));
            Assert.That(Indicator_Operations.Name_Invert("Corps"), Is.EqualTo(Indicator.Body));
            Assert.That(Indicator_Operations.Name_Invert("Esprit"), Is.EqualTo(Indicator.Mind));

        }

    }
}
