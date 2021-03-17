package affichage;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;

	public Fenetre(JPanel panelAffichage, int largeur_fenetre, int hauteur_fenetre) {
	   setTitle("Sokoban v0.1.7kp");
	   add(panelAffichage);
	   setSize(largeur_fenetre, hauteur_fenetre);
	   setResizable(false);
	   setLocationRelativeTo((Component)null);
	   setDefaultCloseOperation(3);
	   setUndecorated(true);
	   setVisible(true);
	}
}
