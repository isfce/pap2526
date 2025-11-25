import unittest
import my_math


class TestMyMath(unittest.TestCase):
    
    def test_estPair(self):
        self.assertTrue(my_math.estPair(0))
        self.assertTrue(my_math.estPair(8))
        self.assertFalse(my_math.estPair(9))
        self.assertRaises(AssertionError, my_math.estPair, -9)
    
    def test_fact(self):
        self.assertEqual(1, my_math.fact(0))
        self.assertEqual(1, my_math.fact(1))
        self.assertEqual(120, my_math.fact(5))
        self.assertRaises(AssertionError, my_math.fact, -1)
    
    def test_nbZero(self): 
        self.assertEqual(1, my_math.nbZero(0))
        self.assertEqual(0, my_math.nbZero(98))
        self.assertEqual(2, my_math.nbZero(9080))
        self.assertRaises(AssertionError, my_math.nbZero, -1)
    
    def test_nbPassages(self):
        self.assertEqual(0, my_math.nbPassages(1))
        self.assertEqual(6, my_math.nbPassages(10))
        self.assertRaises(AssertionError, my_math.nbPassages, 0)
    
    def test_speedConverter(self):
        self.assertEqual(0.0, my_math.speedConverter(0, 'K', 'M'))
    
    def test_fibo(self):
        self.assertEqual(0, my_math.fibo(0))
        self.assertEqual(1, my_math.fibo(1))
        self.assertEqual(1, my_math.fibo(2))
        self.assertEqual(8, my_math.fibo(6))
        self.assertRaises(AssertionError, my_math.fibo, -1)
    
    def test_nombrerOr(self):
        self.assertEqual(1, my_math.nombreOr(1));
        self.assertEqual(2, my_math.nombreOr(2));
        self.assertAlmostEqual(1.666666, my_math.nombreOr(4), delta=0.000001);
        self.assertAlmostEqual(1.6, my_math.nombreOr(5), delta=0.000001);
        
    def test_estPremier(self):
        self.assertTrue(my_math.estPremier(2))
        self.assertTrue(my_math.estPremier(3))
        self.assertTrue(my_math.estPremier(31))
        self.assertFalse(my_math.estPremier(4))
        self.assertFalse(my_math.estPremier(25))
        self.assertFalse(my_math.estPremier(33))
        self.assertRaises(AssertionError, my_math.estPremier, 1)
        

if __name__ == "__main__":
    unittest.main()
