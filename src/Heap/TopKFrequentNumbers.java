package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumbers
{
    void printTopKFrequentNumbers(int[] arr, int k){
        
        Map<Integer,Integer> hashMap = new HashMap<>();
        
        //Create a hashmap of numbers and their count
        for (int i = 0; i <arr.length ; i++)
        {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i],0)+1);
        }
        System.out.println(hashMap);
    
        //We are sorting the heap based on the map entry's value. Which is the count
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>()
        {
            @Override
            public int compare(Map.Entry<Integer, Integer> n1, Map.Entry<Integer, Integer> n2)
            {
                //Better than using  n1.getValue() - n2.getValue() as it can result in overflows in numbers are negative
                return Integer.compare(n1.getValue(),n2.getValue());
            }
        });
        
        for(Map.Entry<Integer,Integer> mapEntry : hashMap.entrySet()){
            minHeap.add(mapEntry);
            if(minHeap.size() > k) minHeap.poll();
        }
        
        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll().getKey());
        }
    }
    
    public static void main(String[] args)
    {
        TopKFrequentNumbers k = new TopKFrequentNumbers();
        int[] arr = new int[]{1,1,1,3,2,2,4};
        k.printTopKFrequentNumbers(arr,2);
    }
}
