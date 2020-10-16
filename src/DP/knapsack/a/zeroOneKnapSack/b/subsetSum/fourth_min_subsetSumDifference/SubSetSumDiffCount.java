package DP.knapsack.a.zeroOneKnapSack.b.subsetSum.fourth_min_subsetSumDifference;

import DP.knapsack.a.zeroOneKnapSack.b.subsetSum.third_count.SubSetSumCountBottomUp;

public class SubSetSumDiffCount
{
    SubSetSumCountBottomUp subsetCount;
    /*
        1. Given an array and a difference
        2. Return the count of the subsets whose sum has the given diff
        3. We can reuse subset count
        [Array]
          / \
       [s1] [s2]
       
       Return the count such that Abs (sum(s1) - sum(s2)) = diff ---(1)
       sum(s1) + sum(s2) = totalSum
       sum(s2) = totalSum - sum(s1)  --- (2)
       eq (2) in eq (1)
       
       sum(s1) - (totalSum - sum(s1)) = diff
       2*sum(s1) = diff + totalSum
       
       sum(s1) = (diff + totalSum)/2 --(3)
     
       
       thus return count(1) which in turn means return count of (3)
       
       i.e. return the count of subsets whose sum = (diff+totalSum)/2
       
     */
    int subSetSumDiffCount(int[] arr,int diff){
        int totalSum = 0;
        for(int elem : arr) totalSum+=elem;
        
        int requiredSum = (diff+totalSum)/2;
        
        return subsetCount.numberOfSubSets(arr,requiredSum,arr.length);
    }
}
