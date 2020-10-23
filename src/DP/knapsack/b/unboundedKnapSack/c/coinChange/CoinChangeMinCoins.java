package DP.knapsack.b.unboundedKnapSack.c.coinChange;

public class CoinChangeMinCoins
{
    int minNumberOfCoinsRecursive(int[] coins, int sum, int n){
        
        //If required sum is zero, then the minimum number of coins required is zero
        if(sum==0) return 0;
        
        //If there are no coins, for any sum, then we need infinite coins
        //Why MAX_VALUE-1 ? since recursive call has 1+recur() it will become MAX_VALUE
        //else it would result in overflow
        if(n==0) return Integer.MAX_VALUE-1;
        
        /*
            1. I have a choice
                1.1. I can include the coin (increase the count by 1) and proceed with same coin
                1.2. I can ignore
            2. I don't have a choice
                2.1. I have to ignore
         */
        
        //1.
        if(coins[n-1]<=sum){
            
            //Choose minimum of 1.1 and 1.2
            return Math.min(
                    1+minNumberOfCoinsRecursive(coins,sum-coins[n-1],n),
                    minNumberOfCoinsRecursive(coins,sum,n-1));
        }
        
        //2.
        else return minNumberOfCoinsRecursive(coins,sum,n-1);
        
    }
    
    int minNumberOfCoinsTopDown(int[] coins, int sum, int n){
        int[][] dp =new int[n+1][sum+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0&&j>0) dp[i][j]=Integer.MAX_VALUE-1;
                else if(j==0) dp[i][j]=0;
                else if(coins[i-1]<=j){
                    dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    
    public static void main(String[] args)
    {
        CoinChangeMinCoins cc = new CoinChangeMinCoins();
        int[] coins = new int[]{9,6,5,1};
        int sum = 11;
        System.out.println(cc.minNumberOfCoinsRecursive(coins,sum,coins.length));
        System.out.println(cc.minNumberOfCoinsTopDown(coins,sum,coins.length));
    }
}
