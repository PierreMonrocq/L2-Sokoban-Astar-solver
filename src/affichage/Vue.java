package affichage;

import affichage.interfaces.ConstructeurAffichage;
import affichage.interfaces.Theme;
import application.Main;
import elements.caisse.Caisse;
import elements.caisse.DetectionCaisses;
import elements.caisse.RechercherCaisses;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import ressources.ChargerRessources;
import ressources.LecteurJSON;

public class Vue extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	public static char[][] terrain;
	public static final int TAILLE_CASE = 40;
	public static int LARGEUR_TERRAIN;
	public static int HAUTEUR_TERRAIN;
	public static Timer fps;
	public static String color = LecteurJSON.lirePropriete("affichage", "theme");

	public static ChargerRessources cr;

	public Vue(char[][] terrain) {
		Vue.terrain = terrain;
		LARGEUR_TERRAIN = (terrain[0]).length * 40;
		HAUTEUR_TERRAIN = terrain.length * 40;
		Theme.setImagesColor(color);
		fps = new Timer(30, this);
		fps.start();
		Color bgColor = Theme.setBgColor(color);
		setBackground(bgColor);
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.translate(40, 40);
		for (int y = 0; y < terrain.length; y++) {
			for (int x = 0; x < (terrain[0]).length; x++) {
				switch (terrain[y][x]) {
				case '#':
					g.drawImage(ChargerRessources.mur.getImage(), 40 * x, 40 * y, this);
					break;
				case 's':
					g.drawImage(ChargerRessources.sol.getImage(), 40 * x, 40 * y, this);
					break;
				case '.':
					g.drawImage(ChargerRessources.solpoint.getImage(), 40 * x, 40 * y, this);
					break;
				default:
					g.drawImage(ChargerRessources.fondIm.getImage(), 40 * x, 40 * y, this);
					break;
				}

			}
		}
		g.drawImage(Main.p.getImage(), Main.p.getXPosition() * 40, Main.p.getYPosition() * 40, null);
		DetectionCaisses.interactionCaisse();
		for (Caisse caisse : RechercherCaisses.caisses) {
			g.drawImage(caisse.getImage(), caisse.getXPosition() * 40, caisse.getYPosition() * 40, null);
		}
		ConstructeurAffichage.afficheur_deplacement.setText(String.valueOf(Main.p.getNb_deplacements()));
	}
}
