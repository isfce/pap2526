package tp00;

import java.util.Scanner;

public class Evaluation {

	/**
	 * Calcule la décision sur base de la note
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
	 * @param args
	 */
	public static void main(String[] args) {
		//Création d'un scanner
		Scanner scan = new Scanner(System.in);
		//lecture d'une note
		System.out.print("Entrez une note: ");
		int note = scan.nextInt();
		//traitement
		String decision = calculDecision(note);
		//affiche résultat
		System.out.println("La décision est: " + decision);
		scan.close();
	}

}
