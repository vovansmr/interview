package solves;

import java.util.HashMap;
import myinterfaces.Algorithm;
import myinterfaces.TimeForProgressBar;
import myinterfaces.WriteSolution;
import utils.AlgorithmType;
import writesolution.AdapterWriteSolutionToConsole;

public class TheFastest implements Algorithm{
	@Override
	public AlgorithmType getAlgorithmType() {
		return AlgorithmType.THEFASTEST;
	}
	
	@Override
	public int calc(int min,int max,TimeForProgressBar calculator, boolean writeSolution,WriteSolution solution) {
		HashMap <Integer,HashMap <Integer,TheFastestData>> map=new HashMap<Integer,HashMap <Integer,TheFastestData>>();
		HashMap <Integer,TheFastestData> tmphash;
		int countSolution=0,counter=0;
		calculator.setTotalCounter((max-min+1)*(max-min+1));
		for (int a=min;a<=max;a++)
			for (int b=min;b<=max;b++) {
				Integer key = a*a*a+b*b*b;
				if(map.get(key)==null) {
					tmphash=new HashMap<Integer,TheFastestData>();
					map.put(key, tmphash);
				}else 
					tmphash=map.get(key);
				tmphash.put(tmphash.size(), new TheFastestData(a,b));
				calculator.setCounter(++counter);
			}
		AdapterWriteSolutionToConsole adapter =new AdapterWriteSolutionToConsole(solution);
		
		for (HashMap<Integer, TheFastestData> tmp :map.values()) {
			countSolution+=tmp.size()*tmp.size();
			if (writeSolution)
				for (int i=0;i<tmp.size();i++)
					for (int j=0;j<tmp.size();j++)
						adapter.add(tmp.get(i), tmp.get(j));
		}	
		return countSolution;
	}
}
