package commands;

import myinterfaces.Builder;
import myinterfaces.Commands;

public class CommandAddWriteSolutionOn implements Commands {

	@Override
	public boolean execute(String param, Builder builder,CommandType type) {
		builder.writeSolutionOn();
		return builder.getNoError();	
	}
}
