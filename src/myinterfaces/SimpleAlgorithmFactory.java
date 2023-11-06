package myinterfaces;

/**
 * Algorithm factory
 */
public interface SimpleAlgorithmFactory {
	/**
	 * Checking the No Error Flag
	 * 
	 */
	boolean getNoError();

	/**
	 * Creation of the algorithm
	 */
	Algorithmable getAlgorithm(String algorithm);

}
