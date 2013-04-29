/*
 * @author Michael VanWie
 * Take in a Function in a formated String
 * break down that String to check for a valid function
 * if the function is valid fill truth tables and evaluate
 * hold this data for the kmap
 */


public class Function {
	String input;
	int numVar;
	TruthTable truthTable;
	
	public Function(String input){
		this.input = input;
	}
	
	public void evalInput(){
		
	}
	
	public void buildTruthTable(){
		truthTable = new TruthTable(5);
	}
	
	public void evalTruth(){}
	
	public void fillKMap(){}
	
	public static void main(String[] args) {
		Function fun = new Function("hi");
		fun.buildTruthTable();
		System.out.println(fun.truthTable.toString());
	}
}
