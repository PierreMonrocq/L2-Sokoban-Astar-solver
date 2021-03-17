package elements.caisse;

import elements.terrain.Terrain;
import javafx.util.Pair;

public class DeplacementCaisses {
	public void DeplacementCaisse() {
	}

	public static void deplacement(int x, int y, int dx, int dy) {
		for (Caisse cr : RechercherCaisses.caisses) {
			if (cr.getXPosition() == x && cr.getYPosition() == y) {
				cr.deplacement(dx, dy);
			}
		}
	}

	public static boolean deplacementCaissePossible(int x, int y, int dx, int dy, Character c, Terrain t) {
		for (Caisse cr : RechercherCaisses.caisses) {
			if (cr.getXPosition() == x && cr.getYPosition() == y) {
				Pair<Integer, Integer> coord = new Pair(Integer.valueOf(y + dx), Integer.valueOf(x + dy));
				if (c.charValue() == t.getTerrainYX(y + dx, x + dy) || RechercherCaisses.coordcaisses.contains(coord)) {
					return false;
				}
			}
		}

		return true;
	}
}
