package DP.MCM.c.booleanParenthesis;

public class BooleanParenthesisRecursive
{
    
    //Refer : https://www.youtube.com/playlist?list=PLQ9cQ3JqeqU_GzOU0aPVs4UBprzmFjnSI
    int numberOfTrueSolutions(String str){
        /*
            Given a boolean expression like T&F^T, return the number of ways this can be evaluated to true
            - The number of ways parenthesis can be placed such that the expression evaluates to true
            - Possible chars in string -> T,F,&,|,^
            
            Similar to MCM, we place the bracket/ partition at several places and try
            
            Say the string is "T&F^F|T"
            T & F ^ F | T
            (T) & (F^F|T)
            (T&F) ^ (F|T)
            (T&F^F) | (T)
            Out of these we need to count how many give result as true
            
            Things to note:
            - The partition is at each position of operators (&,^,|). The sub problems are to left and right of it
            - The position of k will be the position of the operator.
                T & F ^ F | T
                i k   k   k j
                So k is from i+1 to j-1, k will be incremented as k+=2
            - At any position of i and j, we will have only operands (T,F)
            (LeftSubProblem) operator (rightSubProblem)
            (i to k-1)          k      (k+1 to j)
            
            After solving sub problems we need to combine the result say
            (T&F) ^ (F|T)
            
            Three cases for three operators:
            1. & operator: (T&T=T)
                - In this case if the left has two Ts and right has 3 Ts
                - Then the total number of trues after combining them is 2 * 3 = 6
            2. ^ operator (T^F=T, F^T=T)
                - In this case, we can get true only if we have true as well as false values
                - So need True as well as false values both in left and right side
                - True can be obtained by combining these true and false values ( left.True*right.False + left.False*right.True)
            3. | operator (T|F=T,T|T=T,F|T=T)
                - Just like ^, we need false results to compute the total number of true values
            
            we use solve function to get number of true results as well as false results
            to get true count we pass isTrue as true
            to get false count we pass isTrue as false
         */
        return solve(str,0,str.length()-1,true);
    }
    int solve(String str, int i,int j, boolean isTrue){
        
        //Base cases
        if(i>j) return 0; //Since there is no string
        
        if(i==j){ //this means there is a single character and can be either 'T' or 'F' only (since i and j can be only on operands)
            //If we are asking for true count, then if the current char is T, we send 1, else 0
            //If we are asking for false count, then if the current char is F, we send 1, else 0
            if(isTrue) return str.charAt(i)=='T'?1:0;
            else return str.charAt(i)=='F'?1:0;
        }
        
        
        int ans = 0;
        //Iterating through operators
        for(int k=i+1;k<=j-1;k+=2){
            int leftTrue   = solve(str,i,k-1,true);  //Left sub problem true count
            int leftFalse  = solve(str,i,k-1,false); //left sub problem false count
            int rightTrue  = solve(str,k+1,j,true);  //Right sub problem true count
            int rightFalse = solve(str,k+1,j,false); //Right sub problem false count
            
            if(str.charAt(k)=='^'){
                if(isTrue){ //If we looking for true solution
                    //count of T^F and F^T combinations
                    ans+= leftTrue*rightFalse + leftFalse*rightTrue;
                }
                else{
                    //count of F^F and T^T combinations
                    ans+= leftFalse*rightFalse + leftTrue*rightTrue;
                }
            }
            else if(str.charAt(k)=='|'){
                if(isTrue){
                    //count of T|T, T|F, F|T
                    ans+= leftTrue*rightTrue + leftTrue*rightFalse + leftFalse*rightTrue;
                }
                else{
                    //count of F|F
                    ans+=leftFalse*rightFalse;
                }
            }
            else if(str.charAt(k)=='&'){
                if(isTrue){
                    //count of T&T
                    ans+= leftTrue*rightTrue;
                }
                else{
                    //count of T&F, F&T, F&F
                    ans+= leftTrue*rightFalse + leftFalse*rightTrue + leftFalse*rightFalse;
                }
            }
            
        }
        return ans;
    }
    
    public static void main(String[] args)
    {
        BooleanParenthesisRecursive bp = new BooleanParenthesisRecursive();
        System.out.println(bp.numberOfTrueSolutions("T|T&F^T"));
        
        //TODO memoization
        //This involves 3D array dp[i][j][isTrue]
    }
}
