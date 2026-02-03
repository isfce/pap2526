package tp01;

import java.util.HashSet;
import java.util.Set;

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

	/**
	 * Calcule le nombre de bosses
	 * 
	 * @param v
	 * @return nbr de bosses
	 */
	public static int calculNbBosses(int[] v) {
		int cpt = 0;
		boolean monte = false;
		for (int i = 0; i < v.length - 1; i++)
			if (v[i] < v[i + 1])
				monte = true;
			else if (v[i] > v[i + 1] && monte) {
				cpt++;
				monte = false;
			}
		return cpt;
	}

	public static int lettreEnPlace(char[] v1, char[] v2) {
		int cpt = 0;
		for (int i = 0; i < v1.length; i++)
			if (Character.toUpperCase(v1[i]) == Character.toUpperCase(v2[i]))
				cpt++;
		return cpt;
	}

	/**
	 * Indique si le vecteur ne contient pas de doublon
	 * 
	 * @param v
	 * @return
	 */
	public static boolean sansDoublon(int[] v) {
		boolean doublon = false;
		int i = 0;
		while (!doublon && i < v.length - 1) {
			int j = i + 1;
			while (!doublon && j < v.length) {
				doublon = v[i] == v[j];
				j++;
			}
			i++;
		}
		return !doublon;
	}

	/**
	 * Indique si le vecteur contient aucun doublon
	 * 
	 * @param v   vecteur contenant des nombres entre 0 et max
	 * @param max
	 * @return true si pas de doublon
	 */
	public static boolean sansDoublon(int[] v, int max) {
		assert v.length > 0 : "Le vecteur doit contenir au moins 1 élément";
		if (v.length > max + 1)
			return false;
		boolean doublon = false;
		boolean[] b = new boolean[max + 1];// cases à false
		int j = v[0];
		b[j] = true;
		int i = 1;
		while (!doublon && i < v.length) {
			j = v[i];
			if (b[j])
				doublon = true;
			else {
				b[j] = true;
				i++;
			}
		}
		return !doublon;
	}

	public static boolean sansDoublonV3(int[] v) {
		assert v.length > 0 : "Le vecteur doit contenir au moins 1 élément";
		boolean doublon = false;
		Set<Integer> ens = new HashSet<Integer>(v.length);
		int j = v[0];
		ens.add(j);
		int i = 1;
		while (!doublon && i < v.length) {
			j = v[i];
			if (ens.contains(j))
				doublon = true;
			else {
				ens.add(j);
				i++;
			}
		}
		return !doublon;
	}

	/**
	 * Tri par insertion
	 * 
	 * @param v tri le vecteur v
	 * @return retourne l'adresse du vecteur v
	 */
	public static int[] triInsertion(int[] v) {
		int j, tmp;
		long cpt = 0;
		for (int i = 1; i < v.length; i++) {
			cpt++;
			j = i - 1;
			tmp = v[i];
			while (j >= 0 && v[j] > tmp) {
				cpt++;
				v[j + 1] = v[j];
				j--;
			}
			if (j + 1 != i)
				v[j + 1] = tmp;
		}
		System.out.println("INSERTION => nombre d'opérations:" + cpt);
		return v;
	}

	/**
	 * Tri à bulle
	 * 
	 * @param v tri le vecteur v
	 * @return retourne l'adresse du vecteur v
	 */
	public static int[] triBulle0(int[] v) {
		int tmp;
		long cpt = 0;
		for (int i = v.length - 1; i > 0; i--) {
			cpt++;
			for (int j = 0; j < i; j++) {
				cpt++;
				if (v[j] > v[j + 1]) {
					cpt++;
					tmp = v[j];
					v[j] = v[j + 1];
					v[j + 1] = tmp;
				}
			}
		}
		System.out.println("BULLE0 => nombre d'opérations: " + cpt);
		return v;
	}

	/**
	 * Tri à bulle
	 * 
	 * @param v tri le vecteur v
	 * @return retourne l'adresse du vecteur v
	 */
	public static int[] triBulle(int[] v) {
		int tmp, pos = -1;
		long cpt = 0;
		boolean swap;
		int i = v.length - 1;
		do {
			swap = false;
			cpt++;
			for (int j = 0; j < i; j++) {
				cpt++;
				if (v[j] > v[j + 1]) {
					swap = true;
					pos = j;
					cpt++;
					tmp = v[j];
					v[j] = v[j + 1];
					v[j + 1] = tmp;
				}
			}
			i = pos;
		} while (swap);
		System.out.println("BULLE1 => nombre d'opérations:" + cpt);
		return v;
	}

	public static int[] triBulle3(int[] v) {
		boolean echange = true;
		int i = v.length - 1;
		int posD = -1;
		int posG = 0;
		while (echange) {
			echange = false;
			for (int j = posG; j < i; j++)
				if (v[j] > v[j + 1]) {
					int tmp = v[j];
					v[j] = v[j + 1];
					v[j + 1] = tmp;
					echange = true;
					posD = j;
				}
			if (echange) {
				i = posD;
				int l = posG;
				for (int k = i; k > l; k--)
					if (v[k] < v[k - 1]) {
						int tmp = v[k];
						v[k] = v[k - 1];
						v[k - 1] = tmp;
						echange = true;
						posG = k;
					}
			}
		}
		return v;
	}

	/**
	 * Fusion de 2 vecteurs triés
	 * 
	 * @param l1 vecteur trié par ordre croissant
	 * @param l2 vecteur trié par ordre croissant
	 * @return retourne un vecteur trié contenant l1 et l2
	 */
	public static int[] fusionVectSoir(int[] l1, int[] l2) {
		int[] l3 = new int[l1.length + l2.length];
		int i = 0, j = 0, k = 0;
		while (k < l3.length) {
			while (i < l1.length && (j == l2.length || l1[i] <= l2[j])) {
				l3[k] = l1[i];
				i++;
				k++;
			}
			while (j < l2.length && (i == l1.length || l2[j] <= l1[i])) {
				l3[k] = l2[j];
				j++;
				k++;
			}
		}
		return l3;
	}

	/**
	 * Fusion de 2 vecteurs triés
	 * 
	 * @param l1 vecteur trié par ordre croissant
	 * @param l2 vecteur trié par ordre croissant
	 * @return retourne un vecteur trié contenant l1 et l2
	 */
	public static int[] fusionVect(int[] l1, int[] l2) {
		int[] l3 = new int[l1.length + l2.length];
		int i = 0, j = 0, k = 0, maxl1, maxl2;
		while (k < l3.length) {
			maxl2 = j < l2.length ? l2[j] : Integer.MAX_VALUE;
			while (i < l1.length && l1[i] <= maxl2) {
				l3[k] = l1[i];
				k++;
				i++;
			}

			maxl1 = i < l1.length ? l1[i] : Integer.MAX_VALUE;
			while (j < l2.length && l2[j] <= maxl1) {
				l3[k] = l2[j];
				k++;
				j++;
			}
		}

		return l3;

	}

	/**
	 * Indique la position d'insertion de elem dans le vecteur trié par ordre
	 * croissant et sans doublon
	 * 
	 * @param v    vecteur d'entier de taille t
	 * @param n    nombre d'éléments dans le vecteur avec n <= t
	 * @param elem
	 * @return position d'insertion
	 */
	/*
	 * public int recherchePos(int[] v, int n, int elem) {
	 * 
	 * }
	 */
	public static void main(String[] args) {
		// initialise un vecteur sans doublon
		int[] v1 = new int[100000];
		for (int i = 0; i < v1.length; i++)
			v1[i] = i;

		long t1 = System.nanoTime();
		sansDoublon(v1);
		long t2 = System.nanoTime();
		sansDoublon(v1, 1000);
		long t3 = System.nanoTime();
		sansDoublonV3(v1);
		long t4 = System.nanoTime();
		System.out.printf("v1: %,15d%n", (t2 - t1));
		System.out.printf("v2: %,15d%n", (t3 - t2));
		System.out.printf("v3: %,15d%n", (t4 - t3));
	}

}

record RMinMax(int min, int max) {
};
