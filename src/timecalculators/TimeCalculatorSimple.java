package timecalculators;

import myinterfaces.Temporally;
import myinterfaces.Barable;
import myinterfaces.Inputable;
import utils.LoadMessages;
import utils.ProgressBar;

/**
 * Class for time processing and for working with progress bar
 */
public class TimeCalculatorSimple implements Temporally, Barable {
	private long startTime, stopTime;
	private ProgressBar progressBar;
	private long totalCounter;
	private LoadMessages messages = LoadMessages.getInstance();

	/**
	 * Start of processing Parameters:
	 * 
	 * @param writeInfo disable output of service information.
	 *                  {@link Inputable#setWriteInfo(boolean)}
	 */
	@Override
	public void start(boolean writeInfo) {
		startTime = System.nanoTime();
		stopTime = 0;
		progressBar = new ProgressBar(startTime);
		progressBar.setEnable(writeInfo);
	}

	/**
	 * Stop of processing
	 */
	@Override
	public void stop() {
		stopTime = System.nanoTime();
	}

	/**
	 * setting the counter value for calculating the remaining time,% counter
	 * completed operations counter
	 */
	@Override
	public void setCounter(long counter) {
		progressBar.progressPercentage(counter, totalCounter);
	}

	/**
	 * setting the maximum value of the counter totalCounter maximum value of the
	 * counter
	 */
	@Override
	public void setTotalCounter(long totalCounter) {
		this.totalCounter = totalCounter;
	}

	/**
	 * Derivation of the running time of the algorithm
	 */
	@Override
	public String getStatus() {
		if (startTime != 0 && stopTime != 0) {
			String result = "\n" + messages.getProp("workingtime") + (stopTime - startTime) / 1.0 / ProgressBar.sec1
					+ messages.getProp("sec") + "\n";
			return result;
		}
		return "";
	}

}
