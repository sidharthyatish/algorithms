package Recursion;

public class KthSymbolInGrammar
{
    /*
     k 1 2 3 4 5 6 7 8
    n
    1  0 
    2  0 1
    3  0 1 1 0
    4  0 1 1 0 1 0 0 1
    5  0 1 1 0 1 0 0 1 1 0 0 1 0 1 1 0

    Note that for each row, till mid, the results are same as previous row
    after mid, the result is inverse of previous row. 

    Thats it!
    
    
    */
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
