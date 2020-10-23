package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumSumSubArrayOfSizeK
{
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
    
    public static void main(String[] args)
    {
        MaximumSumSubArrayOfSizeK maxK = new MaximumSumSubArrayOfSizeK();
        int[] arr = new int[]{2,3};
        System.out.println(maxK.maxSum(arr,3));
    }
}
