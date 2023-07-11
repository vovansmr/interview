package myinterfaces;

public interface Builder {
	Builder addSolution(String algoritm);
	Builder setMin(int min);
	Builder setMax(int max);
	Builder writeSolutionOn();
	Builder writeInfoOff();
	void buildAndRun();
	public boolean checkParam();
	public boolean getNoError();
}
