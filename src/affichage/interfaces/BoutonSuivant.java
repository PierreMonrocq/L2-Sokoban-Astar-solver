package affichage.interfaces;

import affichage.AdaptationAffichage;
import affichage.Vue;
import application.Main;
import elements.caisse.RechercherCaisses;
import elements.terrain.Terrain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonSuivant implements ActionListener {
	public Terrain t_suiv;

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < Main.allTerrain.size(); i++) {
			if (Main.t_util == Main.allTerrain.get(i)) {
				if (i == Main.allTerrain.size() - 1) {
					char[][] arrayOfChar = Main.allTerrain.get(0);
					Main.t_util = arrayOfChar;
					this.t_suiv = new Terrain(arrayOfChar);
					break;
				}
				char[][] t_util_suiv = Main.allTerrain.get(i + 1);
				Main.t_util = t_util_suiv;
				this.t_suiv = new Terrain(t_util_suiv);

				break;
			}
		}
		this.t_suiv.ajoutFinTableau();
		this.t_suiv.mettreSol();
		Main.CoordP = this.t_suiv.coordTerrainPersonnage();
		Main.p.setPosition(((Integer) Main.CoordP.getKey()).intValue(), ((Integer) Main.CoordP.getValue()).intValue());
		Main.p.getListe_deplacements().clear();
		Main.p.setNb_deplacements(0);
		RechercherCaisses.liste_deplacements.clear();

		Main.c.gererCaisse(this.t_suiv.getTerrain());
		Main.c.gererCollision(this.t_suiv);

		Vue.LARGEUR_TERRAIN = (this.t_suiv.getTerrain()[0]).length * 40;
		Vue.HAUTEUR_TERRAIN = (this.t_suiv.getTerrain()).length * 40;

		Main.fenetre.setSize(AdaptationAffichage.calculerLargeurFenetre(Vue.LARGEUR_TERRAIN),
				AdaptationAffichage.calculerHauteurFenetre(Vue.HAUTEUR_TERRAIN));
		Main.fenetre.setLocationRelativeTo(null);
		Vue.terrain = this.t_suiv.getTerrain();

		ConstructeurAffichage.bottom.setLayer(ConstructeurAffichage.fin, 0);
	}
}
