package Heap;

import java.util.PriorityQueue;

public class ConnectRopeToMinimiseCost
{
    //https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
    /*
        Connect n pieces of ropes such that the the total cost is minimum
        A cost of connecting two pieces is equal to sum of their lengths
        
        Minimum cost can be obtained by connecting two smallest pieces at any time
        
        Min heap will store the smallest pieces at top
        So we take two polls and add them to cost and add back to heap
     */
    int minCost(int[] arr){
        int cost=0;
    
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++) minHeap.add(arr[i]);
        
        while (minHeap.size() >= 2){
            int currCost=0;
            int first = minHeap.poll();
            int second = minHeap.poll();
            currCost = first + second;
            cost += currCost;
            minHeap.add(currCost);
        }
        
        return cost;
    }
    
    public static void main(String[] args)
    {
        ConnectRopeToMinimiseCost rope = new ConnectRopeToMinimiseCost();
        int[] arr = new int[]{4,3,2,6};
        System.out.println(rope.minCost(arr));
        
        //TODO : https://www.geeksforgeeks.org/sum-elements-k1th-k2th-smallest-elements/
        //we can find k1th and k2th and add numbers between them
        //Or k2th and k1th from a single heap and add numbers between them from heap itself
    }
}
