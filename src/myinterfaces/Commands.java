package myinterfaces;

import commands.CommandType;

public interface Commands {
	public boolean execute (String param, Builder builder,CommandType type);
}
