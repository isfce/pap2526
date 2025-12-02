package tp01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestMyBool {
	@Test
	void testMajuscule() {
		assertTrue(MyBool.estMajuscule('A'));
		assertTrue(MyBool.estMajuscule('È'));
		assertFalse(MyBool.estMajuscule('a'));
		assertFalse(MyBool.estMajuscule('è'));
	}

	@Test
	void TestNbBitV1() {
		assertEquals(0, MyBool.nbBitsV1(0));
		assertEquals(2, MyBool.nbBitsV1(18));
		assertEquals(32, MyBool.nbBitsV1(-1));
	}

	@Test
	void TestNbBitV2() {
		assertEquals(0, MyBool.nbBitsV2(0));
		assertEquals(2, MyBool.nbBitsV2(18));
		assertEquals(32, MyBool.nbBitsV2(-1));
	}

	@Test
	void TestNbBitV3() {
		assertEquals(0, MyBool.nbBitsV3(0));
		assertEquals(2, MyBool.nbBitsV3(18));
		assertEquals(32, MyBool.nbBitsV3(-1));
	}
}
