class ClimbingStairs{
    public int climbStairs(int n, boolean isRecursion) {
        //https://leetcode.com/problems/climbing-stairs/description/

        
        /* 
        Base condition
        
        if there is one step, 1 way
        if there are two steps then 2 ways ()
        
        what if there is 0 ways.. though its not in question, it is 1 way
        https://www.youtube.com/watch?v=5o-kdjv7FD0
        this is explained here. To goto step zero to step zero there is only one path [0]. This is of size 1 (confusing..)

        So I either consider if(n<=1) return 1 or the below..
        */
        
        if(n<=2) return n;

        return climbStairs(n-1) + climbStairs(n-2);
        
    }

    public int climbStairs(int n) {
       int[] dp = new int[n+1];

       for(int i=1;i<=n;i++){
        // if I use i<=1 then use dp[i]=1
        if(i==1 || i==2){
            dp[i]=i;
        }
        else{
            dp[i]=dp[i-1]+dp[i-2];
        }
       }

       return dp[n];
        
    }
}