package algorithmes;

import java.util.ArrayList;
import java.util.Comparator;
import javafx.util.Pair;

public class GreedyMatching {
	public static ArrayList<DistanceDeuxPoints> calculerDistances(ArrayList<Pair<Integer, Integer>> posCaisses,
			ArrayList<Pair<Integer, Integer>> posPoints) {
		ArrayList<DistanceDeuxPoints> res = new ArrayList<>();
		System.out.println(posCaisses);
		for (int c = 0; c < posCaisses.size(); c++) {
			for (int p = 0; p < posPoints.size(); p++) {
				int distance = ManhattanDistance.calculerDistanceManhattan(
						((Integer) ((Pair) posCaisses.get(c)).getKey()).intValue(),
						((Integer) ((Pair) posCaisses.get(c)).getValue()).intValue(),
						((Integer) ((Pair) posPoints.get(p)).getKey()).intValue(),
						((Integer) ((Pair) posPoints.get(p)).getValue()).intValue());
				DistanceDeuxPoints distCaissesPoints = new DistanceDeuxPoints(
						((Integer) ((Pair) posCaisses.get(c)).getKey()).intValue(),
						((Integer) ((Pair) posCaisses.get(c)).getValue()).intValue(),
						((Integer) ((Pair) posPoints.get(p)).getKey()).intValue(),
						((Integer) ((Pair) posPoints.get(p)).getValue()).intValue(), distance);
				res.add(distCaissesPoints);
			}
		}
		return res;
	}

	public static ArrayList<DistanceDeuxPoints> greedy(ArrayList<DistanceDeuxPoints> distanceCaissesPoints,
			ArrayList<Pair<Integer, Integer>> posCaisses) {
		distanceCaissesPoints.sort(Comparator.comparing(DistanceDeuxPoints::getDistance));
		ArrayList<DistanceDeuxPoints> res = new ArrayList<>();
		ArrayList<Pair<Integer, Integer>> caisseMatched = new ArrayList<>();
		ArrayList<Pair<Integer, Integer>> pointsMatched = new ArrayList<>();
		while (!distanceCaissesPoints.isEmpty()) {
			DistanceDeuxPoints dist = distanceCaissesPoints.get(0);
			distanceCaissesPoints.remove(0);
			if (!caisseMatched.contains(dist.getXy()) && !pointsMatched.contains(dist.getX2y2())) {
				res.add(new DistanceDeuxPoints(((Integer) dist.getXy().getKey()).intValue(),
						((Integer) dist.getXy().getValue()).intValue(), ((Integer) dist.getX2y2().getKey()).intValue(),
						((Integer) dist.getX2y2().getValue()).intValue(), dist.getDistance()));
				caisseMatched.add(dist.getXy());
				pointsMatched.add(dist.getX2y2());
			}
		}
		for (Pair<Integer, Integer> caissepos : posCaisses) {
			if (!caisseMatched.contains(caissepos)) {
				DistanceUnPoint v = closestGoal(distanceCaissesPoints, caissepos);
				DistanceDeuxPoints uv = new DistanceDeuxPoints(((Integer) caissepos.getKey()).intValue(),
						((Integer) caissepos.getValue()).intValue(), v.getPositionX(), v.getPositionY(),
						v.getDistance());
				res.add(uv);
			}
		}
		return res;
	}

	public static DistanceUnPoint closestGoal(ArrayList<DistanceDeuxPoints> distanceCaissesPoints,
			Pair<Integer, Integer> caissePos) {
		int minvalue = Integer.MAX_VALUE;
		Pair<Integer, Integer> min = null;
		int dist = 0;
		for (DistanceDeuxPoints e : distanceCaissesPoints) {
			if (e.getXy() == caissePos && e.getDistance() < minvalue) {
				minvalue = e.getDistance();
				min = e.getXy();
				dist = e.getDistance();
			}
		}

		DistanceUnPoint d = new DistanceUnPoint(((Integer) min.getKey()).intValue(),
				((Integer) min.getValue()).intValue(), dist);
		return d;
	}
}
