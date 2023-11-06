package myinterfaces;

import utils.AlgorithmType;

/**
 * interface for working with the algorithm
 */
public interface Algorithmable {
	/**
	 * Calculation start method.
	 * 
	 * @param min           minimum value of the algorithm
	 * @param max           maximum value of the algorithm
	 * @param calculator    interface for working with progress bar
	 * @param writeSolution enable output of service information
	 * @param solution      output of the calculated solution
	 */
	int calc(int min, int max, Barable calculator, boolean writeSolution, Writeble solution);

	/**
	 * Algorithm Type Inference
	 * 
	 * @return {@link AlgorithmType}
	 */
	AlgorithmType getAlgorithmType();

}
