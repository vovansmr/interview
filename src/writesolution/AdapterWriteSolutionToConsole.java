package writesolution;

import myinterfaces.WriteSolution;
import solves.TheFastestData;
import utils.LoadMessages;

public class AdapterWriteSolutionToConsole {

	private LoadMessages messages=LoadMessages.getInstance();	
	WriteSolution solution = null;

	public AdapterWriteSolutionToConsole(WriteSolution solution) {
		this.solution = solution;
	}

	public WriteSolution getSolution() {
		return solution;
	}

	public void setSolution(WriteSolution solution) {
		this.solution = solution;
	}
	public void add(TheFastestData left, TheFastestData right){
		if (solution==null)throw new IllegalArgumentException(messages.getProp("adaptererror") );
		solution.add(left.getA(),left.getB(),right.getA(),right.getB());
	}	
}
