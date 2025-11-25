package tp01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import tp01.MyMath.SpeedUnit;

public class TestMyMath {

	@Test
	void testEstPair() {
		assertTrue(MyMath.estPair(0));
		assertTrue(MyMath.estPair(8));
		assertFalse(MyMath.estPair(9));
		assertThrows(AssertionError.class, () -> MyMath.estPair(-9));
	}

	@Test
	void testFact() {
		assertEquals(1, MyMath.fact(0));
		assertEquals(1, MyMath.fact(1));
		assertEquals(120, MyMath.fact(5));
		assertThrows(AssertionError.class, () -> MyMath.fact(-1));
		assertThrows(AssertionError.class, () -> MyMath.fact(21));
	}

	@Test
	void testNbZero() {
		assertEquals(1, MyMath.nbZero(0));
		assertEquals(0, MyMath.nbZero(123));
		assertEquals(3, MyMath.nbZero(10900));
		assertThrows(AssertionError.class, () -> MyMath.nbZero(-1));
	}

	@Test
	void testNbPassages() {
		assertEquals(6, MyMath.nbPassages(10));
		assertEquals(0, MyMath.nbPassages(1));
		assertThrows(AssertionError.class, () -> MyMath.nbPassages(0));
	}

	@Test
	void testSpeedConverter() {
		assertEquals(62.1371, MyMath.speedConverter(100.0, SpeedUnit.KMH, SpeedUnit.MILES), 0.001);
		assertEquals(53.9957, MyMath.speedConverter(100.0, SpeedUnit.KMH, SpeedUnit.NOEUD), 0.0001);
		assertEquals(185.2, MyMath.speedConverter(100.0, SpeedUnit.NOEUD, SpeedUnit.KMH), 0.0001);
		assertEquals(160.934, MyMath.speedConverter(100.0, SpeedUnit.MILES, SpeedUnit.KMH), 0.0001);
		assertEquals(86.8974, MyMath.speedConverter(100.0, SpeedUnit.MILES, SpeedUnit.NOEUD), 0.0001);
		assertEquals(115.07794, MyMath.speedConverter(100.0, SpeedUnit.NOEUD, SpeedUnit.MILES), 0.0001);

	}

	@Test
	void testFibo() {
		assertEquals(0, MyMath.fibo(0));
		assertEquals(1, MyMath.fibo(1));
		assertEquals(8, MyMath.fibo(6));
		assertThrows(AssertionError.class, () -> MyMath.fibo(-1));
	}

	@Test
	void testnbrOr() {
		assertEquals(1, MyMath.nombreOr(1));
		assertEquals(2, MyMath.nombreOr(2));
		assertEquals(1.666666, MyMath.nombreOr(4), 0.000001);
		assertEquals(1.6, MyMath.nombreOr(5), 0.000001);
		assertThrows(AssertionError.class, () -> MyMath.nombreOr(0));
	}

	@Test
	void testPremier() {
		assertTrue(MyMath.estPremier(2));
		assertTrue(MyMath.estPremier(3));
		assertTrue(MyMath.estPremier(5));
		assertTrue(MyMath.estPremier(7));
		assertTrue(MyMath.estPremier(31));
		assertFalse(MyMath.estPremier(4));
		assertFalse(MyMath.estPremier(9));
		assertFalse(MyMath.estPremier(25));
		assertFalse(MyMath.estPremier(33));

		assertThrows(AssertionError.class, () -> MyMath.estPremier(1));
	}
}
