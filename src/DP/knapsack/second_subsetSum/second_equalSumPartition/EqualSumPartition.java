package DP.knapsack.second_subsetSum.second_equalSumPartition;

import DP.knapsack.second_subsetSum.first_existsOrNot.SubSetSumRecur;
import DP.knapsack.second_subsetSum.first_existsOrNot.SubSetSumTopDown;

public class EqualSumPartition
{
    SubSetSumTopDown subsetSum;
    /*
    Re-uses exists subset sum solution
    
    If a sum can be equally partitioned, it has to be even
            22
            /\
           11 11
    Say if we need to find if there are 2 subsets having equal sum, then the total array sum must be even
    If it is even, and say two such subset exists, then if we find if there is one subset with sum as half of the total sum (sum/2)
    Then it means the other subset will also have sum as (sum/2)
    
    Say the total sum of the array is 22. If there is equal partition available, then each subset sum will be 11
    We can just find if there is one subset with sum as 11. If this is true, then by default, the remaining subset must sum to 11
     */
    boolean existsEqualSumPartition(int[] arr, int sum, int n){
        //Find the sum of elements of array
        int totalSum  = 0;
        for(int elem : arr) totalSum+=elem;
        
        //If the total is odd then partition is not possible
        if(totalSum%2!=0) return false;
        
        //Just find if there is a subset with sum  as totalSum/2;
        
        return subsetSum.isSubSetPresent(arr,totalSum/2,n);
    }
}
