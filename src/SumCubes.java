import commands.CommandParser;

public class SumCubes {

	public static void main(String[] args) {
		/**
		 * Creates a parser and passes it the parameters entered in the command line
		 */		
		CommandParser parser=new CommandParser(args);
		parser.parse();
		
	} 

}
