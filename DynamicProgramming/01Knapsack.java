/*
**************** Problem Description ****************
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively.
Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
    Example : 1

    Input:
    N = 3
    W = 4
    values[] = {1,2,3}
    weight[] = {4,5,1}
    Output: 3
*/


class Solution
{
    public static int[][] dp;
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {

        dp =  new int[W+1][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return helper(W,wt,val,n);


    }


    static int helper(int W, int wt[], int val[], int n)
    {
        if(n==0 || W==0 ) return 0;

        if(dp[W][n]!=-1) return dp[W][n];

        if(W>=wt[n-1])
        {
            dp[W][n]= Math.max(helper(W-wt[n-1],wt,val,n-1)+val[n-1], helper(W,wt,val,n-1));
            return dp[W][n];
        }
        else
        {
            dp[W][n]=helper(W,wt,val,n-1);
            return dp[W][n];
        }
    }

}

///Top down approach


class Solution
{
    public static int[][] dp;
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
        dp =  new int[n+1][W+1];

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=W;j++)
            {
                if(wt[i-1]<=j)
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        return dp[n][W];
    }


}




/*
**************** Logic ****************
The solution depends upon the weight of the Knapsack and the items included.
So our DP solution contains 2 states: W(weight) and N(items).
*/