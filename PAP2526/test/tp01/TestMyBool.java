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
	void testNbBitV1() {
		assertEquals(0, MyBool.nbBitsV1(0));
		assertEquals(2, MyBool.nbBitsV1(18));
		assertEquals(32, MyBool.nbBitsV1(-1));
	}

	@Test
	void testNbBitV2() {
		assertEquals(0, MyBool.nbBitsV2(0));
		assertEquals(2, MyBool.nbBitsV2(18));
		assertEquals(32, MyBool.nbBitsV2(-1));
	}

	@Test
	void testNbBitV3() {
		assertEquals(0, MyBool.nbBitsV3(0));
		assertEquals(2, MyBool.nbBitsV3(18));
		assertEquals(32, MyBool.nbBitsV3(-1));
	}
	
	@Test
	void testNbBitV3Bis() {
		assertEquals(0, MyBool.nbBitsV3(0));
		assertEquals(2, MyBool.nbBitsV3(18));
		assertEquals(32, MyBool.nbBitsV3(-1));
	}
	
	@Test
	void testIntToHex() {
		assertEquals("0x0",MyBool.intToHex(0));
		assertEquals("0xf4a",MyBool.intToHex(3914));
		assertEquals("0x80000000",MyBool.intToHex(Integer.MIN_VALUE));
		assertEquals("0xffffffff",MyBool.intToHex(-1));
	}
	
	@Test
	void testIntToHexV2() {
		assertEquals("0x0",MyBool.intToHexV2(0));
		assertEquals("0xf4a",MyBool.intToHexV2(3914));
		assertEquals("0x80000000",MyBool.intToHexV2(Integer.MIN_VALUE));
		assertEquals("0xffffffff",MyBool.intToHexV2(-1));
	}
}
