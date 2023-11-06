package writesolution;

import myinterfaces.Writeble;
import solves.TheFastestData;
import utils.LoadMessages;

/**
 * Pattern adapter transforming the solution of the THEFASTEST algorithm for
 * display
 */
public class AdapterWriteSolutionToConsole {

	final private  LoadMessages messages = LoadMessages.getInstance();
	@SuppressWarnings("UnusedAssignment")
	private Writeble solution = null;

	public AdapterWriteSolutionToConsole(Writeble solution) {
		this.solution = solution;
	}

	/**
	 * Converting thefasters solution to output
	 */
	public void add(TheFastestData left, TheFastestData right) {
		if (solution == null) {
			throw new IllegalArgumentException(messages.getProp("adaptererror"));
		}
		solution.add(left.getA(), left.getB(), right.getA(), right.getB());
	}
}
