package myinterfaces;

import utils.AlgorithmType;

public interface Algorithm {
	public int calc(int min,int max,TimeForProgressBar calculator,boolean writeSolution,WriteSolution solution);
	//public String getAlgorithmName();
	public AlgorithmType getAlgorithmType();
}
