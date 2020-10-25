package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class KClosestNumbers
{
    class Pair{
        int diff;
        int num;
        Pair(int d, int n){
            diff=d;
            num =n;
        }
    }
    void printKClosestNumbers(int[] arr, int k, int x){
        /*
            Find k closest numbers to n
            
            say k =3, n =7
            
                            2, 6, 8, 7, 5, 1
         Abs diff with 7 -> 5, 1, 1, 0, 2, 6
         So closest are those with least diff
         here it is 6,7,8
         
         So we need to build heap based on the diff numbers
         */
    
        //We are creating a comparator to compare the difference instead of number itself
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>()
        {
            @Override
            public int compare(Pair p1, Pair p2)
            {
                //Decreasing order
                return Integer.compare(p2.diff,p1.diff);
            }
        });
        
        for(int i=0;i<arr.length;i++){
            int diff = Math.abs(x - arr[i]);
            maxHeap.add(new Pair(diff,arr[i]));
            if(maxHeap.size() > k) maxHeap.poll();
        }
        
        while (!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll().num);
        }
    }
    
    public static void main(String[] args)
    {
        KClosestNumbers k = new KClosestNumbers();
        int[] arr = new int[]{ 2,6,8,7,5,1};
        k.printKClosestNumbers(arr,3,7);
    }
}
