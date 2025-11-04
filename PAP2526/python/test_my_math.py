import unittest
import my_math

class TestMyMath(unittest.TestCase):
    
    def test_estPair(self):
        self.assertTrue(my_math.estPair(0))
        self.assertTrue(my_math.estPair(8))
        self.assertFalse(my_math.estPair(9))
        self.assertRaises(AssertionError,my_math.estPair,-9)
    
    def test_nbZero(self): 
        self.assertEqual(1,my_math.nbZero(0))
        self.assertEqual(0,my_math.nbZero(98))
        self.assertEqual(2,my_math.nbZero(9080))
        self.assertRaises(AssertionError,my_math.nbZero,-1)
    
    def test_nbPassages(self):
        self.assertEqual(0,my_math.nbPassages(1))
        self.assertEqual(6,my_math.nbPassages(10))
        self.assertRaises(AssertionError,my_math.nbPassages,0)
    
    def test_speedConverter(self):
        self.assertEqual(0.0,my_math.speedConverter(0,'K','M'))
    
if __name__ == "__main__":
    unittest.main()