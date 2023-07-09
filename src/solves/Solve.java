package solves;

import myinterfaces.Algorithm;
import myinterfaces.Inputs;
import myinterfaces.TimeCalculator;
import myinterfaces.TimeForProgressBar;
import myinterfaces.WriteSolve;
import timecalculators.TimeCalculatorSimple;
import utils.LoadMessages;
import writesolve.WriteSolveToConsole;

public class Solve {
	private Inputs inputs=null;
	private Algorithm algorithm=null;
	private TimeCalculator calculator= new TimeCalculatorSimple();
	private LoadMessages messages=LoadMessages.getInstance();
	private WriteSolve solve=new WriteSolveToConsole();
	
	public Algorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	public Solve(Inputs inputs, Algorithm algorithm) {
		this.inputs = inputs;
		this.algorithm = algorithm;
	}

	public Solve() {
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
		if (inputs.getWriteInfo())System.out.println(messages.getProp("StartAL")+ algorithm.getAlgorithmName()+messages.getProp("min")
			+inputs.getMin()+ messages.getProp("max")+inputs.getMax()+ messages.getProp("dot"));
		calculator.start(inputs.getWriteInfo());
		result=algorithm.calc(inputs.getMin(),inputs.getMax(),(TimeForProgressBar)calculator,inputs.getWriteSolve(),solve);		
		calculator.stop();
		solve.printAll();
		solve.clear();
		if (inputs.getWriteInfo())System.out.println(messages.getProp("found")+result+ messages.getProp("solves"));
		if (inputs.getWriteInfo())System.out.println(messages.getProp("endalgo")+ algorithm.getAlgorithmName()+messages.getProp("dot")+calculator.getStatus());
		return result;
	}

}
