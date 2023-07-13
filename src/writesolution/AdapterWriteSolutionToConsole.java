package writesolution;

import myinterfaces.Writeble;
import solves.TheFastestData;
import utils.LoadMessages;
/**
 * Pattern adapter transforming the solution of the THEFASTEST algorithm for display
 */
public class AdapterWriteSolutionToConsole {

	private LoadMessages messages=LoadMessages.getInstance();	
	Writeble solution = null;

	public AdapterWriteSolutionToConsole(Writeble solution) {
		this.solution = solution;
	}

	public Writeble getSolution() {
		return solution;
	}

	public void setSolution(Writeble solution) {
		this.solution = solution;
	}
	/**
	 * Converting thefasters solution to output
	 */
	public void add(TheFastestData left, TheFastestData right){
		if (solution==null)throw new IllegalArgumentException(messages.getProp("adaptererror") );
		solution.add(left.getA(),left.getB(),right.getA(),right.getB());
	}	
}
