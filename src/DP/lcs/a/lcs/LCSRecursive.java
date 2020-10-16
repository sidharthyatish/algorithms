package DP.lcs.a.lcs;

public class LCSRecursive
{
    
    int lcs(String X, String Y, int m, int n){
        /*
        Longest common subsequence - Given two strings, find the length of lcs
        
        Base condition : If any of the string is empty, the common string length is zero
        Choice diagram :
        We compare the last char of both the string
            1. They are equal
                1.1. LCS size grows by one and we proceed with remaining parts of both strings
            2. They are not equal
                2.1. We ignore the last character of string X and keep Y the same and find their LCS
                2.2. We ignore the last character of String Y and keep X the same and find their LCS
                Return the max (2.1,2.2)
        */
        
        //Base condition
        if(m==0||n==0) return 0;
        
        //Choice diagram
        //1.
        if(X.charAt(m-1)==Y.charAt(n-1)){
            //1.1
            return 1+ lcs(X,Y,m-1,n-1);
        }
        //2.
        else{
            //return max (2.1,2.2)
            return Math.max(
                    lcs(X,Y,m,n-1),
                    lcs(X,Y,m-1,n)
            );
        }
    }
    
    public static void main(String[] args)
    {
        LCSRecursive lcs = new LCSRecursive();
        String a = "abcdef";
        String b = "abecrd";
        System.out.println(lcs.lcs(a,b,a.length(),b.length()));
    }
}
