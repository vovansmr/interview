package myinterfaces;

import commands.CommandInit;
import commands.CommandType;

/**
 * Command template interface
 */
public interface Commandable {
	/**
	 * Command template interface parameters
	 * 
	 * @param param   command options {@link CommandInit}
	 * @param builder template builder {@link Builderable}
	 * @param type    mode with parameters or interactive {@link CommandType}
	 * @return Returns true if the command was successful
	 */
    boolean execute(String param, Builderable builder, CommandType type);

}
