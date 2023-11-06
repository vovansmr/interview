package myinterfaces;

/**
 * Template builder
 */
@SuppressWarnings("UnusedReturnValue")
public interface Builderable {
	/**
	 * Add the selected algorithm to the queue
	 * 
	 * @param algoritm name of the algorithm {@link Algorithmable}
	 * @return Builderable
	 */
	Builderable addSolution(String algoritm);

	/**
	 * Set the minimum value of the algorithm to the queue
	 * 
	 * @param min minimum value of the algorithm {@link Inputable#setMin(int)}
	 * @return Builderable
	 * 
	 */
	Builderable setMin(int min);

	/**
	 * Set the maximum value of the algorithm to the queue
	 * 
	 * @param max maximum value of the algorithm {@link Inputable#setMax(int)}
	 * @return Builderable
	 */
	Builderable setMax(int max);

	/**
	 * Displaying the solution of an equation by default off. Adds to the queue
	 * 
	 * @return Builderable
	 */
	Builderable writeSolutionOn();

	/**
	 * Disable output of service information by default on. Adds to the queue
	 * 
	 * @return Builderable
	 */
	Builderable writeInfoOff();

	/**
	 * Start queue processing
	 */
	void buildAndRun();

	/**
	 * Checking entered parameters
	 * 
	 * @return returns true if there are no errors
	 */
    boolean checkParam();

	/**
	 * Checking the No Error Flag
	 * 
	 * @return returns true if there are no errors
	 */
    boolean getNoError();

}
