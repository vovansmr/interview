package myinterfaces;

/**
 * interface for working with progress bar
 */
public interface Barable {
	/**
	 * setting the counter value for calculating the remaining time,%
	 * 
	 * @param counter completed operations counter
	 */
	void setCounter(long counter);

	/**
	 * setting the maximum value of the counter
	 * 
	 * @param counter maximum value of the counter
	 */
	void setTotalCounter(long counter);

}
