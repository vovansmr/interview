package commands;

import myinterfaces.Builder;
import myinterfaces.Commands;

public class CommandAddMax implements Commands {

	@Override
	public boolean execute(String param, Builder builder,CommandType type) {
		int max=Integer.parseInt(param);
		builder.setMax(max);
		return builder.getNoError();
	}
}
