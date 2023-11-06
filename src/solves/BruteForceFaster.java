package solves;

import myinterfaces.Algorithmable;
import myinterfaces.Barable;
import myinterfaces.Writeble;
import utils.AlgorithmType;

/**
 * BruteForceFaster algorithm
 */

public class BruteForceFaster implements Algorithmable {
	/**
	 * Algorithm Type Inference
	 */
	@Override
	public AlgorithmType getAlgorithmType() {
		return AlgorithmType.BRUTEFORSEFASTER;
	}

	/**
	 * Calculation start method.
	 */
	@Override
	public int calc(int min, int max, Barable calculator, boolean writeSolution, Writeble solution) {
		int countSolution = 0, counter = 0;
		calculator.setTotalCounter((long) (max - min + 1) * (max - min + 1) * (max - min + 1));
		for (int a = min; a <= max; a++) {
			for (int b = min; b <= max; b++) {
				for (int c = min; c <= max; c++) {
					double tmp = Math.cbrt(Math.pow(a, 3) + Math.pow(b, 3) - Math.pow(c, 3));
					calculator.setCounter(++counter);
					if (tmp >= min && tmp <= max && tmp - ((int) tmp) == 0) {
						countSolution++;
						// Output of the calculated solution
						if (writeSolution) {
							solution.add(a, b, c, (int) tmp);
						}
					}
				}
			}
		}
		return countSolution;
	}

}