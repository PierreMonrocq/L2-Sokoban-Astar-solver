package algorithmes;

import java.util.ArrayList;
import javafx.util.Pair;

public class DistanceDeuxPoints {
	private Pair<Integer, Integer> xy;
	private Pair<Integer, Integer> x2y2;
	private int distance;

	public DistanceDeuxPoints(int x1, int y1, int x2, int y2, int distance) {
		this.xy = new Pair(Integer.valueOf(x1), Integer.valueOf(y1));
		this.x2y2 = new Pair(Integer.valueOf(x2), Integer.valueOf(y2));
		this.distance = distance;
	}

	public Pair<Integer, Integer> getXy() {
		return this.xy;
	}

	public Pair<Integer, Integer> getX2y2() {
		return this.x2y2;
	}

	public int getDistance() {
		return this.distance;
	}

	public void setXy(Pair<Integer, Integer> xy) {
		this.xy = xy;
	}

	public void setX2y2(Pair<Integer, Integer> x2y2) {
		this.x2y2 = x2y2;
	}

	public void setDistance(int z) {
		this.distance = z;
	}

	public String toString() {
		return "((" + this.xy.getKey() + "," + this.xy.getValue() + ")(" + this.x2y2.getKey() + ","
				+ this.x2y2.getValue() + "))=" + this.distance;
	}

	public static ArrayList<DistanceDeuxPoints> distance2Points(ArrayList<Pair<Integer, Integer>> positions,
			ArrayList<Pair<Integer, Integer>> objectifs, int value) {
		ArrayList<DistanceDeuxPoints> res = new ArrayList<>();
		if (positions.size() != objectifs.size()) {
			return null;
		}
		for (int i = 0; i < positions.size(); i++) {
			DistanceDeuxPoints at = new DistanceDeuxPoints(((Integer) ((Pair) positions.get(i)).getKey()).intValue(),
					((Integer) ((Pair) positions.get(i)).getValue()).intValue(),
					((Integer) ((Pair) objectifs.get(i)).getKey()).intValue(),
					((Integer) ((Pair) objectifs.get(i)).getKey()).intValue(), value);
			res.add(at);
		}
		return res;
	}
}

/*
 * Location: C:\Users\pierr\OneDrive\Bureau\projet_git\L2 Sokoban
 * game\Sokoban.jar!\algorithmes\DistanceDeuxPoints.class Java compiler version:
 * 8 (52.0) JD-Core Version: 1.1.3
 */