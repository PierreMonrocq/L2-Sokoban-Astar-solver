package algorithmes;

import java.util.ArrayList;
import javafx.util.Pair;

public class DistanceUnPoint {
	private int x;
	private int y;
	private int distance;

	public DistanceUnPoint(int x1, int y1, int distance) {
		this.x = x1;
		this.y = y1;
		this.distance = distance;
	}

	public void setPosition(int x1, int y1) {
		this.x = x1;
		this.y = y1;
	}

	public int getPositionX() {
		return this.x;
	}

	public int getPositionY() {
		return this.y;
	}

	public int getDistance() {
		return this.distance;
	}

	public void setDistance(int z) {
		this.distance = z;
	}

	public String toString() {
		return "((" + this.x + "," + this.y + "))=" + this.distance;
	}

	public static ArrayList<DistanceUnPoint> distance1point(ArrayList<Pair<Integer, Integer>> positions, int value) {
		ArrayList<DistanceUnPoint> res = new ArrayList<>();

		for (int i = 0; i < positions.size(); i++) {
			DistanceUnPoint at = new DistanceUnPoint(((Integer) ((Pair) positions.get(i)).getKey()).intValue(),
					((Integer) ((Pair) positions.get(i)).getValue()).intValue(), value);
			res.add(at);
		}
		return res;
	}
}
