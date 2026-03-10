package jeu;

public class Travail {

	// directions possibles
	public enum Direction {
		HORIZONTAL, VERTICAL, DIAGONALE1, DIAGONALE2
	};

	// indique la position de la première lettre du mot et sa direction
	public record PosMot(int x, int y, Direction dir) {
	};

	/**
	 * recherche le mot au sein de la matrice. Hypothèse, le mot existe dans la
	 * matrice et peut être dans une des 4 directions
	 * 
	 * @param grille la matrice avec les lettres
	 * @param mot    un String
	 * @return la position du mot et sa direction
	 */
	public static PosMot chercheMot(char[][] grille, String mot) {
		char[] v = mot.toCharArray();// pour transformer le String en un vecteur de caractères
		PosMot resultat = null;
		char lettre = v[0];
		boolean trouve = false;
		int i = 0;
		int maxI = grille.length - v.length;
		int maxJ = grille[0].length - v.length;
		while (!trouve && i < grille.length) {
			int j = 0;
			while (!trouve && j < grille[0].length) {
				if (grille[i][j] == lettre) {// 1er Lettre OK
					// horizontal
					if (j <= maxJ)
						trouve = rechercheDir(grille, v, i, j, 0, 1);
					if (trouve)
						resultat = new PosMot(i, j, Direction.HORIZONTAL);
					else {
						// diag1
						if (j <= maxJ && i <= maxI)
							trouve = rechercheDir(grille, v, i, j, 1, 1);
						if (trouve)
							resultat = new PosMot(i, j, Direction.DIAGONALE1);
						else {
							// Vert
							if (i <= maxI)
								trouve = rechercheDir(grille, v, i, j, 1, 0);
							if (trouve)
								resultat = new PosMot(i, j, Direction.VERTICAL);
							else {
								// DIAG2
								if (j <= maxJ && i >= v.length - 1)
									trouve = rechercheDir(grille, v, i, j, -1, 1);
								if (trouve)
									resultat = new PosMot(i, j, Direction.DIAGONALE2);
							}
						}
					}
				}
				j++;
			}
			i++;
		}

		return resultat;

	}

	/**
	 * Hypothèse: Cette fonction sera appelée qui s'il reste suffisamment de place
	 * dans la direction donnée
	 * 
	 * @param grille
	 * @param mot
	 * @param x      position(x,y) de la première lettre ds la matrice
	 * @param y
	 * @param dirX   direction => incrément en x et y
	 * @param dirY
	 * @return
	 */
	private static boolean rechercheDir(char[][] grille, char[] mot, int x, int y, int dirX, int dirY) {
		int i = 0;
		do {
			i++;
			x = x + dirX;
			y = y + dirY;
		} while (i < mot.length && grille[x][y] == mot[i]);
		return i == mot.length;
	}

	public static void main(String[] args) {
		String[] mots1 = { "BALLON", "COURSE", "ENTRAINEUR", "GYMNASTIQUE" };
		char[][] grille1 = { 
				{ 'E', 'N', 'T', 'R', 'A', 'I', 'N', 'E', 'U', 'R', 'U' },
				{ 'Q', 'A', 'E', 'P', 'B', 'S', 'Q', 'W', 'O', 'V', 'T' },
				{ 'V', 'T', 'D', 'L', 'C', 'U', 'D', 'Z', 'Y', 'G', 'X' },
				{ 'N', 'Q', 'O', 'X', 'U', 'G', 'X', 'B', 'F', 'O', 'T' },
				{ 'G', 'Y', 'M', 'N', 'A', 'S', 'T', 'I', 'Q', 'U', 'E' },
				{ 'G', 'C', 'S', 'F', 'N', 'A', 'N', 'A', 'S', 'Y', 'D' },
				{ 'D', 'O', 'B', 'A', 'L', 'L', 'O', 'N', 'R', 'Y', 'X' },
				{ 'C', 'U', 'E', 'Q', 'W', 'K', 'F', 'L', 'L', 'H', 'X' },
				{ 'T', 'R', 'U', 'X', 'C', 'P', 'M', 'J', 'E', 'C', 'B' },
				{ 'Z', 'S', 'K', 'R', 'N', 'L', 'W', 'F', 'N', 'T', 'E' },
				{ 'D', 'E', 'H', 'Q', 'X', 'X', 'C', 'C', 'K', 'K', 'J' } };
		// TEST
		for (String s : mots1)
			System.out.println(s+"   "+chercheMot(grille1, s));

		String[] mots2 = { "CYCLISME", "BALLON", "TENNIS", "ATHLETISME","PONXI","BEB" };
		char[][] grille2 = { 
				{ 'B', 'C', 'T', 'N', 'L', 'P', 'I', 'B', 'J', 'A', 'J' },
				{ 'J', 'Y', 'E', 'E', 'E', 'L', 'B', 'Z', 'R', 'T', 'X' },
				{ 'Z', 'C', 'V', 'Q', 'N', 'T', 'X', 'Z', 'H', 'H', 'B' },
				{ 'N', 'L', 'K', 'P', 'F', 'N', 'W', 'C', 'Q', 'L', 'A' },
				{ 'V', 'I', 'O', 'M', 'L', 'A', 'I', 'H', 'J', 'E', 'L' },
				{ 'X', 'S', 'U', 'C', 'M', 'D', 'G', 'S', 'B', 'T', 'L' },
				{ 'A', 'M', 'G', 'P', 'E', 'W', 'X', 'A', 'E', 'I', 'O' },
				{ 'V', 'E', 'B', 'U', 'O', 'B', 'A', 'A', 'R', 'S', 'N' },
				{ 'Q', 'G', 'A', 'B', 'H', 'N', 'W', 'U', 'F', 'M', 'B' },
				{ 'L', 'O', 'N', 'K', 'K', 'F', 'X', 'V', 'I', 'E', 'U' },
				{ 'X', 'L', 'I', 'T', 'W', 'E', 'M', 'I', 'B', 'P', 'W' } };
		// TEST
		for (String s : mots2)
			System.out.println(s+"   "+chercheMot(grille2, s));

	}

}
