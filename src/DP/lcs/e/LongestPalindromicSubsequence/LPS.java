package DP.lcs.e.LongestPalindromicSubsequence;

import DP.lcs.a.lcs.LCSBottomUp;

public class LPS
{
    LCSBottomUp lcs;
    
    int maxLength(String X){
        int m = X.length();
        lcs = new LCSBottomUp();
        
        /*
            LPS = Longest palindromic subsequence. Find the longest subsequence which is a palindrome
            a = "agbcba"
            The LPS is abcba of length 5
            
            LPS(a) = LCS(a, reverse(a))
            
            a = "agbcba"
            rev_a = "abcbga"
            Their LCS will be a longest palindrome
         */
        StringBuilder revStr = new StringBuilder(X);
        String xRev = revStr.reverse().toString();
        
        return lcs.lcs(X,xRev,X.length(),xRev.length());
        
        //TODO : number of insertions to make a string palindrome
        /*
            To make a string palindrome
            a="AEBCDBA"
            we can either delete E,D or insert D,E on either side
            String -> LPS
                 (deletion/insertions)
                 Number of insertions and number of deletions are same
                 If we choose to delete we are gonna delete E,D
                 If we choose to insert we are gonna insert E,D
                 So in both cases return length(a) - LPS(a)
         */
        
    }
    
}
