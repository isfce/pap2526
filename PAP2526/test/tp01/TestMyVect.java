package tp01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestMyVect {
	@Test
	public void testSommeV() {
		int[] v0 = {};
		int[] v1 = { 1, 5, -2 };
		assertEquals(0, MyVect.sommeV(v0));
		assertEquals(4, MyVect.sommeV(v1));
		assertThrows(AssertionError.class, () -> MyVect.sommeV(null));
	}

	@Test
	public void testNbElem() {
		int[] v0 = {};
		int[] v1 = { 1, 2, 3, 0, 1, 2, 2, 8 };
		assertEquals(1, MyVect.nbElemV(v1, 0));
		assertEquals(3, MyVect.nbElemV(v1, 2));
		assertEquals(2, MyVect.nbElemV(v1, 1));
		assertEquals(1, MyVect.nbElemV(v1, 8));
		assertEquals(0, MyVect.nbElemV(v1, 88));
		assertThrows(AssertionError.class, () -> MyVect.nbElemV(v0, 0));
	}

	@Test
	public void testMinMax() {
		int[] v0 = {};
		int[] v1 = { 1, 50, 3, 1 };
		assertArrayEquals(new int[] { 1, 50 }, MyVect.minMaxElem(v1));
		assertThrows(AssertionError.class, () -> MyVect.minMaxElem(v0));
	}

	@Test
	public void testMinMax2() {
		int[] v0 = {};
		int[] v1 = { 1, 50, 3, 1 };
		assertEquals(1, MyVect.minMaxElem2(v1).min());
		assertEquals(50, MyVect.minMaxElem2(v1).max());
		assertEquals(new RMinMax(1, 50), MyVect.minMaxElem2(v1));
		assertThrows(AssertionError.class, () -> MyVect.minMaxElem2(v0));
	}

	@Test
	public void testClone() {
		int[] v0 = {};
		int[] v1 = { 1, 5, -2 };
		assertArrayEquals(new int[] { 1, 5, -2 }, MyVect.clone(v1));
		assertArrayEquals(new int[] {}, MyVect.clone(v0));
	}

	@Test
	public void testPalindrome() {
		assertTrue(MyVect.estPalindrome("RADAR".toCharArray()));
		assertTrue(MyVect.estPalindrome("ABBA".toCharArray()));
		assertTrue(MyVect.estPalindrome("A".toCharArray()));
		assertFalse(MyVect.estPalindrome("ABTFBA".toCharArray()));
		assertFalse(MyVect.estPalindrome("zBBA".toCharArray()));
	}

	@Test
	public void testInverse() {
		int[] v1 = { 1, 5, -2 };
		MyVect.inverseV(v1);
		assertArrayEquals(new int[] { -2, 5, 1 }, v1);

	}

	@Test
	public void testNbBosses() {
		int[] v0 = { 1 };
		int[] v1 = { 1, 4 };
		int[] v2 = { 1, 2, 1 };
		int[] v3 = { 1, 2, 2, 3, 4, 1, -1, -1, 1, 2, 1, 4, 4 };
		assertEquals(0, MyVect.calculNbBosses(v0));
		assertEquals(0, MyVect.calculNbBosses(v1));
		assertEquals(1, MyVect.calculNbBosses(v2));
		assertEquals(2, MyVect.calculNbBosses(v3));
	}

	@Test
	public void testDoublon() {
		assertTrue(MyVect.sansDoublon(new int[] { 1, 2, 3, 4 }));
		assertFalse(MyVect.sansDoublon(new int[] { 1, 2, 3, 4, 4 }));
		assertFalse(MyVect.sansDoublon(new int[] { 1, 1, 3, 4, 5 }));
	}

	@Test
	public void testDoublonV2() {
		assertTrue(MyVect.sansDoublon(new int[] { 1, 2, 3, 4 }, 5));
		assertFalse(MyVect.sansDoublon(new int[] { 1, 2, 3, 4, 4 }, 4));
		assertFalse(MyVect.sansDoublon(new int[] { 1, 1, 3, 4, 5 }, 5));
		assertFalse(MyVect.sansDoublon(new int[] { 1, 2, 3, 4, 5, 0, 5 }, 5));
	}

	@Test
	public void testDoublonV3() {
		assertTrue(MyVect.sansDoublonV3(new int[] { 1, 2, 3, 4 }));
		assertFalse(MyVect.sansDoublonV3(new int[] { 1, 2, 3, 4, 4 }));
		assertFalse(MyVect.sansDoublonV3(new int[] { 1, 1, 3, 4, 5 }));
		assertFalse(MyVect.sansDoublonV3(new int[] { 1, 2, 3, 4, 5, 0, 5 }));
	}

	@Test
	public void testTriInsertion() {
		assertArrayEquals(new int[] { 1 }, MyVect.triInsertion(new int[] { 1 }));
		assertArrayEquals(new int[] { 1, 2 }, MyVect.triInsertion(new int[] { 1, 2 }));
		assertArrayEquals(new int[] { 1, 2 }, MyVect.triInsertion(new int[] { 2, 1 }));
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, MyVect.triInsertion(new int[] { 4, 3, 2, 1 }));
	}

	@Test
	public void testTriBulle0() {
		assertArrayEquals(new int[] { 1 }, MyVect.triBulle0(new int[] { 1 }));
		assertArrayEquals(new int[] { 1, 2 }, MyVect.triBulle0(new int[] { 1, 2 }));
		assertArrayEquals(new int[] { 1, 2 }, MyVect.triBulle0(new int[] { 2, 1 }));
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, MyVect.triBulle0(new int[] { 4, 3, 2, 1 }));
		assertArrayEquals(new int[] { 1, 4, 5, 6, 9 }, MyVect.triBulle0(new int[] { 9, 4, 5, 6, 1 }));

	}
	@Test
	public void testTriBulle1() {
		assertArrayEquals(new int[] { 1 }, MyVect.triBulle(new int[] { 1 }));
		assertArrayEquals(new int[] { 1, 2 }, MyVect.triBulle(new int[] { 1, 2 }));
		assertArrayEquals(new int[] { 1, 2 }, MyVect.triBulle(new int[] { 2, 1 }));
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, MyVect.triBulle(new int[] { 4, 3, 2, 1 }));
		assertArrayEquals(new int[] { 1, 4, 5, 6, 9 }, MyVect.triBulle(new int[] { 9, 4, 5, 6, 1 }));

	}
	@Test
	public void testTriBulle3() {
		assertArrayEquals(new int[] { 1 }, MyVect.triBulle3(new int[] { 1 }));
		assertArrayEquals(new int[] { 1, 2 }, MyVect.triBulle3(new int[] { 1, 2 }));
		assertArrayEquals(new int[] { 1, 2 }, MyVect.triBulle3(new int[] { 2, 1 }));
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, MyVect.triBulle3(new int[] { 4, 3, 2, 1 }));
		assertArrayEquals(new int[] { 1, 4, 5, 6, 9 }, MyVect.triBulle3(new int[] { 9, 4, 5, 6, 1 }));

	}
	
	@Test
	public void testFusionVect() {
		assertArrayEquals(new int[] { 1,2,3,4 }, MyVect.fusionVect(new int[] { 1,2 },new int[] {3,4}));
		assertArrayEquals(new int[] { 1,2,3,4 }, MyVect.fusionVect(new int[] { 3,4 },new int[] {1,2}));
		assertArrayEquals(new int[] { 1,2,3,4 }, MyVect.fusionVect(new int[] { 1,2,4},new int[] {3}));
		assertArrayEquals(new int[] { 1,2,3,4 }, MyVect.fusionVect(new int[] { 3},new int[] {1,2,4}));
		assertArrayEquals(new int[] { 2,3,4,6,7,7,8,8,9,10,15}, MyVect.fusionVect(new int[] { 4,7,8,8},new int[] {2,3,6,7,9,10,15}));
		

	}
	@Test
	public void testFusionVectSoir() {
		assertArrayEquals(new int[] { 1,2,3,4 }, MyVect.fusionVectSoir(new int[] { 1,2 },new int[] {3,4}));
		assertArrayEquals(new int[] { 1,2,3,4 }, MyVect.fusionVectSoir(new int[] { 3,4 },new int[] {1,2}));
		assertArrayEquals(new int[] { 1,2,3,4 }, MyVect.fusionVectSoir(new int[] { 1,2,4},new int[] {3}));
		assertArrayEquals(new int[] { 1,2,3,4 }, MyVect.fusionVectSoir(new int[] { 3},new int[] {1,2,4}));
		assertArrayEquals(new int[] { 2,3,4,6,7,7,8,8,9,10,15}, MyVect.fusionVectSoir(new int[] { 4,7,8,8},new int[] {2,3,6,7,9,10,15}));
		

	}
}
