package affichage;

public class AdaptationAffichage {
	public static double calculerLargeurAffichage(int taille_largeur_fenetre, int taille_largeur_terrain) {
		double percentage = taille_largeur_terrain / taille_largeur_fenetre;
		double espaces = (1.0D - percentage) / 2.0D;
		return espaces * taille_largeur_fenetre;
	}

	public static double calculerLargeurAffichageIA(int taille_largeur_fenetre, int taille_largeur_terrain) {
		double percentage = taille_largeur_terrain / taille_largeur_fenetre;
		double espaces = (1.0D - percentage) / 4.0D;
		return espaces * taille_largeur_fenetre;
	}

	public static int calculerLargeurFenetre(int taille_largeur_terrain) {
		return taille_largeur_terrain + 90;
	}

	public static int calculerHauteurFenetre(int taille_hauteur_terrain) {
		return taille_hauteur_terrain + 161;
	}

	public static int calculerLargeurFenetreIA(int taille_largeur_terrain) {
		return taille_largeur_terrain * 2 + 130;
	}

	public static int calculerHauteurFenetreIA(int taille_hauteur_terrain) {
		return taille_hauteur_terrain + 60 + 77 + 10;
	}
}
