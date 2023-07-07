package solves;

import myinterfaces.Algoritm;
import myinterfaces.TimeCalculator;

public class BruteForce implements Algoritm{
	
	@Override
	public String getAlgoritmName() {
		return "BruteForce";
	}

	@Override
	public int calc(int min,int max,TimeCalculator calculator,boolean writeSolve) {
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
							if (writeSolve)System.out.println(a+"^3+"+b+"^3="+c+"^3+"+d+"^3");
						}
						calculator.setCounter(++counter);
					}
		return countSolves;
	}
}
