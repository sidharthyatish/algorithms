package DP.lcs.b.lcSubString;

public class LongestCommonSubstring
{
    
    /*
        To find substring, until the strings are same, I increment the length,
        Once I find a discontinuity, I reset the length to 0 and update the new length
     */
    int maxLengthRecur(String X, String Y, int m, int n, int res){
        
        //The maximum length is stored in res. If I reach the end of any string, I return the res
        if(m==0||n==0) return res;
        
        //If the last char of both strings are equal, res is incremented and I continue with the rest of the string
        if(X.charAt(m-1)==Y.charAt(n-1)){
            return maxLengthRecur(X,Y,m-1,n-1,res+1);
        }
        else{
            
            /*
                If they are not equal, I reset the res to 0 and continue to find new length
                1. I consider X as whole and Y without last char, res = 0 -> recur(X,Y,m,n-1,0) Here res =0
                2. I consider Y as whole and X without last char, res = 0 -> recur(X,Y,m-1,n,0) Here res =0
                3. I already have res calculated so far
                
                Need to return max(1,2,3)
             */
            return Math.max(res,Math.max(maxLengthRecur(X,Y,m,n-1,0), maxLengthRecur(X,Y,m-1,n,0)));
        }
    }
    
    int maxLengthTopDown(String X,String Y, int m, int n){
        int[][] dp = new int[m+1][n+1];
        
        int max = 0;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0) dp[i][j]=0;
                else if(X.charAt(i-1)==Y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    //dp[i][j] Now contains max so far. We need to update max length now
                    max = Math.max(max,dp[i][j]);
                }
                else{
                    //If they are not equal I reset it to zero. Loop continues with remaining string
                    dp[i][j] = 0;
                }
            }
        }
        
        return max;
    }
    
    public static void main(String[] args)
    {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String X = "abecmdefrae";
        String Y = "abdcudecfre";
        System.out.println(lcs.maxLengthRecur(X,Y,X.length(),Y.length(),0));
        System.out.println(lcs.maxLengthTopDown(X,Y,X.length(),Y.length()));
    }
}
