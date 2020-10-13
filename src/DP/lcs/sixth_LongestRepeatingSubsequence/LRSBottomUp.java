package DP.lcs.sixth_LongestRepeatingSubsequence;

public class LRSBottomUp
{
    int lrs(String a){
        int m = a.length();
        String b = a;
        int[][] dp = new int[m+1][m+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=m;j++){
                if(i==0||j==0) dp[i][j]=0;
                //This can be a.charAt(i-1)==a.charAt(j-1) also
                else if(a.charAt(i-1)==b.charAt(j-1)&&i!=j) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[m][m];
    }
    
    public static void main(String[] args)
    {
        LRSBottomUp lrs = new LRSBottomUp();
        String a = "AABEBCDD";
        System.out.println(lrs.lrs(a));
    }
}
