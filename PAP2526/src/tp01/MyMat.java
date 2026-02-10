package tp01;

public class MyMat {
	/**
	 * @param mat Affichage d'une matrice plus esthétique matrice n*m
	 */
	public static void afficheMat(int[][] mat) {
		// Définir les caractères pour les bordures
		char bordureHorizontale = '\u2550';
		char bordureVerticale = '\u2551';
		char croixHorizVert = '\u256C';
		// nbr de colonnes
		int m = mat[0].length;
		// nombre de caractères max pour une donnée de mat
		int nb = nbMaxChar(mat) + 1;
		// max car pour afficher l'indice de ligne
		int maxCarLigne = Integer.toString(mat.length).length();
		// max car pour la 1ère colonne de la matrice
		int maxCarColonne1 = nbMaxCharCol1(mat) + 1;

		// début coin sup gauche
		System.out.printf("%" + maxCarLigne + "s" + bordureVerticale, " ");
		// indice de colonne avec un écart minimum pour la 1ère colonne
		for (int j = 0; j < m; j++) {
			int nbr = j == 0 ? maxCarColonne1 : nb;
			System.out.printf("%" + nbr + "d", j);
		}
		System.out.println();
		// Affichage d'une ligne horizontale de séparation
		int cpt = maxCarLigne;
		for (int j = 0; j < cpt; j++)
			System.out.print(bordureHorizontale);
		// La croix
		System.out.print(croixHorizVert);
		// La suite de la ligne horizontale
		cpt = m * nb;
		for (int j = 0; j < cpt; j++)
			System.out.print(bordureHorizontale);

		System.out.println();
		// la matrice avec les entêtes de ligne
		for (int i = 0; i < mat.length; i++) {
			// entête de ligne et séparation
			System.out.printf("%" + maxCarLigne + "d" + bordureVerticale, i);
			for (int j = 0; j < m; j++) {
				// les données en ligne avec le minimum d'espace pour la 1ère colonne
				int nbr = j == 0 ? maxCarColonne1 : nb;
				System.out.printf("%" + nbr + "d", mat[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Pour l'affichage afficheMat Retourne le nombre maximum de caractères des
	 * nombres de la matrice
	 * 
	 * @param mat
	 * @return
	 */
	private static int nbMaxChar(int[][] mat) {
		int maxi = 1;
		for (int[] v : mat)
			for (int elem : v)
				maxi = Math.max(maxi, Integer.toString(elem).length());
		return maxi;
	}

	/**
	 * Pour l'affichage afficheMat nbr maimum de caractères pour la 1ère colonne de
	 * la matrice
	 * 
	 * @param mat
	 * @return
	 */
	private static int nbMaxCharCol1(int[][] mat) {
		int maxi = 1;
		for (int i = 0; i < mat.length; i++)
			maxi = Math.max(maxi, Integer.toString(mat[i][0]).length());
		return maxi;
	}

	/**
	 * Recherche le plus petit élément dans le vecteur
	 * 
	 * @param m matrice d'entier
	 * @return plus petit élément
	 */
	public static int rechercheMin(int[][] m) {
		int mini = m[0][0];
		for (int[] v : m)
			for (int e : v)
				if (e < mini)
					mini = e;
		return mini;
	}

	/**
	 * Retourne true si e existe dans la matrice
	 * 
	 * @param m matrice non nulle
	 * @param e l'entier à rechercher
	 * @return
	 */
	public static boolean existeInMat(int[][] m, int e) {
		boolean trouve = false;
		int j, i = 0;
		while (!trouve && i < m.length) {
			j = 0;
			while (!trouve && j < m[i].length) {
				/*
				 * trouve = m[i][j] == e; j++;
				 */
				if (m[i][j] == e)
					trouve = true;
				else
					j++;
			}
			i++;
		}
		return trouve;
	}

	/**
	 * Vérifie si une matrice carrée est symétrique
	 * 
	 * @param m matrice carrée
	 * @return true si symétrique
	 */
	public static boolean estSymetrique(int[][] m) {
		boolean sym = true;
		int j, i = 1;
		while (sym && i < m.length) {
			j = 0;
			while (sym && j < i) {
				if (m[i][j] != m[j][i])
					sym = false;
				else
					j++;
				/*
				 * sym = m[i][j] == m[j][i]; j++;
				 */
			}
			i++;
		}
		return sym;
	}

	/**
	 * Valide une séquence de chiffres
	 * 
	 * @param v la séquence de chiffres
	 * @param m une matrice 10 sur 10 de booléens (transition de i->j)
	 * @return true si valide
	 */
	public static boolean validerSeq(int[] v, boolean[][] m) {
		boolean valide = true;
		int i = 0;
		while (valide && i < v.length - 1) {
			valide = m[v[i]][v[i + 1]];
			i++;
		}
		return valide;
	}

	public static void main(String[] args) {
		int[][] m1 = { { 5, 3, 2 }, { 1, 7, 2 } };
		afficheMat(m1);
	}

}
