package tp01;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestMyMath {
	
	@Test
	void testEstPair() {
		assertTrue(MyMath.estPair(0));
		assertTrue(MyMath.estPair(8));
		assertFalse(MyMath.estPair(9));
		assertThrows(AssertionError.class,()->MyMath.estPair(-9) );
	}
	
	@Test
	void testNbZero() {
	  //TODO	
	}
	
	@Test
	void testNbPassages() {
	  //TODO	
	}
	
	@Test
	void testSpeedConverter() {
	  //TODO	
	}

}
