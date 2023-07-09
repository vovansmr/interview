package commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import myinterfaces.Builder;
import myinterfaces.Commands;
import utils.LoadMessages;
import utils.SolvesBuilder;

public class CommandParser {
	private HashMap<String, Commands> map;
	private CommandType type;
	private Builder builder;
	private String []args=null;
	LoadMessages messages=LoadMessages.getInstance();
	
	public CommandParser() {
		type=CommandType.RUNINTERACTIVE;
		init();
	}
	
	public CommandParser(String[] args) {
		if (args.length>0) {
			this.args = args;
			type=CommandType.RUNFROMTERMINAL;
		}else {
			type=CommandType.RUNINTERACTIVE;
		}
		init();
	}
	
	private void init() {
		Commands tmp;
		String pref="--",pref2="-";
		if (type==CommandType.RUNINTERACTIVE) {
			pref="";
			pref2="";
		}
		builder = new SolvesBuilder();
		map=new HashMap<String, Commands>();
		map.put(pref+"min", new CommandAddMin());
		map.put(pref+"max", new CommandAddMax());
		map.put(pref+"writeinfooff", new CommandAddWriteInfoOff());
		map.put(pref+"writesolveon", new CommandAddWriteSolveOn());
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
	}

	private boolean parseCommands(String[] workString) {
		boolean noError=true;		
		String [] tmp;
		for(int i=0;i<workString.length&&noError;i++) {			
			tmp =workString[i].split("[=]");
			Commands commands= map.get(tmp[0].trim());
			if (commands!=null&&noError) {
				try {
					if(tmp.length==2) noError= commands.execute(tmp[1].trim(), builder,type);
					else noError= commands.execute("", builder,type);
				}catch ( Exception exc){
					System.err.println(messages.getProp("error")+ workString[i]);
					noError=false;
				}
			}else {
				System.err.println(messages.getProp("errorUP")+workString[i]);
				noError=false;
			}
		}
		return noError;
	}
	
	private void parse_interactive() {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(messages.getProp("interactive"));
		String commandint="";		
		String [] workString;
		boolean noError=true;
		try {
			while(true) {
				System.out.print(">");
				commandint = read.readLine();
				workString= commandint.split("[ ]");
				noError = parseCommands(workString);
				if (noError) System.out.println(messages.getProp("ok"));
				noError=true;
			}
		} catch (IOException e) {
			System.out.println(messages.getProp("interactiveerror"));
			//e.printStackTrace();
		}		
	}
	
	public void parse() {
		if (type==CommandType.RUNINTERACTIVE) parse_interactive();
		else {
			boolean noError = parseCommands(args);
			if (noError&&!(args.length==1&&(args[0].equals("-h")||args[0].equals("--help"))))builder.buildAndRun();
		}
	}	
}
