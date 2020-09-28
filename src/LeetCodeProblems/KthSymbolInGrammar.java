package LeetCodeProblems;

public class KthSymbolInGrammar
{
    public int kthGrammar(int N,int k){
        // https://leetcode.com/problems/k-th-symbol-in-grammar/
        
        if(N==1) return 0;
        int currRowLength = (int) Math.pow(2,N-1);
        if(k <= currRowLength/2){
            return kthGrammar(N-1,k/2);
        }
        else{
            //If we are in second half, then we have to go to previous row first half.
            // if k = 5 and length = 8  then its in second half, the equivalent first half is 1 (5-8/2)
            // if k = 7 and length = 8 then equivalent first half is 3 (7-8/2)
            return kthGrammar(N-1,k-currRowLength/2)==0? 1:0;
        }
    }
    
    public static void main(String[] args)
    {
        KthSymbolInGrammar kth = new KthSymbolInGrammar();
        System.out.println(kth.kthGrammar(4,5));
    }
}
