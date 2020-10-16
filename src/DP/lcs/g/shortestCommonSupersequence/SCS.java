package DP.lcs.g.shortestCommonSupersequence;

import DP.lcs.a.lcs.LCSBottomUp;

public class SCS
{
    LCSBottomUp lcsHelper;
    int lengthOfSCS(String a, String b){
        lcsHelper = new LCSBottomUp();
        /*
            Shortest common super sequence is a shortest sequence out of which both string a and string b can be derived
            a = "geek"
            b = "eke"
            the shortest super sequence by merging a and b is
            g e e k
                e k e
          = g e e k e
          Note: the sequence that is common in both/ repeating sequence is included only once
          
            a = "AGGTAB"
            b = "GXTXAYB"
            
            A G G T A B
            G X T X A Y B
            
            those chars that are present in both a and b are written only once, the remaining chars are written as such
            
            Matching chars in both string a and b = LCS
            
            LCS of above a and b = G T A B
            so from a and b , remove the LCS
            a + b = "AGGTABGXTXAYB"
            remove LCS = "GTAB"
            a+b-LCS(a,b) = "AGGXTXAYB" => Shortest Common super sequence
            
            Thus length of SCS = length(a)+length(b) - LCS(a,b)
         */
        return a.length()+b.length() - lcsHelper.lcs(a,b,a.length(),b.length());
        //TODO print SCS
        //Printing is similar to print LCS. We take the top down dp and, print them if they are equal
        //also print if they are not equal depending on the direction we are moving
        //If any one string becomes empty, print the rest of the string
    }
}
