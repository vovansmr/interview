package myinterfaces;

public interface Inputs {
	public int getMin();
	public void setMin(int min);
	public int getMax();
	public void setMax(int max);
	public void setWriteSolve(boolean writeSolve);
	public boolean getWriteSolve();
	public boolean getWriteInfo();
	public void setWriteInfo(boolean writeInfo);
	public static final int MIN=1;
	public static final int MAX=1000;

}
