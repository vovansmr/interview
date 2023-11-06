package commands;

import myinterfaces.Builderable;
import myinterfaces.Commandable;
import utils.LoadMessages;

/**
 * Help command. Works with parameters and in interactive modes
 */
public class CommandHelp implements Commandable {

	@Override
	public boolean execute(String param, Builderable builder, CommandType type) {
		LoadMessages messages = LoadMessages.getInstance();
		// Selection of prefixes depending on operating modes
		String prefix1 = (type == CommandType.RUNFROMTERMINAL) ? "helpcount" : "helpcounti";
		String prefix2 = (type == CommandType.RUNFROMTERMINAL) ? "help" : "helpi";

		int count = Integer.parseInt(messages.getProp(prefix1));
		for (int i = 0; i < count; i++) {
			System.out.println(messages.getProp(prefix2 + i));
		}
		return true;
	}

}
