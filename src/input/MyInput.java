package input;

import myinterfaces.Inputs;

public class MyInput implements Inputs {
	private int min=MIN;
	private int max=MAX;
	private boolean writeSolve=false;
	private boolean writeInfo=true;
	private static String minError="The minimum value must be between "+MIN+" and max";
	private static String maxError="the maximum value must be between min and "+ MAX;
	@Override
	public int getMin() {
		return min;
	}

	public boolean checkMin (int min,boolean noExc) {
		if (min>=MIN&&min<max)return true;
		else {
			if (!noExc)throw new IllegalArgumentException(minError);
			return false;
		}
	}
	
	public static boolean checkMinMax (int min,int max ,boolean noExc) {
		if (min>=MIN&&min<max&&max<=MAX)return true;
		else {
			if (!noExc)throw new IllegalArgumentException(minError);
			return false;
		}
	}
	
	@Override
	public void setMin(int min) {
		if (checkMin(min,false)) this.min=min;
	}
	
	public boolean checkMax (int max,boolean noExc) {
		if (max>min&&max<=MAX)return true;
		else {
			if (!noExc)throw new IllegalArgumentException(maxError);
			return false;
		}
	}

	@Override
	public int getMax() {
		return max;
	}

	@Override
	public void setMax(int max) {		
		if (checkMax(max,false))this.max=max;
	}

	public MyInput(int min, int max) {
		if(checkMax(max,false)&&checkMin(min,false)) {
			this.min = min;
			this.max = max;
		}
	}

	public MyInput() {
	}

	@Override
	public void setWriteSolve(boolean  writeSolve) {
		this.writeSolve=writeSolve;		
	}

	@Override
	public boolean getWriteSolve() {		
		return writeSolve;
	}

	@Override
	public boolean getWriteInfo() {
		return writeInfo;
	}

	@Override
	public void setWriteInfo(boolean writeInfo) {
		this.writeInfo=writeInfo;
	}

}
