package elements.personnage;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javafx.util.Pair;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import ressources.ChargerRessources;

public class Personnage {
	private int x;
	private int y;
	private Image texture_personnage;
	public int nb_deplacements;
	private ArrayList<Pair<Integer, Integer>> liste_deplacements = new ArrayList<>();
	private int taille_liste_deplacements = 10;

	public Personnage() {
		ImageIcon img = new ImageIcon(load("images/jeu/personnage/personnage.png"));
		this.texture_personnage = img.getImage();
	}

	public void setTexture_personnage(Image texture_personnage) {
		this.texture_personnage = texture_personnage;
	}

	public void setTexture_personnage(Icon path) {
		ImageIcon img = new ImageIcon(iconToImage(path));
		this.texture_personnage = img.getImage();
	}

	public Personnage(int x, int y, String image) {
		ImageIcon img = new ImageIcon(load(image));
		this.texture_personnage = img.getImage();
		setPosition(x, y);
		this.liste_deplacements.add(new Pair(Integer.valueOf(x), Integer.valueOf(y)));
	}

	public Image getImage() {
		return this.texture_personnage;
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getXPosition() {
		return this.x;
	}

	public int getYPosition() {
		return this.y;
	}

	public void deplacement(int dx, int dy) {
		this.x += dx;
		this.y += dy;
		this.nb_deplacements++;
		ajouterDeplacement(this.x, this.y);
	}

	public int getNb_deplacements() {
		return this.nb_deplacements;
	}

	public void setNb_deplacements(int nb_deplacements) {
		this.nb_deplacements = nb_deplacements;
	}

	public void ajouterDeplacement(int x, int y) {
		Pair<Integer, Integer> coord = new Pair(Integer.valueOf(x), Integer.valueOf(y));
		if (this.liste_deplacements.size() == this.taille_liste_deplacements) {
			this.liste_deplacements.remove(0);
			this.liste_deplacements.add(coord);
		} else {
			this.liste_deplacements.add(coord);
		}
	}

	public ArrayList<Pair<Integer, Integer>> getListe_deplacements() {
		return this.liste_deplacements;
	}

	public int getTaille_liste_deplacements() {
		return this.taille_liste_deplacements;
	}

	public void setTaille_liste_deplacements(int taille_liste_deplacements) {
		this.taille_liste_deplacements = taille_liste_deplacements;
	}

	public void afficherCoordonneesPersonnage() {
		System.out.println("coordonnées joueur (x,y) :" + getXPosition() + " " + getYPosition());
	}

	private static Image load(String file) {
		try {
			return ImageIO.read(ChargerRessources.class.getResourceAsStream(file));
		} catch (IOException e) {
			e.printStackTrace();

			return null;
		}
	}

	public Image iconToImage(Icon icon) {
		if (icon instanceof ImageIcon)
			return ((ImageIcon) icon).getImage();

		BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), 1);
		icon.paintIcon(null, image.getGraphics(), 0, 0);
		return image;
	}
}
