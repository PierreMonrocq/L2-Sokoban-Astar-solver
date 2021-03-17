package application;

import affichage.Fenetre;
import elements.caisse.RechercherCaisses;
import elements.personnage.Personnage;
import elements.personnage.PersonnageControlleur;
import elements.terrain.Terrain;
import java.awt.event.KeyListener;

public class Controlleur {
	private static PersonnageControlleur pc;
	private static RechercherCaisses ac;
	private final Character id_element_collision = Character.valueOf('#');
	public Fenetre f;

	public Controlleur(Fenetre fenetre) {
		this.f = fenetre;
	}

	public void gererControlesPersonnages(Personnage p) {
		pc = new PersonnageControlleur();
		this.f.addKeyListener((KeyListener) pc);
		pc.controllerPersonnage(p);
		this.f.validate();
	}

	public void gererCollision(Terrain terrain) {
		pc.ajouterContraintes(terrain, this.id_element_collision);
	}

	public void gererCaisse(char[][] terrain) {
		ac = new RechercherCaisses(terrain);
		RechercherCaisses.genererCaisse();
		RechercherCaisses.genererCoordSol();
	}
}
