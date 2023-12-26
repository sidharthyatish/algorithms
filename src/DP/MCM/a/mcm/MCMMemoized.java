class Solution{
    
    static int[][] dp = new int[101][101];
    
    static int solve(int arr[], int i, int j){
        if(i>=j) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int minValue = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
        
        int tempAns = solve(arr,i,k) + solve(arr,k+1,j) + arr[i-1]*arr[k]*arr[j];
        
        minValue = Math.min(minValue,tempAns);
        }
        dp[i][j] = minValue;
        return dp[i][j];
    }
    static int matrixMultiplication(int N, int arr[])
    {
        for(int[] row: dp) Arrays.fill(row,-1);
        return solve(arr, 1, N-1);   
    }
}