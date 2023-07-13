package myinterfaces;
	/**
	 * Time processing interface
	 */
	public interface Temporally {
	/**
	 * Start of processing with the output parameter of service information
	 * @param writeInfo Disable output of service information.
	 */
	public void start(boolean writeInfo);
	/**
	 * Stop processing		
	 */
	public void stop();
	
	/**
	 * Derivation of the running time of the algorithm
	 */
	public String getStatus();
	
}
