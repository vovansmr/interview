package timecalculators;

import myinterfaces.TimeCalculator;
import myinterfaces.TimeForProgressBar;
import utils.LoadMessages;
import utils.ProgressBar;

public class TimeCalculatorSimple implements TimeCalculator,TimeForProgressBar {
	private long startTime,stopTime;
	private ProgressBar progressBar;
	private long totalCounter;
	private LoadMessages messages=LoadMessages.getInstance();
	
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
			String result= "\n"+messages.getProp("workingtime") + (stopTime-startTime)/1.0/ProgressBar.sec1 +messages.getProp("sec")+"\n";
			return result;
		}
		return "";
	}

}
