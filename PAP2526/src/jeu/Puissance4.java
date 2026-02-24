package jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Jeu de puissance 4 version 0.01
 */
public class Puissance4 {
	// codes des cases ==> static car idem pour tous les objets et fixe
	private static final int BORDURE = -1;
	private static final int VIDE = 0;
	private static final int JAUNE = 1;
	private static final int ROUGE = 2;
	// Joueur
	private final String joueurJaune;
	private final String joueurRouge;
	// Tour
	private boolean tour;
	private static final boolean TOUR_DES_JAUNES = true;
	private static final boolean TOUR_DES_ROUGES = !TOUR_DES_JAUNES;
	// ETAT
	private boolean fin;
	private boolean gagne;
	// Pions
	private static final int NB_CASES = 6 * 7;
	private int nbPions;
	// Position du dernier pion
	private int lignePion;
	private int colonnePion;

	// le plateau de jeu avec une bordure (-1)
	private int[][] jeu = new int[8][9];

	// Scanner pour les entrées de l'utilisateur
	private Scanner scan;

	/**
	 * Création d'une nouvelle partie	
	 * @param string
	 * @param string2
	 */
	public Puissance4(String joueur1, String joueur2) {
		this.joueurJaune = joueur1;
		this.joueurRouge = joueur2;
		initPartie();
		scan = new Scanner(System.in);
	}

	/**
	 * Initialise une partie avec les mêmes joueurs
	 */
	private void initPartie() {
		tour = Math.random() < 0.5 ? TOUR_DES_JAUNES : TOUR_DES_ROUGES;
		initJeu();// initialise la matrice
		fin = false;
		gagne = false;
		nbPions = 0;
	}

	// affiche le jeu
	private void afficheJeu() {
		int[][] mat = jeu;
		System.out.println("-----------------------------------------------------");
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
		for (int j = 1; j < m - 1; j++) {
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
		cpt = (m - 1) * nb;
		for (int j = 1; j < cpt; j++)
			System.out.print(bordureHorizontale);

		System.out.println();
		// la matrice avec les entêtes de ligne
		for (int i = 1; i < mat.length - 1; i++) {
			// entête de ligne et séparation
			System.out.printf("%" + maxCarLigne + "d" + bordureVerticale, i);
			for (int j = 1; j < m - 1; j++) {
				// les données en ligne avec le minimum d'espace pour la 1ère colonne
				int nbr = j == 0 ? maxCarColonne1 : nb;
				if (mat[i][j] != 0)
					System.out.printf("%" + nbr + "d", mat[i][j]);
				else
					System.out.printf("%" + nbr + "s", ' ');
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------------");
	}

	/**
	 * Pour l'affichage du jeu
	 * Retourne le nombre maximum de caractères des nombres de la matrice
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
	 * Pour l'affichage du jeu
	 * nbr maimum de caractères pour la 1ère colonne de la matrice
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
	 * Crée une bordure avec des -1 et des 0 ailleurs
	 *  temporairement avec une visibilité "public"
	 */
	private void initJeu() {
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 9; j++)
				if (i == 0 || i == 7 || j == 0 || j == 8)
					jeu[i][j] = BORDURE;
				else
					jeu[i][j] = VIDE;
	}

	/**
	 * Doit insérer le pion dans le jeu et
	 * mettre à jour la position du pion inséré (lignePion,colonnePion)
	 * @param couleur  1 jaune et 2 rouge
	 * @param colonne  1..7
	 * @return true si le coup est valable
	 */
	public boolean insertPion(int couleur, int colonne) {
		if (jeu[1][colonne] != VIDE)
			return false;
		int i = 2;
		// cherche une case occupée
		while (jeu[i][colonne] == VIDE)
			i++;
		i--; // case d'insertion
		jeu[i][colonne] = couleur;
		// maj de la position du pion dans le jeu
		this.lignePion = i;
		this.colonnePion = colonne;
		return true;
	}

	/**
	 * Lancement d'une partie innitialisée
	 */
	private void start() {
		if (fin) {
			System.out.println("Lancement d'une nouvelle partie!");
			initPartie();
		}
		boolean ok;
		while (!fin) {
			afficheJeu();
			do {
				// choix d'une colonne par un joueur (1..7)
				int col = choisirColonne();
				ok = insertPion(pionJoueur(), col);
				if (!ok)
					System.out.println("La colonne est déjà pleine!!");
			} while (!ok);
			nbPions++;// un pion en plus dans le jeu
			gagne = quatreALaSuite();
			fin = gagne || nbPions == NB_CASES;
			if (!fin)// changement joueur
				tour = !tour;
		}
		afficheJeu();
		if (gagne)
			System.out.println("Bravo " + nomJoueur() + " vous avez gagné!!");
		else
			System.out.println("Pas de gagnant");
	}

	/**
	 * Retourne true si au moins 4 pions à la suite pour
	 * le joueur actuel (tour)
	 * @return true si gagné
	 */
	private boolean quatreALaSuite() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Retourne le code du pion du joueur dont c'est le tour
	 * @return
	 */
	private int pionJoueur() {
		return tour == TOUR_DES_JAUNES ? JAUNE : ROUGE;
	}

	/**
	 * Retourne le nom du joueur dont c'est le tour
	 * @return
	 */
	private String nomJoueur() {
		return tour == TOUR_DES_JAUNES ? joueurJaune : joueurRouge;
	}

	/**
	 * Retourne un choix de colonne entre 1 et 7
	 * @return 1..7
	 */
	private int choisirColonne() {
		int colonne = 0;
		boolean bad = false;
		System.out.print(nomJoueur() + ", Entrez un numéro de colonne 1..7: ");
		do {
			try {
				colonne = scan.nextInt();
				bad = colonne < 1 || colonne > 7;
			} catch (InputMismatchException e) {
				bad = true;
				scan.next();// vide le mauvais caractère du buffer
			}
			System.out.println();
			if (bad)
				System.out.print("ERREUR, Entrez un nombre entre 1 et 7: ");
		} while (bad);

		return colonne;
	}

	public static void main(String[] args) {
		Puissance4 partie = new Puissance4("Waf", "Vo");
		partie.start();
		// partie.afficheListeDesCoups();

		// partie.start();

	}

}
