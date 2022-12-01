/*
**************** Problem Description ****************
Given an array cost[] of positive integers of size N and an integer W, cost[i] represents the cost of ‘i’ kg packet of oranges.
The task is to find the minimum cost to buy W kgs of oranges. If it is not possible to buy exactly W kg oranges then the output will be -1
Note:
1. cost[i] = -1 means that ‘i’ kg packet of orange is unavailable
2. It may be assumed that there is infinite supply of all available packet types.
    Example : 1

    Input:
    N = 5, arr[] = {20, 10, 4, 50, 100}
    W = 5
    Output: 14
    Explanation:
    Choose two oranges to minimize cost. First orange of 2Kg and cost 10. Second orange of 3Kg and cost 4.
    Example : 2

    Input:
    N = 5, arr[] = {-1, -1, 4, 3, -1}
    W = 5

    Output: -1
    Explanation:
    It is not possible to buy 5 kgs of oranges.
*/


class Solution
{
    public int minimumCost(int cost[], int N,int W)
    {
        int[][] dp = new int[N+1][W+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        int ans= helper(cost,N,W,dp);
        return (ans<0)?-1:ans;
    }
    public static int helper(int[] cost,int index,int weight,int[][] dp)
    {
        if(weight<=0) return 0;

        if(index<=0) return 100000;

        if(dp[index][weight]!=-1) return dp[index][weight];

        if(index<=weight && cost[index-1] !=-1)
        {
            int take= cost[index-1]+helper(cost,index,weight-index,dp);
            int notTaken=helper(cost,index-1,weight,dp);
            return dp[index][weight]=Math.min(take,notTaken);
        }
        else
        {
            return dp[index][weight]=helper(cost,index-1,weight,dp);
        }
    }
}

/*
**************** Logic ****************
Variation of unbounded knapsack.
*/
