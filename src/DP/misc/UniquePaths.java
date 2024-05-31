class UniquePaths {
    public int uniquePaths(int m, int n) {
        // If there is only one row / column, then a single straight line path is the only possibility
        // That becomes the base condition
        // Then we sum up paths from top and left (since only right and bottom movement is possible)

        //https://leetcode.com/problems/unique-paths/
        
        /*
        if(m==1 || n==1) return 1;

        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
        */

        int[][] dp = new int[m+1][n+1];


				//also works for i=0;i<m.. in that case return dp[m-1][n-1]
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1 || j ==1) dp[i][j]=1;
                else dp[i][j] = dp[i-1][j]+dp[i][j-1]; //+dp[i-1][j-1] if diagonal is asked
            }
        }
        return dp[m][n];
    }
}