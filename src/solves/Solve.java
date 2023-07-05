package solves;

import myinterfaces.Algoritm;
import myinterfaces.Inputs;

public class Solve {
	private Inputs inputs=null;
	private Algoritm algoritm=null;
	
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
		long time2,time1;
		if (inputs==null||algoritm==null)System.out.println("Inputs or algoritm not set");
		else {
			System.out.println("Start algoritm "+ algoritm.getAlgoritmName());
			time1=System.nanoTime();
			result=algoritm.calc(inputs.getMin(),inputs.getMax());		
			time2=System.nanoTime();
			System.out.println("Found "+result+ " solves");
			System.out.println("End algoritm "+ algoritm.getAlgoritmName()+"\nWorking time " + (time2-time1)/1000000000.0+"sec.\n");
		}
		return result;
	}

}
