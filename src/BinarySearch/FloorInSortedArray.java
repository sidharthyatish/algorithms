package BinarySearch;

public class FloorInSortedArray {
    
    /*
    *  Given a number 7.8 the floor is the lower and ceil is the upper bound
    * just like floor and ceiling
    * ----- 8--- Ceiling
    * |    7.8
    * ----- 7---- Floor
    * 
    * So in an array
    * {1 2 3 4 6 7 8}
    * The floor of a number say 5, is the number that is smaller than 5 but largest among all the smaller ones
    * 
    * in the above case, the possible candidates are {1 2 3 4}, out of this 4 is the largest. This is the floor
    * 
    * I can rephrase this as, the floor is the left number where the given number can squeeze into
    * 
    * {1 2 3 4 6 7 8}
    *         ^ -> 5 can squeeze here so the left of it is the floor
    * 
    * */
    static int findFloor(long arr[], int n, long x)
    {
        /*
        If I find the number in mid, then the same number is the floor as well.
        If the mid is smaller than x, then this is a possible candidate for floor. But we are not sure,
        the possible floor can lie in the right subarray only. Why?
        {1 2 3 4 6 7 8}
           ^ say if I am here
            then 2 can be a potential candidate for floor but we have to find the largest among the smallest,
            so we discard left subarray and traverse only right
            
         */
        int low = 0;
        int high = n-1;
        int res = -1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==x) return mid;

            else if(arr[mid]<x){
                res = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return res;
    }

}
