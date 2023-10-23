package commands;

import myinterfaces.Builderable;
import myinterfaces.Commandable;

/**
 * Сommand to add the maximum value of the algorithm to the queue
 */
public class CommandAddMax implements Commandable {

	@Override
	public boolean execute(String param, Builderable builder, CommandType type) {
		int max = Integer.parseInt(param);
		builder.setMax(max);
		return builder.getNoError();
	}
}
