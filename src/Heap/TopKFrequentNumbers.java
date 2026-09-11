package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumbers
{

    //simpler solution for better understanding. In this approach I create a heap of only integers and store the key of the hmap based on the value
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> countMap = new HashMap<>();
        int[] result = new int[k];
        int index=0;

        for(int n : nums){
            countMap.put(n,countMap.getOrDefault(n,0)+1);
        }

        //Add to a heap, sort the map by value and not key
        //so here key only gets sorted but countMap is refered to arrange it inside
        PriorityQueue<Integer> minHeap = 
        new PriorityQueue<>((a,b)->Integer.compare(countMap.get(a),countMap.get(b)));

        //maintain a heap of size k
        for(int num : countMap.keySet()){
            minHeap.add(num);
            if(minHeap.size()>k) minHeap.poll();
        }

        //get the results
        for(int i=0;i<k;i++){
            result[i]=minHeap.poll();
        }

    
        return result;
        
    }

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
