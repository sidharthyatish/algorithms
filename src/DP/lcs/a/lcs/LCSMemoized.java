package DP.lcs.a.lcs;

public class LCSMemoized
{
    //Memoization  = recursion + table. So the best idea is to keep this table outside
    int[][] dp;
    
    LCSMemoized(){
        //say the constraints says that length of the strings is 1000 at max
        //Initialise the table with -1
        dp = new int[1001][1001];
        for(int i =0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++) dp[i][j]=-1;
        }
    }
    
    int lcs(String X,String Y, int m, int n){
        if(m==0||n==0) return 0;
        
        //Memoization : check and return the table value before making any recursive calls
        if(dp[m][n] > -1) return dp[m][n];
        
        if(X.charAt(m-1)==Y.charAt(n-1)){
            dp[m][n] = 1 + lcs(X,Y,m-1,n-1);
        }
        else{
            dp[m][n] = Math.max(
                    lcs(X,Y,m,n-1),
                    lcs(X,Y,m-1,n)
            );
        }
        return dp[m][n];
    }
    
    public static void main(String[] args)
    {
        LCSMemoized lcs = new LCSMemoized();
        String a = "abcdef";
        String b = "aberd";
        System.out.println(lcs.lcs(a,b,a.length(),b.length()));
    }
}
