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

