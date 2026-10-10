class MaximumOfAllSubArrayOfK {

    //NOTE THIS WONT WORK WITH NEGATIVE NUMBERS.
    //This uses the new (simplified) template on readme.
    int maxSubArrayOfSumK(int[] arr, int k){
        int i=0;
        int j=0;
        int n =arr.length;
        int currSum=0;
        int maxSubArraySize=0;

        while(j<n){
            //operation with j
            currSum+=arr[j];


            //condition met
            if(currSum == k){
                maxSubArraySize = Math.max(currSum, maxSubArraySize);
            }
            //condition not met
            else {
                while(currSum > k){
                    currSum-=arr[i];
                    i++;
                }
            }
            //slide window;
            j++;
            
        }

        return maxSubArraySize;
    }
}