package DP.lcs.third_printLCS;

public class PrintLCS
{
    String printLCS(String X,String Y, int m,int n){
        //First build the LCS DP
        
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0) dp[i][j]=0;
                else if(X.charAt(i-1)==Y.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        /*
            How are we building this DP table?
            
              ---------------
              |   $   |   #  |
              --------------
              |   %   |   *  |
              ---------------
              
              Consider the above as cells of the table
              Here:
                * -> dp[i][j]
                $ -> dp[i-1][j-1]
                # -> dp[i-1][j]
                % -> dp[i][j-1]
                
                We determine the value of * as
                if (X[i-1] == Y[i-1]) then val(*) = val($) +1
                else val(*) = max( val(%), val(#))
                
                If we follow this, we can identify the path we need to travel from dp[m][n] and get each char of string
                only if (X[i-1] == Y[j-1]) we will consider the character in result
         */
        
        StringBuilder lcsString =  new StringBuilder();
        
        int i=m;
        int j=n;
        
        //If any of them reaches 0, then it means they have become empty
        while(i>0&&j>0){
            if(X.charAt(i-1)==Y.charAt(j-1)){
                lcsString.append(X.charAt(i-1));
                i--;
                j--;
            }
            else{
                //Move to the cell which contains the max value in the diagonal (%,#) in the comment above
                if(dp[i-1][j]>dp[i][j-1]) i--;
                else j--;
            }
        }
        //The LCS string as iterated will be in reverse
        return lcsString.reverse().toString();
    }
    
    public static void main(String[] args)
    {
        PrintLCS lcs = new PrintLCS();
        String a = "arcdef";
        String b = "abecrde";
        System.out.println(lcs.printLCS(a,b,a.length(),b.length()));
    }
}
