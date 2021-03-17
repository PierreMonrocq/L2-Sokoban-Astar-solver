package affichage.interfaces;

import affichage.AdaptationAffichage;
import application.Main;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class SelectionMenu implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source instanceof JButton) {
			String selection = ((JButton) source).getText();
			CardLayout cl = (CardLayout) Main.affichageMultiple.getLayout();
			switch (selection) {
			case "1 JOUEUR":
				cl.show(Main.affichageMultiple, "Jeu");
				Main.fenetre.setSize(AdaptationAffichage.calculerLargeurFenetre(Main.t.getHauteur()),
						AdaptationAffichage.calculerHauteurFenetre(Main.t.getLargeur()));
				Main.etat.setCourrant("Jeu");
				break;
			case "1 JOUEUR VS IA":
				Main.fenetre.setSize(AdaptationAffichage.calculerLargeurFenetreIA(Main.t.getHauteur()),
						AdaptationAffichage.calculerHauteurFenetreIA(Main.t.getLargeur()));

				cl.show(Main.affichageMultiple, "JeuIA");
				Main.etat.setCourrant("JeuIA");
				break;
			case "OPTIONS":
				cl.show(Main.affichageMultiple, "MenuO");
				break;
			case "QUITTER":
				System.exit(0);
				break;
			}
		}
	}
}