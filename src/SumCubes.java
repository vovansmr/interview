

import input.MyInput;
import myinterfaces.Inputs;
import solves.BruteForce;
import solves.BruteForceFaster;
import solves.Solve;
import solves.TheFastest;

public class SumCubes {

	public static void main(String[] args) {
		Inputs input = new MyInput();
		Solve solve=new Solve(input,new TheFastest());
		
		input.setMax(100);
		solve.calc();
		
		solve.setAlgoritm(new BruteForceFaster());
		solve.calc();

		solve.setAlgoritm(new BruteForce());
		solve.calc();
	}

}
