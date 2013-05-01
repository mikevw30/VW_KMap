
public class KSolver {
	Function function;
	TruthTable truthTable;
	
	public KSolver(){
		//init gui here
	}
	
	public void truthSolve(){
		function.normalizeInput();
		function.readInput(); 
		function.setResult();
	}
	
	public static void main(String[] args) {
		KSolver kSolve = new KSolver();
		kSolve.function = new Function("ABCDEFGHIJKLMNOP");//TODO: FIX EXTRA ()()(()((())) paren's
		kSolve.truthSolve();
		System.out.println(kSolve.function.postFix+"\n\n");
		System.out.println(kSolve.function.toString());
	}
}