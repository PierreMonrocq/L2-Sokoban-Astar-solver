package elements.personnage;

import affichage.interfaces.ConstructeurAffichage;
import application.Main;
import elements.caisse.DeplacementCaisses;
import elements.caisse.RechercherCaisses;
import elements.terrain.Terrain;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PersonnageControlleur extends KeyAdapter {
	private Personnage p;
	private Terrain t;
	private Character c;

	public void controllerPersonnage(Personnage personnage) {
		this.p = personnage;
	}

	public void ajouterContraintes(Terrain terrain, Character colision) {
		this.t = terrain;
		this.c = colision;
	}

	public void keyTyped(KeyEvent e) {
		char touche_clavier = e.getKeyChar();

		if (Main.etat.getCourrant().equals("Jeu")) {
			if ((touche_clavier == 'z' || touche_clavier == 'Z')
					&& this.c.charValue() != this.t.getTerrainYX(this.p.getYPosition() - 1, this.p.getXPosition())
					&& DeplacementCaisses.deplacementCaissePossible(this.p.getXPosition(), this.p.getYPosition() - 1,
							-1, 0, this.c, this.t)) {
				RechercherCaisses.ajouterDeplacement(RechercherCaisses.caisses);
				this.p.deplacement(0, -1);
				ConstructeurAffichage.retour.setEnabled(true);
				DeplacementCaisses.deplacement(this.p.getXPosition(), this.p.getYPosition(), 0, -1);
			}

			if ((touche_clavier == 'q' || touche_clavier == 'Q')
					&& this.c.charValue() != this.t.getTerrainYX(this.p.getYPosition(), this.p.getXPosition() - 1)
					&& DeplacementCaisses.deplacementCaissePossible(this.p.getXPosition() - 1, this.p.getYPosition(), 0,
							-1, this.c, this.t)) {
				RechercherCaisses.ajouterDeplacement(RechercherCaisses.caisses);
				this.p.deplacement(-1, 0);
				ConstructeurAffichage.retour.setEnabled(true);
				DeplacementCaisses.deplacement(this.p.getXPosition(), this.p.getYPosition(), -1, 0);
			}

			if ((touche_clavier == 's' || touche_clavier == 'S')
					&& this.c.charValue() != this.t.getTerrainYX(this.p.getYPosition() + 1, this.p.getXPosition())
					&& DeplacementCaisses.deplacementCaissePossible(this.p.getXPosition(), this.p.getYPosition() + 1, 1,
							0, this.c, this.t)) {
				RechercherCaisses.ajouterDeplacement(RechercherCaisses.caisses);
				this.p.deplacement(0, 1);
				ConstructeurAffichage.retour.setEnabled(true);
				DeplacementCaisses.deplacement(this.p.getXPosition(), this.p.getYPosition(), 0, 1);
			}

			if ((touche_clavier == 'd' || touche_clavier == 'D')
					&& this.c.charValue() != this.t.getTerrainYX(this.p.getYPosition(), this.p.getXPosition() + 1)
					&& DeplacementCaisses.deplacementCaissePossible(this.p.getXPosition() + 1, this.p.getYPosition(), 0,
							1, this.c, this.t)) {
				RechercherCaisses.ajouterDeplacement(RechercherCaisses.caisses);
				this.p.deplacement(1, 0);
				ConstructeurAffichage.retour.setEnabled(true);
				DeplacementCaisses.deplacement(this.p.getXPosition(), this.p.getYPosition(), 1, 0);
			}
		}
	}
}
