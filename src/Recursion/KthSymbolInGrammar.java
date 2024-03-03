package Recursion;

public class KthSymbolInGrammar
{
    public int kthGrammar(int n, int k) {
        if(k==1) return 0;
        int length = (int)Math.pow(2,n-1); //Note length is obtained by previous row's n and not current row's
        int mid = length/2;
        if(k<=mid)
            return kthGrammar(n-1,k);
        else
            return kthGrammar(n-1,k-mid) ==0? 1:0; 
    }
}
