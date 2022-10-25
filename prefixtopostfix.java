import java.util.*;
public class PrefixToPostfix {

	public static String preToPostStack(char[] exp) {		 
		  Stack<String> s = new Stack<>();
		  int length = exp.length;
		  for (int i = length - 1; i >= 0; i--) {
			  if (!isOp(exp[i])) {
				  s.push(Character.toString(exp[i]));				
			  } else {			
				  String op1 = s.pop();
				  String op2 = s.pop();
				  String temp = op1 + op2 + exp[i];
				  s.push(temp);
			  }
		  }
		  return s.peek();
	}   
    public static ArrayList<String> preToPostRec(ArrayList<String> exp) {  
        String op = exp.remove(0);    
        List<String> op1 = isOp(exp.get(0).charAt(0)) ? preToPostRec(exp) : Arrays.asList(exp.remove(0));
        List<String> op2 = isOp(exp.get(0).charAt(0)) ? preToPostRec(exp) : Arrays.asList(exp.remove(0));
        ArrayList<String> res = new ArrayList<>(exp.size());
        res.addAll(op1);
        res.addAll(op2);
        res.add(op);
        return res;
    }
    
	private static boolean isOp(char Op) {
		if (Op == '+' || Op == '-' || Op == '*' || Op  == '/') {
			return true;
		} else {
			return false;
		}
	}
	private static String convert(ArrayList<String> s) {
		String res = "";
		for (String i: s) {
			res += i;
		}
		return res;
	}
       
    public static void main(String[] args) {
    	String s ="+*AB/CD"; //A*B + C/D
    	System.out.println("postfix(stack): " + preToPostStack(s.toCharArray()));	      
    	
    	ArrayList<String> input = new ArrayList<>(Arrays.asList(s.split("")));
		ArrayList<String> output = preToPostRec(input);
		System.out.println("postfix(recursion): " + convert(output));     		
    }
}
