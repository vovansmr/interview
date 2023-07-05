package solves;

import myinterfaces.Algoritm;

public class BruteForceFaster implements Algoritm{
	
	@Override
	public String getAlgoritmName() {
		return "BruteForceFaster";
	}
	
	@Override
	public int calc(int min,int max) {
		int countSolves=0;
		for (int a=min;a<=max;a++)
			for (int b=min;b<=max;b++)
				for (int c=min;c<=max;c++) {
						double tmp = Math.cbrt(Math.pow(a, 3)+Math.pow(b, 3)-Math.pow(c, 3));
						if (tmp>=min&&tmp<=max&&tmp-((int)tmp)==0) {
							countSolves++; 
							//System.out.println(a+"^3+"+b+"^3="+c+"^3+"+d+"^3");
						}
				}			
		return countSolves;
	}
}