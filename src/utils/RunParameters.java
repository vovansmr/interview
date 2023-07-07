package utils;

import myinterfaces.Algoritm;
import myinterfaces.Inputs;

public class RunParameters {
	private int min=Inputs.MIN;
	private int max=Inputs.MAX;
	private boolean writeSolve=false;
	private boolean writeInfo=true;
	private Algoritm algoritm=null;
	private AlgoritmNane name=AlgoritmNane.THEFASTEST;
	public int getMin() {
		return min;
	}
	@Override
	public String toString() {
		return "RunParameters [min=" + min + ", max=" + max + ", writeSolve=" + writeSolve + ", writeInfo=" + writeInfo
				+ ", algoritm=" + algoritm + ", name=" + name + "]";
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
	public AlgoritmNane getName() {
		return name;
	}
	public void setName(AlgoritmNane name) {
		this.name = name;
	}
	public Algoritm getAlgoritm() {
		return algoritm;
	}
	public void setAlgoritm(Algoritm algoritm) {
		this.algoritm = algoritm;
	}
}
