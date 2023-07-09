package commands;

import myinterfaces.Builder;
import myinterfaces.Commands;
import utils.LoadMessages;

public class CommandHelp implements Commands {

	@Override
	public boolean execute(String param, Builder builder,CommandType type) {
		LoadMessages messages=LoadMessages.getInstance();
		
		String prefix1= (type==CommandType.RUNFROMTERMINAL)?"helpcount":"helpcounti";
		String prefix2= (type==CommandType.RUNFROMTERMINAL)?"help":"helpi";
		
		int  count=Integer.parseInt(messages.getProp(prefix1));
		for(int i=0;i<count;i++)  System.out.println(messages.getProp(prefix2+i));
		return true;		
	}

}
