//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int[][][] dp = new int[201][201][2];
    
    static int solve(String S, int i, int j, boolean isTrue){
        if(i>j) return 0;
        
        if(i==j){
            if(isTrue) return S.charAt(i)=='T'? 1 : 0;
            else return S.charAt(i) == 'F'? 1 : 0;
        }
        
        if(dp[i][j][isTrue?1:0]!=-1) return dp[i][j][isTrue?1:0];
        
        int ans=0;
        
        for(int k=i+1;k<=j-1;k+=2){
            int leftTrue = solve(S,i,k-1,true);
            int leftFalse = solve(S,i,k-1,false);
            int rightTrue = solve(S,k+1,j,true);
            int rightFalse = solve(S,k+1,j,false);
            
            switch(S.charAt(k)){
                case '^':
                    if(isTrue) ans+=leftTrue*rightFalse + leftFalse*rightTrue;
                    else ans+=leftTrue*rightTrue + leftFalse*rightFalse;
                    break;
                case '|':
                    if(isTrue) ans+=leftTrue*rightTrue+leftFalse*rightTrue+leftTrue*rightFalse;
                    else ans+=leftFalse*rightFalse;
                    break;
                case '&':
                    if(isTrue) ans+=leftTrue*rightTrue;
                    else ans+=leftFalse*rightFalse+leftFalse*rightTrue+leftTrue*rightFalse;
                    break;
            }
            
            
            
            
        }
        dp[i][j][isTrue?1:0] = ans%1003;
        return dp[i][j][isTrue?1:0];
    }
    static int countWays(int N, String S){
        // code here
        
        for(int[][] i : dp){
            for(int[] j : i){
                Arrays.fill(j,-1);
            }
        }
        return solve(S, 0, N-1, true);
    }
}