package tp01;

import java.util.function.BiFunction;

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

	/**
	 * Calcule la factorielle de n
	 * 
	 * @param n 0<=n<=20
	 * @return
	 */
	public static long fact2(int n) {
		assert n >= 0 && n < 21 : "n doit être positif et <21";
		long f = 1;
		for (int i = 2; i <= n; i++)
			f = f * i;
		return f;
	}

	public static long fact(int n) {
		assert n >= 0 && n < 21 : "n doit être positif et <21";
		long f = 1;
		for (; n >= 2; n--)
			f = f * n;
		return f;
	}

	/**
	 * Affiche tableau avec l'opération fct
	 * 
	 * @param n
	 * @param fct (a,b)->a op b
	 */
	public static void tableau(int n, BiFunction<Integer, Integer, Integer> fct) {
		assert n < 10 & n > 0 : "n entre 1 et 9";
		// affiche entête de colonne
		System.out.print("    ");
		for (int i = 1; i <= n; i++)
			System.out.printf("%4d", i);
		System.out.println();
		// ligne en dessous des entêtes de colonne
		for (int i = 0; i <= n; i++)
			System.out.printf("____");
		System.out.println();
		// affiche tableau
		for (int a = 1; a <= n; a++) {
			// entête de ligne
			System.out.printf("%3d|", a);
			for (int b = 1; b <= n; b++) {
				System.out.printf("%4d", fct.apply(a, b));
			}
			System.out.println();
		}
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
	 * @param n
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
		tableau(5, (x, y) -> x * y);
		tableau(5, (x, y) -> x - y);
		tableau(5, (x, y) -> x % y);
	}

}
