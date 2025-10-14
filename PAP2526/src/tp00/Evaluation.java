package tp00;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Evaluation {

	/**
	 * Calcule la décision sur base de la note
	 * 
	 * @param note un entier entre 0 et 100
	 * @return la décision
	 */
	public static String calculDecision(int note) {
		assert note >= 0 && note <= 100 : "La note doit être entre 0 et 100";
		String res;
		if (note < 30)
			res = "Refus";
		else if (note < 50)
			res = "Ajourné";
		else
			res = "Réussite";
		return res;
	}

	/**
	 * Lancement des exemples
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Création d'un scanner
		Scanner scan = new Scanner(System.in);
		
		//input
		int note = 0;
		boolean erreur;
		do {
			try {
				// lecture d'une note
				System.out.print("Entrez une note: ");
				note = scan.nextInt();
				erreur = note < 0 || note > 100;
				if (erreur)
					System.out.println("Entrez un nombre entre 0 et 100!");
			} catch (InputMismatchException e) {
				System.err.println("ATTENTION CE N'EST PAS UN NOMBRE");
				scan.next();//vide le scanner avec la mauvaise entrée
				erreur = true;
			}
		} while (erreur);

		// traitement
		String decision = calculDecision(note);
		
		// affiche résultat
		System.out.println("La décision est: " + decision);
		scan.close();
	}

}
