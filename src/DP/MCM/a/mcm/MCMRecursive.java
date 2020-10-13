package DP.MCM.a.mcm;

public class MCMRecursive
{
    /*
        Given two matrices of index [a x b] and [c x d]
        - They can be multiplied only if b==c
        - The number of multiplications  = a * b * d (b==c so considering any one)
        - The resultant matrix will have the dimension [a x d]
        
        Matrix Chain Multiplication
        ---------------------------
        Given a set of matrices, we need to arrive at the resultant matrix with minimum number of multiplications
        
        Say matrices A1,A2,A3,A4 Can be multiplied as
        (A1A2)(A3A4), A1((A2A3)A4), (A1(A2A3))A4 ..
        Out of these we need to find the minimum multiplications required
        Note : the sequence in which the matrices are arranged does not change. i.e. we don't multiply A1 with A3 or A4 directly
        ABC != ACB since in matrix multiplication AB != BA (Here BC!=CB)
        
        
        Things to do to solve:
        1. find base condition
        2. Find the range of k
        3. For each k, find the temp ans and find min out of all
        
     */
    int minNumberOfMultiplications(int[] arr){
        /*
            The question contains an array of dimensions
            arr = [10,20,30,40,50]
            Here A1 = [10 x 20]
                 A2 = [20 x 30]
                 A3 = [30 x 40]
                 A4 = [40 x 50]
            For Given Ai the dimension is arr[i-1] x arr[i]
            
            We partition the array into (i..k) (k+1..j-1) //Why j-1? if k ==j, then k+1 is out of bounds
            Say ABCD are the matrices (not the array, just the matrices)
            A B  C   D
            i k k+1  j
            (i..k) => (AB) --> Eq. (1)
            (k+1..j) => (CD) --> Eq. (2) // Note here we are considering the matrix itself and not the arr hence j instead of j-1
            (1) has the no. of multiplications for AB
            (2) has no of multiplications for CD
            We need to multiply (1) and (2) --> Eq. (3)
            So for a given iteration of k, (1) + (2) + (3) is the number of multiplications
            we need to find the minimum of (1)+(2)+(3) for all values of k
            
            arr = [10 20 30 40 50]
                       i        j
                       [-------]  <- k (i..j-1) => partitions (i..k) (k+1..j-1)
                        [-------] <- k (i+1..j) => partitions (i..k-1) (k..j)
                       We can consider any of the above k conditions
                       
           How to find eq(3) above??
           (A1A2)(A3A4)
               k  k+1
               
            say we have arr = [10, 20, 30, 40]
                                    i  k   j
            A = [10,20] B = [20,30] C = [30,40]
            No of mul => AB = 10 * 20 * 30
            Dimensions =>  AB [10 x 30]   C = [30 x 40]
            No of mul AB*C = 10 * 30 * 40
                            i-1   k     j
            This the cost of multiplication for a given iteration
            arr[i-1]*arr[k]*arr[j]
         */
        return solve(arr,1,arr.length-1);
    }
    
    int solve(int arr[], int i, int j){
        if(i>=j) return 0; //1. Base condition
        
        int minValue = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){ //2. Find range of k
            int tempAns = solve(arr,i,k)+solve(arr,k+1,j) + arr[i-1]*arr[k]*arr[j]; //get temp ans
            //                        (AB)           (CD)                   (ABCD)
            minValue = Math.min(minValue,tempAns); //3. Get the minimum of each temp ans of k
        }
        return minValue;
    }
    
    public static void main(String[] args)
    {
        MCMRecursive mcm = new MCMRecursive();
        int[] arr = new int[]{40,20,30,10,30};
        System.out.println(mcm.minNumberOfMultiplications(arr));
    }
}
