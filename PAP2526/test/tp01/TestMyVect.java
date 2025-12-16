package tp01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
