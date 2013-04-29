
public class TruthTable {
	TTRow[] grid;
	int numVar;
	int x;
	int y;
	
	public TruthTable(int numVar){
		x = (int) Math.pow(2, numVar);
		grid = new TTRow[x];
		for (int i = 0; i < x; i++) {
			grid[i]= new TTRow(numVar);
		}
		fillTruthTable(x);
	}
	
	public void fillTruthTable(int x){
		fillStepOne();
	}

	public void fillStepOne(){
		for (int i = 0; i < x; i++) {
			grid[i].setLengthAndValue(i);
		}
	}
	
	public String toString(){
		String t = "";
		for (int i = 0; i < x; i++) {
			t+= grid[i].toString()+"\n";
		}
		return t;
	}
	
	public static void main(String[] args) {
		TruthTable bes = new TruthTable(4);
		System.out.println(bes.toString());
		int result = ~0|~1;
		
		if(result==-2) result = 0;
		if(result==-1) result = 1;
		
		System.out.println(result);
		result = ~1&0;
		System.out.println(result);
		
	}
}
