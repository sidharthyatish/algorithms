package DP.knapsack.second_subsetSum.first_existsOrNot;

public class SubSetSumTopDown
{
    public boolean isSubSetPresent(int[] arr, int sum, int nItems){
        boolean[][] dp = new boolean[nItems+1][sum+1];
        
        for(int i=0;i<=nItems;i++){
            for(int j=0;j<=sum;j++){
                if(i==0&&j>0) dp[i][j] = false;
                else if(j==0) dp[i][j] = true;
                else if(arr[i-1]<=j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[nItems][sum];
    }
    
    public static void main(String[] args)
    {
        SubSetSumTopDown ss = new SubSetSumTopDown();
        int arr[] = new int[]{5,3,2,1,4};
        int sum = 15;
        System.out.println(ss.isSubSetPresent(arr,sum,arr.length));
    }
}
