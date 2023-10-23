package utils;

import input.MyInput;
import myinterfaces.Algorithmable;
import myinterfaces.Inputable;

/**
 * Class for storing data about the algorithm and data entered by the user
 */
public class RunParameters {
	private Inputable input = new MyInput();
	private Algorithmable algorithm = null;

	public int getMin() {
		return input.getMin();
	}

	public void setMin(int min) {
		input.setMin(min);
	}

	public int getMax() {
		return input.getMax();
	}

	public void setMax(int max) {
		input.setMax(max);
	}

	public boolean isWriteSolution() {
		return input.getWriteSolution();
	}

	public void setWriteSolution(boolean writeSolution) {
		input.setWriteSolution(writeSolution);
		;
	}

	public boolean isWriteInfo() {
		return input.getWriteInfo();
	}

	public void setWriteInfo(boolean writeInfo) {
		input.setWriteInfo(writeInfo);
		;
	}

	public Algorithmable getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(Algorithmable algorithm) {
		this.algorithm = algorithm;
	}
}
