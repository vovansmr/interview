package myinterfaces;
	/**
	 * Algorithm factory
	 */
	public interface SimpleAlgorithmFactory {
	/**
	 *  Checking the No Error Flag
	 *  
	 */
		public boolean getNoError();
	/**
	 * Creation of the algorithm	
	 */
	public Algorithmable GetAlgorithm(String algorithm) ;

}
