package commands;

import myinterfaces.Builderable;
import myinterfaces.Commandable;
	/**
	 * Command to exit interactive mode
	 */
public class CommandExit implements Commandable {

	@Override
	public boolean execute(String param, Builderable builder,CommandType type) {
		System.exit(0);		
		return true;		
	}
}
