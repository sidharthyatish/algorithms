package DP.knapsack.a.zeroOneKnapSack.b.subsetSum.third_count;

public class SubSetSumCountBottomUp
{
    public int numberOfSubSets(int[] arr, int sum, int n){
        int[][] table = new int[n+1][sum+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                //Initialisation (base condition)
                if(i==0&&j>0) table[i][j]=0;
                else if(j==0) table[i][j]=1;
                
                //Have a choice (can be included for comparision)
                else if(arr[i-1]<=j){
                    
                    //Sum of both included and excluded sub problems
                    table[i][j]=table[i-1][j-arr[i-1]]+table[i-1][j];
                }
                //Exclude from comparision
                else table[i][j]=table[i-1][j];
            }
        }
        
        return table[n][sum];
    }
    
    public static void main(String[] args)
    {
        SubSetSumCountBottomUp ss = new SubSetSumCountBottomUp();
        int[] arr = new int[]{1,2,3,3};
        int sum =6;
        System.out.println(ss.numberOfSubSets(arr,6,arr.length));
    }
}
