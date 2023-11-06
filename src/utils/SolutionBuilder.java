package utils;

import java.util.ArrayDeque;
import java.util.Queue;

import input.MyInput;
import myinterfaces.Algorithmable;
import myinterfaces.Builderable;
import myinterfaces.Inputable;
import myinterfaces.SimpleAlgorithmFactory;
import solves.Solution;

/**
 * The execution queue creation class. Implemented using the builder template.
 */
public class SolutionBuilder implements Builderable {

	private RunParameters parameters = null;
	private final Queue<RunParameters> run = new ArrayDeque<>();
	private boolean noError = true;
	private final LoadMessages messages = LoadMessages.getInstance();
	private final CheckMinMaxClass check = CheckMinMaxClass.getInstance();
	private final SimpleAlgorithmFactory factory = new AlgorithmFactory();

	/**
	 * Checking the No Error Flag
	 */
	public boolean getNoError() {
		boolean result = noError;
		noError = true;
		return result;
	}

	/**
	 * Add the selected algorithm to the queue
	 */
	@SuppressWarnings("IfStatementWithIdenticalBranches")
	@Override
	public Builderable addSolution(String algorithm) {
		if (parameters == null) {
			parameters = new RunParameters();
		} else {
			if (parameters.getAlgorithm().getAlgorithmType() != AlgorithmType.NO) {
				run.add(parameters);
			}
			parameters = new RunParameters();
		}
		Algorithmable algo = factory.getAlgorithm(algorithm);
		if (algo != null) {
			parameters.setAlgorithm(algo);
		}
		noError = factory.getNoError();
		if (!noError) {
			parameters = null;
		}
		return this;
	}

	/**
	 * Status check before launch
	 */
	private boolean check(String messageOnError) {
		if (parameters != null && parameters.getAlgorithm() != null) {
			return true;
		} else {
			noError = false;
			System.err.println(messageOnError);
		}
		return false;
	}

	/**
	 * Set the minimum value of the algorithm to the queue
	 */
	@Override
	public Builderable setMin(int min) {
		if (check(messages.getProp("selectalgo"))) {
			parameters.setMin(min);
		}
		return this;
	}

	/**
	 * Set the maximum value of the algorithm to the queue
	 */
	@Override
	public Builderable setMax(int max) {
		if (check(messages.getProp("selectalgo"))) {
			parameters.setMax(max);
		}
		return this;
	}

	/**
	 * Displaying the solution of an equation by default off. Adds to the queue
	 */
	@Override
	public Builderable writeSolutionOn() {
		if (check(messages.getProp("selectalgo"))) {
			parameters.setWriteSolution(true);
		}
		return this;
	}

	/**
	 * Disable output of service information by default on. Adds to the queue
	 */
	@Override
	public Builderable writeInfoOff() {
		if (check(messages.getProp("selectalgo"))) {
			parameters.setWriteInfo(false);
		}
		return this;
	}

	/**
	 * Checking entered parameters
	 */
	public boolean checkParam() {
		for (RunParameters param : run) {
			if (!check(messages.getProp("wrongalgorithm"))) {
				return false;
			}
			if (!(check.checkMinMax(param.getMin(), param.getMax(), true))) {
				System.err.println(check.getMinError() + "\n" + check.getMaxError());
				noError = false;
				return false;
			}
		}
		return true;
	}

	/**
	 * Queue start for execution
	 */
	@Override
	public void buildAndRun() {
		if (noError && parameters != null) {
			run.add(parameters);
			if (checkParam()) {
				run.forEach((param) -> {
					Inputable inputs = new MyInput(param.getMin(), param.getMax());
					inputs.setWriteInfo(param.isWriteInfo());
					inputs.setWriteSolution(param.isWriteSolution());
					Solution solve = new Solution(inputs, param.getAlgorithm());
					solve.calc();
				});
				run.clear();
				parameters = null;
			}
		} else {
			noError = false;
			System.err.println(messages.getProp("wrongalgorithm"));
		}
	}
}
