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
	
	@Override
	public Builder addSolve(String algoritm) {
		if(parameters==null) parameters=new RunParameters();
		else {
			run.add(parameters);
			parameters=new RunParameters();
		}
		
		switch (algoritm) {		
			case "bruteforse":
			case "BRUTEFORSE":
	        case "BF":
	        	parameters.setName(AlgoritmNane.BRUTEFORSE);
	        	parameters.setAlgoritm(new BruteForce());
	            break;
	            
	        case "bruteforsefaster":   
	        case "BRUTEFORSEFASTER":
	        case "BFF":
	        	parameters.setName(AlgoritmNane.BRUTEFORSEFASTER);
	        	parameters.setAlgoritm(new BruteForceFaster());
	            break;
	                     
	        case "THEFASTEST":
	        case "thefastest":
	        case "TF":
	        	parameters.setName(AlgoritmNane.THEFASTEST);
	        	parameters.setAlgoritm(new TheFastest());
	            break;   
	            
		}
		return this;
	}

	@Override
	public Builder setMin(int min) {
		parameters.setMin(min);
		return this;
	}

	@Override
	public Builder setMax(int max) {
		parameters.setMax(max);
		return this;
	}

	@Override
	public Builder writeSolveOn() {
		parameters.setWriteSolve(true);
		return this;
	}

	@Override
	public Builder writeInfoOff() {
		parameters.setWriteInfo(false);
		return this;
	}
	
	boolean checkParam() {
		for (RunParameters param: run) 
			if (!(param.getAlgoritm()!=null&&MyInput.checkMinMax(param.getMin(),param.getMax(), true))) {
				System.err.print("checking parameters error");
				return false;
			}
		return true;
	}

	@Override
	public void buildAndRun() {
		run.add(parameters);
		if (checkParam()) {
			//run.add(parameters);
			//Solve solve= null;
			run.forEach((param)->{
				Inputs inputs=  new MyInput(param.getMin(),param.getMax());
				inputs.setWriteInfo(param.isWriteInfo());
				inputs.setWriteSolve(param.isWriteSolve());
				Solve solve= new Solve(inputs,param.getAlgoritm());
				solve.calc();
			});
			/*
			for (RunParameters param: run) {
				Inputs inputs=  new MyInput(param.getMin(),param.getMax());
				inputs.setWriteInfo(param.isWriteInfo());
				inputs.setWriteSolve(param.isWriteSolve());
				solve= new Solve(inputs,param.getAlgoritm());
				solve.calc();
				
			}*/
		run.clear();
		}
		
	}

}
