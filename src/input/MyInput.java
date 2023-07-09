package input;

import myinterfaces.Inputs;
import utils.CheckMinMaxClass;
import myinterfaces.Constants;

public class MyInput implements Inputs {
	private int min=Constants.MIN;
	private int max=Constants.MAX;
	private boolean writeSolve=false;
	private boolean writeInfo=true;
	private CheckMinMaxClass check= CheckMinMaxClass.getInstance();
	
	@Override
	public int getMin() {
		return min;
	}
	
	@Override
	public void setMin(int min) {
		if(check.checkMinMax(min,max,false)) 
			this.min = min;
	}
	
	@Override
	public int getMax() {
		return max;
	}

	@Override
	public void setMax(int max) {		
		if (check.checkMinMax(min,max,false))this.max=max;
	}

	public MyInput(int min, int max) {
		if(check.checkMinMax(min,max,false)) {
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
