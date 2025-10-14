import unittest
import my_math

class TestMyMath(unittest.TestCase):
    
    def test_estPair(self):
        self.assertTrue(my_math.estPair(0))
        self.assertTrue(my_math.estPair(8))
        self.assertFalse(my_math.estPair(9))
        self.assertRaises(AssertionError,my_math.estPair,-9)
    
if __name__ == "__main__":
    unittest.main()