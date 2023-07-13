package commands;

import myinterfaces.Builderable;
import myinterfaces.Commandable;
	/**
	 * Command for displaying the solution of an equation. Adds to the queue
	 */
public class CommandAddWriteSolutionOn implements Commandable {

	@Override
	public boolean execute(String param, Builderable builder,CommandType type) {
		builder.writeSolutionOn();
		return builder.getNoError();	
	}
}
