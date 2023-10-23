package commands;

import myinterfaces.Builderable;
import myinterfaces.Commandable;

/**
 * Сommand to add the selected algorithm to the queue
 */
public class CommandAddAlgorithm implements Commandable {
	/**
	 * Сommand to add the selected algorithm to the queue
	 * 
	 * @param param String algorithm name
	 */
	@Override
	public boolean execute(String param, Builderable builder, CommandType type) {
		builder.addSolution(param);
		return builder.getNoError();
	}
}
