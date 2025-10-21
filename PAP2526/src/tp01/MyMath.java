package tp01;

public class MyMath {
	/**
	 * Indique si un nombre est pair
	 * 
	 * @param n entier >=0
	 * @return true si pair
	 */
	public static boolean estPair(int n) {
		assert n >= 0 : " n doit être >=0";
		// return n % 2 == 0;// v1
		// return n / 2 * 2 == n;// v2
		// return ((n>>1)<<1) == n;//v3
		return (n & 1) == 0;// v4
	}

	/*--  
	 * 
	 * TP TOUSSAINT
	 * 
	 */

	public static byte nbZero(int n) {
		byte cpt = 0;
		// TODO
		return cpt;
	}

	public static int nbPassages(int n) {
		int cpt = 0;
		// TODO
		return cpt;
	}

	// vous pouvez ajuster cette entête si vous optez pour un type énuméré à la
	// place de char, pour préciser l'unité
	public static double speedConverter(double v, char unitI, char unitD) {
		double res = v;
		// TODO
		return res;
	}

	public static void main(String[] args) {
		System.out.println(estPair(4));
		System.out.println(estPair(9));
	}

}
