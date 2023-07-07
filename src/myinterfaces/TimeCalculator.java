package myinterfaces;

public interface TimeCalculator {
	public void start(boolean writeInfo);
	public void stop();
	public void setCounter(long counter);
	public void setTotalCounter(long counter);
	public String getStatus();
}
