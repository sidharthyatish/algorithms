package stack;

import java.util.Stack;

public class LargestAreaInHistogram
{
    //Best explanation for single array (geeksforgeeks solution) : https://www.youtube.com/watch?v=lktr76SxB2w
    /*
        For a single bar, the max area it can extend to the left is up to NSE to left
                      and the max area it can extend to the right is up to NSE to right
        One possible solution is to get the index of NSE lefts in NSE_Left[]
                                and get the index of NSE rights in NSE_right[]
         The area for the bar at i is hist[i] * ( NSE_right[i] - NSE_left[i] -1 )
         
         The challenge is getting the NSE right and NSE left for i in a single iteration.
         This is explained well here: https://stackoverflow.com/questions/4311694/maximize-the-rectangular-area-under-histogram/35931960#35931960
         The visual representation and code is here: https://www.youtube.com/watch?v=lktr76SxB2w
         
         In geeks for geeks they use while loop and hence updating i seems to be a little complex to understand from code
         
         for every i
            if stack is empty or the current bar is bigger than the bar on top of stack, push it
            else{ we found a bar that is smaller than the one inside the stack. This is capable of popping all the bigger ones inside
                
                We pop all the bigger ones
                    - popped height as height
                    - Now the stack may contain some elements
                        - NSE to left is the one in stack
                        - NSE to right is the i that is capable of popping this one
                        - area = popped_height * ( i - stack.peek -1 )
                    - The stack may not contain elements
                        - NSE to right is the i that is capable of popping this one
                        - area = popped_height * ( i )
                        
                 
                
                 push the current i to stack
            }
            We have popped only bigger than i bars, there can be smaller bars inside the stack. We have to calculate area by considering
                 all element in stack as popped height
                 Since there can't be a right element as nothing was capable of popping these out, we take right as
                 arr.length, which means these bars can extend to the whole right
            
            
            This if and else both pushed i to stack. So we can take it outside. Then there is no need of if else at all.
     */
    int maxArea(int[] hist){
        Stack<Integer> stack = new Stack<>();
        
        int maxArea =Integer.MIN_VALUE;
        int currArea;
        for(int i=0;i<hist.length;i++){
            
            while (!stack.isEmpty() && hist[i]<=hist[stack.peek()]){
                int popped = stack.pop();
                if(stack.isEmpty())
                    currArea = hist[popped] * i;
                else
                    currArea = hist[popped] * (i - stack.peek() -1);
                maxArea = Math.max(currArea,maxArea);
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()){
            int popped = stack.pop();
            if(stack.isEmpty())
                currArea = hist[popped] * hist.length;
            else
                currArea = hist[popped] * (hist.length - stack.peek() -1);
            maxArea = Math.max(currArea,maxArea);
        }
        return maxArea;
    }
    
    
    public static void main(String[] args)
    {
        LargestAreaInHistogram hist = new LargestAreaInHistogram();
        int[] arr = new int[]{2,4,6,3,8,5};
        System.out.println(hist.maxArea(arr));
    }
}
