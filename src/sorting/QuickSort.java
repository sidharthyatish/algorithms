package sorting;

import java.util.Arrays;

public class QuickSort
{
    void quickSort(int arr[],int low,int high){
        if(low<high){
            int p = partition(low,high,arr);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }
    }
    int partition(int low, int high, int[] arr){
        int pivot = arr[high];
        // i will keep track of the smallest numbers than pivot. We will update arr[i] by iterating through j..high-1 and swapping if it is lower than pivot
        int i = low;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
            }
        }
        
        //swap the current i which is (lessThanPivot)(<i will be here>greaterThanPivot)[pivot]
        //The current position for the pivot element is the position of i
        // (lessThanPivot)[pivot](greaterThanPivot)
        //-------------------^--------------------- This is i position. After swapping it with arr[high], pivot element comes here
        int temp = arr[i];
        arr[i]=arr[high];
        arr[high]=temp;
        
        return i; // I is the current position for the pivot element
    }
    
    public static void main(String[] args)
    {
        QuickSort qs = new QuickSort();
        int[] arr = new int[]{5,8,4,1,6};
        qs.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
