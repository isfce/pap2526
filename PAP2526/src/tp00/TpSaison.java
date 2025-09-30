package tp00;

public class TpSaison {
/**
 * Indique la saison
 * @param jour 1..31
 * @param mois 1..12
 * @return la saison
 */
	public static String calculSaison(int jour, int mois) {
		assert jour>0 && jour <32 && mois>0 && mois<13 :"le mois et ou le jour ne sont pas correct(s)!";
		String saison;
		saison = (mois >= 3 && mois <= 6 && 
				!(mois == 3 && jour < 21) && !(mois == 6 && jour > 20)) ? "Printemps"
				: (mois >= 6 && mois <= 9) &&
				!(mois == 6 && jour < 21) && !(mois == 9 && jour > 22) ? "Eté"
				: (mois >= 9 && mois <= 12) && 
				!(mois == 9 && jour < 23) && !(mois == 12 && jour > 20)? "Automne"
				: "Hiver";
		return saison;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
