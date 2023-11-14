package DP.knapsack.a.zeroOneKnapSack.b.subsetSum.a.existsOrNot;

public class SubSetSumBottomUp
{
    public boolean isSubSetPresent(int[] arr, int sum, int nItems){
        boolean[][] dp = new boolean[nItems+1][sum+1];
        
        for(int i=0;i<=nItems;i++){
            for(int j=0;j<=sum;j++){
                if(i==0&&j>0) dp[i][j] = false; // why j>0 ? becasue if j==0=> sum==0 then its always true. In recursive code this is nItems==0 (comes below)
                else if(j==0) dp[i][j] = true; // in recursive code this is sum==0 (comes above)
                else if(arr[i-1]<=j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[nItems][sum];
    }
    
    public static void main(String[] args)
    {
        SubSetSumBottomUp ss = new SubSetSumBottomUp();
        int arr[] = new int[]{5,3,2,1,4};
        int sum = 15;
        System.out.println(ss.isSubSetPresent(arr,sum,arr.length));
    }
}
