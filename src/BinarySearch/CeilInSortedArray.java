class CeilInSortedArrat{
    /*
    this is the same problem
    https://leetcode.com/problems/search-insert-position/description/
     
     This is just opposite of floor in sorted array
     */

    public int searchInsert(int[] nums, int target) {
        // same as ceil in a sorted array

        int low = 0;
        int high = nums.length-1;
        int res = nums.length;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target){
                res = mid;
                high = mid-1;
            }
            else low = mid+1;
        }

        return res;
        
    }
}