package solves;

import myinterfaces.Algorithm;
import myinterfaces.Inputs;
import myinterfaces.TimeCalculator;
import myinterfaces.TimeForProgressBar;
import myinterfaces.WriteSolution;
import timecalculators.TimeCalculatorSimple;
import utils.LoadMessages;
import writesolution.WriteSolutionToConsole;

public class Solution {
	private Inputs inputs=null;
	private Algorithm algorithm=null;
	private TimeCalculator calculator= new TimeCalculatorSimple();
	private LoadMessages messages=LoadMessages.getInstance();
	private WriteSolution solution=new WriteSolutionToConsole();
	
	public Algorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	public Solution(Inputs inputs, Algorithm algorithm) {
		this.inputs = inputs;
		this.algorithm = algorithm;
	}

	public Solution() {
	}
	
	public Inputs getInputs() {
		return inputs;
	}

	public void setInputs(Inputs inputs) {
		this.inputs = inputs;
	}
	
	public int calc() {
		int result=0;
		if (inputs==null||algorithm==null) throw new IllegalArgumentException(messages.getProp("inputsER"));
		if (inputs.getWriteInfo())System.out.println(messages.getProp("StartAL")+ algorithm.getAlgorithmType()+messages.getProp("min")
			+inputs.getMin()+ messages.getProp("max")+inputs.getMax()+ messages.getProp("dot"));
		calculator.start(inputs.getWriteInfo());
		result=algorithm.calc(inputs.getMin(),inputs.getMax(),(TimeForProgressBar)calculator,inputs.getWriteSolution(),solution);		
		calculator.stop();
		solution.printAll();
		solution.clear();
		if (inputs.getWriteInfo())System.out.println(messages.getProp("found")+result+ messages.getProp("solutions"));
		if (inputs.getWriteInfo())System.out.println(messages.getProp("endalgo")+ algorithm.getAlgorithmType()+messages.getProp("dot")+calculator.getStatus());
		return result;
	}

}
