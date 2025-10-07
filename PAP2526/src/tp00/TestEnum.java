package tp00;

import util.Forme;

public class TestEnum {

	public static void main(String[] args) {
		Forme f1 = Forme.COEUR;

		String res = switch (f1) {
		case PIQUE, TREFFLE -> {
			System.out.println("Branche N");
			yield "NOIR";
		}
		case CARREAU, COEUR -> {
			System.out.println("Branche R");
			yield "ROUGE";
		}
		};

		System.out.println(res);

	}
}
