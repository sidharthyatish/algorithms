package BinarySearch;

public class FindElementInRotatedArray {

    public int getSmallestElementIndex(int[] arr){
        int low = 0;
        int n = arr.length;
        int high = n-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            int prevIndex = (mid-1 + n) %n;
            if(arr[low]<=arr[high]) return low;
            else if(arr[mid]<=arr[prevIndex]) return mid;
            else if(arr[low]<=arr[mid]) low = mid+1;
            else high = mid-1;
        }
        return 0;
    }

    public int binarySearch(int[] arr, int target, int low, int high){

        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]==target) return mid;
            else if(target<arr[mid]) high = mid-1;
            else low = mid+1;
        }
        return -1;


    }

    public int searchInRotatedArray(int[] arr, int target) {

        /*
        * TO search in rotated array, you have to find the index of the smallest element in the array
        * Once we find it out the array will be something like this
        * [0 ....largest_num,smallest_num..... n-1]
        *
        * So you when u find the smallest number in a rotated array
        * {6 7 8 9 1 2 3 4 5}
        *          ^
        * {(sorted) (sorted)}
        *
        * So the subarrays to left and right of smallest element are sorted
        *
        *
        * the process is
        *
        * find the smallest number. If its the target, return it
        *
        * binary search the left and right subarrays. If the element is present in either of subarrays, return it
        * */
        int n = arr.length;

        int minIndex = getSmallestElementIndex(arr);
        int maxIndex = (minIndex-1 );

        if(arr[minIndex] == target) return minIndex;

        // {6 7 8 9 1 2 3 4 5}
        //        ^ ^
        //  0     | |       n-1
        // maxIndex minIndex

        int resultLeft = binarySearch(arr,target,0,maxIndex);
        int resultRight = binarySearch(arr,target,minIndex,n-1);
        return resultLeft>=0? resultLeft : resultRight;

        /*
        Surprisingly all edge cases are also handled, such as single element, two elements, already sorted array, etc

        since we are searching anyways to left and right of smallest number,
        we will find out the element inside either subarrays eventually
         */

    }
}
