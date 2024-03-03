package Recursion;

import java.util.Stack;

public class DeleteMidOfStack
{

    //refactored solution with a single method. GFG submission works for this solution as well
    public void deleteFromStackAtPosition(Stack<Integer> stack, int pos){
        if(stack.isEmpty()) return;
        if(pos==1){
            stack.pop();
            return;
        }
        int currElem = stack.pop();
        deleteFromStackAtPosition(stack,pos-1);
        stack.push(currElem);
    }


    void deleteMid(Stack<Integer> stack){
        int k = stack.size()/2 +1;
        if(k==0 || stack.size() ==0) return;
        solve(stack,k);
        
        
    }
    void solve(Stack<Integer> stack, int k){
        
        //Base condition. If we are remove the kth (1st) element we see
        if(k==1){
            stack.pop();
            return;
        }
        
        //Keep the top element safely
        int elem = stack.pop();
        
        //Now the size of stack is reduced, so recur to remaining elements. Now we have to remove k-1th element
        solve(stack,k-1);
        
        //After it is solved, push back the stored element
        stack.push(elem);
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
        new DeleteMidOfStack().deleteMid(s);
        System.out.println(s);
    }
}
