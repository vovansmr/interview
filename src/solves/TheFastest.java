package solves;

import java.util.HashMap;
import myinterfaces.Algorithm;
import myinterfaces.TimeForProgressBar;
import myinterfaces.WriteSolve;
import utils.LoadMessages;

public class TheFastest implements Algorithm{
	private LoadMessages messages=LoadMessages.getInstance();
	@Override
	public String getAlgorithmName() {
		return messages.getProp("TheFastest");
	}
	
	@Override
	public int calc(int min,int max,TimeForProgressBar calculator, boolean writeSolve,WriteSolve solve) {
		HashMap <Integer,HashMap <Integer,TheFastestData>> map=new HashMap<Integer,HashMap <Integer,TheFastestData>>();
		HashMap <Integer,TheFastestData> tmphash;
		int countSolves=0,counter=0;
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
		for (HashMap<Integer, TheFastestData> tmp :map.values()) {
			countSolves+=tmp.size()*tmp.size();
			if (writeSolve)
				for (int i=0;i<tmp.size();i++)
					for (int j=0;j<tmp.size();j++)
						solve.add(tmp.get(i), tmp.get(j));
		}	
		return countSolves;
	}
}
