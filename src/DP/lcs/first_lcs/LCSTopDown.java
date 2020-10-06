package DP.lcs.first_lcs;

public class LCSTopDown
{
    int lcs(String X,String Y, int m,int n){
        int[][] dp = new int[m+1][n+1];
        /*
            In top down, we use the same approach of recursion
            Recursion base case -> DP initialisation (first row and first column)
            Recursion choice diagram -> DP filling remaining rows and columns
            
            Recursion base case (m==0 || n==0) return 0; -> (m==0||n==0) dp[m][n]=0;
            Recursion choice diagram
                1. The characters are same
                   if X.charAt(m-1)==Y.char(n-1)
                        1 + lcs(X,m-1,n-1) -> 1 + dp[m-1][n-1]
                2. The characters are not same
                    max( lcs(X,Y,m,n-1), lcs(X,Y,m-1,n) -> max(dp[m][n-1],dp[m-1[n])
            The above changes are for any particular cell, which when added to a loop
            m->i, n->j
         */
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0) dp[i][j]=0;
                else if(X.charAt(i-1)==Y.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        
        return dp[m][n];
    }
    
    public static void main(String[] args)
    {
        LCSTopDown lcs = new LCSTopDown();
        String a = "abcdef";
        String b = "abced";
        System.out.println(lcs.lcs(a,b,a.length(),b.length()));
    }
}
