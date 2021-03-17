package algorithmes;

public class ModelisationTerrain {
	public char[][] actuel;
	public String solution;
	public int x;
	public int y;

	ModelisationTerrain(char[][] terrain, String s2, int dx, int dy) {
		this.actuel = terrain;
		this.solution = s2;
		this.x = dx;
		this.y = dy;
	}
}
