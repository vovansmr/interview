package utils;

/**
 * Class progress bar
 */
@SuppressWarnings("unused")
public class ProgressBar {
	final String iconLeftBoundary = "[";
	final String iconDone = "=";
	final String iconRemain = ".";
	final String iconRightBoundary = "]";
	final public static long SEC_1 = 1000000000;
	@SuppressWarnings("FieldCanBeLocal")
	final private int size = 10;
	@SuppressWarnings("UnusedAssignment")
	private long lastDone = 0;
	@SuppressWarnings("UnusedAssignment")
	private long startTimer = 0;
	private boolean enable = true;
	private final LoadMessages messages = LoadMessages.getInstance();

	/**
	 * Calculation of the remaining time of the algorithm
	 */
	public String getTime(long done, long total) {
		StringBuilder time = new StringBuilder(messages.getProp("timeleft"));
		long currentTime = System.nanoTime();
		long tmp = (long) (((currentTime - startTimer) * (total * 1.0 / done) - (currentTime - startTimer)) / SEC_1);
		time.append(tmp);
		time.append(messages.getProp("sec"));
		return time.toString();
	}

	/**
	 * Output progress bar 1 time per second
	 */
	public void progressPercentage(long done, long total) {
		long donePercents = (100 * done) / total;
		if (enable && (100 == donePercents || System.nanoTime() > lastDone)) {
			lastDone = System.nanoTime() + SEC_1;
			if (done > total) {
				throw new IllegalArgumentException(messages.getProp("done") + done + messages.getProp("total") + total);
			}
			long doneLength = size * donePercents / 100;
			StringBuilder bar = new StringBuilder(iconLeftBoundary);
			for (int i = 0; i < size; i++) {
				if (i < doneLength) {
					bar.append(iconDone);
				} else {
					bar.append(iconRemain);
				}
			}
			bar.append(iconRightBoundary);
			System.out.print("   \r" + bar + " " + donePercents + "%" + getTime(done, total));
			if (done == total) {
				System.out.print("\n");
			}
		}
	}

	public ProgressBar(long startTimer) {
		lastDone = System.nanoTime() + SEC_1;
		this.startTimer = startTimer;
	}

	/**
	 * progress bar enable/disable
	 */
	public boolean getEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
