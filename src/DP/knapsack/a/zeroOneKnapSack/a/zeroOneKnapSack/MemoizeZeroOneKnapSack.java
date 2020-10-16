package DP.knapsack.a.zeroOneKnapSack.a.zeroOneKnapSack;

import java.util.Arrays;

public class MemoizeZeroOneKnapSack
{
    /*
    Memoization is Recursion + table
    1. If the value is present in table, return it
    2. Else store it to table and return the stored value
     */
    int[][] dp;
    
    MemoizeZeroOneKnapSack(){
        dp = new int[10][10];
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }
    }
    int maxProfit(int[] weights, int[] values, int capacity, int nItems){
        if(nItems==0||capacity==0) return 0;
        
        if(dp[nItems][capacity]>Integer.MIN_VALUE) return dp[nItems][capacity];
        
        if(weights[nItems-1]<=capacity){
            dp[nItems][capacity] = Math.max(values[nItems-1]+maxProfit(weights,values,capacity-weights[nItems-1],nItems-1),
                    maxProfit(weights,values,capacity,nItems-1));
        }
        else{
            dp[nItems][capacity] = maxProfit(weights, values, capacity, nItems-1);
        }
        return dp[nItems][capacity];
    }
    
    public static void main(String[] args)
    {
        MemoizeZeroOneKnapSack ks = new MemoizeZeroOneKnapSack();
        
        int w[] = new int[]{4,5,1};
        int v[] = new int[]{1,2,3};
        int capacity = 4;
        System.out.println(ks.maxProfit(w,v,capacity,3));
    }
}
