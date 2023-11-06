package myinterfaces;

/**
 * Time processing interface
 */
@SuppressWarnings("unused")
public interface Temporally {
	/**
	 * Start of processing with the output parameter of service information
	 * 
	 * @param writeInfo Disable output of service information.
	 */
    void start(boolean writeInfo);

	/**
	 * Stop processing
	 */
    void stop();

	/**
	 * Derivation of the running time of the algorithm
	 */
    String getStatus();

}
