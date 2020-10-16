package DP.knapsack.a.zeroOneKnapSack.a.zeroOneKnapSack;

import java.util.Arrays;

public class BottomupZeroOneKnapSack
{
    int[][] knapSack;
    
    int maxProfit(int[] weights, int[] values, int capacity, int nItems){
        //in top down, replace nItems, capacity in recursive calls to i,j in interation
        for(int i=0;i<=nItems;i++){
            for(int j=0;j<=capacity;j++){
                //initialisation (or) base condition in recursion
                if(i==0||j==0) knapSack[i][j]=0;
                
                /*
                i=0 and j=0 rows and columns will take care of base case
                we start from i=1,j=1 for our DP filling
                At i=1 we will be looking at 0th item, i=2 we will be looking at 1st item and so on
                Thus we are using i-1 to get our value/weight
                 */
                
                else if(weights[i-1]<=j){ //For this iteration j is the maxCapacity
                    knapSack[i][j] = Math.max(
                            values[i-1]+knapSack[i-1][j-weights[i-1]],
                            knapSack[i-1][j]
                    );
                }
                else{
                    knapSack[i][j] = knapSack[i-1][j];
                }
            }
        }
        return knapSack[nItems][capacity];
    }
    
    public static void main(String[] args)
    {
        BottomupZeroOneKnapSack ks = new BottomupZeroOneKnapSack();
        ks.knapSack = new int[10][10];
        for(int i=0;i<ks.knapSack.length;i++){
            Arrays.fill(ks.knapSack[i],Integer.MIN_VALUE);
        }
    
        int w[] = new int[]{4,5,1};
        int v[] = new int[]{1,2,3};
        int capacity = 4;
        System.out.println(ks.maxProfit(w,v,capacity,3));
    }
}
