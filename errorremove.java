import java.util.*;
 
class GFG
{
     
static boolean isOperand(char x)
{
    return (x >= 'a' && x <= 'z') ||
            (x >= 'A' && x <= 'Z');
}
 

static String getInfix(String exp)
{
    Stack<String> s = new Stack<String>();
 
    for (int i = 0; i < exp.length(); i++)
    {
        // Push operands
        if (isOperand(exp.charAt(i)))
        {
        s.push(exp.charAt(i) + "");
        }
 
      
        else
        {
            String op1 = s.peek();
            s.pop();
            String op2 = s.peek();
            s.pop();
            s.push("(" + op2 + exp.charAt(i) +
                    op1 + ")");
        }
    }
 
   
    return s.peek();
}
 
// Driver code
public static void main(String args[])
{
    String exp = "ab*c+";
    System.out.println( getInfix(exp));
}
}
