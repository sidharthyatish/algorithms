

//User function Template for Java

class Solution {

    //https://www.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1
    
    public void solve(int zeros, int ones, int n, String output,ArrayList<String> answer){
        if(n==0){
            answer.add(output);
            return;
        }
        

        solve(zeros,ones+1,n-1,output+"1",answer);

        if(zeros!=ones)
            solve(zeros+1,ones,n-1,output+"0",answer);
            

    }
    ArrayList<String> NBitBinary(int N) {
        ArrayList<String> answer = new ArrayList<String>();
        
        int numZeros = 0;
        int numOnes = 0;
        String output = "";
        solve(numZeros,numOnes,N,output,answer);
        //No need to sort, just make sure the recursive call of "1" is before "0"
        return answer;
        // code here
    }
}