package utils;

import java.util.ArrayDeque;
import java.util.Queue;

import input.MyInput;
import myinterfaces.Builder;
import myinterfaces.Inputs;
import solves.BruteForce;
import solves.BruteForceFaster;
import solves.Solve;
import solves.TheFastest;

public class SolvesBuilder implements Builder{
	
	private RunParameters parameters=null;
	private Queue<RunParameters> run = new ArrayDeque<RunParameters>(); 
	private boolean noError=true;
	private LoadMessages messages=LoadMessages.getInstance();
	private CheckMinMaxClass check = CheckMinMaxClass.getInstance();
	
	public boolean getNoError() {
		boolean result =noError;
		noError=true;
		return result;
	}
	@Override
	public Builder addSolve(String algoritm) {
		if(parameters==null) parameters=new RunParameters();
		else {
			run.add(parameters);
			parameters=new RunParameters();
		}
		noError=true;
		
		switch (algoritm) {		
			case "bruteforse":
			case "BRUTEFORSE":
	        case "BF":
	        	parameters.setNameAndAlgorithm(AlgorithmNane.BRUTEFORSE, new BruteForce());
	            break;
	            
	        case "bruteforsefaster":   
	        case "BRUTEFORSEFASTER":
	        case "BFF":
	        	parameters.setNameAndAlgorithm(AlgorithmNane.BRUTEFORSEFASTER,new BruteForceFaster());
	            break;
	                     
	        case "THEFASTEST":
	        case "thefastest":
	        case "TF":
	        	parameters.setNameAndAlgorithm(AlgorithmNane.THEFASTEST,new TheFastest());
	            break;  
	            
	        default:
	        	noError=false;
	        	System.err.println(messages.getProp("wrongalgorithm"));
	        	parameters=null;
	        	break;
            
		}
		return this;
	}

	private boolean check(String messageOnError) {
		if (parameters!=null&&parameters.getAlgorithm()!=null){
			return true;
		}else {
			noError=false;
        	System.err.println(messageOnError);        	
		}
		return false;
	}
	
	@Override
	public Builder setMin(int min) {
		if (check(messages.getProp("selectalgo"))) parameters.setMin(min);		
		return this;
	}

	@Override
	public Builder setMax(int max) {
		if (check(messages.getProp("selectalgo"))) parameters.setMax(max);		
		return this;
	}

	@Override
	public Builder writeSolveOn() {
		if (check(messages.getProp("selectalgo"))) parameters.setWriteSolve(true);	
		return this;
	}

	@Override
	public Builder writeInfoOff() {
		if (check(messages.getProp("selectalgo"))) parameters.setWriteInfo(false);
		return this;
	}
	
	public boolean checkParam() {
		for (RunParameters param: run) {		
			if(!check(messages.getProp("wrongalgorithm")))return false;
			
			if (!(check.checkMinMax(param.getMin(),param.getMax(), true))) {
				System.err.println(check.getMinError()+"\n"+check.getMaxError());
				noError=false;
				return false;
			}
		}
		return true;
	}

	@Override
	public void buildAndRun() {
		if (noError&&parameters!=null) {
			run.add(parameters);
			if (checkParam()) {
				run.forEach((param)->{
					Inputs inputs=  new MyInput(param.getMin(),param.getMax());
					inputs.setWriteInfo(param.isWriteInfo());
					inputs.setWriteSolve(param.isWriteSolve());
					Solve solve= new Solve(inputs,param.getAlgorithm());
					solve.calc();
				});
			run.clear();
			parameters=null;
			}
		}else {
			noError=false;
			System.err.println(messages.getProp("wrongalgorithm"));
		}
	}
}
