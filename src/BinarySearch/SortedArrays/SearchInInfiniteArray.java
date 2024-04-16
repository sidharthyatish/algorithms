class SearchInInfiniteArray{

    public int search(){
        /*

            This cannot be coded in leetcode as there is no way of depicting an infinite array. If there is, it can be an F2F question

            since we dont know the length of the array, we keep on increasing the end in multiples of two.

            [0.................INFINITY]
            start with low = 0, high =1
            
            Loop till elem > arr[high] which means we want to find an end such that it crosses the element to be searched.
            until then
            low = high
            high = high *2

            finally binary search with the latest low and high



        ****** VARIATION *****
        find the first position of 1 in infinite binary sorted array

        [ 00000000000111111...... INFINITE]

        same approach as above to find the high...

        but here
        loop til elem == 1
        low = high
        high = high *2


        now we have a high which is 1. But we dont know if its the first occurrence.

        This so a modified binary search to find the first occurrence (res = high,high = mid-1) to go to left sub array
        
        */
       return 0;
    }
}