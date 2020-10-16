package DP.lcs.h.sequencePatternMatching;

import DP.lcs.a.lcs.LCSBottomUp;

public class SPM
{
    boolean doesStringAExistsAsSubsequenceinB(String a, String b){
        /*
            a= "ABY"
            b= "AXBXY"
            
            here a is subsequence of b
            
            here the LCS is the same as string a
            
            return length(a) == LCS(a,b)
         */
        LCSBottomUp lcsBottomUp = new LCSBottomUp();
        return a.length() == lcsBottomUp.lcs(a,b,a.length(),b.length());
    }
}
