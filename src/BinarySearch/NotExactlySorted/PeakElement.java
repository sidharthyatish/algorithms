class PeakElement{
    //https://leetcode.com/problems/find-peak-element/

    /* 
        In this problem, the array can:
        1. Rise and fall
        2. Just keep on rising
        3. Just keep on falling
        4. It may fall and rise, but in that case we are interested in either of the peak element which will 


        To rise and fall the element should be between 0>element<n-1 
        0[------]n-1 only then it has space to rise and fall

        How do we discard array

        say the array

        0 1 2 3 4 2 1 0
              | 
              -> say this is mid
              now mid-1 is smaller and mid+1 is larger, which means the array is rising on right side
              this means that peak element could be only on the rising side. Thus discard the non rising side
        
        if we say arrive in mid at 0, which means high and low was very close to 0.
            - This means the array is  peaked in 0 or 1 positions 
        if we arrive mid at n-1, this means high and low are very close to n-1
            - This means the array is peaked in n-1 or n-2 positions


    */

    public int findPeakElement(int[] arr) {
        int low = 0;
        int n = arr.length;
       int high = n-1;
       if(n==1) return 0;
       if(n==2) return arr[0]>arr[1]? 0:1;
       while(low<=high){
           int mid = low +(high-low)/2;
           //Scenario 1.
           if(mid>0 && mid<n-1){
               if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                   return mid;
               }
               if(arr[mid-1]>arr[mid]) high = mid-1;
               else low = mid+1;
           }
           // Scenario 3.
           if(mid==0){
               return (arr[0]>arr[1])? 0 : 1;
           }
           //Scenario 2.
           if(mid==n-1){
               return arr[n-1]>arr[n-2]? n-1: n-2;
           }
       }
       
       return low;
    }
}