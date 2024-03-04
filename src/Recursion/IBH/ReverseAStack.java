package Recursion;

import java.util.Stack;

public class ReverseAStack
{
    void reverseAStack(Stack<Integer> stack){
        if(stack.size() == 0) return;
        
        //Get the top element
        int elem = stack.pop();
        
        //Reverse the remaining stack
        reverseAStack(stack);
        
        //Insert the popped element to the last
        insertElementAtBottom(stack,elem);
        
    }
    
    void insertElementAtBottom(Stack<Integer> stack, int elem){
        //If stack is empty we can put it in
        if(stack.isEmpty()){
            stack.push(elem);
            return;
        }
        
        
        //Get the top element
        int popped = stack.pop();
        
        //Insert the element to the bottom of the remaining stack
        insertElementAtBottom(stack,elem);
        
        //Push back the popped element
        stack.push(popped);
        
    }
    
    public static void main(String[] args)
    {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        System.out.println(s);
        new ReverseAStack().reverseAStack(s);
        System.out.println(s);
    }
}
