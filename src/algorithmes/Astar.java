package algorithmes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import javafx.util.Pair;

public class Astar {
	public final char[][] directionsChar = new char[][] { { 'h', 'H' }, { 'd', 'D' }, { 'b', 'B' }, { 'g', 'G' } };
	public final int[][] directionsInt = new int[][] { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
	public static ArrayList<Pair<Integer, Integer>> coordPoint;
	public static String solution;

	public String solve(char[][] terrain) {
		rechercherCoordPoint(terrain);
		System.out.println(coordPoint);
		Pair<Integer, Integer> coordPerso = rechercherCoordPerso(terrain);
		int persoY = ((Integer) coordPerso.getKey()).intValue();
		int persoX = ((Integer) coordPerso.getValue()).intValue();
		System.out.println(persoX + "," + persoY);
		String idTerrain = convertirTerrain(terrain);
		Set<String> history = new HashSet<>();
		LinkedList<ModelisationTerrain> open = new LinkedList<>();
		history.add(idTerrain);

		open.add(new ModelisationTerrain(terrain, "", persoX, persoY));

		while (!open.isEmpty()) {
			ModelisationTerrain element = open.poll();
			char[][] act = element.actuel;
			String solu = element.solution;
			int x = element.x;
			int y = element.y;
			for (int i = 0; i < this.directionsInt.length; i++) {
				char[][] essai = copy(act);
				int dx = this.directionsInt[i][0];
				int dy = this.directionsInt[i][1];
				if (dansTerrain(x, y, dx, dy, essai)
						&& (essai[y + dy][x + dx] == '$' || essai[y + dy][x + dx] == '*')) {
					if ((essai = pousser(x, y, dx, dy, essai)) != null) {
						String essaiString = convertirTerrain(essai);
						if (!history.contains(essaiString)) {
							String nouvelleSolu = solu + this.directionsChar[i][1];
							if (estTermine(essai)) {
								solution = nouvelleSolu;
								return nouvelleSolu;
							}
							open.add(new ModelisationTerrain(essai, nouvelleSolu, x + dx, y + dy));
							history.add(essaiString);
						}

					}
				} else if (dansTerrain(x, y, dx, dy, essai) && (essai = deplacer(x, y, dx, dy, essai)) != null) {
					String essaiString = convertirTerrain(essai);
					if (!history.contains(essaiString)) {
						String nouvelleSolu = solu + this.directionsChar[i][0];
						open.add(new ModelisationTerrain(essai, nouvelleSolu, x + dx, y + dy));
						history.add(essaiString);
					}
				}
			}
		}

		return "Aucunes solutions trouvée";
	}

	public char[][] deplacer(int x, int y, int dx, int dy, char[][] terrain) {
		if (terrain[y + dy][x + dx] != ' ' && terrain[y + dy][x + dx] != '.') {
			return (char[][]) null;
		}

		char[][] res = copy(terrain);
		for (Pair<Integer, Integer> coord : coordPoint) {
			if (y == ((Integer) coord.getValue()).intValue() && x == ((Integer) coord.getKey()).intValue()) {
				res[y][x] = '.';
			}
		}
		if (res[y][x] != '.') {
			res[y][x] = ' ';
		}
		res[y + dy][x + dx] = '@';
		return res;
	}

	public char[][] pousser(int x, int y, int dx, int dy, char[][] terrain) {
		if (terrain[y + dy * 2][x + dx * 2] != ' ' && terrain[y + dy * 2][x + dx * 2] != '.') {
			return (char[][]) null;
		}
		char[][] res = copy(terrain);
		for (Pair<Integer, Integer> coord : coordPoint) {
			if (y == ((Integer) coord.getValue()).intValue() && x == ((Integer) coord.getKey()).intValue()) {
				res[y][x] = '.';
			}
		}
		if (res[y][x] != '.') {
			res[y][x] = ' ';
		}
		res[y + dy][x + dx] = '@';
		res[y + dy * 2][x + dx * 2] = '$';
		return res;
	}

	public static boolean estTermine(char[][] terrain) {
		ArrayList<Pair<Integer, Integer>> termine = new ArrayList<>();
		for (int y = 0; y < terrain.length; y++) {
			for (int x = 0; x < (terrain[y]).length; x++) {
				if (terrain[y][x] == '$' || terrain[y][x] == '*') {
					termine.add(new Pair(Integer.valueOf(y), Integer.valueOf(x)));
				}
			}
		}

		for (Pair<Integer, Integer> coordC : termine) {
			if (!coordPoint.contains(coordC)) {
				return false;
			}
		}
		System.out.println(termine);
		System.out.println("A* terminé");
		System.out.println(convertirTerrainSaut(terrain));
		return true;
	}

	public static String convertirTerrain(char[][] maze) {
		String s = "";
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < (maze[i]).length; j++) {
				s = s + maze[i][j];
			}
		}
		return s;
	}

	public static String convertirTerrainSaut(char[][] maze) {
		String s = "";
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < (maze[i]).length; j++) {
				s = s + maze[i][j];
			}
			s = s + "\n";
		}
		return s;
	}

	public static boolean dansTerrain(int x, int y, int dx, int dy, char[][] terrain) {
		return (x + dx > 0 && y + dy > 0 && x + dx <= (terrain[0]).length && y + dy <= terrain.length);
	}

	public static Pair<Integer, Integer> rechercherCoordPerso(char[][] terrain) {
		for (int y = 0; y < terrain.length; y++) {
			for (int x = 0; x < (terrain[0]).length; x++) {
				if (terrain[y][x] == '@') {
					return new Pair(Integer.valueOf(y), Integer.valueOf(x));
				}
				if (terrain[y][x] == '+') {
					return new Pair(Integer.valueOf(y), Integer.valueOf(x));
				}
			}
		}
		return null;
	}

	public void rechercherCoordPoint(char[][] terrain) {
		coordPoint = new ArrayList<>();
		for (int y = 0; y < terrain.length; y++) {
			for (int x = 0; x < (terrain[0]).length; x++) {
				if (terrain[y][x] == '.' || terrain[y][x] == '*' || terrain[y][x] == '+') {
					coordPoint.add(new Pair(Integer.valueOf(y), Integer.valueOf(x)));
				}
			}
		}
	}

	private static char[][] copy(char[][] nums) {
		char[][] copy = new char[nums.length][];

		for (int i = 0; i < copy.length; i++) {
			char[] member = new char[(nums[i]).length];
			System.arraycopy(nums[i], 0, member, 0, (nums[i]).length);
			copy[i] = member;
		}

		return copy;
	}
}