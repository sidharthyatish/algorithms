class CostToClimbStairs { 

    //https://leetcode.com/problems/min-cost-climbing-stairs/

    public int minCostRecursive(int[] cost, int n){
        /*
        Base condition:
            Given in the problem that you can start from step 0 or step 1
            This means cost to go to step 0 or step 1 is zero. So if there is only one step or zero steps, I can directly climb to destination (this will be zeroth (first) step)
        Choices:
            I have two choices, I can end up in step n-1 or step n-2 before I can reach the floor
            in given example [10,15,20]

                            |````` This is the top floor
                        20|``
                      15|``  --> Or I can start here so reaching here will cost zero but leaving here costs 15                
                    10|`` --> I can start here. so reaching here will cost zero, but leaving here costs 10

            Despite starting from first step or second step (cost 0), I can climb 1 or two steps, which means I can end up in n-1th step or n-2th step
            In out example it would be either at step with cost to leave 15 (n-2) or with cost to leave 20 (n-1). I need to find the minimum of these both

            choices
            - I am at (n-1)th step
                - cost[n-1]+minCost(remaining n-1 steps)
            - I am at (n-2)th step
                - cost[n-2] + minCost(remaining n-2 steps)
            Find the minimum of these two
         */
       

        //if n==0 there are no steps to climb so cost is zero
        //if n==1 then I am already at the top so cost is zero.
        if(n<=1) return 0; 

        return Math.min(minCostRecursive(cost,n-1)+cost[n-1], minCostRecursive(cost,n-2)+cost[n-2]);

    }

    public int minCost(int[] cost, int n){

        int[] dp = new int[n+1];

        for(int i=0;i<=n;i++){
            if(i<=1) dp[i]=0; // if there is only ine step, i can directly climb to destination (this is zeroth step)
            else dp[i]=Math.min(cost[i-1]+dp[i-1],cost[i-2]+dp[i-2]);
        }
        return dp[n];


    }
}