package tp01;

public class MyBool {
	/**
	 * indique si la lettre est une majuscule
	 * 
	 * @param c doit être une lettre
	 * @return
	 */
	public static boolean estMajuscule(char c) {
		return (c & 32) == 0;
	}

	/**
	 * Retourne le nombre de bits à 1
	 * 
	 * @param n
	 * @return
	 */
	public static int nbBitsV1(int n) {
		int cpt = 0;
		int masque = 1;
		for (int i = 1; i <= 32; i++) {
			if ((n & masque) != 0)
				cpt++;
			masque = masque << 1;
		}
		return cpt;
	}

	public static int nbBitsV2(int n) {
		int cpt = 0;

		return cpt;
	}

	public static int nbBitsV3(int n) {
		int cpt = 0;

		return cpt;
	}

}
