package DP.MCM.d.scrambledString;

public class ScrambledStringRecursive
{
    boolean isScrambled(String a, String b){
        /*
            Given two strings, we need to find if one string is scrambled version of another
            
            Scrambled?
            ---------
            A string is set to be scrambled if it is represented as a binary tree and we swapped the children of non-leaf nodes
            A single child of a node cannot be empty. i.e., the no. of children can be either 0 or 2.
            
            "great" <-Non leaf
              / \
             g  reat <- Non leaf (if swapped the string would have been reatg)
                / \
                r  eat <-Non leaf (if swapped it would have been geatr)
                   / \
       Non leaf-> ea  t (if swapped at ea it would have been graet)
                  / \
                  e a
                  
          Only non leaf's children can be swapped.
          The partition can be at any position but not first and last since a single child can't be empty
          No of swaps can be 'zero or more'. So we may or may not swap.
          
          For a given string it can be partitioned anywhere from 1 to len-1
          g|r|e|a|t
          Any partition could have been swapped. Note even if they are anagrams, they need not be scrambled strings
          
          How to solve?
          ------------
          Since the possible swaps is zero or more, it can be swapped or not. So we search with two assumptions
          We assume them as swapped and check if they are scrambled, we assume them as not swapped and check if they are scrambled
          In either case if they return true, they are scrambled. If both cases fail, they are not.
          1. swapped --> (1)
                - a= gr|eat , b= eat|gr
                - Note the position of partition is diff for both
                - compare if first two of a with last two of b --> (1.1) Both must be scrambled strings of each other
                - Compare rest half of a with first half of b  --> (1.2) Both must be scrambled strings of each other
                - return true if 1.1 and 1.2 are true
          2. not swapped --> (2)
                - a= gr|eat, b=gr|eat
                - Note the position of partition is same for both
                - Compare if first two of a with first 2 of b --> (2.1) Both must be scrambled strings of each other
                - Compare rest half of both a and b           --> (2.2) Both must be scrambled strings of each other
                - return true if 2.1 and 2.2 are true
          If either (1) or (2) becomes true, it means they are scrambled strings
          
          Note: in each halves, we aren't checking if the strings are equal, we are checking if the sub strings are scrambled or not
          e.g. in case (1) say a = gr|eat , b = ate|gr --> They are swapped at this position but the substrings are not equal but scrambled
               in case (2) say a = gr|eat , b = gr|ate --> They are not swapped at this position but the substrings are not equal but scrambled
                        eat <- non leaf (swapping gives ate)
                        / \
                        e at
          
         */
        return solve(a,b);
    }
    boolean solve(String a, String b){
        //If both are diff length, they are not scrambled strings at all
        if(a.length()!=b.length()) return false;
        
        //Empty strings are scrambled
        if(a.length()==0) return true;
        
        //Equal strings are scrambled strings
        if(a.equals(b)) return true;
        
        //If they are not equal but they are a single char or less then they are not scrambled strings
        if(a.length()<=1) return false;
        
        int n = a.length();
    
        for(int i=1;i<=n-1;i++){
            
            //If they are swapped gr|eat    eat|gr we need to compare at opposite positions for both halves
            boolean ifTheyAreSwapped =
                    solve(a.substring(0,i),b.substring(n-i,n)) &&
                            solve(a.substring(i,n),(b.substring(0,n-i)));
            
            //If they are not swapped gr|eat   gr|eat we need to compare same positions for both halves
            boolean ifTheyAreNotSwapped =
                    solve(a.substring(0,i),b.substring(0,i)) &&
                            solve(a.substring(i,n),(b.substring(i,n)));
            if(ifTheyAreNotSwapped || ifTheyAreSwapped) return true;
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        ScrambledStringRecursive sc = new ScrambledStringRecursive();
        System.out.println(sc.isScrambled("coder","ocder"));
    }
}
