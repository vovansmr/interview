package solves;

import myinterfaces.Algorithmable;
import myinterfaces.Barable;
import myinterfaces.Writeble;
import utils.AlgorithmType;

/**
 * BruteForce algorithm
 */
public class BruteForce implements Algorithmable {
	/**
	 * Algorithm Type Inference
	 */
	@Override
	public AlgorithmType getAlgorithmType() {
		return AlgorithmType.BRUTEFORSE;
	}

	/**
	 * Calculation start method.
	 */
	@Override
	public int calc(int min, int max, Barable calculator, boolean writeSolution, Writeble solution) {
		int countSolution = 0;
		long counter = (max - min + 1);
		counter *= counter * counter * counter;
		calculator.setTotalCounter(counter);
		counter = 0;
		for (int a = min; a <= max; a++) {
			for (int b = min; b <= max; b++) {
				for (int c = min; c <= max; c++) {
					for (int d = min; d <= max; d++) {
						if (Math.pow(a, 3) + Math.pow(b, 3) == Math.pow(c, 3) + Math.pow(d, 3)) {
							countSolution++;
							// Output of the calculated solution
							if (writeSolution) {
								solution.add(a, b, c, d);
							}
						}
						calculator.setCounter(++counter);
					}
				}
			}
		}
		return countSolution;
	}
}
