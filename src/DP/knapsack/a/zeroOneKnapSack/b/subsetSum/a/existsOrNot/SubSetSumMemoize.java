class Solution {

    
    static boolean isSubsetPresent(int arr[], int sum, int n, int[][] dp){
        if(sum==0) return true;
        if(n==0) return false;
        
        if(dp[n][sum]!=-1) return dp[n][sum]==1? true: false;
        if(arr[n-1]<=sum){
            boolean included = isSubsetPresent(arr,sum-arr[n-1],n-1, dp);
            boolean excluded = isSubsetPresent(arr,sum,n-1,dp);
            dp[n][sum] = (included || excluded)? 1:0;
            
        }
        else{
            dp[n][sum] =  isSubsetPresent(arr,sum,n-1,dp)? 1:0;
        }
        return dp[n][sum]==1;
    }
    static boolean isSubsetSum(int arr[], int sum) {
        // code here
        
        int[][] dp = new int[arr.length+1][sum+1];

        //Only filling as -1 makes sense. Keeping it as a boolean array is making it difficult because
        // There are three cases. 1. Does the dp have an answer? 2. Is the answer true 3. Is the answer false
        // So we have to deal with three numbers -1,0,1 
        
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return isSubsetPresent(arr,sum,arr.length, dp);
        
    }
}