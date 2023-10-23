package utils;

import myinterfaces.Algorithmable;
import myinterfaces.SimpleAlgorithmFactory;
import solves.BruteForce;
import solves.BruteForceFaster;
import solves.TheFastest;

/**
 * Factory for creating algorithms
 */
public class AlgorithmFactory implements SimpleAlgorithmFactory {

	private boolean noError = true;
	private LoadMessages messages = LoadMessages.getInstance();

	/**
	 * Checking the No Error Flag
	 */
	@Override
	public boolean getNoError() {
		boolean result = noError;
		noError = true;
		return result;
	}

	/**
	 * Factory for creating algorithms
	 */
	@Override
	public Algorithmable GetAlgorithm(String algorithm) {
		Algorithmable algo = null;
		switch (algorithm) {
		case "bruteforse":
		case "BRUTEFORSE":
		case "BF":
			algo = new BruteForce();
			break;

		case "bruteforsefaster":
		case "BRUTEFORSEFASTER":
		case "BFF":
			algo = new BruteForceFaster();
			break;

		case "THEFASTEST":
		case "thefastest":
		case "TF":
			algo = new TheFastest();
			break;

		default:
			noError = false;
			System.err.println(messages.getProp("wrongalgorithm"));
			break;
		}
		return algo;
	}

}
