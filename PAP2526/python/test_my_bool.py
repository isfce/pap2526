import unittest
import my_bool


class TestMyBool(unittest.TestCase):
    
    def test_estMajuscule(self):
        self.assertTrue(my_bool.estMajuscule('A'))
        self.assertTrue(my_bool.estMajuscule('É'))
        self.assertFalse(my_bool.estMajuscule('a'))
        self.assertFalse(my_bool.estMajuscule('é'))
        
    
             
if __name__ == "__main__":
    unittest.main()