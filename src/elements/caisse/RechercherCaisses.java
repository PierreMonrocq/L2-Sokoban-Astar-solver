package elements.caisse;

import java.util.ArrayList;
import javafx.util.Pair;

public class RechercherCaisses {
	public static char[][] terrain;
	public static ArrayList<Caisse> caisses;
	public static ArrayList<Caisse> caisses_init;
	public static ArrayList<Pair<Integer, Integer>> coordcaisses;
	public static ArrayList<Pair<Integer, Integer>> coordsolspoints;
	public static ArrayList<ArrayList<Caisse>> liste_deplacements = new ArrayList<>();
	private int taille_liste_deplacements = 10;

	public RechercherCaisses(char[][] terrain) {
		RechercherCaisses.terrain = terrain;
	}

	public static void genererCaisse() {
		caisses = new ArrayList<>();
		caisses_init = new ArrayList<>();
		for (int y = 0; y < terrain.length; y++) {
			for (int x = 0; x < (terrain[0]).length; x++) {
				Caisse ca = new Caisse(x, y);
				Caisse ca_init = new Caisse(x, y);
				if (terrain[y][x] == '$') {
					caisses.add(ca);
					caisses_init.add(ca_init);
					terrain[y][x] = 's';
				}
				if (terrain[y][x] == '*') {
					caisses.add(ca);
					caisses_init.add(ca_init);
					terrain[y][x] = '.';
				}
			}
		}
	}

	public static void gererCoordCaisses() {
		coordcaisses = new ArrayList<>();
		for (Caisse caisse : caisses) {
			Pair<Integer, Integer> coordcaisseseule = new Pair(Integer.valueOf(caisse.getYPosition()),
					Integer.valueOf(caisse.getXPosition()));
			coordcaisses.add(coordcaisseseule);
		}
	}

	public static void genererCoordSol() {
		coordsolspoints = new ArrayList<>();
		for (int y = 0; y < terrain.length; y++) {
			for (int x = 0; x < (terrain[0]).length; x++) {
				if (terrain[y][x] == '.') {
					Pair<Integer, Integer> coordsolpoint = new Pair(Integer.valueOf(y), Integer.valueOf(x));
					coordsolspoints.add(coordsolpoint);
				}
			}
		}
	}

	public static void caisseplacee() {
		gererCoordCaisses();
		for (int i = 0; i < coordcaisses.size(); i++) {
			if (coordsolspoints.contains(coordcaisses.get(i))) {
				((Caisse) caisses.get(i)).place();
			} else {
				((Caisse) caisses.get(i)).nonplace();
			}
		}
	}

	public static void ajouterDeplacement(ArrayList<Caisse> caisses) {
		ArrayList<Caisse> clone = new ArrayList<>();
		for (Caisse ca : caisses) {
			Caisse cr = new Caisse(ca.getXPosition(), ca.getYPosition());
			clone.add(cr);
		}
		liste_deplacements.add(clone);
	}

	public static ArrayList<ArrayList<Caisse>> getListe_deplacements() {
		return liste_deplacements;
	}

	public int getTaille_liste_deplacements() {
		return this.taille_liste_deplacements;
	}

	public void setTaille_liste_deplacements(int taille_liste_deplacements) {
		this.taille_liste_deplacements = taille_liste_deplacements;
	}
}