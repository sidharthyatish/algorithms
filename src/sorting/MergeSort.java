package sorting;

import java.util.Arrays;

public class MergeSort
{
    public int[] mergeSort(int[] arr){
        if(arr.length<=1) return arr;
        
        int mid = (arr.length/2);
        
        int[] leftArray = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] rightArray = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        
        return merge(leftArray,rightArray);
    }
    
    public int[] merge(int[] leftArray, int[] rightArray){
        int[] result = new int[leftArray.length+rightArray.length];
        int resultIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        
        while (leftIndex<leftArray.length&&rightIndex<rightArray.length){
            if(leftArray[leftIndex]<rightArray[rightIndex]){
                result[resultIndex++]=leftArray[leftIndex++];
            }
            else{
                result[resultIndex++]=rightArray[rightIndex++];
            }
        }
        while (leftIndex< leftArray.length) result[resultIndex++]=leftArray[leftIndex++];
        while (rightIndex< rightArray.length) result[resultIndex++]=rightArray[rightIndex++];
        
        return result;
    }
    
    public static void main(String[] args)
    {
        MergeSort ms = new MergeSort();
        int[] arr = new int[]{3,4,5,1,2};
        
        System.out.println(Arrays.toString(ms.mergeSort(arr)));
    }
}
