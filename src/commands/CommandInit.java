package commands;

import java.util.HashMap;
import myinterfaces.Commandable;

	/**
	 * Initializing a HashMap with Commands
	 * 
	 */	
public class CommandInit {
	public CommandInit() {
		
	}
	/**
	 * Initializing a HashMap with Commands
	 * Facade template
	 * @param type type mode with parameters or interactive {@link CommandType}
	 * @return HashMap with Commands
	 */	
	public HashMap<String, Commandable> getInitedCommands(CommandType type) {
		Commandable tmp;
		String pref="--",pref2="-";
		if (type==CommandType.RUNINTERACTIVE) {
			pref="";
			pref2="";
		}		
		HashMap<String, Commandable>map=new HashMap<String, Commandable>();
		map.put(pref+"min", new CommandAddMin());
		map.put(pref+"max", new CommandAddMax());
		map.put(pref+"writeinfooff", new CommandAddWriteInfoOff());
		map.put(pref+"writesolutionon", new CommandAddWriteSolutionOn());
		tmp = new CommandAddAlgorithm();
		map.put(pref+"algorithm", tmp);
		map.put(pref2+"a", tmp);
		tmp = new CommandHelp();
		map.put(pref+"help", tmp);
		map.put(pref2+"h", tmp);
		if (type==CommandType.RUNINTERACTIVE) {
			map.put("run", new CommandRun());
			map.put("exit", new CommandExit());
		}
		return map;		
	}
}
