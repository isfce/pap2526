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
	/**
	 * Retourne le nombre de zéros (base 10)
	 * 
	 * @param n >=0
	 * @return
	 */
	public static byte nbZero(int n) {
		assert n >= 0 : "n doit être >=0";
		if (n == 0)
			return 1;
		byte cpt = 0;
		while (n != 0) {
			if (n % 10 == 0)
				cpt++;
			n = n / 10;
		}
		return cpt;
	}

	/**
	 * Nombre de passages avant d'obtenir 1
	 * 
	 * @param n >0
	 * @return
	 */
	public static int nbPassages(int n) {
		assert n > 0 : "n doit être > 0";
		int cpt = 0;
		while (n != 1) {
			if ((n & 1) == 0)// estPair
				n = n >> 1; // idem à n = n / 2;
			else
				n = n * 3 + 1;
			cpt++;
		}
		return cpt;
	}

	public enum SpeedUnit {
		KMH, MILES, NOEUD
	};

	// vous pouvez ajuster cette entête si vous optez pour un type énuméré à la
	// place de char, pour préciser l'unité
	public static double speedConverter(double v, SpeedUnit unitI, SpeedUnit unitD) {
		if (unitI == unitD)
			return v;
		// ==> en km/h
		v = switch (unitI) {
		case SpeedUnit.MILES -> v * 1.60934;
		case SpeedUnit.NOEUD -> v * 1.852;
		case SpeedUnit.KMH -> v;
		};
		// km/h ==> unitD
		v = switch (unitD) {
		case SpeedUnit.MILES -> v * 0.621371;
		case SpeedUnit.NOEUD -> v * 0.539957;
		case SpeedUnit.KMH -> v;
		};
		return v;
	}

	public static void main(String[] args) {
		System.out.println(estPair(4));
		System.out.println(estPair(9));
	}

}
