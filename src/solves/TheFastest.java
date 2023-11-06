package solves;

import java.util.HashMap;
import myinterfaces.Algorithmable;
import myinterfaces.Barable;
import myinterfaces.Writeble;
import utils.AlgorithmType;
import writesolution.AdapterWriteSolutionToConsole;

/**
 * TheFastest algorithm
 */
public class TheFastest implements Algorithmable {
	/**
	 * Algorithm Type Inference
	 */
	@Override
	public AlgorithmType getAlgorithmType() {
		return AlgorithmType.THEFASTEST;
	}

	/**
	 * Calculation start method.
	 */
	@Override
	public int calc(int min, int max, Barable calculator, boolean writeSolution, Writeble solution) {
		HashMap<Integer, HashMap<Integer, TheFastestData>> map = new HashMap<>();
		HashMap<Integer, TheFastestData> tmphash;
		int countSolution = 0, counter = 0;
		calculator.setTotalCounter((long) (max - min + 1) * (max - min + 1));
		for (int a = min; a <= max; a++) {
			for (int b = min; b <= max; b++) {
				Integer key = a * a * a + b * b * b;
				if (map.get(key) == null) {
					tmphash = new HashMap<>();
					map.put(key, tmphash);
				} else {
					tmphash = map.get(key);
				}
				tmphash.put(tmphash.size(), new TheFastestData(a, b));
				calculator.setCounter(++counter);
			}
		}
		// Algorithm solution output adapter
		AdapterWriteSolutionToConsole adapter = new AdapterWriteSolutionToConsole(solution);
		// Output of the calculated solution
		for (HashMap<Integer, TheFastestData> tmp : map.values()) {
			countSolution += tmp.size() * tmp.size();
			if (writeSolution) {
				for (int i = 0; i < tmp.size(); i++) {
					for (int j = 0; j < tmp.size(); j++) {
						adapter.add(tmp.get(i), tmp.get(j));
					}
				}
			}
		}
		return countSolution;
	}
}
