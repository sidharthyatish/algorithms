package DP.knapsack.a.zeroOneKnapSack.a.zeroOneKnapSack;

public class RecursiveZeroOneKnapSack
{
    int maxProfit(int[] weights, int[] values, int capacity, int nItems){
        //base case, least possible inputs
        if(capacity==0||nItems==0) return 0;
        
        /*
        two conditions:
        1.I have a choice (i.e., This item will fit in knapsack)
            1.1. I can use this weight
            1.2. I can ignore this weight
        2. I don't have a choice (i.e., This item won't fit in knapsack)
        
         */
        
        //1.
        if(weights[nItems-1]<=capacity){
            // return Max(1.1, 1.2)
            // 1.1 -> The capacity gets decreased, value gets increased
            // 1.2 -> Capacity remains same, value remains same, we move to next element
            return Math.max(values[nItems-1] + maxProfit(weights,values,capacity-weights[nItems-1],nItems-1),
                    maxProfit(weights,values,capacity,nItems-1));
        }
        else{
            //return 2 i.e., ignore this element
            return maxProfit(weights,values,capacity,nItems-1);
        }
        
    }
    
    public static void main(String[] args)
    {
        RecursiveZeroOneKnapSack ks = new RecursiveZeroOneKnapSack();
        int w[] = new int[]{4,5,1};
        int v[] = new int[]{1,2,3};
        int capacity = 4;
        System.out.println(ks.maxProfit(w,v,capacity,3));
    }
}
