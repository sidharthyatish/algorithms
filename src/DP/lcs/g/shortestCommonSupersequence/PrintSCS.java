public class PrintSCS {
     public String shortestCommonSupersequence(String str1, String str2) {
        //Generate LCS dp array
        
        int m =str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j ==0 ) dp[i][j]=0;
                else if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        //Printing SCS

        int i=m;
        int j=n;

        StringBuilder scsBuilder = new StringBuilder();

        while(i>0 && j>0){

            if(str1.charAt(i-1) == str2.charAt(j-1)){
                scsBuilder.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                scsBuilder.append(str1.charAt(i-1));
                i--;
            }
            else{
                scsBuilder.append(str2.charAt(j-1));
                j--;
            }

        }

        while(i>0){
            scsBuilder.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            scsBuilder.append(str2.charAt(j-1));
            j--;
        }

        return scsBuilder.reverse().toString();

    }
}