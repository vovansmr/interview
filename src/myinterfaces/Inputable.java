package myinterfaces;

/**
 * Interface for storing data entered by the user
 */
public interface Inputable {
	/**
	 * Get the minimum value of the algorithm The minimum value
	 * {@link Constant#MIN} and maximum value {@link Constant#MAX}
	 * 
	 * @return minimum value of the algorithm
	 */
    int getMin();

	/**
	 * Set the minimum value of the algorithm The minimum value
	 * {@link Constant#MIN} and maximum value {@link Constant#MAX}
	 * 
	 * @param min minimum value of the algorithm
	 */
    void setMin(int min);

	/**
	 * Get the maximum value of the algorithm The minimum value
	 * {@link Constant#MIN} and maximum value {@link Constant#MAX} maximum
	 * value of the algorithm
	 */
    int getMax();

	/**
	 * Set the maximum value of the algorithm The minimum value
	 * {@link Constant#MIN} and maximum value {@link Constant#MAX}
	 * 
	 * @param max maximum value of the algorithm
	 */
    void setMax(int max);

	/**
	 * Set displaying the solution of an equation
	 * 
	 * @param writeSolution displaying the solution of an equation by default off
	 */
    void setWriteSolution(boolean writeSolution);

	/**
	 * Get displaying the solution of an equation
	 * 
	 * @return writeSolution displaying the solution of an equation by default off
	 */
    boolean getWriteSolution();

	/**
	 * Get disable output of service information
	 * 
	 * @return disable output of service information by default on
	 */
    boolean getWriteInfo();

	/**
	 * Set disable output of service information be default on
	 * 
	 * @param writeInfo disable output of service information by default on
	 */
    void setWriteInfo(boolean writeInfo);

}
