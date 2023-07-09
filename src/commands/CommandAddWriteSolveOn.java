package commands;

import myinterfaces.Builder;
import myinterfaces.Commands;

public class CommandAddWriteSolveOn implements Commands {

	@Override
	public boolean execute(String param, Builder builder,CommandType type) {
		builder.writeSolveOn();
		return builder.getNoError();	
	}
}
