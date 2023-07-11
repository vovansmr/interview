package commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import myinterfaces.Builder;
import myinterfaces.Commands;
import utils.LoadMessages;
import utils.SolutionBuilder;

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
		builder = new SolutionBuilder();
		CommandInit commandInit = new CommandInit();
		map=commandInit.getInitedCommands(type);

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
