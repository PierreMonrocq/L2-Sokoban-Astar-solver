package affichage.interfaces;

import affichage.Vue;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import ressources.ChargerRessources;
import ressources.LecteurJSON;

public class Theme implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		JComboBox comBox = (JComboBox) source;
		String color = (String) comBox.getSelectedItem();
		switch (color) {
		case "Bleu":
			changerCouleur("Bleu");
			break;
		case "Rouge":
			changerCouleur("Rouge");
			break;
		case "Vert":
			changerCouleur("Vert");
			break;
		case "Classic":
			changerCouleur("Classic");
			break;
		case "Gris":
			changerCouleur("Gris");
			break;
		}

	}

	public void changerCouleur(String couleur) {
		setImagesColor(couleur);
		setColor(couleur);
	}

	public static Color setBgColor(String couleur) {
		Color bgColor = StringtoColor(LecteurJSON.lirePropriete("theme", couleur, "BgColor").split(" "));
		return bgColor;
	}

	public static void setImagesColor(String couleur) {
		Vue.cr = new ChargerRessources();
		Vue.cr.chargerImages(couleur);
	}

	public static void setColor(String couleur) {
		Vue.cr.chargerCouleur(couleur);
	}

	public static Color getBarreColor(String couleur) {
		Color colorbarre = StringtoColor(LecteurJSON.lirePropriete("theme", couleur, "BarreColor").split(" "));
		return colorbarre;
	}

	public static Color getButColor(String couleur) {
		Color Colorbut = StringtoColor(LecteurJSON.lirePropriete("theme", couleur, "ButColor").split(" "));
		return Colorbut;
	}

	public static Color getButSurvolColor(String couleur) {
		Color Colorbutsurvol = StringtoColor(LecteurJSON.lirePropriete("theme", couleur, "ButColorSurvol").split(" "));
		return Colorbutsurvol;
	}

	public static Color StringtoColor(String[] couleurs) {
		Color Couleur = null;
		String[] colors = couleurs;
		ArrayList<Integer> col = new ArrayList<>();
		for (String str : colors) {
			col.add(Integer.valueOf(Integer.parseInt(str)));
		}
		Couleur = new Color(((Integer) col.get(0)).intValue(), ((Integer) col.get(1)).intValue(),
				((Integer) col.get(2)).intValue());
		return Couleur;
	}
}
