package DP.knapsack.second_unboundedKnapSack.second_rodCutting;

public class TopDownRodCutting
{
    int maxProfit(int[] prices, int maxLength){
        
        int[][] dp = new int[maxLength+1][prices.length+1];
        
        
        //Here lengths[i-1] is just gonna be i So we avoided that array itself
        for(int i=0;i<=prices.length;i++){
            for(int j=0;j<=maxLength;j++){
                if(i==0||j==0) dp[i][j]=0;
                else if(i<=j)
                {
                    // this would have been dp[i][j] = max(prices[i-1]+dp[i][j-lengths[i-1],dp[i-1][j])
                    dp[i][j] = Math.max(prices[i - 1] + dp[i][j - i], dp[i - 1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[maxLength][maxLength];
    }
    
    public static void main(String[] args)
    {
        TopDownRodCutting rc = new TopDownRodCutting();
        int[] lengths = new int[]{1,2,3,4,5,6,7,8};
        int[] prices = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(rc.maxProfit(prices,prices.length));
    }
}
