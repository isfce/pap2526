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

	public static void main(String[] args) {
		System.out.println(estPair(4));
		System.out.println(estPair(9));
	}

}
