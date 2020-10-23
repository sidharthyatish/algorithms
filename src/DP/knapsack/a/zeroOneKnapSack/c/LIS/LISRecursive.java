package DP.knapsack.a.zeroOneKnapSack.c.LIS;


public class LISRecursive
{
    int lisRecursive(int[] arr, int rightElement, int n){
        if(n==0) return 0;
        
        if(arr[n-1]<rightElement){
            return Math.max(1+ lisRecursive(arr,arr[n-1],n-1), lisRecursive(arr,rightElement,n-1));
        }
        else{
            return lisRecursive(arr,rightElement,n-1);
        }
    }
    
    
    public static void main(String[] args)
    {
        LISRecursive lis = new LISRecursive();
        
        int[] arr = new int[]{10, 22, 9, 33, 21, 50, 41, 60};
    
        System.out.println(lis.lisRecursive(arr,Integer.MAX_VALUE,arr.length));
    }
}
