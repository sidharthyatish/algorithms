package DP.MCM.b.palindromePartitioning;

public class PalindromeParitioning
{
    int minNumberOfPartitionsRecursive(String str){
        /*
            Given a string, find the minimum number of partitions we can make such that each substring is a palindrome
            str = "ABCBD"
             A | BCB | D
             all three substrings are palindrome. The number of partitions is 2
             
             We need to place the partition at several positions and find if the substrings are palindrome.
             This is similar to MCM.
             1. find base case
             2. Find the range of k
             3. For each k, find a temp solution
             4. Return minimum of temp solutions
         */
        return solve(str,0,str.length()-1);
    }
    int solve(String str,int i,int j){
        //If string is a palindrome, then no partition is required
        if(i>=j) return 0; //If i==j that is a single char which is a palindrome, if i>j, it is out of index
        
        //For memoization check here itself
        if(isPalindrome(str, i, j)) return 0;
        
        //Range of k is from i to j-1. If k ==j, then k+1 is invalid
        int res = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int tempAns = solve(str,i,k) + solve(str,k+1,j) + 1; //1 => We are considering the current k pos as a partition
            //In worst case, all the characters are partitioned to get palindrome
            // a | b | c | d | e so numPartitions = length()-1
            res = Math.min(res,tempAns);
        }
        return res;
        
    }
    boolean isPalindrome(String str,int i,int j){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        PalindromeParitioning pp = new PalindromeParitioning();
        System.out.println(pp.minNumberOfPartitionsRecursive("abcbca"));
    }
}
