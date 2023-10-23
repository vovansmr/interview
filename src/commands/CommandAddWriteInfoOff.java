package commands;

import myinterfaces.Builderable;
import myinterfaces.Commandable;

/**
 * Сommand to disable output of service information. Adds to the queue
 */
public class CommandAddWriteInfoOff implements Commandable {

	@Override
	public boolean execute(String param, Builderable builder, CommandType type) {
		builder.writeInfoOff();
		return builder.getNoError();
	}
}
