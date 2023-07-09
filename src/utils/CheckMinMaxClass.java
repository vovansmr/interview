package utils;
import myinterfaces.Constants;
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

	public boolean checkMin (int min,boolean noExc) {
		return checkMinMax(min, Constants.MAX, noExc);
	}
	
	public static CheckMinMaxClass getInstance () {
		if (instance==null)instance=new CheckMinMaxClass();
		return instance;
	}
	
	private CheckMinMaxClass() {
		LoadMessages messages=LoadMessages.getInstance();
		minError=messages.getProp("minError")+Constants.MIN+messages.getProp("minError2");
		maxError=messages.getProp("maxError")+Constants.MAX;
	}

	public boolean checkMax (int max,boolean noExc) {
		return checkMinMax(Constants.MIN, max, noExc);
	}
	
	public  boolean checkMinMax (int min,int max ,boolean noExc) {
		if (min>=Constants.MIN&&min<max&&max<=Constants.MAX)return true;
		else {
			if (!noExc)throw new IllegalArgumentException(minError+"\n"+maxError);
			return false;
		}
	}
}