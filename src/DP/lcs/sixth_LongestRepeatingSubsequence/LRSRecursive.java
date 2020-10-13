package DP.lcs.sixth_LongestRepeatingSubsequence;

public class LRSRecursive
{
    int lrsRecursive(String a){
        /*
            The subsequence that repeats itself as well is the longest in the Longest repeating subsequence
            
            say a = "AABEBCDD"
            Here "ABD" subsequence comes twice
            
            How to find the length of it?
            -----------------------------
            a = "AABEBCDD"
            b = "AABEBCDD" //Copy of a
            Say we are finding LCS of a and b (which is LCS(a,a))
            Here E and C comes only once which means if E and C are to be found in a and b, it will ONLY be found in same index
            of a and b (E->3, C->5) Whereas others would not only be found in same index
            
            Say in a we get a B and in b we get B
            if they are in same index we ignore them, if they are in diff index we include them
            
            X = AAEBB
            Y = AAEBB
            if we encounter E, then it will be in same index of X and Y. i.e., X[2],Y[2]
            if we encounter A, then it might be in X[0],Y[0] --> Eq.(1) (or) X[0],Y[1] or X[1],Y[0] --> Eq.(2)
            if we encounter B, then it might be in X[3],Y[3] --> Eq.(1) (or) X[3],Y[4] or X[4],Y[3] --> Eq.(2)
            We ignore the case of Eq.(1) since the indices are same, and we consider Eq.(2).
            In this case, we consider only the repeated instances of both the strings
            
            Note: in Eq(2) there are two cases, however LCS value for both the cases would be the same. Since we are considering only
            the max value, the final result would be same.
         */
        return lrs(a,a,a.length(),a.length());
        
        
    }
    
    int lrs(String a, String b,int m,int n){
        if(m==0||n==0) return 0;
        
        //The characters must be equal but the position (here length) must not be same.
        //We can use a single string a itself as a.charAt(m-1)==a.charAt(n-1) also.
        if(a.charAt(m-1)==b.charAt(n-1)&&m!=n) return 1+lrs(a,b,m-1,n-1);
        else return Math.max(lrs(a,b,m,n-1),lrs(a,b,m-1,n));
    }
    
    public static void main(String[] args)
    {
        LRSRecursive lrs = new LRSRecursive();
        String a = "AABEBCEDD";
        System.out.println(lrs.lrsRecursive(a));
    }
    
    
}
