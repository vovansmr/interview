package commands;

import myinterfaces.Builder;
import myinterfaces.Commands;

public class CommandAddMin implements Commands {

	@Override
	public boolean execute(String param, Builder builder,CommandType type) {
		int min=Integer.parseInt(param);
		builder.setMin(min);
		return builder.getNoError();				
	}
}
