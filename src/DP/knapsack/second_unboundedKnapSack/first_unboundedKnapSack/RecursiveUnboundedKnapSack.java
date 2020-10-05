package DP.knapsack.second_unboundedKnapSack.first_unboundedKnapSack;

public class RecursiveUnboundedKnapSack
{
    /*
        In 0/1 KnapSack we have a choice and the item at choice can be taken only once
        In Unbounded, a single item can be considered multiple times
     */
    
    int maxProfit(int weights[], int values[], int capacity, int nItems){
        //base condition, least possible inputs
        if(capacity==0||nItems==0) return 0;
        
        /*
            1. I have a choice:
                1.1. I can consider it once and continue with the same item again
                1.2. I can ignore and continue with remaining items
            2. I don't have a choice:
                - I ignore and continue for remaining items
         */
        //1.
        if(weights[nItems-1]<=capacity){
            //max of 1.1 or 1.2
            //Note 1.1 recursive call is made to same item and not for remaining items (nItems and not nItems-1)
            return Math.max(
                    values[nItems-1]+maxProfit(weights,values,capacity-weights[nItems-1],nItems), //recursive call to same item
                    maxProfit(weights,values,capacity,nItems-1)
            );
        }
        //2.
        else{
            return maxProfit(weights,values,capacity,nItems-1);
        }
    }
}
