package affichage.interfaces;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.border.Border;

public class Methodes {
	public static Color couleurBouton;
	public static Color couleurBoutonSurvol;

	public static JButton creerBouton(String texte, int tailleX, int tailleY, ImageIcon img1, ImageIcon img2,
			ImageIcon img3) {
		JButton but = new JButton(texte);
		but.setFont(new Font("Verdana", 1, 15));
		but.setBorder((Border) null);
		but.setFocusable(false);
		but.setPreferredSize(new Dimension(tailleX, tailleY));
		but.setIcon(img1);
		but.setRolloverIcon(img2);
		but.setDisabledIcon(img3);
		but.setContentAreaFilled(false);
		return but;
	}

	public static JButton creerBoutonMenu(String texte, int tailleX, int tailleY, ImageIcon img1, ImageIcon img2,
			ImageIcon img3, String theme) {
		couleurBouton = Theme.getButColor(theme);
		couleurBoutonSurvol = Theme.getButSurvolColor(theme);
		Color police = new Color(236, 240, 241);
		final Color bordure = new Color(246, 229, 141);
		final Color bordure_survol = new Color(249, 202, 36);
		final JButton but = creerBouton(texte, tailleX, tailleY, img1, img2, img3);
		but.setFont(new Font("Verdana", 1, 20));
		but.addActionListener(new SelectionMenu());
		but.setForeground(police);
		but.setAlignmentX(0.5F);
		but.setBackground(couleurBouton);
		but.setBorder(BorderFactory.createMatteBorder(4, 5, 4, 5, bordure));
		but.setContentAreaFilled(true);
		but.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				but.setBackground(Methodes.couleurBoutonSurvol);
				but.setBorder(BorderFactory.createMatteBorder(4, 5, 4, 5, bordure_survol));
			}

			public void mouseExited(MouseEvent e) {
				but.setBackground(Methodes.couleurBouton);
				but.setBorder(BorderFactory.createMatteBorder(4, 5, 4, 5, bordure));
			}
		});
		return but;
	}

	public static JLabel creerTexte(String titre, int taille, Color police) {
		JLabel texte = new JLabel(titre);
		texte.setFont(new Font("Verdana", 1, taille));
		texte.setForeground(police);
		texte.setAlignmentX(0.5F);
		return texte;
	}

	public static void ajouterTexte(String titre, int taille, int margeY_avant, int margeY_apres, Color police, Container container) {
		JLabel texte = new JLabel(titre);
		texte.setFont(new Font("Verdana", 1, taille));
		texte.setForeground(police);
		texte.setAlignmentX(0.5F);
		container.add(Box.createRigidArea(new Dimension(8, margeY_avant)));
		container.add(texte);
		container.add(Box.createRigidArea(new Dimension(8, margeY_apres)));
   }

	public static JCheckBox creerCheckBox(String texte, boolean selected, Color police) {
		JCheckBox checkbox = new JCheckBox(texte);
		checkbox.setOpaque(false);
		checkbox.setFont(new Font("Verdana", 1, 15));
		checkbox.setForeground(police);
		checkbox.setSelected(selected);
		checkbox.setFocusable(false);
		checkbox.setBorder((Border) null);
		checkbox.setAlignmentX(0.5F);
		return checkbox;
	}

	public static JComboBox creerComboBox(int selected, String[] liste) {
		JComboBox<String> comboBox = new JComboBox<>(liste);
		comboBox.setSelectedIndex(selected);
		comboBox.setFont(new Font("Verdana", 1, 10));
		comboBox.setMaximumSize(new Dimension(100, 30));
		comboBox.setAlignmentX(0.5F);
		comboBox.setFocusable(false);
		return comboBox;
	}

	public static void ajouterSlider(Integer min, Integer max, Integer init, Container container) {
		JSlider slider = new JSlider(0, (new Integer(min.intValue())).intValue(),
				(new Integer(max.intValue())).intValue(), (new Integer(init.intValue())).intValue());
		slider.setFont(new Font("Verdana", 1, 10));
		slider.setFocusable(false);
		slider.setOpaque(false);
		slider.setForeground(Color.yellow);
		slider.setMaximumSize(new Dimension(150, 30));
		slider.setAlignmentX(0.5F);
		container.add(slider);
		container.add(Box.createRigidArea(new Dimension(10, 10)));
	}

	public static JButton creerSelecteurPersonnage(int tailleX, int tailleY, ImageIcon img1, ImageIcon img2) {
		JButton but = new JButton();

		but.setOpaque(false);
		but.setBorder((Border) null);
		but.setFocusable(false);
		but.setPreferredSize(new Dimension(tailleX, tailleY));
		but.setIcon(img1);
		but.setRolloverIcon(img2);
		but.setAlignmentX(0.5F);
		but.addActionListener(new SelectionPersonnages());
		return but;
	}
}
