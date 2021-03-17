package affichage.interfaces;

import application.Main;
import elements.caisse.Caisse;
import elements.caisse.RechercherCaisses;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.util.Pair;
import javax.swing.JButton;

public class BoutonRetour implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (Main.p.getListe_deplacements().size() >= 2) {
			Pair<Integer, Integer> dernier_element_joueur = Main.p.getListe_deplacements()
					.get(Main.p.getListe_deplacements().size() - 2);
			Main.p.setPosition(((Integer) dernier_element_joueur.getKey()).intValue(),
					((Integer) dernier_element_joueur.getValue()).intValue());
			Main.p.getListe_deplacements().remove(Main.p.getListe_deplacements().size() - 1);
			Main.p.getListe_deplacements().remove(Main.p.getListe_deplacements().size() - 1);
			Main.p.getListe_deplacements()
					.add(new Pair(Integer.valueOf(Main.p.getXPosition()), Integer.valueOf(Main.p.getYPosition())));
			Main.p.setNb_deplacements(Main.p.getNb_deplacements() - 1);
			if (RechercherCaisses.liste_deplacements.size() >= 1) {
				ArrayList<Caisse> dernier_element_caisses = RechercherCaisses.getListe_deplacements()
						.get(RechercherCaisses.liste_deplacements.size() - 1);
				RechercherCaisses.caisses = dernier_element_caisses;
				RechercherCaisses.liste_deplacements.remove(RechercherCaisses.liste_deplacements.size() - 1);
			}
			if (Main.p.getListe_deplacements().size() == 1) {
				Object source = e.getSource();
				if (source instanceof JButton)
					((JButton) source).setEnabled(false);
			}
		}
	}
}
