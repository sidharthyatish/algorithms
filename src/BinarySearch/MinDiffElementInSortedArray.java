class MinDiffElementInSortedArray{

    /**
     * Given a sorted array and an element, find an element such that the absolute difference with the given element in minimum
     * 
     * { 1 3 8 11 17 } and given element is 10, then the min diff element is 11 (11 - 10 ==1 is the minimum difference)
     * 
     * When we observe this, the element with min difference can be either floor or ceil. So mind(abs(ceil-elem),abs(floor-elem))
     * will give us the result. This is one approach.
     * 
     * We have another approach. 
     * 
     * When we run a normal binary search as
     * 
     * while(low<=high)
     * 
     * when the element is not present in the array,
     * then when the loop is over, then it becomes high > low 
     * 
     * { 1 3 8 11 17} i seach for 10, then at the end of the loop
     * 
     * { 1 3 8 11 17}
     *       ^  ^
     *    high  low
     * 
     * This would be the case always, i.e., high would be at floor and low would be at ceil of the searched element. 
     */
    public int findMinDiffElement(int[] arr, int elem){

        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==elem) return arr[mid];
            else if(elem<arr[mid]) high = mid-1;
            else low = mid+1;
        }

        // Now high = floor and low = ceil, thus they are the neighbours of the element to be searched and are the closest to the searched elem

        int differenceWithFloor = Math.abs(arr[high]-elem);
        int differenceWithCeil = Math.abs(arr[low]-elem);
        return differenceWithFloor < differenceWithCeil ? arr[high] : arr[low];
    }
}