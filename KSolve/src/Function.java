import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*
 * @author Michael VanWie
 * Take in a Function in a formated String
 * break down that String to check for a valid function
 * if the function is valid fill truth tables and evaluate
 * hold this data for the kmap
 */


public class Function {
	String input;
	String postFix ="";
	int numVar;
	TruthTable truthTable;
	Stack<Character> funS = new Stack<Character>();
	ArrayList<Character> varArr = new ArrayList<Character>();
	
	int resultArr[];
	
	public Function(String input){
		this.input = input;
	}
	
	/*
	 * Pseudo code for readInput() found below
	 * http://faculty.cs.niu.edu/~hutchins/csci241/eval.htm
	 */
	
	public void readInput(){
		int index = 0;
		int end = input.length();
		char prevChar = input.charAt(index);
		char charAtIndex = input.charAt(index);
		boolean first = true;
		while(index != end){  //while we arent at the end of the input
			//System.out.println("im here 1");
			charAtIndex = input.charAt(index);
			
			//System.out.println("c,p: "+charAtIndex+","+prevChar);
			
			
			if(charAtIndex >= 'A' && charAtIndex <= 'Z'){ //check for valid operand (capital letters that represent variables)
				//System.out.println(charAtIndex+"here1");
				postFix += charAtIndex;	//add charAtIndex to postFix
				if(!varArr.contains(charAtIndex)){ //get unique operators and count them
					varArr.add(charAtIndex);
					numVar++;
				}
			}
			if(charAtIndex == '('){// if left paren
				if(prevChar >= 'A' && prevChar <= 'Z'){
					funS.push('&');
				}
				funS.push('('); //push it to stack
			}
			if(charAtIndex == ')'){ //if right paren
				while(!funS.isEmpty() && !funS.peek().equals('(')){ //while the stack isn't empty and stack.peek is NOT a left paren
					postFix += funS.pop();// pop the stack and add that value to postFix  
				}
				funS.pop(); //get rid of the left paren.
			}
			if(charAtIndex == '+' || (charAtIndex >= 'A' && charAtIndex <= 'Z' && prevChar >= 'A' && prevChar <= 'Z') && !first){
				if(funS.isEmpty() || funS.peek().equals('(')){ //if the stack is empty or peek == (
					
					if(charAtIndex == '+'){// if i found a  operator push it.
						funS.push(charAtIndex);
					}
					else{
						funS.push('&');
					}
				}
				else{
					while(!funS.isEmpty() && !funS.peek().equals('(') && checkStack(charAtIndex,funS.peek())){
						//System.out.println(charAtIndex+","+funS.peek());
						postFix +=	funS.pop();
					}
					funS.push(charAtIndex);
				}
			}
			index++;
			prevChar = charAtIndex;
			first = false;
		}	
		while(!funS.isEmpty()){
			//System.out.println("im here4");
			postFix += funS.pop();
		}
		truthTable = new TruthTable(numVar); //init the truth table.
		Collections.sort(varArr);			//alpha sort the variables in the truth table.
	}
	
	public boolean checkStack(char charAtIndex, char top){ //checking order of operations.
		if(top>= 'A' && top<= 'Z'){
			return true;
		}
		else if(charAtIndex == '+' && top == '&'){
			return true;
		}
		else if(charAtIndex == '&' && top == '+'){
			return false;
		}
		else{
			return true;
		}
	}
	
	
	public int evelInput(int gridRow){
		Stack<Integer> evalS = new Stack<Integer>();
		int index = 0;
		int end = postFix.length();
		int opp = 0;
	
		while (index!=end){
			char charAtIndex = postFix.charAt(index);
	        if(charAtIndex>='A' && charAtIndex<='Z'){//an operand is found
	        	//System.out.println("found a var: "+charAtIndex);
	        	int i = 0;
	        	for (i = 0; i < numVar; i++) {
	        		if(charAtIndex == varArr.get(i)){
	        			break;
	        		}
				}
	           evalS.push(truthTable.grid[gridRow].row[(numVar-1)-i]);
	        }//End-If
	        else{// an operator is found
	        	if(charAtIndex == '&'){
	        		opp = 2;
	        		}
	        	else{
	        		opp = 1;
	        	}
	        	int result = (new BasicFunction(evalS.pop(),evalS.pop(),opp)).evalBF();
				evalS.push(result);
			}//End-If
	        index++;
		}//End-While
		return evalS.pop();
	}	
	
	public void setResult(){
		for (int i = 0; i < Math.pow(2, numVar); i++) {
			int temp = evelInput(i);
			truthTable.grid[i].setValue(temp);
		}
	}
	
	public String toString(){
		String t = input+ "\n";
		for (int i = 0; i < varArr.size(); i++) {
			t+= varArr.get(i);
		}
		t+="\t: sln\n";
		
		for (int i = 0; i < Math.pow(2, numVar); i++) {
			t+=truthTable.grid[i].toString()+"\n";
		}
		
		return t;
	}
}
