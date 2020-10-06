package DP.knapsack.second_unboundedKnapSack.third_coinChange;

public class CoinChangeMaxWays
{
    int maxNumberOfWaysRecursive(int[] coins, int sum, int n){
        //For zero sum, there is always one empty subset {} possible.
        if(sum==0) return 1;
        
        //Else if sum > 0 but we don't have coins then number of ways is zero
        if(n==0) return 0;
        
        /*
            1. I have a choice
                1.1. I can choose it and continue with the same coin
                1.2. I can ignore the coin and proceed with the remaining coins
            2. I don't have a choice
                2.1. I ignore and continue with remaining coins
         */
        
        //1.
        if(coins[n-1]<=sum){
            //1.1 + 1.2
            //Note : 1.1 -> we have chosen and recursively called for same coin, but the sum decreases
            //Note : 1.2 -> we have ignored so we moved to remaining coins n-1 and sum remains same
            return maxNumberOfWaysRecursive(coins,sum-coins[n-1],n) + maxNumberOfWaysRecursive(coins,sum,n-1);
        }
        //2.
        else{
            //2.1
            return maxNumberOfWaysRecursive(coins,sum,n-1);
        }
    }
    
    int maxNumberOfWaysTopDown(int[] coins, int sum, int n){
        int[][] dp = new int[n+1][sum+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0&&j>0) dp[i][j]=0;
                else if(j==0) dp[i][j]=1;
                else if(coins[i-1]<=j){
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
    
    public static void main(String[] args)
    {
        CoinChangeMaxWays cc = new CoinChangeMaxWays();
        int[] coins = new int[]{1,2,3};
        int sum =4;
        System.out.println(cc.maxNumberOfWaysRecursive(coins,sum,coins.length));
        System.out.println(cc.maxNumberOfWaysTopDown(coins,sum,coins.length));
    }
}
