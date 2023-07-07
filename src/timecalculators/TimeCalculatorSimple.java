package timecalculators;

import myinterfaces.TimeCalculator;
import utils.ProgressBar;

public class TimeCalculatorSimple implements TimeCalculator {
	private long startTime,stopTime;
	private ProgressBar progressBar;
	private long totalCounter;
	
	@Override
	public void start(boolean writeInfo) {
		startTime=System.nanoTime();
		stopTime=0;
		progressBar= new ProgressBar(startTime);
		progressBar.setEnable(writeInfo);
	}

	@Override
	public void stop() {
		stopTime=System.nanoTime();
	}

	@Override
	public void setCounter(long counter) {
		progressBar.progressPercentage(counter, totalCounter);
	}

	@Override
	public void setTotalCounter(long totalCounter) {
		this.totalCounter=totalCounter;
	}

	@Override
	public String getStatus() {
		if (startTime!=0&&stopTime!=0) {
			String result= "\nWorking time " + (stopTime-startTime)/1.0/ProgressBar.sec1 +" sec.\n";
			return result;
		}
		return "";
	}

}
