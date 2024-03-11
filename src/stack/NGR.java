package stack;

import java.util.Arrays;
import java.util.Stack;

public class NGE
{
    int[] nextGreaterElement(int[] arr){
        /*
            Given an array, for each element print the nearest greatest element to the right
            arr[] = [1, 3, 2, 4]
            NGE[] = [3, 4, 4, -1]
            
            
            For every element we consider the arr to the right
            1 [3, 2, 4] -->(3)
            1, 3 [2, 4] -->(4)
            1, 3, 2, [4] ->(4)
            1, 3, 2, 4 []->(-1)

            - 1.1 - For each element in the array (arr[i]) the right sub array (arr[i+1]..n) should be inside the stack
            - 1.2 -  But to be present inside the stack, element on the top should always be smaller than the one at the bottom
            
            Here [] is a stack since we are considering closer element
            Since the stack is built from right most element, we traverse the array from the right
            
            Process:
            
            for 4, the right sub array is [], the stack is |], empty so NGE is -1, add the element to stack 
                (this is for the next iteration, this element is part of the right sub array )
            for 2, the right sub array is [4] the stack is |4], top of stack > 2 so NGE is 4, add the element to stack (for next iteration this is part of subarray)
            for 3, the right sub array is [2,4] the stack is |2,4], the stack.peek() is smaller so pop all smaller elements (why? this violates 1.2)
                    Now the stack becomes |4], now stack is not empty. If it is empty return -1
                    meaning all the elements in stack were smaller. If not empty, return top elem
                    So NGE is 4, add the current element to stack
            for 1, the right sub array is [3,2,4], the stack is |3,4], (2 was not eligible to be in stack) top of stack > 1 so NGE is 3, add this to stack |1,3,4]
            
            All elements are over :)
            -------------------------
            Note, every element in stack is smaller than the one below it.
            that's why |3,2,4] is not possible and we pop all the smaller elements of 3
   
         */
        
        int[] res = new int[arr.length];
    
        Stack<Integer> stack = new Stack<>();
        
        //TODO next greater to left. this loop becomes (i=0..length-1)
        for(int i=arr.length-1;i>=0;i--){
            
            //If the stack is empty,there are no greater elements at all
            if(stack.isEmpty()) res[i]=-1;
            
            //If the stack has an element and it is bigger, this is the nearest greater element
            //TODO Next smaller to left/right change the conditions
            else if(stack.peek()>arr[i]) res[i]=stack.peek();
            
            //The stack has element but it is smaller
            else{
                
                //Remove all the smaller elements
                while (!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                }
                
                //If stack becomes empty, all elements were smaller and result is -1. else the stack has now the greater element
                if(stack.isEmpty()) res[i]=-1;
                else res[i]=stack.peek();
            }
            
            //Add the current element to stack
            stack.push(arr[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args)
    {
        NGE nge = new NGE();
        int[] arr = new int[]{1,3,2,4};
        System.out.println(Arrays.toString(nge.nextGreaterElement(arr)));
    }
}
