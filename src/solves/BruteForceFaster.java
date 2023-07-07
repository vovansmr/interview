package solves;

import myinterfaces.Algoritm;
import myinterfaces.TimeCalculator;

public class BruteForceFaster implements Algoritm{
	
	@Override
	public String getAlgoritmName() {
		return "BruteForceFaster";
	}
	
	@Override
	public int calc(int min,int max,TimeCalculator calculator,boolean writeSolve) {
		int countSolves=0,counter=0;
		calculator.setTotalCounter((max-min+1)*(max-min+1)*(max-min+1));
		for (int a=min;a<=max;a++)
			for (int b=min;b<=max;b++)
				for (int c=min;c<=max;c++) {
						double tmp = Math.cbrt(Math.pow(a, 3)+Math.pow(b, 3)-Math.pow(c, 3));
						calculator.setCounter(++counter);
						if (tmp>=min&&tmp<=max&&tmp-((int)tmp)==0) {
							countSolves++; 
							if (writeSolve)System.out.println(a+"^3+"+b+"^3="+c+"^3+"+(int)tmp+"^3");
						}
				}			
		return countSolves;
	}
}