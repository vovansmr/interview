package solves;

import myinterfaces.Algoritm;
import myinterfaces.Inputs;
import myinterfaces.TimeCalculator;
import timecalculators.TimeCalculatorSimple;

public class Solve {
	private Inputs inputs=null;
	private Algoritm algoritm=null;
	private TimeCalculator calculator= new TimeCalculatorSimple();
	
	public Algoritm getAlgoritm() {
		return algoritm;
	}

	public void setAlgoritm(Algoritm algoritm) {
		this.algoritm = algoritm;
	}

	public Solve(Inputs inputs, Algoritm algoritm) {
		this.inputs = inputs;
		this.algoritm = algoritm;
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
		if (inputs==null||algoritm==null) throw new IllegalArgumentException("Inputs or algoritm not set");
		if (inputs.getWriteInfo())System.out.println("Start algoritm "+ algoritm.getAlgoritmName()+" min=" +inputs.getMin()+ " max="+inputs.getMax()+ ".");
		calculator.start(inputs.getWriteInfo());
		result=algoritm.calc(inputs.getMin(),inputs.getMax(),calculator,inputs.getWriteSolve());		
		calculator.stop();
		if (inputs.getWriteInfo())System.out.println("Found "+result+ " solves.");
		if (inputs.getWriteInfo())System.out.println("End algoritm "+ algoritm.getAlgoritmName()+"."+calculator.getStatus());
		return result;
	}

}
