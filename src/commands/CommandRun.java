package commands;

import myinterfaces.Builderable;
import myinterfaces.Commandable;
	/**
	 * Start queue processing
	 * 
	 */
public class CommandRun implements Commandable {

	@Override
	public boolean execute(String param, Builderable builder,CommandType type) {
		if(builder.checkParam())builder.buildAndRun();
		return builder.getNoError();		
	}
}
