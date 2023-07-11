package utils;

import java.util.ArrayDeque;
import java.util.Queue;

import input.MyInput;
import myinterfaces.Algorithm;
import myinterfaces.Builder;
import myinterfaces.Inputs;
import myinterfaces.SimpleAlgorithmFactory;
import solves.Solution;

public class SolutionBuilder implements Builder{
	
	private RunParameters parameters=null;
	private Queue<RunParameters> run = new ArrayDeque<RunParameters>(); 
	private boolean noError=true;
	private LoadMessages messages=LoadMessages.getInstance();
	private CheckMinMaxClass check = CheckMinMaxClass.getInstance();
	private SimpleAlgorithmFactory factory=new AlgorithmFactory();
	
	public boolean getNoError() {
		boolean result =noError;
		noError=true;
		return result;
	}
	@Override
	public Builder addSolution(String algorithm) {
		if(parameters==null) parameters=new RunParameters();
		else {
			if(parameters.getAlgorithm().getAlgorithmType()!=AlgorithmType.NO) run.add(parameters);
			parameters=new RunParameters();
		}
		Algorithm algo= factory.GetAlgorithm(algorithm);
		if (algo!=null)parameters.setAlgorithm(algo);
		noError=factory.getNoError();
		if (!noError) parameters=null;
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
	public Builder writeSolutionOn() {
		if (check(messages.getProp("selectalgo"))) parameters.setWriteSolution(true);	
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
					inputs.setWriteSolution(param.isWriteSolution());
					Solution solve= new Solution(inputs,param.getAlgorithm());
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
