package algorithmes;

public class ManhattanDistance {
	public static int calculerDistanceManhattan(int x0, int y0, int x1, int y1) {
		return Math.abs(x1 - x0) + Math.abs(y1 - y0);
	}
}
