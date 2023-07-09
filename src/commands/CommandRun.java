package commands;

import myinterfaces.Builder;
import myinterfaces.Commands;

public class CommandRun implements Commands {

	@Override
	public boolean execute(String param, Builder builder,CommandType type) {
		if(builder.checkParam())builder.buildAndRun();
		return builder.getNoError();		
	}
}
