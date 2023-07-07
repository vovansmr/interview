

import utils.SolvesBuilder;

public class SumCubes {

	public static void main(String[] args) {

		SolvesBuilder solvesBuilder= new SolvesBuilder();
		solvesBuilder.addSolve("TF").setMin(10).setMax(100).addSolve("BFF").setMin(10).setMax(11).
		addSolve("BF").setMin(150).setMax(200).buildAndRun();
		/*writeSolveOn().writeInfoOff().
		addSolve("BFF").setMin(10).setMax(11).
		addSolve("BF").setMin(150).setMax(2000).build();*/
	} 

}
