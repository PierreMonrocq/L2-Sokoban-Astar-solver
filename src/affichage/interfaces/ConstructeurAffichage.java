package affichage.interfaces;

import affichage.AdaptationAffichage;
import application.Main;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import ressources.ChargerRessources;
import ressources.LecteurJSON;
import ressources.Music;

public class ConstructeurAffichage extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public static JLabel afficheur_deplacement;
	public static JButton retour;
	public static JLayeredPane bottom;
	public static JButton joueur;
	public static JButton joueurIA;
	public static JButton optionsMenu;
	public static JButton quitter;
	public static JPanel fin;
	public static JPanel options;
	public static JPanel interfaceJeu;
	public static JPanel jeu;
	public static JPanel barreGUI;
	public static JPanel quitterm;
	public static JPanel menuPrincipal;
	public static final String JOUEUR = "1 JOUEUR";
	public static final String JOUEURIA = "1 JOUEUR VS IA";
	public static final String OPTIONS = "OPTIONS";
	public static final String QUITTER = "QUITTER";
	public static JButton quitterFin;
	public static JButton restart;
	public static JButton suivant;
	public static Music m;

	public ConstructeurAffichage(JPanel panelJeu, String theme, int largeur, int hauteur, int largeurT, int hauteurT,
			LecteurJSON jsonParam) {
		setLayout(new CardLayout());
		JPanel menu = creerEtAfficherMenuPrincipal(largeur, theme);
		add(menu, "MenuP");
		JPanel fin = creerEtAfficherFin(largeur, hauteur, theme);
		JPanel param = creerEtAfficherParam(largeur, hauteur, theme);
		add(param, "MenuO");
		JPanel jeu = creerEtAfficherJeu(panelJeu, fin, largeurT, hauteurT, theme);
		add(jeu, "Jeu");
		setBorder(BorderFactory.createMatteBorder(4, 5, 4, 5, new Color(246, 229, 141)));
	}

	public static JPanel creerEtAfficherJeu(JPanel jeu, JPanel fin, int largeur_fenetre, int hauteur_fenetre,
			String theme) {
		interfaceJeu = new JPanel();
		interfaceJeu.setLayout(new BorderLayout());
		ConstructeurAffichage.jeu = jeu;

		jeu.setOpaque(true);
		jeu.setBounds(0, 0, largeur_fenetre, hauteur_fenetre);
		jeu.setBackground(Theme.setBgColor(theme));

		bottom = new JLayeredPane();
		bottom.setOpaque(true);
		bottom.setLayout((LayoutManager) null);
		bottom.add(jeu, new Integer(0));
		bottom.add(fin, new Integer(-1));

		barreGUI = new JPanel();
		barreGUI.setBackground(Theme.getBarreColor(theme));
		barreGUI.setPreferredSize(new Dimension(0, 76));
		barreGUI.setLayout((LayoutManager) null);

		afficheur_deplacement = new JLabel();
		afficheur_deplacement.setFont(new Font("Verdana", 1, 25));
		afficheur_deplacement.setForeground(new Color(236, 240, 241));

		JButton menu = Methodes.creerBouton("", 40, 40, ChargerRessources.icone_menu,
				ChargerRessources.icone_menu_survol, null);
		JButton param = Methodes.creerBouton("", 40, 40, ChargerRessources.icone_param,
				ChargerRessources.icone_param_survol, null);
		JButton recom = Methodes.creerBouton("", 40, 40, ChargerRessources.icone_recom,
				ChargerRessources.icone_recom_survol, null);

		retour = Methodes.creerBouton("", 75, 40, ChargerRessources.icone_fleche, ChargerRessources.icone_fleche_survol,
				ChargerRessources.icone_fleche_desact);
		retour.setEnabled(false);
		retour.addActionListener(new BoutonRetour());

		param.addActionListener(e -> {
			CardLayout cl = (CardLayout) Main.affichageMultiple.getLayout();

			cl.show(Main.affichageMultiple, "MenuO");
			Main.etat.setCourrant("MenuP");
			Main.etat.setPrecedent("Jeu");
			Main.fenetre.setSize(Main.LARGEUR_FENETRE, Main.HAUTEUR_FENETRE);
		});
		menu.addActionListener(e -> {
			CardLayout cl = (CardLayout) Main.affichageMultiple.getLayout();

			cl.show(Main.affichageMultiple, "MenuP");

			Main.etat.setCourrant("MenuP");
			Main.etat.setPrecedent("MenuP");
			Main.fenetre.setSize(Main.LARGEUR_FENETRE, Main.HAUTEUR_FENETRE);
		});
		recom.addActionListener(new BoutonReset());

		barreGUI.add(Box.createRigidArea(new Dimension(10, 67)));
		barreGUI.add(menu);
		menu.setBounds(20, 18, 40, 40);
		barreGUI.add(param);
		param.setBounds(80, 18, 40, 40);
		barreGUI.add(retour);
		retour.setBounds(140, 18, 75, 40);
		barreGUI.add(afficheur_deplacement);
		afficheur_deplacement.setBounds(largeur_fenetre / 2 - 10, 18, 150, 40);
		barreGUI.add(recom);
		recom.setBounds(largeur_fenetre - 70, 18, 40, 40);

		interfaceJeu.add(barreGUI, "First");
		interfaceJeu.add(bottom, "Center");
		return interfaceJeu;
	}

	public static JPanel creerEtAfficherParam(int largeur, int hauteur, String theme) {
		String[] tailleList = { "Taille du Niveau", "Plein Ecran" };
		String[] themesList = LecteurJSON.lireCouleur();

		Color fond = Theme.setBgColor(theme);
		Color police = new Color(236, 240, 241);

		JPanel menuOptions = new JPanel();
		options = new JPanel();

		menuOptions.setLayout(new BorderLayout());

		options.setLayout(new BoxLayout(options, 1));
		options.setBackground(fond);
		options.setAlignmentX(0.5F);

		JButton quitterParam = Methodes.creerBouton("", 40, 40, ChargerRessources.icone_croix,
				ChargerRessources.icone_croix_survol, null);
		JButton p1 = Methodes.creerSelecteurPersonnage(40, 40, ChargerRessources.perso1_img,
				ChargerRessources.perso1_img);
		JButton p2 = Methodes.creerSelecteurPersonnage(40, 40, ChargerRessources.perso2_img,
				ChargerRessources.perso2_img);
		JButton p3 = Methodes.creerSelecteurPersonnage(40, 40, ChargerRessources.perso3_img,
				ChargerRessources.perso3_img);
		p1.setBackground(fond);
		p2.setBackground(fond);
		p3.setBackground(fond);

		quitterParam.addActionListener(e -> {
			CardLayout cl = (CardLayout) Main.affichageMultiple.getLayout();

			cl.show(Main.affichageMultiple, Main.etat.getPrecedent());

			Main.etat.setCourrant(Main.etat.getPrecedent());
			if (Main.etat.getPrecedent().equals("Jeu")) {
				Main.fenetre.setSize(AdaptationAffichage.calculerLargeurFenetre(Main.t.getHauteur()),
						AdaptationAffichage.calculerHauteurFenetre(Main.t.getLargeur()));
			} else if (Main.etat.getPrecedent().equals("JeuIA")) {
				Main.fenetre.setSize(AdaptationAffichage.calculerLargeurFenetreIA(Main.t.getHauteur()),
						AdaptationAffichage.calculerHauteurFenetreIA(Main.t.getLargeur()));
			}
		});
		JPanel selectionPersonnage = new JPanel();
		selectionPersonnage.setMaximumSize(new Dimension(565, 95));
		selectionPersonnage.setBackground(fond);
		selectionPersonnage.setLayout(new FlowLayout(1));
		selectionPersonnage.add(p1);
		selectionPersonnage.add(p2);
		selectionPersonnage.add(p3);
		selectionPersonnage.setOpaque(false);

		JLabel logoO = new JLabel(ChargerRessources.logoOptions);
		Methodes.ajouterTexte("Affichage", 25, 170, 10, police, options);
		JCheckBox br = Methodes.creerCheckBox("Bouton retour", true, police);
		br.addActionListener(e -> {
			if (br.isSelected() == true) {
				retour.setVisible(true);
			} else {
				retour.setVisible(false);
			}
		});
		options.add(br);
		options.add(Box.createRigidArea(new Dimension(5, 7)));
		JCheckBox contour = Methodes.creerCheckBox("Contours fenêtre", false, police);

		options.add(contour);
		Methodes.ajouterTexte("Taille fenêtre: ", 15, 10, 5, police, options);
		JComboBox taille = Methodes.creerComboBox(0, tailleList);
		options.add(taille);
		Methodes.ajouterTexte("Thème: ", 15, 10, 5, police, options);
		int val_couleur = 2;
		for (int i = 0; i < themesList.length; i++) {
			if (themesList[i].equals(theme)) {
				val_couleur = i;
			}
		}
		JComboBox themeDefilant = Methodes.creerComboBox(val_couleur, themesList);
		options.add(themeDefilant);
		themeDefilant.addActionListener(new Theme());
		Methodes.ajouterTexte("Audio", 25, 10, 10, police, options);

		JCheckBox desacson = Methodes.creerCheckBox("Désactiver sons", false, police);
		desacson.setSelected(true);
		desacson.addActionListener(e -> {
			if (desacson.isSelected() == true) {
				m.interrupt();

				Music.stopMusic();
			} else {
				m = new Music("SokoBan_8bits.wav");
				m.start();
			}
		});
		options.add(desacson);
		Methodes.ajouterTexte("Volume: ", 15, 10, 5, police, options);
		Methodes.ajouterSlider(Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(50), options);
		Methodes.ajouterTexte("Personnage", 25, 0, 10, police, options);
		options.add(selectionPersonnage);

		menuOptions.add(logoO);
		logoO.setBounds(largeur / 2 - 180, 40, 360, 130);
		quitterParam.setBounds(largeur - 70, 18, 40, 40);
		menuOptions.add(quitterParam);
		menuOptions.add(options, "Center");
		return menuOptions;
	}

	public static JPanel creerEtAfficherFin(int largeur, int hauteur, String theme) {
		fin = new JPanel();
		fin.setBackground(Theme.setBgColor(theme));
		fin.setLayout(new BorderLayout());
		fin.setBorder(new LineBorder(new Color(246, 229, 141), 4));
		fin.setOpaque(true);

		Color police = Color.white;

		int taille = 22;
		JLabel gagne = Methodes.creerTexte("Niveau Terminé !", taille, police);

		JPanel top = new JPanel();
		top.setOpaque(false);
		top.setLayout(new FlowLayout());
		top.add(gagne);

		quitterFin = Methodes.creerBoutonMenu("Quitter", 100, 40, null, null, null, theme);
		quitterFin.setForeground(police);
		quitterFin.addActionListener(e -> System.exit(0));

		restart = Methodes.creerBoutonMenu("Recommencer", 180, 40, null, null, null, theme);
		restart.setForeground(police);
		restart.addActionListener(new BoutonReset());

		suivant = Methodes.creerBoutonMenu("Niveau Suivant", 200, 40, null, null, null, theme);
		suivant.setForeground(police);
		suivant.addActionListener(new BoutonSuivant());

		JPanel boutons = new JPanel();
		boutons.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		boutons.setOpaque(false);

		int espace = 23;
		gbc.gridy = 0;
		boutons.add(suivant, gbc);
		gbc.gridy++;
		boutons.add(Box.createRigidArea(new Dimension(0, espace)), gbc);
		gbc.gridy++;
		boutons.add(restart, gbc);
		gbc.gridy++;
		boutons.add(Box.createRigidArea(new Dimension(0, espace)), gbc);
		gbc.gridy++;
		boutons.add(quitterFin, gbc);
		gbc.gridy++;
		boutons.add(Box.createRigidArea(new Dimension(0, espace)), gbc);

		fin.add(top, "North");
		fin.add(boutons, "South");
		fin.setBounds(largeur / 2 - 225, hauteur / 2 - 260 + 76, 450, 260);
		return fin;
	}

	public static JPanel creerEtAfficherMenuPrincipal(int largeur, String theme) {
		menuPrincipal = new JPanel();
		menuPrincipal.setLayout((LayoutManager) null);
		menuPrincipal.setBackground(Theme.setBgColor(theme));

		JLabel logoP = new JLabel(ChargerRessources.logo);
		joueur = Methodes.creerBoutonMenu("1 JOUEUR", 270, 70, null, null, null, theme);
		joueurIA = Methodes.creerBoutonMenu("1 JOUEUR VS IA", 270, 70, null, null, null, theme);
		optionsMenu = Methodes.creerBoutonMenu("OPTIONS", 270, 70, null, null, null, theme);
		quitter = Methodes.creerBoutonMenu("QUITTER", 270, 70, null, null, null, theme);
		JLabel version = Methodes.creerTexte("v0.1.7kp", 10, new Color(246, 229, 141));
		JLabel credit = Methodes.creerTexte("Pierre MONROCQ, Kévin LEUCHART & Julien SAVARY", 10,
				new Color(246, 229, 141));

		menuPrincipal.add(logoP);
		logoP.setBounds(largeur / 2 - 180, 40, 360, 130);
		menuPrincipal.add(joueur);
		joueur.setBounds(largeur / 2 - 135, 200, 270, 70);
		menuPrincipal.add(joueurIA);
		joueurIA.setBounds(largeur / 2 - 135, 300, 270, 70);
		menuPrincipal.add(optionsMenu);
		optionsMenu.setBounds(largeur / 2 - 135, 400, 270, 70);
		menuPrincipal.add(quitter);
		quitter.setBounds(largeur / 2 - 135, 500, 270, 70);
		menuPrincipal.add(version);
		version.setBounds(5, -5, 300, 50);
		menuPrincipal.add(credit);
		credit.setBounds(largeur - 315, -5, 300, 50);
		return menuPrincipal;
	}
}
