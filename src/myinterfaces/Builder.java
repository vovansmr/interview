package myinterfaces;

public interface Builder {
	Builder addSolve(String algoritm);
	Builder setMin(int min);
	Builder setMax(int max);
	Builder writeSolveOn();
	Builder writeInfoOff();
	void buildAndRun();
	public boolean checkParam();
	public boolean getNoError();
}
