package tp01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestMyMat {
	@Test
	public void testMini() {
		assertEquals(0, MyMat.rechercheMin(new int[][] { { 1, 2 }, { 3, 0 } }));
		assertEquals(-1, MyMat.rechercheMin(new int[][] { { -1, 2 }, { 3, 0 } }));
	}

	@Test
	public void testExiste() {
		assertTrue(MyMat.existeInMat(new int[][] { { 1, 2 }, { 3, 0 } }, 0));
		assertTrue(MyMat.existeInMat(new int[][] { { -1, 2 }, { 3, 0 } }, 2));
		assertFalse(MyMat.existeInMat(new int[][] { { -1, 2 }, { 3, 0 } }, 20));
	}

	@Test
	public void testSym() {
		assertTrue(MyMat.estSymetrique(new int[][] { { 9, -1, 6 }, { -1, 5, 1 }, { 6, 1, 3 } }));
		assertFalse(MyMat.estSymetrique(new int[][] { { 9, -1, -6 }, { -1, 5, 1 }, { 6, 1, 3 } }));
		assertTrue(MyMat.estSymetrique(new int[][] { { 1, 2 }, { 2, 1 } }));
		assertFalse(MyMat.estSymetrique(new int[][] { { 1, 2 }, { -2, 1 } }));
	}
}
