package utils;

import myinterfaces.Constant;

/**
 * Min and max check class. Implemented as a singleton design pattern
 */
public class CheckMinMaxClass {
	@SuppressWarnings("UnusedAssignment")
	private String minError = "";
	@SuppressWarnings("UnusedAssignment")
	private String maxError = "";
	private static CheckMinMaxClass instance = null;

	public String getMinError() {
		return minError;
	}

	public String getMaxError() {
		return maxError;
	}

	/**
	 * Implemented as a singleton design pattern
	 */
	public static CheckMinMaxClass getInstance() {
		if (instance == null) {
			instance = new CheckMinMaxClass();
		}
		return instance;
	}

	/**
	 * Private constructor
	 */
	private CheckMinMaxClass() {
		LoadMessages messages = LoadMessages.getInstance();
		minError = messages.getProp("minError") + Constant.MIN + messages.getProp("minError2");
		maxError = messages.getProp("maxError") + Constant.MAX;
	}

	/**
	 * Min and max check
	 * 
	 * @param noExc If true don't throw an exception on errors
	 * @return true if there are no errors
	 */
	public boolean checkMinMax(int min, int max, boolean noExc) {
		if (min >= Constant.MIN && min < max && max <= Constant.MAX) {
			return true;
		} else {
			if (!noExc) {
				throw new IllegalArgumentException(minError + "\n" + maxError);
			}
			return false;
		}
	}
}