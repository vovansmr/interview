package solves;

import myinterfaces.Algorithm;
import myinterfaces.TimeForProgressBar;
import myinterfaces.WriteSolve;
import utils.LoadMessages;

public class BruteForceFaster implements Algorithm{
	private LoadMessages messages=LoadMessages.getInstance();

	@Override
	public String getAlgorithmName() {
		return messages.getProp("BruteForceFaster");
	}
	
	@Override
	public int calc(int min,int max,TimeForProgressBar calculator,boolean writeSolve,WriteSolve solve) {
		int countSolves=0,counter=0;
		calculator.setTotalCounter((max-min+1)*(max-min+1)*(max-min+1));
		for (int a=min;a<=max;a++)
			for (int b=min;b<=max;b++)
				for (int c=min;c<=max;c++) {
						double tmp = Math.cbrt(Math.pow(a, 3)+Math.pow(b, 3)-Math.pow(c, 3));
						calculator.setCounter(++counter);
						if (tmp>=min&&tmp<=max&&tmp-((int)tmp)==0) {
							countSolves++; 
							if (writeSolve) solve.add(a, b, c, (int)tmp);
						}
				}			
		return countSolves;
	}
}