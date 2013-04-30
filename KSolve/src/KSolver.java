
public class KSolver {
	Function function;
	TruthTable truthTable;
	
	public KSolver(){
		//init gui here
	}
	
	public void truthSolve(){
		function.readInput();
		function.setResult();
	}
	
	
	public static void main(String[] args) {
		KSolver kSolve = new KSolver();
		kSolve.function = new Function("(AB)+(CD)");
		kSolve.truthSolve();
		
		System.out.println(kSolve.function.toString());
	}
}
