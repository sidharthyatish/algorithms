class UniquePathsTwo {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){ // There can be an obstacle in the starting itself.
                    dp[i][j] = obstacleGrid[i][j]==0? 1 : 0;
                }
                // For the path to the right, if we see even one obstacle, then the entire right path is blocked.
                // There can be a obstacle and then next cell might be non obstacle. In that case, we should not consider that path (whole path is blocked)
                // Thats why instead of assigning 1 directly, we assign the previous cell value
                else if(i==0){
                    dp[i][j] = obstacleGrid[i][j]==0? dp[i][j-1] : 0;
                }
                else if(j==0){
                    dp[i][j] = obstacleGrid[i][j]==0? dp[i-1][j] : 0;
                }
                else {
                    if(obstacleGrid[i][j]==0){
                        dp[i][j] = dp[i-1][j]+dp[i][j-1];
                    }
                    else{
                        dp[i][j]=0;
                    }
                    
                }
            }
        }

        return dp[m-1][n-1];

    }
}