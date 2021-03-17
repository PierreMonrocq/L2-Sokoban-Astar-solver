package elements.terrain;

import javafx.util.Pair;

public class Terrain {
	public char[][] terrain;

	public Terrain(char[][] terrain) {
		this.terrain = terrain;
	}

	public char[][] getTerrain() {
		return this.terrain;
	}

	public int getTerrainYX(int y, int x) {
		return this.terrain[y][x];
	}

	public void setTerrain(char[][] terrain) {
		this.terrain = terrain;
	}

	public Pair<Integer, Integer> coordTerrainPersonnage() {
		for (int y = 0; y < this.terrain.length; y++) {
			for (int x = 0; x < (this.terrain[0]).length; x++) {
				if (this.terrain[y][x] == '@') {
					Pair<Integer, Integer> perso = new Pair(Integer.valueOf(x), Integer.valueOf(y));
					this.terrain[y][x] = 's';
					return perso;
				}
				if (this.terrain[y][x] == '+') {
					Pair<Integer, Integer> perso = new Pair(Integer.valueOf(x), Integer.valueOf(y));
					this.terrain[y][x] = '.';
					return perso;
				}
			}
		}
		return null;
	}

	public void mettreSol() {
		for (int y = 0; y < this.terrain.length; y++) {
			int nbMurL = 0;
			for (int j = 0; j < (this.terrain[0]).length; j++) {
				if (this.terrain[y][j] == '#') {
					nbMurL++;
				}
			}

			int murLVisite = 0;
			for (int x = 0; x < (this.terrain[0]).length; x++) {
				if (this.terrain[y][x] == '#') {
					murLVisite++;
				}
				if (murLVisite >= 1 && murLVisite < nbMurL && this.terrain[y][x] == ' ') {
					this.terrain[y][x] = 's';
				}
			}
		}
		visiteHauteur();
	}

	public void visiteHauteur() {
		int nbMurH = 0;
		for (int y = 0; y < (this.terrain[0]).length; y++) {
			nbMurH = 0;
			for (int x = 0; x < this.terrain.length; x++) {
				if (this.terrain[x][y] == '#') {
					nbMurH++;
				}
			}

			int MurHVisi = 0;
			for (int j = 0; j < this.terrain.length; j++) {
				if (this.terrain[j][y] == '#') {
					MurHVisi++;
				}
				if (MurHVisi == 0 && MurHVisi <= nbMurH && this.terrain[j][y] == 's') {
					this.terrain[j][y] = ' ';
				}
			}
		}
	}

	public int getHauteur() {
		return (this.terrain[0]).length * 40;
	}

	public int getLargeur() {
		return this.terrain.length * 40;
	}

	public int calculerLongueurMax() {
		int max = 0;
		for (int x = 0; x < this.terrain.length; x++) {
			if ((this.terrain[x]).length > max) {
				max = (this.terrain[x]).length;
			}
		}
		return max;
	}

	public void ajoutFinTableau() {
		int ROWS = this.terrain.length;
		int COLS = calculerLongueurMax();
		char[][] array2 = new char[ROWS][COLS];

		for (int i = 0; i < this.terrain.length; i++) {
			for (int j = 0; j < (this.terrain[i]).length; j++) {
				array2[i][j] = this.terrain[i][j];
			}
		}
		this.terrain = array2;
	}
}