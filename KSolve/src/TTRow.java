
public class TTRow {
	int length;
	int row[];
	int value;
	
	public TTRow(int length){
		this.length = length;
		row = new int[length];
		for (int i = 0; i < row.length; i++) {
			row[i]=0;
		}
		value = 0;
	}
	
	public void setLengthAndValue(int value){
		this.value = value;
		//log_2(value) + 1 = how many bits are need for any given value.
		//this.length = (int) (Math.log(value) / Math.log(2)) + 1; 
		setBinaryVal();
	}
	
	public void setBinaryVal(){
		int temp = value;
		
		for (int i = length; i >=0; i--) {
			int powerOfTwo = (int) Math.pow(2, i);
			if(temp-powerOfTwo>=0){
				row[i]=1;
				temp-=powerOfTwo; 
			}
		}
	}
	public String toString(){
		String t="";
			for (int i = length-1; i >= 0; i--) {
				t+=row[i];
			}
			t+="\t: "+value;
		return t;
	}
}
