/*
 * @author Michael VanWie
 * call more than once for 3 or more variables in a function
 *  A&(B&(C&(D&(E&F))))
 *	
 */


public class BasicFunction {
	int a;
	int b;
	int flag;
	int result;
	
	public BasicFunction(int a, int b, int flag){
		this.a = a;
		this.b = b;
		this.flag = flag;
	}
	
	public int evalBF(){
		if(flag == 1) {
			result = (a|b);
		}
		else if(flag == 2){
			System.out.println("A&B");
			result = a&b;
		}
		
		if(result ==-1){
			result = 1;
		}
		else if(result ==-2){
			result = 0;
		}
		
		return result;
	}
}
