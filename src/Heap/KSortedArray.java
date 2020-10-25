package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSortedArray
{
    /*
        Also known as sort a nearly sorted array
        This means that at any index i, the element that is supposed to be at i will be
        either in k position to left or k positions to right
        if k = 3
        [---i---]
        element will be either in 3 indexes before or 3 indexes after i
        if i was 7 then the element will be [4 5 6] 7 [ 8 9 10]
     */
    
    void sortKSortedArray(int[] arr, int k){
        int index = 0;
    
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            minHeap.add(arr[i]);
            if(minHeap.size() > k){
                arr[index++] = minHeap.poll();
                
            }
        }
        while (!minHeap.isEmpty()) arr[index++] = minHeap.poll();
    }
    
    public static void main(String[] args)
    {
        KSortedArray k = new KSortedArray();
        int[] arr = new int[]{2, 6, 3, 12, 56, 8};
        System.out.println(Arrays.toString(arr));
        k.sortKSortedArray(arr,3);
        System.out.println(Arrays.toString(arr));
    }
}
