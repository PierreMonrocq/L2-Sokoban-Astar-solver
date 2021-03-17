package elements.caisse;

import java.awt.Image;
import ressources.ChargerRessources;

public class Caisse {
	private int x;
	private int y;
	private Image texture_caisse;

	public Caisse() {
		this.texture_caisse = ChargerRessources.caisse.getImage();
	}

	public Caisse(int x, int y) {
		this.texture_caisse = ChargerRessources.caisse.getImage();
		setPosition(x, y);
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

	public Image getImage() {
		return this.texture_caisse;
	}

	public void place() {
		this.texture_caisse = ChargerRessources.caisseplacee.getImage();
	}

	public void nonplace() {
		this.texture_caisse = ChargerRessources.caisse.getImage();
	}

	public void deplacement(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	public String toString() {
		return "coordonnées caisse (x,y) :" + getYPosition() + " " + getXPosition();
	}
}