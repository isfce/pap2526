import unittest
import my_bool


class TestMyBool(unittest.TestCase):
    
    def test_estMajuscule(self):
        self.assertTrue(my_bool.estMajuscule('A'))
        self.assertTrue(my_bool.estMajuscule('É'))
        self.assertFalse(my_bool.estMajuscule('a'))
        self.assertFalse(my_bool.estMajuscule('é'))
        
    def test_intToHex(self):
        self.assertEqual("0x0", my_bool.intToHex(0))
        self.assertEqual("0x9", my_bool.intToHex(9))
        self.assertEqual("0xffffffff", my_bool.intToHex(0xffffffff))
        self.assertEqual("0xf4a", my_bool.intToHex(3914))
        
             
if __name__ == "__main__":
    unittest.main()