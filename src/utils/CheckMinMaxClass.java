package utils;
import myinterfaces.Constantable;
/**
 * Min and max check class.
 * Implemented as a singleton design pattern 
 */
public class CheckMinMaxClass {
	private String minError="";
	private String maxError="";
	private static CheckMinMaxClass instance=null;	
	
	public String getMinError() {
		return minError;
	}
	
	public String getMaxError() {
		return maxError;
	}
	/**
	 * Min check 
	 * @param noExc If true don't throw an exception on errors
	 * @return true if there are no errors 
	 */
	public boolean checkMin (int min,boolean noExc) {
		return checkMinMax(min, Constantable.MAX, noExc);
	}
	/**
	 * Implemented as a singleton design pattern 
	 */
	public static CheckMinMaxClass getInstance () {
		if (instance==null)instance=new CheckMinMaxClass();
		return instance;
	}
	/**
	 * Private constructor
	 */
	private CheckMinMaxClass() {
		LoadMessages messages=LoadMessages.getInstance();
		minError=messages.getProp("minError")+Constantable.MIN+messages.getProp("minError2");
		maxError=messages.getProp("maxError")+Constantable.MAX;
	}
	/**
	 * Max check 
	 * @param noExc If true don't throw an exception on errors
	 * @return true if there are no errors 
	 */
	public boolean checkMax (int max,boolean noExc) {
		return checkMinMax(Constantable.MIN, max, noExc);
	}
	/**
	 * Min and max check 
	 * @param noExc If true don't throw an exception on errors
	 * @return true if there are no errors 
	 */
	public  boolean checkMinMax (int min,int max ,boolean noExc) {
		if (min>=Constantable.MIN&&min<max&&max<=Constantable.MAX)return true;
		else {
			if (!noExc)throw new IllegalArgumentException(minError+"\n"+maxError);
			return false;
		}
	}
}