package tp01;

import java.util.Arrays;

public class MyVect {

	public static void affiche(int[] v) {
		if (v == null) {
			System.out.println("null");
			return;
		}
		System.out.print("[");
		int i = v.length;
		for (int elem : v) {
			i--;
			System.out.print(elem + (i != 0 ? ", " : ""));
		}
		System.out.println("]");
	}

	/**
	 * Calcule la somme des éléments du vecteur
	 * 
	 * @param v
	 * @return
	 */
	public static long sommeV(int[] v) {
		assert v != null : "Le vecteur doit exister";
		long s = 0;
		for (int elem : v)
			s = s + elem;
		return s;
	}

	public static void main(String[] args) {
		int[] vn = null;
		int[] v0 = {};
		int[] v1 = { 1, 1, 2, 3, 5, 8 };
		System.out.println(v1);
		System.out.println(Arrays.toString(v1));
		affiche(vn);
		affiche(v0);
		affiche(v1);
	}
}
