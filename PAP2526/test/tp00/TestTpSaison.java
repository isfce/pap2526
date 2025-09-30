package tp00;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestTpSaison {

	@Test
	void testSaison() {

		assertEquals("Printemps", TpSaison.calculSaison(21, 3));
		assertEquals("Printemps", TpSaison.calculSaison(20, 4));
		assertEquals("Printemps", TpSaison.calculSaison(20, 6));

		assertEquals("Eté", TpSaison.calculSaison(21, 6));
		assertEquals("Eté", TpSaison.calculSaison(22, 7));
		assertEquals("Eté", TpSaison.calculSaison(22, 9));

		assertEquals("Automne", TpSaison.calculSaison(23, 9));
		assertEquals("Automne", TpSaison.calculSaison(22, 10));
		assertEquals("Automne", TpSaison.calculSaison(20, 12));

		assertEquals("Hiver", TpSaison.calculSaison(21, 12));
		assertEquals("Hiver", TpSaison.calculSaison(21, 1));
		assertEquals("Hiver", TpSaison.calculSaison(20, 3));
		
		assertThrows(AssertionError.class,()->{TpSaison.calculSaison(21,-1 ); });
		assertThrows(AssertionError.class,()->{TpSaison.calculSaison(21,13 ); });
		assertThrows(AssertionError.class,()->{TpSaison.calculSaison(-1,11 ); });
		assertThrows(AssertionError.class,()->{TpSaison.calculSaison(32,11 ); });
	}

}
