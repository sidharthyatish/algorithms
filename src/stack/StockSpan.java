package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan
{
    int[] minStocksForEachDay(int[] price){
        /*
            The price of stocks for each day is given.
            Stock span for a given day is the number of consecutive days having price <= given days prize
            
            In other words, The number of elements to the left until Next greater element is reached
            
            which can be obtained for a position i by index(NGE) - i
            
            If there is no NGE at all, then the stack will be empty. In such case,
            The stock span is 1 + No of elements to left
                which is      1 + (i)
         */
    
        //In this stack we will place the index of NGE rather than the NGE itself.
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[price.length];
        
        //Since NGE to left, left loop
        for(int i=0;i<price.length;i++){
            if(stack.isEmpty()) res[i]=i+1;
            else if(price[stack.peek()]>price[i]) res[i] = i-stack.peek();
            else{
                while (!stack.isEmpty()&&price[stack.peek()]<=price[i]) stack.pop();
                
                if(stack.isEmpty()) res[i] = i+1; //i+1 : If stack is empty, then all the smaller elements are removed. So all to the left are smaller. No of elements in left =i, The current element count is 1 so i+1
                else res[i] = i-stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
    
    public static void main(String[] args)
    {
        StockSpan ss = new StockSpan();
        int[] prices = new int[]{10, 4, 5, 90, 120, 80};
        System.out.println(Arrays.toString(ss.minStocksForEachDay(prices)));
    }
}
