package DP.knapsack.second_subsetSum.third_count;

public class SubSetSumCountRecur
{
    int numberOfSubSets(int[] arr, int sum, int n){
        /*
        Very similar to knapsack and subsetsum exists problem. I can choose to include an element or not.
        I just need to return the sum of sub problems
         */
        
        //If the sum is zero, then it always has one solution (empty subset)
        if(sum==0) return 1;
        
        //If there are no elements in the array but the sum is greater than zero, then there is zero subset
        if(n==0) return 0;
        
        //I have a choice, I can consider the element in the subset and continue, or ignore and continue
        if(arr[n-1]<=sum){
            
            //return the sum of both scenarios as I need the count of subsets
            return numberOfSubSets(arr,sum-arr[n-1],n-1)+numberOfSubSets(arr,sum,n-1);
        }
        //I dont have a choice. So I ignore and continue
        else{
            return numberOfSubSets(arr,sum,n-1);
        }
        
    }
    
    public static void main(String[] args)
    {
        SubSetSumCountRecur ss = new SubSetSumCountRecur();
        int[] arr = new int[]{1,2,3,3};
        int sum =6;
        System.out.println(ss.numberOfSubSets(arr,6,arr.length));
    }
}
