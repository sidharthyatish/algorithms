package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumSumSubArrayOfSizeK
{

    //This was my approach after glancing at the video, the next method is aditya's solution. Better stick to that
    int maxSum(int arr[], int k){
        /*
            Instead of creating all subarrays,
            Create one window
            [------------]
            |--k--|
            i     j
            Get the sum, then decrease the front and increase the end
            [------------]
              |--k--|
              i++   j++
            This can be done by sum-=arr[i], sum+=arr[j]
         */
        
        int sum=0;
        int max=0;
        
        if(k>arr.length) return -1;
        //First window is created and sum is calculated
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        max=sum;
        //i..j is sliding window
        int i=0;
        int j=k-1;
        
        while(j<arr.length-1){
            //Remove the first element from window
            sum-=arr[i];
            i++;
            
            //Add the next element to window
            j++;
            sum+=arr[j];
            max=Math.max(sum,max);
        }
        
        return max;
        
    }


    static long maximumSumSubarray(int k, ArrayList<Integer> Arr,int N){
        /* 
        A window size of two index is denoted by the expression

        j-i+1

        [ 0 1 2 3 4 5 6 7]

        Length of index 3 to 6 is 4 => 6-3+1
        Length of index 2 to 7 is 6 => 7-2+1

        So if j-1+1==k then its a subarary of size k. Do the operation needed here. 
        only when this condition is met, the sum is useful for us. Choose it, find if its max.
        after that, i and j is incremented to go to next window. Just before that, 
        subtract arr[i] from sum. 
        sum-=arr[i] -> (1)
        sum+=arr[j] -> (2)       
        
        */
        int i=0;
        int j=0;
        long maxSum = Long.MIN_VALUE;
        long sum = 0;
        while(j<N){
            // Eq -> (2) 
            // I calculate the sum irrespective of the window size as I need the sum in either case. But do I consider it as max or not depends on the window size
            sum+=Arr.get(j);

            // We need not make the window sum before the loop. If its not of the window size, just make the window bigger
            if(j-i+1<k){
                j++;
            }

            // if its of the appropriate window size, then just do whatever useful stuff u need
            else if(j-i+1 == k){
                maxSum = Math.max(sum,maxSum);
                // Eq -> (1)
                sum-=Arr.get(i);
                i++;
                j++;
            }
        }
        
        return maxSum;
    }

    
    
    public static void main(String[] args)
    {
        MaximumSumSubArrayOfSizeK maxK = new MaximumSumSubArrayOfSizeK();
        int[] arr = new int[]{2,3};
        System.out.println(maxK.maxSum(arr,3));
    }
}
