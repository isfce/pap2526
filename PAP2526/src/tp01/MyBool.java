package tp01;

public class MyBool {
	static final char[] intToHex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

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

	/**
	 * Idée sans modifier n et s'arrêter le plus vite possible
	 * 
	 * @param n
	 * @return
	 */
	public static int nbBitsV2(int n) {
		int cpt = 0;
		int masque1 = 1;
		int masque2 = -1; // tous les bits à 1
		while ((n & masque2) != 0) {
			if ((n & masque1) != 0)
				cpt++;
			masque1 = masque1 << 1;
			masque2 = masque2 << 1;
		}
		return cpt;
	}

	/**
	 * On peut modifier n
	 * 
	 * @param n
	 * @return
	 */
	public static int nbBitsV3(int n) {
		int cpt = 0;
		while (n != 0) {
			if ((n & 1) != 0)
				cpt++;
			n = n >>> 1; // décalage classique: injecte des 0 à gauche
		}
		return cpt;
	}

	/**
	 * On peut modifier n
	 * 
	 * @param n
	 * @return
	 */
	public static int nbBitsV3Bis(int n) {
		int cpt = 0;
		while (n != 0) {
			cpt += (n & 1);// ajoute 1 ou 0
			n = n >>> 1; // décalage classique: injecte des 0 à gauche
		}
		return cpt;
	}

	/**
	 * Convertion d'un entier en Hexa
	 * 
	 * @param n
	 * @return
	 */
	public static String intToHex(int n) {
		String res = "";
		char c;
		int v;
		do {
			v = (n & 15);
			// un cast pour passer d'un int vers un char
			c = (char) (v + (v <= 9 ? '0' : 'a' - 10));// +32 pour minuscules
			res = c + res;
			n = n >>> 4; // décalage classique injecte des 0 à gauche
		} while (n != 0);
		return "0x" + res;
	}

	/**
	 * Convertion d'un entier en Hexa
	 * 
	 * @param n
	 * @return
	 */
	public static String intToHexV2(int n) {
		String res = "";
		int v;
		do {
			v = (n & 15);
			res = intToHex[v] + res;
			n = n >>> 4; // décalage classique injecte des 0 à gauche
		} while (n != 0);
		return "0x" + res;
	}

	/**
	 * Indique le nombre de bytes nécessaires pour coder ce caractère en UTF8
	 * 
	 * @param c un caractère en unicode
	 * @return
	 */
	public static int nbBytesUtf8(char c) {
		if ((c & 0xFF80) == 0)
			return 1;
		if ((c & 0xF800) == 0)
			return 2;
		return 3;
	}

	/**
	 * Décodage d'un code UTF8 en unicode
	 * 
	 * @param n un code UTF8 valable
	 * @return le code unicode associé
	 */
	public static int decodeUtf8(int n) {
		int res = 0;
		if ((n & 0x80) == 0)
			res = n;
		else if ((n & 0xff0000) == 0)
			res = n & 0x3f | (n & 0x1f00) >> 2;
		else
			res = n & 0x3f | (n & 0x3f00) >> 2 | (n & 0xf0000) >> 4;
		return res;
	}

	public static void main(String[] args) {
		System.out.println(nbBytesUtf8('a'));
		System.out.println(nbBytesUtf8('é'));
		System.out.println(nbBytesUtf8('€'));
		System.out.println((char) decodeUtf8(0xE282AC));
	}
}








