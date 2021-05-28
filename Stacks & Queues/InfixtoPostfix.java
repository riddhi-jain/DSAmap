// Infix expression: The expression of the form a op b. When an operator is in-between every pair of operands.
// Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
// *********Problem Statement***********
// The compiler scans our expressions either from left to right or
// from right to left
// conside the expression : "a+b*c+d"
// The compiler first scans the expression to evaluate the expression 'b*c' ( since * has higher precedence) 
// to PEMDAS ) then again scans the expression to add a to it. The result is then added to d after another
// scan. This repeated scanning being very inefficient it is better to convert the infix expression 
// "a+b*c+d" to postfix : "abc*+d+". This can be evaluated easily using a Stack.

package Stacks;

import java.util.*;

public class InfixtoPostfix {

    static int Prec (char x) 
    {
        switch(x) {
            case '+':
            case '-':
                    return 1;
            case '*':
            case '/':
                    return 2;
            case '^':
                    return 3;
        }
        return -1;
    }
    static String infixtoPostfix123 ( String expr)
    {
        String result = new String("");

        Stack<Character> stack = new Stack<>();

        for ( int i =0; i< expr.length(); i++) 
        {
            char c = expr.charAt(i);
            
            // First we concatenate any operand that we do not need for our operation's precedence
            if (Character.isLetterOrDigit(c)) 
            {
                result += c;
            }
            // Since the open bracket has the highest precedence we push it to the stack without any conditions 
            else if (c == '(') {
                stack.push(c);
            }
            else if(c==')') { // However for closed bracket to be pushed in we first need to pop out and concatenate the initial operands and then terminate the loop as soon as
                // We encounter the required closed bracket in the expression
                    while(!stack.isEmpty() && stack.peek() != '(') 
                        result+= stack.pop();
                        stack.pop();
                    
                    
            }
            // Next we concatenate our other operators with the help of precedence function
            else {
                while( !stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    
                    result += stack.pop();
                }
                
                stack.push(c); 
            }
            
        }

        // Next we write the code foropping opeartion of the stack 
        // Keep in mind that the only invalid symbol to be at the top of the stack is (
        while(!stack.isEmpty()) {
            if(stack.peek() == '(')
            return ("Invalid Expression");
            
        result += stack.pop();
        }
        return result;
}
    public static void main(String[] args) {
        String expr = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixtoPostfix123(expr));
        
    }

}
