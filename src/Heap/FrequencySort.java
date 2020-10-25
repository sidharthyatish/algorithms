package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FrequencySort
{
    void frequencySort(int[] arr){
        Map<Integer,Integer> hashMap = new HashMap<>();
        
        //Building the frequency hashMap
        for (int i = 0; i <arr.length ; i++)
        {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i],0)+1);
        }
        
        //Sort it based on values of Map.Entry
        //Can be done by heaps/lists
        
        List<Map.Entry<Integer,Integer>> entryList = new LinkedList<>(hashMap.entrySet());
        
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>()
        {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                //Descending order
                return Integer.compare(o2.getValue(),o1.getValue());
            }
        });
        System.out.println(entryList);
        for(Map.Entry<Integer,Integer> entry : entryList){
            for (int i = 0; i <entry.getValue() ; i++)
            {
                System.out.print(entry.getKey()+" ");
            }
        }
    }
    
    public static void main(String[] args)
    {
        FrequencySort f = new FrequencySort();
        int[] arr = new int[]{2,3,2,2,1,2,4,1,4,4};
        f.frequencySort(arr);
    }
}
