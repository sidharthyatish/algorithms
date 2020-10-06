package DP.knapsack.second_unboundedKnapSack.second_rodCutting;

public class RecursiveRodCutting
{
    /*
        Using two arrays
     */
    int maxProfit(int[] price, int[] lengths, int maxLength, int nItems){
        if(nItems==0||maxLength==0) return 0;
        
        if(lengths[nItems-1]<=maxLength){
            return Math.max(price[nItems-1]+maxProfit(price,lengths,maxLength-lengths[nItems-1],nItems),
                    maxProfit(price,lengths,maxLength,nItems-1));
        }
        else{
            return maxProfit(price,lengths,maxLength,nItems-1);
        }
    }
    
    /*
        Using single array
     */
    int maxProfit(int[] price, int maxLength, int currentLength){
        if(maxLength==0||currentLength==0) return 0;
        
        if(currentLength<=maxLength){
            return Math.max(
                    price[currentLength-1]+maxProfit(price,maxLength-currentLength,currentLength),
                    maxProfit(price,maxLength,currentLength-1)
            );
        }
        else{
            return maxProfit(price,maxLength,currentLength-1);
        }
    }
    
    public static void main(String[] args)
    {
        RecursiveRodCutting rc = new RecursiveRodCutting();
        int[] lengths = new int[]{1,2,3,4,5,6,7,8};
        int[] prices = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(rc.maxProfit(prices,lengths,lengths.length,prices.length));
        System.out.println(rc.maxProfit(prices,prices.length,prices.length));
    }
}
