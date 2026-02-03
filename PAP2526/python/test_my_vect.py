import unittest
import my_vect


class TestMyVect(unittest.TestCase):
       
    def test_fusion(self):
        self.assertEqual([1,2,3,4 ],my_vect.fusion([1,2],[3,4]));
        self.assertEqual([1,2,3,4 ],my_vect.fusion([3,4],[1,2]));
        self.assertEqual([2,3,4,6,7,7,8,8,9,10,15 ],my_vect.fusion([4,7,8,8],[2,3,6,7,9,10,15]));
        self.assertEqual([2,3,4,6,7,7,8,8,9,10,15 ],my_vect.fusion([2,3,6,7,9,10,15],[4,7,8,8]));
    
        
if __name__ == "__main__":
    unittest.main()