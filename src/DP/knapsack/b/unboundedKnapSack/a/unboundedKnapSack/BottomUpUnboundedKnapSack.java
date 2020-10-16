package DP.knapsack.b.unboundedKnapSack.a.unboundedKnapSack;

public class BottomUpUnboundedKnapSack
{
    int maxProfit(int weights[], int values[],int capacity, int nItems){
        int[][] dp = new int[nItems+1][capacity+1];
        
        for(int i=0;i<=nItems;i++){
            for(int j=0;j<=capacity;j++){
                if(i==0||j==0) dp[i][j]=0;
                else if(weights[i-1]<=j){
                    dp[i][j] = Math.max(values[i-1]+dp[i][j-weights[i-1]],dp[i-1][j]);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[nItems][capacity];
    }
}
