package DP.knapsack.a.zeroOneKnapSack.b.subsetSum.d.minSubsetSumDifference;

import DP.knapsack.a.zeroOneKnapSack.b.subsetSum.c.count.SubSetSumCountBottomUp;

class TargetSum {

    SubSetSumCountBottomUp subSetSumCount;
    
    TargetSum(){
        subSetSumCount = new SubSetSumCountBottomUp();
    }

    int targetSumCount(int[] arr, int sum){
        /* Given an array, apply signs +, - such that their sum is equal to given sum
         We need to count the number of such possibilities
         This is the same as subsetsumdiffcount.
        arr [1,1,2,3], sum = 1. This can be achieved in multiple ways [-1 +1 -2 +3], [-1 +1 -2 +3], [+1 +1 +2 -3]
        say for a given result [-1 +1 -2 +3] this can be rewritten as [+1 +3 -1 -2] (bringing +s and -s together)
        [1+3] - [1+2] ==> (s1 - s2)

        thus {[-1 +1 -2 +3] == given sum} ==== {s1-s2 == given sum}
        Thus this question is a rephrase of the problem that find subsets count whose difference is equal to a given number (SubSetSumDiffCount)
        */
       int totalSum = 0;
       for(int eachNum : arr) totalSum+=eachNum;

       int requiredSum = (diff+totalSum)/2;

       // NOTE : if diff+totalSum is odd, then the result is zero. So add a check for that
       return (diff+totalSum)%2!=0? 0 : subSetSumCount.numberOfSubSets(arr,requiredSum,arr.length);
    }


}