package Recursion;

public class KthSymbolInGrammar
{
    int kthSymbol(int n, int k){
        if(k==1||n==1) return 0;
        int length = (int) Math.pow(2,n);
        int mid = length/2;
        if(k<=mid){
            return kthSymbol(n-1,k);
        }
        else
            return kthSymbol(n-1,k-mid)==1?0:1;
    }
}
