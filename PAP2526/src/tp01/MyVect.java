package tp01;

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

	/**
	 * Retourne le nombre de fois que nbr existe ds le vecteur
	 * 
	 * @param v
	 * @param nbr élément à rechercher
	 * @return
	 */
	public static int nbElemV(int[] v, int nbr) {
		assert v.length > 0 : "Le vecteur ne peut pas être vide";
		int cpt = 0;
		for (int elem : v)
			if (elem == nbr)
				cpt++;
		return cpt;

	}

	/**
	 * retourne le min et le max d'un vecteur
	 * 
	 * @param v
	 * @return res[0]=min res[1]=max
	 */
	public static int[] minMaxElem(int[] v) {
		assert v.length > 0 : "Le vecteur ne peut pas être vide";
		int[] res = { v[0], v[0] };
		for (int i = 1; i < v.length; i++)
			if (v[i] < res[0])
				res[0] = v[i];// autre min
			else if (v[i] > res[1])
				res[1] = v[i];// autre max
		return res;
	}

	public static RMinMax minMaxElem2(int[] v) {
		assert v.length > 0 : "Le vecteur ne peut pas être vide";
		int min = v[0], max = v[0];
		for (int i = 1; i < v.length; i++)
			if (v[i] < min)
				min = v[i];// autre min
			else if (v[i] > max)
				max = v[i];// autre max
		return new RMinMax(min, max);
	}

	/**
	 * clone 2 vecteurs
	 * 
	 * @param v
	 * @return
	 */
	public static int[] clone(int[] v) {
		int[] res = new int[v.length];
		for (int i = 0; i < v.length; i++)
			res[i] = v[i];
		return res;
	}

	public static boolean estPalindrome(char[] txt) {
		int i = 0;
		int j = txt.length - 1;
		boolean palindrome = true;
		while (palindrome && i < j) {
			palindrome = txt[i] == txt[j];
			i++;
			j--;
		}
		return palindrome;
	}

	/**
	 * Inverse le contenu du vecteur
	 * 
	 * @param v
	 */
	public static void inverseV(int[] v) {
		int i = 0;
		int j = v.length - 1;
		int tmp;
		while (i < j) {
			// swap v[i] avec v[j]
			tmp = v[i];
			v[i] = v[j];
			v[j] = tmp;
			// avance
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
	}

}

record RMinMax(int min, int max) {
};
