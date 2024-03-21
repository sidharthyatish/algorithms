class SearchInNearlySorted{
    public static int findIndex(int[] nums, int target)
        {

            /*
            
                Nearly sorted means, an element that is supposed to be present in position i can be in i-1 or i+1 position

                Thus we modify the binarys search such that we search for mid mid-1 mid+1 at the same time for a target

                make sure they are inside the working range

                [low <= mid-1 < mid < mid+1 <= high]

                Also as we have searched mid, -1 and +1 the left and right sub array is as follows
                
                [{low   mid-2}{mid-1,mid,mid+1}{mid+2     high}]
                 ^ left subarray                ^ right subarray

                 Note : going mid-2 or mid+2 will not go out of bounds. Why?
                 at any time we are checking mid-1 and +1 at the same time. So say we will never reach an index 0

                 say [0 1 2]
                 when mid is 1, we would search for the elements 0(mid-1) and 2(mid+1) in this iteration itself, 
                 thus this will not become further smaller subarrays
            */
            // Write your code here...
            int low = 0;
            int high = nums.length-1;
            
            while(low<=high){
                int mid = low + (high-low)/2;
                
                if(nums[mid]==target) return mid;
                
                if(mid-1>=low && nums[mid-1]==target) return mid-1;
                
                if(mid+1<=high && nums[mid+1] == target) return mid+1;
                
                else if(target<nums[mid]) high = mid-2;
                else low = mid+2;
            }
            return -1;
        }
}