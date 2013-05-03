
public class KSolver {
	Function function;
	KMap kMap;
	
	public KSolver(){
		//init gui here
	}
	
	public void truthSolve(){
		function.normalizeInput();
		function.readInput(); 
		function.fillResult();
	}
	
	public void initKMapWithTable(){
		kMap = new KMap(function.getNumVar());
		kMap.fillMap(function.truthTable);
	}
	
	public String toString(){
		return function.toString()+"\n"+ kMap.toString();
	}
	
	public static void main(String[] args) {
		KSolver kSolve = new KSolver();
		kSolve.function = new Function("~A~B~C~D");
		kSolve.truthSolve();
		kSolve.initKMapWithTable();
		
		System.out.println(kSolve.toString());
	}
}


//	   \  00,01,11,10
//		\____________
//	00	|
//	01	|
//	11	|
//	10	|