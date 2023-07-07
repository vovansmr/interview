package utils;
public class ProgressBar {
	public static final long sec1=1000000000;
	private long lastDone=0;
	private long startTimer=0;
	private boolean enable=true;
	
	public String getTime(long done,long total) {
		StringBuilder time = new StringBuilder(" time left ");
		long currentTime=System.nanoTime();
		long tmp=(long) (((currentTime- startTimer)*(total*1.0/done)-(currentTime-startTimer))/sec1);
		time.append(tmp);
		time.append(" sec.");
		return time.toString();
	}
	
	public void progressPercentage(long done, long total) {	        
        long donePercents = (100 * done) / total;
        if (enable&&(100==donePercents||System.nanoTime()>lastDone)) {
        	lastDone=System.nanoTime()+sec1;
        	int size = 10;
	        String iconLeftBoundary = "[";
	        String iconDone = "=";
	        String iconRemain = ".";
	        String iconRightBoundary = "]";
	        if (done > total) {
	            throw new IllegalArgumentException("done = " + done+ " total = "+ total);
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
	        System.out.print("   \r" + bar + " " + donePercents + "%"+getTime(done, total));
	        if (done == total) {
	            System.out.print("\n");
	        }
        }
	}
	
	public ProgressBar(long startTimer) {
		init(startTimer);
	}

	public void init (long startTimer) {
		lastDone=System.nanoTime()+sec1;
		this.startTimer=startTimer;
	}

	public boolean getEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
