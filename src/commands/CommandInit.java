package commands;

import java.util.HashMap;
import myinterfaces.Commands;

public class CommandInit {
	public CommandInit() {
		
	}
	
	public HashMap<String, Commands> getInitedCommands(CommandType type) {
		Commands tmp;
		String pref="--",pref2="-";
		if (type==CommandType.RUNINTERACTIVE) {
			pref="";
			pref2="";
		}		
		HashMap<String, Commands>map=new HashMap<String, Commands>();
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
