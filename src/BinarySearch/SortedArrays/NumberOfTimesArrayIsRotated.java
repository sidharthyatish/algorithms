package BinarySearch;

public class NumberOfTimesArrayIsRotated {

    /*
        Types of array rotation :
        1. Left rotation
            - In this the elements are shifted to left
            - The first element goes to last
            - {1 2 3 4} => {2 3 4 1} (after rotating once) note that [234] is shifted to left of [1]
        2. Right rotation
            - In this the elements are shifted to right
            - The last element goes to first position
            - {1 2 3 4} => {4 1 2 3}  (after rotating once) note that [123] is shifted to right of [4]

        This problem deals with right rotation hence the solution is straightforward

        An array (right rotation)
        {1 2 3 4 5 6 7}
        when rotated once
        {7 1 2 3 4 5 6}
        when rotated again (twice)
        {6 7 1 2 3 4 5}

        Note that the position of the smallest element is a count of how much times the array is rotated

        But if we take the case of left rotation
        {1 2 3 4 5 6 7}
        when rotated once
        {2 3 4 5 6 7 1} (smallest index is 6 (7[size]-1[number of rotations])
        when rotated again (twice)
        {3 4 5 6 7 1 2} (smallest index is 5 (7[size] - 2[number of rotations])

        Here note that the position of the smallest element is as follows
        smallest_index = size - num_rotations
        thus
        num_rotations = size - smallest_index

        However if smallest index is 0, then number of rotations is zero


        for both rotations if smallest index = 0 then rotations is zero


        1 times => [n-1]
        2 times => [n-2]
        x times => [n-x]

        say the smallest index is we got is x
        then return x==0? 0: n-x

        we can avoid this condition if we check prior if the array is already sorted.
        Then just return n-x only

     */
    int findIndexOfSmallestElement(int nums[], int n) {

        /*
            To find the index of smallest element in rotated array

            {1 2 3 4 5 6 7}
            rotated 4 times
            {4 5 6 7 1 2 3}
                     ^
             0 1 2 3 4 => index of smallest element.

             Lets take the mid
             {4 5 6 7 1 2 3}
                    ^
                    This is dividing the array into two subarrays
             Compare both sub arrays with mid
             {4 5 6 7} {7 1 2 3}
             ^sorted   ^unsorted
             The min element lies in the unsorted subarray.
             Thus, discard the sorted subarray and search only inside the unsorted subarray

             In order to be minimum element it must be
             prev >=mid<= next
             search for this condition to get the target index

             However, we need not even check for next
             prev>=mid would be sufficient to find the smallest

         */
        int low = 0;
        int high = nums.length-1;

        // if(nums[low]<=nums[high]) return low; //when array is already sorted .NOTE : this condition must be inside the loop. Without this testcases are failing
        // WHY? Say 4 5 6 7 0 1 2 -> here mid is 7. NOW if I go left or right the array is sorted. I cannot assume that if I discard a sorted array, the rest half is unsorted

        while(low<=high){
            int mid = low + (high - low)/2;


            int prevIndex = (mid-1 +n)%n;
            // if the mid is 0, then if we go back to -1,
            // we pull it forward by n so that it comes to n (circular)

            // Checking for next index is actually not needed. Was able to solve and submit without next Index
            //int nextIndex = (mid+1)%n;


            if(nums[low]<=nums[high]) return low; // array is already sorted

            else if(nums[mid]<=nums[prevIndex]){ //target condition
                return mid;
            }
            else if(nums[low]<=nums[mid]){ //discard the left subarray if its sorted
                low = mid+1;
            }
            else{ //discard the right subarray if its sorted
                high = mid-1;
            }
        }
        return 0;

    }
}
