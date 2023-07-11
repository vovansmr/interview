package utils;

import myinterfaces.Algorithm;
import myinterfaces.SimpleAlgorithmFactory;
import solves.BruteForce;
import solves.BruteForceFaster;
import solves.TheFastest;

public class AlgorithmFactory implements SimpleAlgorithmFactory {
	
	private boolean noError=true;
	private LoadMessages messages=LoadMessages.getInstance();
	@Override
	public boolean getNoError() {
		boolean result =noError;
		noError=true;
		return result;
	}

	@Override
	public Algorithm GetAlgorithm(String algorithm) {
		Algorithm algo=null;
		switch (algorithm) {		
			case "bruteforse":
			case "BRUTEFORSE":
	        case "BF":
	        	algo=new BruteForce();
	            break;
	            
	        case "bruteforsefaster":   
	        case "BRUTEFORSEFASTER":
	        case "BFF":
	        	algo=new BruteForceFaster();
	            break;
	                     
	        case "THEFASTEST":
	        case "thefastest":
	        case "TF":
	        	algo=new TheFastest();
	            break;  
	            
	        default:
	        	noError=false;
	        	System.err.println(messages.getProp("wrongalgorithm"));
	        	break;        
		}
		return algo;
	}
	
}
