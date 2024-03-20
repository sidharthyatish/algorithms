package BinarySearch;

public class BinarySearch {
    public static int binarySearch(int[] arr, int elem){
        int low = 0;
        int high = arr.length -1;

        while(low<=high){ // always check with = during comparison to handle duplicates
            int mid = low + (high - low)/2; // lowest index plus half of their total length
            if(elem == arr[mid]) return mid;
            else if(elem <= arr[mid]) high = mid-1; // [(l    m-1) m (m+1    h)]
            else low = mid+1;
        }
        return -1;
    }

    /*
    VARIATIONS:

    * Reverse sorted 
        - in this case, the else if and else condition is swapped. 
    * Order unknown search
        - Here the array can be sorted in asc or desc order
        - Find out if its asc or desc by comparing arr[low] and arr[high]
        - arr[low] < arr[high]? asc : desc
        - Based on this flag change the condition of high and low
    */

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(arr,4));
    }
}
