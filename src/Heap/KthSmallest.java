package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest
{
    int kthSmallest(int[] arr, int k){
    
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i=0;i<arr.length;i++){
            maxHeap.add(arr[i]);
            if(maxHeap.size() > k) maxHeap.poll();
        }
        return maxHeap.isEmpty()? -1 : maxHeap.peek();
    }
    
    public static void main(String[] args)
    {
        KthSmallest k = new KthSmallest();
        int[] arr = new int[]{7,8,1,2,10,15};
        System.out.println(k.kthSmallest(arr,3));
    }
}
