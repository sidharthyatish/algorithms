package sorting;

import java.util.Arrays;

public class HeapSort
{
    void sort(int[] arr){
        int n = arr.length;
        int lastNonLeaf = (n/2)-1;
        
        for(int i = lastNonLeaf; i>=0; i--){
            heapify(arr,n,i);
        }
        
        for(int i=n-1; i>=0 ; i--){
            int temp =arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            
            heapify(arr,i,0);
        }
    }
    
    /*
        Why heapify works?
        1. Heapify makes a heap of given node and heapifies all of its violating children
        2. If we have called heapify for a given node n, we can be assured that n and its children are heap now
        3. If we are calling heap on an array, at a position i, Then i and its children are heaps. But it is possible
           that i's parents may not be satisfying heap property
        4. That's why in heapsort, we heapify all parents / non leaf nodes (from lastNonLeafNode -> (n/2)-1 to root -> 0).
           So if the parents violates the heap property, heapify will fix the parent and all its 'violating'
           children that has resulted because of this 'parent' heapify process
        5. In a heap
            - add : will add the element to last and bubble till it can reach top (if it violates)
            - delete :
                > Deleting means deleting root
                > Swap the root with last element, and heapify the remaining (n-1) elements
                > Thus the last node (which was previously root) can be now removed
                > Remaining elements are now heap and happy :)
         6. Heap sort makes use of deletion to get sorted elements
         
         Why max heap sorts in increasing order?
         - The removed element comes to last of the array
         - Max heap removes largest number
         - Thus largest numbers come to the end
     */
    void heapify(int[] arr,int n,int i){
        int largest = i;
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        
        
        //The largest among the three must be the root. If not, swap and heapify
        if(leftChild<n && arr[leftChild] > arr[largest]){
            largest = leftChild;
        }
        if(rightChild<n && arr[rightChild] > arr[largest]){
            largest = rightChild;
        }
        
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            //The violation occurred at this child. So heapify that position to make its children as heaps
            heapify(arr,n,largest);
        }
    }
    
    public static void main(String[] args)
    {
        int[] arr = new int[]{8,3,4,1,6,7,2};
        HeapSort heapSort = new HeapSort();
        System.out.println(Arrays.toString(arr));
        heapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
