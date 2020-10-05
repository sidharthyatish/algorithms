package DP.knapsack.first_zeroOneKnapSack.first_zeroOneKnapSack;

import java.util.Arrays;

public class MemoizeZeroOneKnapSack
{
    /*
    Memoization is Recursion + table
    1. If the value is present in table, return it
    2. Else store it to table and return the stored value
     */
    int[][] knapSack;
    int maxProfit(int[] weights, int[] values, int capacity, int nItems){
        if(nItems==0||capacity==0) return 0;
        
        if(knapSack[nItems-1][capacity]>Integer.MIN_VALUE) return knapSack[nItems-1][capacity];
        
        if(weights[nItems-1]<=capacity){
            knapSack[nItems-1][capacity] = Math.max(values[nItems-1]+maxProfit(weights,values,capacity-weights[nItems-1],nItems-1),
                    maxProfit(weights,values,capacity,nItems-1));
        }
        else{
            knapSack[nItems-1][capacity] = maxProfit(weights, values, capacity, nItems-1);
        }
        return knapSack[nItems-1][capacity];
    }
    
    public static void main(String[] args)
    {
        MemoizeZeroOneKnapSack ks = new MemoizeZeroOneKnapSack();
        ks.knapSack = new int[10][10];
        for(int i=0;i<ks.knapSack.length;i++){
            Arrays.fill(ks.knapSack[i],Integer.MIN_VALUE);
        }
        
        int w[] = new int[]{4,5,1};
        int v[] = new int[]{1,2,3};
        int capacity = 4;
        System.out.println(ks.maxProfit(w,v,capacity,3));
        for(int[] row : ks.knapSack){
            System.out.print(Arrays.toString(row));
            System.out.println();
        }
    }
}
