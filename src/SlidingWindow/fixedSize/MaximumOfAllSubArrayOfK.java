class MaximumOfAllSubArrayOfK{
    static ArrayList <Integer> failedSolution(int arr[], int n, int k)
    {
        // Your code here
        ArrayList<Integer> solution = new ArrayList<Integer>();
        
        int i=0;
        int j=0;
        int max=Integer.MIN_VALUE;
        
        while(j<n){
            // include operation
            max = Math.max(arr[j],max);
            
            //when window size is not satisfied
            if(j-i+1 < k){
                j++;
            }
            
            //when window size is satisfied
            else if(j-i+1 == k){
                // add to solution
                solution.add(max);
                
                //exclude operation
                if(max==arr[i]){
                    /*
                        This is where this appriach fails. In this case, since the first element of current window is max,
                        removing it means we have to assign the max to the next greatest element among the remaining
                        e.g. [4,3,2],1 => 4 is max but this is only for this window
                        4 [ 3 2 1] => remove 4, then max must be 3 now, which means I need to have the elements
                        to the right of 4 to be accessible. 

                        Thus, instead of a single max variable, I need to have another DS that would store more than one max elements
                    
                    */

                }
                
                
                //slide the window
                j++;
                i++;
            
            }
        }
        
        return solution;
    }

    static ArrayList <Integer> successSolution(int arr[], int n, int k)
    {
        /* 
        Since we have problem finding the next maximum number in the next window as stated in above function, we are using a DS
        that can add and remove elements into an array using both ends - Dequeue
        we maintain a dequeue such that the elements are in descending order. Every element is add to tail of dequeue

        We make sure that when an element is added to the dequeue, all the elements to the left should be bigger

        [---------][j] <- new element
         ^       ^
         |       |
         all these should be bigger. If they are smaller, remove them.

         Why?
         The head of the dequeu contains the maximum number. When a new element is added and to its left there are smaller numbers,
         then the newly added element is the max. So the left becomes useless now.

         Also as the elements become smaller towards right (desc order), this means they are all valid candidates to becomes the next biggest element in the next window 
        
        Note: At anytime, the number of elements in deque would be max K
        */
        // Your code here
        ArrayList<Integer> solution = new ArrayList<Integer>();
        
        int i=0;
        int j=0;
        
        Deque<Integer> maxQueue = new ArrayDeque<Integer>();
        
        while(j<n){
            // include operation

            // Remove all the smaller elements to the left 
            while(maxQueue.size() > 0 && maxQueue.peekLast()<arr[j]){
                maxQueue.removeLast();
            }

            // add the element after 'cleaning' the deQ
            maxQueue.addLast(arr[j]);
            
            //when window size is not satisfied
            if(j-i+1 < k){
                j++;
            }
            
            //when window size is satisfied
            else if(j-i+1 == k){
                // add to solution

                // head of the deQ has the max element for the current window
                solution.add(maxQueue.peekFirst());
                
                //exclude operation

                //If head is the max, and i++ means window will change, this means the current element in head is gonna lose its max position.
                if(maxQueue.peekFirst() == arr[i]){
                    maxQueue.removeFirst();

                }
                
                
                //slide the window
                j++;
                i++;
                
    
            }
        }
        
        return solution;
    }
}