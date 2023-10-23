package commands;

import myinterfaces.Builderable;
import myinterfaces.Commandable;

/**
 * Сommand to add the minimum value of the algorithm to the queue
 */
public class CommandAddMin implements Commandable {

	@Override
	public boolean execute(String param, Builderable builder, CommandType type) {
		int min = Integer.parseInt(param);
		builder.setMin(min);
		return builder.getNoError();
	}
}
