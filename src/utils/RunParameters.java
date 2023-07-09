package utils;

import myinterfaces.Algorithm;
import myinterfaces.Constants;

public class RunParameters {
	private int min=Constants.MIN;
	private int max=Constants.MAX;
	private boolean writeSolve=false;
	private boolean writeInfo=true;
	private Algorithm algorithm=null;
	private AlgorithmNane name=AlgorithmNane.NO;
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public boolean isWriteSolve() {
		return writeSolve;
	}
	public void setWriteSolve(boolean writeSolve) {
		this.writeSolve = writeSolve;
	}
	public boolean isWriteInfo() {
		return writeInfo;
	}
	public void setWriteInfo(boolean writeInfo) {
		this.writeInfo = writeInfo;
	}
	public AlgorithmNane getName() {
		return name;
	}
	public void setName(AlgorithmNane name) {
		this.name = name;
	}
	public Algorithm getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}
	public void setNameAndAlgorithm(AlgorithmNane name,Algorithm algorithm) {
		setName(name);
		setAlgorithm(algorithm);
	}
}
