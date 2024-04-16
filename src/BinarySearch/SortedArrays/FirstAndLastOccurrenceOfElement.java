class FirstAndLastOccurrenceOfElement{

    /* 
    
        Array contains duplicates and we need to find the first and last index

        - Run binary search twice, once for first index, next for last index
        - If you are running for finding first index, then right subarray is to be discarded
        - If you are running for finging last index, then left subarray needds to be discarded
        - Update the res and the mid in each call respectively


        * Variations:
        - Count of element (frequency) in sorted array
            -> get the first occurrence index -- (1)
            -> get the last occurrence index  -- (2)
            -> (lastIndex - firstIndex) + 1  // zero based index so size will be one point greater


    */
    public long binarySearch(long arr[], long elem, boolean isFirstOccurrence){
        int start = 0;
        int end = arr.length-1;
        int res = -1;
        
        while(start<=end){
            int mid = start + (end - start)/2;
            if(elem == arr[mid]){
                res = mid;
                if(isFirstOccurrence){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else if(elem<arr[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return res;
    }
    
    public pair indexes(long v[], long x)
    {
        // Your code goes here
        pair result = new pair(-1,-1);
        
        result.first=binarySearch(v,x,true);
        result.second=binarySearch(v,x,false);
        
        return result;
    }
}

