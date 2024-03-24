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


        
        */
       return 0;
    }
}