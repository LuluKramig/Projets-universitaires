using ButopiaMysteries.Logic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ButopiaMysteries_Test
{
    public class TrialsTest
    {
        /// <summary>
        /// Tests NumericalResult
        /// </summary>
        [Test]
        public void NumericalResult_Test()
        {
            int s = 2;
            List<int> l1 = null;
            List<int> l2 = [];
            List<int> l3 = new List<int>();
            l3.Add(1);
            l3.Add(2);
            l3.Add(3);
            NumericalResult_TestMethod(l1);
            NumericalResult_TestMethod(l2);
            NumericalResult_TestMethod(l3,0,6); 
            NumericalResult_TestMethod(l1,s);
            NumericalResult_TestMethod(l2,s);
            NumericalResult_TestMethod(l3,s,6);
        }
        /// <summary>
        /// Method used by the tests to assert that NumericalResult works correctly
        /// </summary>
        /// <param name="list"></param>
        /// <param name="skill"></param>
        /// <param name="sum"></param>
        private void NumericalResult_TestMethod(List<int> list, int skill=0, int sum = 0)
        {
            if (list == null) // Case: null list
            {
                Assert.That(Trial.NumericResult(list, skill), Is.EqualTo(0));
                return;
            }
            if (list.Count == 0) // Case: empty list
            {
                Assert.That(Trial.NumericResult(list, skill), Is.EqualTo(0));
                return;
            }
            if (skill == 0) // Case: void skill
            {
                Assert.That(Trial.NumericResult(list, skill), Is.EqualTo(0));
                return;
            }
            // Nominal case
            Assert.That(Trial.NumericResult(list, skill), Is.EqualTo(sum));
        }
        /// <summary>
        /// Tests the amount of points to the levels
        /// </summary>
        [Test]
        public void NiveauTest()
        {
            Assert.That(Trial.Niveau(Difficulty.Rien), Is.EqualTo(0));
            Assert.That(Trial.Niveau(Difficulty.Trivial), Is.EqualTo(5));
            Assert.That(Trial.Niveau(Difficulty.Facile), Is.EqualTo(10));
            Assert.That(Trial.Niveau(Difficulty.Normal), Is.EqualTo(15));
            Assert.That(Trial.Niveau(Difficulty.Complexe), Is.EqualTo(20));
            Assert.That(Trial.Niveau(Difficulty.Délicat), Is.EqualTo(25));
            Assert.That(Trial.Niveau(Difficulty.Défi), Is.EqualTo(30));
            Assert.That(Trial.Niveau(Difficulty.Exploit), Is.EqualTo(50));
            Assert.That(Trial.Niveau(Difficulty.Surhumain), Is.EqualTo(75));
            Assert.That(Trial.Niveau(Difficulty.Impossible), Is.EqualTo(100));
        }
        /// <summary>
        /// Tests the levels from a point amount
        /// </summary>
        [Test]
        public void DifficultyMaxTest()
        {
            Assert.That(Trial.DifficultéMax(1), Is.EqualTo(Difficulty.Rien));
            Assert.That(Trial.DifficultéMax(-1), Is.EqualTo(Difficulty.Rien));
            Assert.That(Trial.DifficultéMax(5), Is.EqualTo(Difficulty.Trivial));
            Assert.That(Trial.DifficultéMax(6), Is.EqualTo(Difficulty.Facile));
            Assert.That(Trial.DifficultéMax(10), Is.EqualTo(Difficulty.Facile));
            Assert.That(Trial.DifficultéMax(11), Is.EqualTo(Difficulty.Normal));
            Assert.That(Trial.DifficultéMax(16), Is.EqualTo(Difficulty.Complexe));
            Assert.That(Trial.DifficultéMax(20), Is.EqualTo(Difficulty.Complexe));
            Assert.That(Trial.DifficultéMax(21), Is.EqualTo(Difficulty.Délicat));
            Assert.That(Trial.DifficultéMax(26), Is.EqualTo(Difficulty.Défi));
            Assert.That(Trial.DifficultéMax(30), Is.EqualTo(Difficulty.Défi));
            Assert.That(Trial.DifficultéMax(31), Is.EqualTo(Difficulty.Exploit));
            Assert.That(Trial.DifficultéMax(50), Is.EqualTo(Difficulty.Exploit));
            Assert.That(Trial.DifficultéMax(51), Is.EqualTo(Difficulty.Surhumain));
            Assert.That(Trial.DifficultéMax(75), Is.EqualTo(Difficulty.Surhumain));
            Assert.That(Trial.DifficultéMax(100), Is.EqualTo(Difficulty.Impossible));
        }
        /// <summary>
        /// Tests the names of the difficulties
        /// </summary>
        [Test]
        public void NameTest()
        {
            Assert.That(Trial.Name("Rien"), Is.EqualTo(Difficulty.Rien));
            Assert.That(Trial.Name("Trivial"), Is.EqualTo(Difficulty.Trivial));
            Assert.That(Trial.Name("Facile"), Is.EqualTo(Difficulty.Facile));
            Assert.That(Trial.Name("Normal"), Is.EqualTo(Difficulty.Normal));
            Assert.That(Trial.Name("Complexe"), Is.EqualTo(Difficulty.Complexe));
            Assert.That(Trial.Name("Délicat"), Is.EqualTo(Difficulty.Délicat));
            Assert.That(Trial.Name("Défi"), Is.EqualTo(Difficulty.Défi));
            Assert.That(Trial.Name("Exploit"), Is.EqualTo(Difficulty.Exploit));
            Assert.That(Trial.Name("Surhumain"), Is.EqualTo(Difficulty.Surhumain));
            Assert.That(Trial.Name("Impossible"), Is.EqualTo(Difficulty.Impossible));
        }

    }
}