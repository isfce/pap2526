package tp03;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tp02.Recursivite;

public class TestRecursivite {
	@Test
	public void testPivot() {
		int[] v0 = { 1, 2, 3, 4 };
		int[] v1 = { 1, 2, 3, 0 };
		int[] v2 = { 2, 1 };
		int[] v3 = { 1, 3 };
		int[] v4 = { 1 };
		int[] v5 = { 5, 1, 8, 2, 7, 4 };
		int res = Recursivite.posPivot(v0, 0, 3);
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, v0);
		assertEquals(3, res);
		res = Recursivite.posPivot(v1, 0, 3);
		assertArrayEquals(new int[] { 0, 2, 3, 1 }, v1);
		assertEquals(0, res);
		res = Recursivite.posPivot(v2, 0, 1);
		assertArrayEquals(new int[] { 1, 2 }, v2);
		assertEquals(0, res);
		res = Recursivite.posPivot(v3, 0, 1);
		assertArrayEquals(new int[] { 1, 3 }, v3);
		assertEquals(1, res);
		res = Recursivite.posPivot(v4, 0, 0);
		assertArrayEquals(new int[] { 1 }, v4);
		assertEquals(0, res);
		res = Recursivite.posPivot(v5, 0, 5);
		assertArrayEquals(new int[] { 2, 1, 4, 5, 7, 8 }, v5);
		assertEquals(2, res);
	}

	@Test
	public void testTriQuick() {
		assertArrayEquals(new int[] { 1 }, Recursivite.quicksort(new int[] { 1 }));
		assertArrayEquals(new int[] { 1, 2 }, Recursivite.quicksort(new int[] { 1, 2 }));
		assertArrayEquals(new int[] { 1, 2 }, Recursivite.quicksort(new int[] { 2, 1 }));
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, Recursivite.quicksort(new int[] { 4, 3, 2, 1 }));
		assertArrayEquals(new int[] { 1, 4, 5, 6, 9 }, Recursivite.quicksort(new int[] { 9, 4, 5, 6, 1 }));
		assertArrayEquals(new int[] { 1, 2, 4, 5, 7, 8 }, Recursivite.quicksort(new int[] { 5, 1, 8, 2, 7, 4 }));

	}
}
