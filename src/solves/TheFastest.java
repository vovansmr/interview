package solves;

import java.util.HashMap;
import java.util.Objects;

import myinterfaces.Algoritm;

public class TheFastest implements Algoritm{
	
	@Override
	public String getAlgoritmName() {
		return "TheFastest";
	}
	
	@Override
	public int calc(int min,int max) {
		
		class Data{
			int a;
			public Data(int a, int b) {
				this.a = a;
				this.b = b;
			}
			int b;
			@Override
			public int hashCode() {
				return Objects.hash(a, b);
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Data other = (Data) obj;
				return a == other.a && b == other.b;
			}			
		}
		
		HashMap <Integer,HashMap <Integer,Data>> map=new HashMap<Integer,HashMap <Integer,Data>>();
		HashMap <Integer,Data> tmphash;
		int countSolves=0;
		for (int a=min;a<=max;a++)
			for (int b=min;b<=max;b++) {
				Integer key = a*a*a+b*b*b;
				if(map.get(key)==null) {
					tmphash=new HashMap<Integer,Data>();
					map.put(key, tmphash);
				}else 
					tmphash=map.get(key);
				tmphash.put(tmphash.size(), new Data(a,b));
			}
		for (HashMap<Integer, Data> tmp :map.values()) 
			countSolves+=tmp.size()*tmp.size();			
		return countSolves;
	}
}
