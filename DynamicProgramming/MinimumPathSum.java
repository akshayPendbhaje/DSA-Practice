/*
**************** Problem Description ****************
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
    Example : 1

    Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
    Output: 7
    Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
    Example : 2

    Input: grid = [[1,2,3],[4,5,6]]
    Output: 12
*/

class Solution {
    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length+1][grid[0].length+1];

        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        return helper(grid,0,0,dp);
    }

    public static int helper(int[][] grid,int row,int col,int[][] dp)
    {
        if(row==grid.length-1 && col == grid[0].length-1)
            return grid[row][col];

        if(row>=grid.length || col >= grid[0].length)
            return Integer.MAX_VALUE;

        if(dp[row][col]!=-1)
            return dp[row][col];

        dp[row][col]=Math.min(helper(grid,row+1,col,dp) , helper(grid,row,col+1,dp))+grid[row][col]; // Go down or go right + current value

        return dp[row][col];
    }
}

/*
**************** Logic ****************
We have 2 choices, we can go right or bottom.
Calculate minimum path sum for both choices and choose minimum.
Both choices have overlapping sub problems, hence store the result in dp.
*/