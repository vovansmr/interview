package solves;

import myinterfaces.Algorithm;
import myinterfaces.TimeForProgressBar;
import myinterfaces.WriteSolve;
import utils.LoadMessages;

public class BruteForce implements Algorithm{
	private LoadMessages messages=LoadMessages.getInstance();
	
	@Override
	public String getAlgorithmName() {
		return messages.getProp("BruteForce");
	}

	@Override
	public int calc(int min,int max,TimeForProgressBar calculator,boolean writeSolve,WriteSolve solve) {
		int countSolves=0;
		long counter=(max-min+1);
		counter*=counter*counter*counter;
		calculator.setTotalCounter(counter);
		counter=0;
		for (int a=min;a<=max;a++)
			for (int b=min;b<=max;b++)
				for (int c=min;c<=max;c++)
					for (int d=min;d<=max;d++) {
						if (Math.pow(a, 3)+Math.pow(b, 3)==Math.pow(c, 3)+Math.pow(d, 3)) {
							countSolves++; 
							if (writeSolve) solve.add(a, b, c, d);
						}
						calculator.setCounter(++counter);
					}
		return countSolves;
	}
}
