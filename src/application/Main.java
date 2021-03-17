package application;

import affichage.AdaptationAffichage;
import affichage.Fenetre;
import affichage.Vue;
import affichage.interfaces.ConstructeurAffichage;
import elements.personnage.Personnage;
import elements.terrain.Terrain;
import java.util.ArrayList;
import javafx.util.Pair;
import javax.swing.JPanel;
import ressources.LecteurJSON;

public class Main {
	public static final String VERSION = "v0.1.7kp";
	public static Personnage p;
	public static Pair<Integer, Integer> CoordP;
	public static Terrain t;
	public static Fenetre fenetre;
	public static final String image_perso = "images/jeu/personnage/personnage.png";
	public static LecteurJSON param = new LecteurJSON("param.json");
	public static int HAUTEUR_FENETRE = 650;
	public static int LARGEUR_FENETRE = 580;

	public static ConstructeurAffichage affichageMultiple;

	public static Controlleur c;
	public static Etat etat;
	public static char[][] classic = new char[][] { { ' ', ' ', '#', '#', '#', '#', '#', ' ' },
			{ '#', '#', '#', ' ', ' ', ' ', '#', ' ' }, { '#', '.', '@', '$', ' ', ' ', '#', ' ' },
			{ '#', '#', '#', ' ', '$', '.', '#', ' ' }, { '#', '.', '#', '#', '$', ' ', '#', ' ' },
			{ '#', ' ', '#', ' ', '.', ' ', '#', '#' }, { '#', '$', ' ', '*', '$', '$', '.', '#' },
			{ '#', ' ', ' ', ' ', '.', ' ', ' ', '#' }, { '#', '#', '#', '#', '#', '#', '#', '#' } };

	public static char[][] tuto = new char[][] { { ' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', '#', '.', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', '#', '$', '#', '#', '#', '#', ' ', ' ', ' ', ' ' },
			{ '#', '#', '#', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ' },
			{ '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', '#', '#', ' ' },
			{ '#', ' ', '.', ' ', ' ', ' ', '.', ' ', ' ', '$', ' ', '#', ' ' },
			{ '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '#', ' ' },
			{ '#', '#', ' ', '$', ' ', '@', ' ', ' ', ' ', '#', '#', '#', ' ' },
			{ ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ' },
			{ ' ', ' ', '#', ' ', ' ', '$', ' ', '.', ' ', '#', '#', '#', '#' },
			{ ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
			{ ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '$', ' ', '#' },
			{ ' ', ' ', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
			{ ' ', ' ', ' ', ' ', '#', '.', ' ', ' ', '$', '#', '#', '#', '#' },
			{ ' ', ' ', ' ', ' ', '#', '#', '#', ' ', ' ', '#', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', '#', '#', ' ', ' ', ' ' } };

	public static char[][] t3 = new char[][] {
			{ ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', '#', '$', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', '#', '#', '#', ' ', ' ', '$', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', '#', ' ', ' ', '$', ' ', '$', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ '#', '#', '#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', ' ', ' ', '#', '#', '#', '#', '#', '#' },
			{ '#', ' ', ' ', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', ' ', '.', '.', '#' },
			{ '#', ' ', '$', ' ', ' ', '$', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '.', '#' },
			{ '#', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', '@', '#', '#', ' ', ' ', '.', '.', '#' },
			{ ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
			{ ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' } };

	public static char[][] ecureil = new char[][] { { ' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', '#', '#', ' ', '#', ' ', '#', '#', '#', '#' },
			{ ' ', '#', '#', ' ', ' ', '#', '#', '#', ' ', ' ', '#' },
			{ '#', '#', ' ', '$', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
			{ '#', ' ', ' ', ' ', '@', '$', ' ', '#', ' ', ' ', '#' },
			{ '#', '#', '#', ' ', '$', '#', '#', '#', ' ', ' ', '#' },
			{ ' ', ' ', '#', ' ', ' ', '#', '.', '.', ' ', ' ', '#' },
			{ ' ', '#', '#', ' ', '#', '#', '.', '#', ' ', '#', '#' },
			{ ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ' },
			{ ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', ' ' },
			{ ' ', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ' } };

	public static char[][] pave = new char[][] { { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
			{ '#', '.', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '$', ' ', '#' },
			{ '#', ' ', '$', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '#' },
			{ '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '$', '#' },
			{ '#', ' ', ' ', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
			{ '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '.', '#' },
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' } };

	public static char[][] t_util;

	public static ArrayList<char[][]> allTerrain = (ArrayList) new ArrayList<>();

	public static void main(String[] args) {
		LecteurJSON.lireCouleur();

		allTerrain.add(pave);
		allTerrain.add(tuto);
		allTerrain.add(classic);
		allTerrain.add(t3);
		allTerrain.add(ecureil);

		t_util = allTerrain.get(0);
		t = new Terrain(t_util);
		t.ajoutFinTableau();
		t.mettreSol();

		CoordP = t.coordTerrainPersonnage();
		p = new Personnage(((Integer) CoordP.getKey()).intValue(), ((Integer) CoordP.getValue()).intValue(),
				"images/jeu/personnage/personnage.png");

		affichageMultiple = new ConstructeurAffichage((JPanel) new Vue(t.getTerrain()), "Gris", LARGEUR_FENETRE,
				HAUTEUR_FENETRE, AdaptationAffichage.calculerLargeurFenetre(t.getHauteur()),
				AdaptationAffichage.calculerHauteurFenetre(t.getLargeur()), param);
		fenetre = new Fenetre((JPanel) affichageMultiple, LARGEUR_FENETRE, HAUTEUR_FENETRE);

		c = new Controlleur(fenetre);
		c.gererCaisse(t.getTerrain());
		c.gererControlesPersonnages(p);
		c.gererCollision(t);

		etat = new Etat("MenuP", "MenuP");
	}
}
