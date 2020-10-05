package DP.knapsack.first_zeroOneKnapSack.second_subsetSum.first_existsOrNot;

public class SubSetSumRecur
{
    boolean isSubSetPresent(int[] arr, int sum, int nItems){
        //If the sum is zero, then it is always true as empty subset {} sum is zero
        if(sum==0) return true;
        //If sum is not zero but number of items is zero then the subset is not at all possible
        if(nItems==0) return false;
        
        /*
        Like 01KnapSack there are two conditions
        1. I have a choice (the current item can be used for comparison i.e., its value <= sum)
            1.1. I can consider it in subset (It can be optimal)
            1.2. I can discard it in subset (It cannot be optimal)
        2. I dont have a choice (the current item can be discarded i.e., its value>sum)
         */
        
        //1.1
        if(arr[nItems-1]<=sum){
            //return (1.1 or 1.2)
            return isSubSetPresent(arr,sum-arr[nItems-1],nItems-1) ||
                    isSubSetPresent(arr,sum,nItems-1);
        }
        //1.2
        else {
            return isSubSetPresent(arr,sum,nItems-1);
        }
    }
    
    public static void main(String[] args)
    {
        SubSetSumRecur ss = new SubSetSumRecur();
        int arr[] = new int[]{5,3,2,1,4};
        int sum = 45;
        System.out.println(ss.isSubSetPresent(arr,sum,arr.length));
    }
}
