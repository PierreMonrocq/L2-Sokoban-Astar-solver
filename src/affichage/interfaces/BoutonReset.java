package affichage.interfaces;

import application.Main;
import elements.caisse.Caisse;
import elements.caisse.RechercherCaisses;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BoutonReset implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Main.p.getListe_deplacements().clear();
		Main.p.setPosition(((Integer) Main.CoordP.getKey()).intValue(), ((Integer) Main.CoordP.getValue()).intValue());
		Main.p.getListe_deplacements().add(Main.CoordP);
		Main.p.setNb_deplacements(0);
		RechercherCaisses.liste_deplacements.clear();
		RechercherCaisses.caisses = cloneCaisse(RechercherCaisses.caisses_init);
		ConstructeurAffichage.bottom.setLayer(ConstructeurAffichage.fin, 0);
	}

	public static ArrayList<Caisse> cloneCaisse(ArrayList<Caisse> caisses) {
		ArrayList<Caisse> clone = new ArrayList<>();
		for (Caisse ca : caisses) {
			Caisse cr = new Caisse(ca.getXPosition(), ca.getYPosition());
			clone.add(cr);
		}
		return clone;
	}
}
