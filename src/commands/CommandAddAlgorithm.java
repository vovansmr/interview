package commands;

import myinterfaces.Builder;
import myinterfaces.Commands;

public class CommandAddAlgorithm implements Commands {

	@Override
	public boolean execute(String param, Builder builder,CommandType type) {
		builder.addSolve(param);
		return builder.getNoError();
	}
}