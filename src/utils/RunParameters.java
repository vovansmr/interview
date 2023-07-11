package utils;

import myinterfaces.Algorithm;
import myinterfaces.Constants;

public class RunParameters {
	private int min=Constants.MIN;
	private int max=Constants.MAX;
	private boolean writeSolution=false;
	private boolean writeInfo=true;
	private Algorithm algorithm=null;
	private AlgorithmType type=AlgorithmType.NO;
	
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
	public boolean isWriteSolution() {
		return writeSolution;
	}
	public void setWriteSolution(boolean writeSolution) {
		this.writeSolution = writeSolution;
	}
	public boolean isWriteInfo() {
		return writeInfo;
	}
	public void setWriteInfo(boolean writeInfo) {
		this.writeInfo = writeInfo;
	}
	public AlgorithmType getType() {
		return type;
	}
	public void setType(AlgorithmType type) {
		this.type = type;
	}
	public Algorithm getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
		type= algorithm.getAlgorithmType();
	}
}
