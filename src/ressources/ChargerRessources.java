package ressources;

import affichage.interfaces.ConstructeurAffichage;
import affichage.interfaces.Methodes;
import affichage.interfaces.Theme;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ChargerRessources {
	public static ImageIcon fondIm;
	public static ImageIcon mur;
	public static ImageIcon caisse;
	public static ImageIcon caisseplacee;
	public static ImageIcon sol;
	public static ImageIcon solpoint;
	public static ImageIcon icone_fleche;
	public static ImageIcon icone_fleche_survol;
	public static ImageIcon icone_fleche_desact;
	public static ImageIcon icone_menu;
	public static ImageIcon icone_menu_survol;
	public static ImageIcon icone_param;
	public static ImageIcon icone_croix_survol;
	public static ImageIcon icone_croix;
	public static ImageIcon icone_param_survol;
	public static ImageIcon icone_recom;
	public static ImageIcon icone_recom_survol;
	public static ImageIcon perso1_img;
	public static ImageIcon perso2_img;
	public static ImageIcon perso3_img;
	public static ImageIcon logo;
	public static ImageIcon logoOptions;

	public void chargerImages(String couleur) {
		fondIm = new ImageIcon(load("images/jeu/" + couleur + "/fond.png"));
		mur = new ImageIcon(load("images/jeu/" + couleur + "/mur.png"));
		caisse = new ImageIcon(load("images/jeu/caisse.png"));
		caisseplacee = new ImageIcon(load("images/jeu/caisseplace.png"));
		sol = new ImageIcon(load("images/jeu/" + couleur + "/sol.png"));
		solpoint = new ImageIcon(load("images/jeu/" + couleur + "/solpoint.png"));
		icone_fleche = new ImageIcon(load("images/menu/icone_fleche.png"));
		icone_fleche_survol = new ImageIcon(load("images/menu/icone_fleche_survol.png"));
		icone_fleche_desact = new ImageIcon(load("images/menu/icone_fleche_desact.png"));
		icone_menu = new ImageIcon(load("images/menu/icone_menu.png"));
		icone_menu_survol = new ImageIcon(load("images/menu/icone_menu_survol.png"));
		icone_param = new ImageIcon(load("images/menu/icone_param.png"));
		icone_param_survol = new ImageIcon(load("images/menu/icone_param_survol.png"));
		icone_croix = new ImageIcon(load("images/menu/icone_croix.png"));
		icone_croix_survol = new ImageIcon(load("images/menu/icone_croix_survol.png"));
		icone_recom = new ImageIcon(load("images/menu/icone_recom.png"));
		icone_recom_survol = new ImageIcon(load("images/menu/icone_recom_survol.png"));
		perso1_img = new ImageIcon(load("images/jeu/personnage/personnage.png"));
		perso2_img = new ImageIcon(load("images/jeu/personnage/personnage2.png"));
		perso3_img = new ImageIcon(load("images/jeu/personnage/personnage3.png"));
		logo = new ImageIcon(load("images/menu/logo.png"));
		logoOptions = new ImageIcon(load("images/menu/options.png"));
	}

	public void chargerCouleur(String couleur) {
		Color coul_fond = Theme.setBgColor(couleur);
		ConstructeurAffichage.jeu.setBackground(coul_fond);
		ConstructeurAffichage.options.setBackground(coul_fond);
		ConstructeurAffichage.menuPrincipal.setBackground(coul_fond);
		ConstructeurAffichage.fin.setBackground(coul_fond);

		Color couleur_barre = Theme.getBarreColor(couleur);
		ConstructeurAffichage.barreGUI.setBackground(couleur_barre);

		Color couleurBoutonMenu = Theme.getButColor(couleur);
		Methodes.couleurBouton = couleurBoutonMenu;
		ConstructeurAffichage.joueur.setBackground(couleurBoutonMenu);
		ConstructeurAffichage.joueurIA.setBackground(couleurBoutonMenu);
		ConstructeurAffichage.optionsMenu.setBackground(couleurBoutonMenu);
		ConstructeurAffichage.quitter.setBackground(couleurBoutonMenu);
		ConstructeurAffichage.quitterFin.setBackground(couleurBoutonMenu);
		ConstructeurAffichage.restart.setBackground(couleurBoutonMenu);
		ConstructeurAffichage.suivant.setBackground(couleurBoutonMenu);

		Methodes.couleurBoutonSurvol = Theme.getButSurvolColor(couleur);
	}

	private static Image load(String file) {
		try {
			return ImageIO.read(ChargerRessources.class.getResourceAsStream(file));
		} catch (IOException e) {
			e.printStackTrace();

			return null;
		}
	}
}
