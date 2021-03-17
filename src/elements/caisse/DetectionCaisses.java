package elements.caisse;

import affichage.interfaces.ConstructeurAffichage;

public class DetectionCaisses {
	public static boolean detecterFin() {
		for (int i = 0; i < RechercherCaisses.coordcaisses.size(); i++) {
			if (!RechercherCaisses.coordsolspoints.contains(RechercherCaisses.coordcaisses.get(i))) {
				return false;
			}
		}
		return true;
	}

	public static void interactionCaisse() {
		RechercherCaisses.caisseplacee();
		if (detecterFin()) {
			ConstructeurAffichage.retour.setEnabled(false);
			ConstructeurAffichage.bottom.setLayer(ConstructeurAffichage.fin, 1);
		}
	}
}
