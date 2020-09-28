package LeetCodeProblems;

import java.util.Stack;

public class ReversePolishNotation
{
    private int evalRPN(String[] tokens){
        int length = tokens.length;
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<length;i++){
            String token = tokens[i];
            
            if(token.equals("+")||token.equals("-")||token.equals("/")||token.equals("*")){
                if(stack.size()<2) return -1;
                int a,b;
                b=stack.pop();
                a=stack.pop();
                switch (token){
                    case "+" : stack.push(a+b);
                    break;
                    case "-" : stack.push(a-b);
                    break;
                    case "/" : stack.push(a/b);
                    break;
                    case "*" : stack.push(a*b);
                    break;
                }
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.size()>0? stack.pop() : -1;
    }
    
    public static void main(String[] args)
    {
        ReversePolishNotation rp = new ReversePolishNotation();
        System.out.println(rp.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
