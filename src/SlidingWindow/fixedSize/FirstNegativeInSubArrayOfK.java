class FirstNegativeInSubArrayOfK{
    
    
    public long[] printFirstNegativeInteger(long A[], int N, int k)
    {
        
        int i=0;
        int j=0;

        //operation
        List<Long> negativeNumbers = new ArrayList<Long>();
        
        // The result will be of this size, for all the windows, the number of results in N-K+1
        long[] results = new long[N-k+1];
        int resultIndex = 0;
        
        while(j<N){
            // operation for j
            if(A[j] < 0){
                // we store all the negative numbers for the window
                // The first number in this list is the first negative number of the window
                negativeNumbers.add(A[j]);
            }
            // window size not me
            if(j-i+1 < k){
                j++;
            }
            //window size met
            else if(j-i+1 == k){
                // calculations using operations done so far
                
                if(negativeNumbers.size()>0){
                    // The first number of the list is the first negative number of the window. Hence it comes in result
                    results[resultIndex++]=negativeNumbers.get(0);
                    // since we are gonna do i++, remove it from the list/operations as well. 
                    if(A[i]==negativeNumbers.get(0)){
                        negativeNumbers.remove(0);
                    }
                    
                }
                else{
                    // No negative numbers for the window? store zero (given in problem statement)
                    results[resultIndex++] = 0;
                }

                // slide the window
                i++;
                j++;
                
            }
        }
        return results;
        
    }
}