package myinterfaces;
/**
 * Interface for storing data entered by the user
 */
public interface Inputable {
	/**
	 * 	Get the minimum value of the algorithm 
	 * The minimum value {@link Constantable#MIN} 
	 * and maximum value {@link Constantable#MAX}
	 * @return minimum value of the algorithm
	 */
	public int getMin();
	/**
	 * Set the minimum value of the algorithm 
	 * The minimum value {@link Constantable#MIN} 
	 * and maximum value {@link Constantable#MAX}
	 * @param min minimum value of the algorithm
	 */
	public void setMin(int min);
	/**
	 *  Get the maximum value of the algorithm 
	 *  The minimum value {@link Constantable#MIN} 
	 *  and maximum value {@link Constantable#MAX}
	 *  maximum value of the algorithm
	 */
	public int getMax();
	/**
	 * Set the maximum value of the algorithm 
	 * The minimum value {@link Constantable#MIN} 
	 * and maximum value {@link Constantable#MAX}
	 * @param max maximum value of the algorithm
	 */
	public void setMax(int max);
	/**
	 *  Set displaying the solution of an equation
	 *  @param writeSolution displaying the solution of an equation by default off
	 */
	public void setWriteSolution(boolean writeSolution);
	/**
	 * Get displaying the solution of an equation
	 * @return writeSolution displaying the solution of an equation by default off
	 */
	public boolean getWriteSolution();
	/**
	 *  Get disable output of service information
	 *  @return disable output of service information by default on
	 */
	public boolean getWriteInfo();
	/**
	 *  Set disable output of service information be default on
	 *  @param disable output of service information by default on
	 */
	public void setWriteInfo(boolean writeInfo);
	
}
