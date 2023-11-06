package solves;

import myinterfaces.Algorithmable;
import myinterfaces.Inputable;
import myinterfaces.Temporally;
import myinterfaces.Barable;
import myinterfaces.Writeble;
import timecalculators.TimeCalculatorSimple;
import utils.LoadMessages;
import writesolution.WriteSolutionToConsole;

/**
 * Class for managing solution calculation
 */
@SuppressWarnings("unused")
public class Solution {
	private Inputable inputs = null;
	private Algorithmable algorithm = null;
	private final Temporally calculator = new TimeCalculatorSimple();
	private final LoadMessages messages = LoadMessages.getInstance();
	private final Writeble solution = new WriteSolutionToConsole();

	/**
	 * Gets the algorithm to calculate
	 * 
	 * @return algorithm {@link Algorithmable}
	 */
	public Algorithmable getAlgorithm() {
		return algorithm;
	}

	/**
	 * Sets the algorithm for calculations
	 * 
	 * @param algorithm {@link Algorithmable}
	 */
	public void setAlgorithm(Algorithmable algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param inputs    class for storing data entered by the user
	 * @param algorithm class for working with the algorithm {@link Algorithmable}
	 *                  {@link Inputable}
	 */
	public Solution(Inputable inputs, Algorithmable algorithm) {
		this.inputs = inputs;
		this.algorithm = algorithm;
	}

	/**
	 * Constructor with out parameters
	 */
	public Solution() {
	}

	/**
	 * Gets the class with the data entered by the user
	 * 
	 * @return Inputable class with the data entered by the user {@link Inputable}
	 */
	public Inputable getInputs() {
		return inputs;
	}

	/**
	 * Sets a class with the data entered by the user
	 * 
	 * @param inputs lass for storing data entered by the user {@link Inputable}
	 */
	public void setInputs(Inputable inputs) {
		this.inputs = inputs;
	}

	/**
	 * Method to start calculations
	 * 
	 */
	public void calc() {
		@SuppressWarnings("UnusedAssignment") int result = 0;
		// Parameter Check
		if (inputs == null || algorithm == null) {
			throw new IllegalArgumentException(messages.getProp("inputsER"));
		}
		if (inputs.getWriteInfo()) {
			System.out.println(messages.getProp("StartAL") + algorithm.getAlgorithmType() + messages.getProp("min")
					+ inputs.getMin() + messages.getProp("max") + inputs.getMax() + messages.getProp("dot"));
		}
		// Preparing for time processing
		calculator.start(inputs.getWriteInfo());
		// Start calculation of equation values
		result = algorithm.calc(inputs.getMin(), inputs.getMax(), (Barable) calculator, inputs.getWriteSolution(),
				solution);
		// Stoping for time processing
		calculator.stop();
		// Print all solutions
		solution.printAll();
		// Clear array
		solution.clear();
		// Output of service information
		if (inputs.getWriteInfo()) {
			System.out.println(messages.getProp("found") + result + messages.getProp("solutions"));
		}
		if (inputs.getWriteInfo()) {
			System.out.println(messages.getProp("endalgo") + algorithm.getAlgorithmType() + messages.getProp("dot")
					+ calculator.getStatus());
		}
	}

}
