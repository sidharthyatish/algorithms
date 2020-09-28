package LeetCodeProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis
{
    boolean isValid(String s){
        int length = s.length();
        Map<Character,Character> mapping = new HashMap<>();
        mapping.putIfAbsent(')','(');
        mapping.putIfAbsent(']','[');
        mapping.putIfAbsent('}','{');
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<length;i++){
            Character c = s.charAt(i);
            if(mapping.containsKey(c)){
                if(!stack.isEmpty()&&stack.peek().equals(mapping.get(c))) stack.pop();
                else return false;
            }
            else{
                stack.push(c);
            }
        }
        
        return stack.size()==0;
    }
    
    public static void main(String[] args)
    {
        ValidParanthesis vp = new ValidParanthesis();
        System.out.println(vp.isValid("()[]{}"));
    }
    
}
