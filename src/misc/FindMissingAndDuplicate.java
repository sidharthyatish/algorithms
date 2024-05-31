class FindMissingAndDuplicate {
    
    int[] findTwoElement(int arr[], int n) {
        // code here
        int missing = 0;
        int duplicate =0;

        // For every element, we take the (abs) element==> :Note: as a position and mark it as negative. 
        // If a number is negative, it means that there was some another element in the array whose value is the same as current position
        // When we try to mark a number and its already marked, then, there was already an element, with value as current position, capable of marking it. So the current element (or the current marking position) is the dupe
        // After markings are done, one element will be unmarked. That position is the missing number
        
        for(int i=0;i<arr.length;i++){
            int pos = Math.abs(arr[i])-1;
            if(arr[pos]<0){
                duplicate = pos+1;
            }
            else arr[pos] = -arr[pos];
            
        }
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                missing = i+1;
            }
        }
        
        return new int[]{duplicate,missing};
    }
}