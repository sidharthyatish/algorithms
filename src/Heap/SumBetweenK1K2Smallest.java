package Heap;

import java.util.PriorityQueue;

public class SumBetweenK1K2Smallest
{
    int sumBetweenK1andK2(int[] arr, int k1, int k2){
        //Build a max Heap of k2 size
        int sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2,o1));
        
        for(int i =0;i<arr.length;i++){
            maxHeap.add(arr[i]);
            if(maxHeap.size() > k2) maxHeap.poll();
        }
        
        //Now we have only k2 elements in heap k2 [elements] k1 .. 1
        // We need to ignore the k2 smallest and k1 smallest but sum all the elements in between
        if(!maxHeap.isEmpty()) maxHeap.poll(); //Remove the k2th smallest element
        int numOfElements  = k2-k1-1;
        while (numOfElements > 0 && !maxHeap.isEmpty()){
            sum += maxHeap.poll();
            numOfElements--;
        }
        return numOfElements>0? -1 : sum;
        //Complexity O(k2logn) -> for building the max heap + O((k2-k1) logn) -> For extraction and sum
        //Overall it is O(k2logn)
    }
    
    public static void main(String[] args)
    {
        SumBetweenK1K2Smallest k1k2 = new SumBetweenK1K2Smallest();
        int[] arr = new int[]{10, 2, 50, 12, 48, 13};
        System.out.println(k1k2.sumBetweenK1andK2(arr,2,6));
    }
}
