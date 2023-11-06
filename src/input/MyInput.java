package input;

import myinterfaces.Inputable;
import utils.CheckMinMaxClass;
import myinterfaces.Constant;

/**
 * Class for storing data entered by the user
 */
public class MyInput implements Inputable {
	private int min = Constant.MIN;
	private int max = Constant.MAX;
	/**
	 * Displaying the solution of an equation.
	 */
	private boolean writeSolution = false;
	/**
	 * Disable output of service information.
	 */
	private boolean writeInfo = true;
	/**
	 * Class for checking min and max parameters
	 */
	private final CheckMinMaxClass check = CheckMinMaxClass.getInstance();

	@Override
	public int getMin() {
		return min;
	}

	/**
	 * Validation value, must be in [MIN, MAX]
	 */
	@Override
	public void setMin(int min) {
		if (check.checkMinMax(min, max, false)) {
			this.min = min;
		}
	}

	@Override
	public int getMax() {
		return max;
	}

	/**
	 * Validation value, must be in [MIN, MAX]
	 */
	@Override
	public void setMax(int max) {
		if (check.checkMinMax(min, max, false)) {
			this.max = max;
		}
	}

	/**
	 * Validation value, must be in [MIN, MAX]
	 */
	public MyInput(int min, int max) {
		if (check.checkMinMax(min, max, false)) {
			this.min = min;
			this.max = max;
		}
	}

	public MyInput() {
	}

	@Override
	public void setWriteSolution(boolean writeSolution) {
		this.writeSolution = writeSolution;
	}

	@Override
	public boolean getWriteSolution() {
		return writeSolution;
	}

	@Override
	public boolean getWriteInfo() {
		return writeInfo;
	}

	@Override
	public void setWriteInfo(boolean writeInfo) {
		this.writeInfo = writeInfo;
	}

}