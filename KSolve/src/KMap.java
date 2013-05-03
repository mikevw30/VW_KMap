
public class KMap {
	int x;
	int y;
	int numVar;
	int[][] grid;
	
	
	public KMap(int numVar){
		popXY(numVar);
		grid = new int[x][y];
		popGrid(numVar);
	}
	
	public void popXY(int numVar){
		if(numVar == 1){
			x = twoOfPower(1);
			y = twoOfPower(0);
		}
		
		if(numVar == 2){
			x = twoOfPower(1);
			y = twoOfPower(1);
		}
		if(numVar == 3){
			x = twoOfPower(2);
			y = twoOfPower(1);
		}
		if(numVar == 4){
			x = twoOfPower(2);
			y = twoOfPower(2);
		}
	}
	
	public int twoOfPower(int n){
		return (int) Math.pow(2, n);
	}
	
	public void popGrid(int numVar){
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				grid[i][j] = (numVar*i)+j;
			}
		}
		if(numVar>=3){
			switchRow(2,3);
			if(numVar==4){
				switchCol(2,3);
			}
		}
	}
	
	public void switchRow(int x1, int x2){
		for (int i = 0; i < y; i++) {
			int temp = grid[x1][i];
			grid[x1][i]=grid[x2][i];
			grid[x2][i]=temp;
		}
	}
	public void switchCol(int y1, int y2){
		for (int i = 0; i < x; i++) {
			int temp = grid[i][y1];
			grid[i][y1]=grid[i][y2];
			grid[i][y2]=temp;
		}
	}
	
	public void fillMap(TruthTable truthTable) {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				//System.out.println(truthTable.x);
				grid[i][j] = truthTable.grid[grid[i][j]].value;
			}
		}
	}
	
	public String toString(){
		String t = "";
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
					t+=" "+grid[i][j] +" ";
			}
			t+="\n";
		}
		return t;
	}
//	    00 01 11 10 
//	    -----------
//	00 | 0  0  1  0 
//	01 | 1  1  1  1 
//	11 | 1  1  1  1 
//	10 | 1  1  1  1
	

//	public static void main(String[] args) {
//		KMap km1 = new KMap(1);
//		System.out.println(km1.toString());
//		KMap km2 = new KMap(2);
//		System.out.println(km2.toString());
//		KMap km3 = new KMap(3);
//		System.out.println(km3.toString());
//		KMap km4 = new KMap(4);
//		System.out.println(km4.toString());
//	}
	
}
