package commands;

import myinterfaces.Builder;
import myinterfaces.Commands;

public class CommandAddWriteInfoOff implements Commands {

	@Override
	public boolean execute(String param, Builder builder,CommandType type) {
		builder.writeInfoOff();
		return builder.getNoError();		
	}
}
