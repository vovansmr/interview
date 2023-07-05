package input;

import myinterfaces.Inputs;

public class MyInput implements Inputs {
	private int min=1;
	private int max=1000;
	@Override
	public int getMin() {
		return min;
	}

	@Override
	public void setMin(int min) {
		this.min=min;
	}

	@Override
	public int getMax() {
		return max;
	}

	@Override
	public void setMax(int max) {
		this.max=max;
	}

	public MyInput(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public MyInput() {

	}

}
