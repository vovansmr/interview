package commands;

import myinterfaces.Builder;
import myinterfaces.Commands;

public class CommandExit implements Commands {

	@Override
	public boolean execute(String param, Builder builder,CommandType type) {
		System.exit(0);		
		return true;		
	}
}
