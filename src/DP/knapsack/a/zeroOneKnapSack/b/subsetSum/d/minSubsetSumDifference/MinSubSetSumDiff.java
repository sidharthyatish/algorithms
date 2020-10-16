package DP.knapsack.a.zeroOneKnapSack.b.subsetSum.d.minSubsetSumDifference;

public class MinSubSetSumDiff
{
    /*
    1. Divide the array into two subsets
    2. The difference between the sum of two subsets must be minimum
    
            [Array]
              /\
           [S1] [S2]
    Abs(sum(s1) - sum(s2)) must be minimum --- (1)
    
    Return the minimum sum
    
    sum(s2) = totalSum - sum(s1)   --- (2)
    
    Put eq (2) in eq (1)
    
    Abs(sum(s1) - (totalSum - sum(s1))
    Abs(2sum(s1) - totalSum)) (or) Abs(totalSum - 2 * sum(s1)) must be minimum
    
    
    (0)|<--------------------->|(totalSum)
    sum(s1) and sum(s2) lies in this line
       |<-----------|--------->|
       (0)      totalSum/2     (totalSum)
       
       It is not necessary that all numbers from 0..totalSum/2 are valid. We need to consider only valid sums
       if sum(s1) lies in first half then sum(s2) will lie in the second half since sum(s2) = totalSum - sum(s1)
       
       So we can find valid(Note!) sums that lie between 0..totalSum/2 and find the diff (totalSum - 2sum(s1)) and return which is minimum
       
       Note! How to find valid sums?? Valid sums are those for which subset exists.
       In the subset sum, the last row contains true for those subsets with sum exists. We can just use this row
       
     */
    int minSubSetSumDiff(int arr[], int n){
        int totalSum = 0;
        for(int elem : arr) totalSum+=elem;
        
        boolean[][] dp = new boolean[n+1][totalSum+1];
        //SubSet Sum DP
        for(int i=0;i<=n;i++){
            for(int j=0;j<=totalSum;j++){
                if(i==0&&j>0) dp[i][j]=false;
                else if (j==0) dp[i][j] = true;
                else if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        /*
            In the DP array
               (0)......(totalSum)
            (0)[T,F,F,F...]
            (1)[T,........]
            ...
            ...
            (n)[T,........] //This row will contain true if subset with sum (0,1,2,3...totalSum) exists or not.
            We can just iterate till half of totalSum and get the minimum diff
         */
        
        //Without dp, this can be isSubSetSum(arr,i)
        int minimumDiff = Integer.MAX_VALUE;
        for(int i=0;i<=totalSum/2;i++){
            int sumS1 = dp[n][i]? i:0;
            minimumDiff = Math.min(minimumDiff,totalSum-2*sumS1);
        }
        return minimumDiff;
        
    }
    
    public static void main(String[] args)
    {
        MinSubSetSumDiff sd = new MinSubSetSumDiff();
        int[] arr = new int[]{1,2,7};
        System.out.println(sd.minSubSetSumDiff(arr,arr.length));
    }
}
