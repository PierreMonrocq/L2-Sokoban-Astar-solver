package algorithmes;

import java.util.List;

public class DepthFirstSearch {
	public static boolean rechercheChemin(char[][] terrain, int x, int y, List<Integer> chemin) {
		if (terrain[y][x] == '.') {
			chemin.add(Integer.valueOf(x));
			chemin.add(Integer.valueOf(y));
			return true;
		}

		if (terrain[y][x] == ' ') {
			terrain[y][x] = 'v';

			int dx = -1;
			int dy = 0;
			if (rechercheChemin(terrain, x + dx, y + dy, chemin)) {
				chemin.add(Integer.valueOf(x));
				chemin.add(Integer.valueOf(y));
				return true;
			}
			dx = 1;
			dy = 0;
			if (rechercheChemin(terrain, x + dx, y + dy, chemin)) {
				chemin.add(Integer.valueOf(x));
				chemin.add(Integer.valueOf(y));
				return true;
			}

			dx = 0;
			dy = -1;
			if (rechercheChemin(terrain, x + dx, y + dy, chemin)) {
				chemin.add(Integer.valueOf(x));
				chemin.add(Integer.valueOf(y));
				return true;
			}

			dx = 0;
			dy = 1;
			if (rechercheChemin(terrain, x + dx, y + dy, chemin)) {
				chemin.add(Integer.valueOf(x));
				chemin.add(Integer.valueOf(y));
				return true;
			}
		}
		return false;
	}
}
