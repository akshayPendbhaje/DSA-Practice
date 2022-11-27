/*
**************** Problem Description ****************
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
    Example : 1

    Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    Output: 4
    Example : 2

    Input: matrix = [["0","1"],["1","0"]]

    Output: 1
    Example : 3

    Input: matrix = [["0"]]
    Output: 0
*/

class Solution {
    public int maximalSquare(char[][] matrix) {

        int rows=matrix.length;
        int cols=matrix[0].length;

        int[][] dp = new int[rows+1][cols+1];
        int ans=0;
        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=cols;j++)
            {
                if (matrix[i-1][j-1] == '1')
                {
                    dp[i][j]=1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);

                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans*ans;
    }
}


/*
**************** Logic ****************
dp[i][j] represents the max side length of the square from dp[0][0] to dp[i][j].
The max size of the square at dp[i][j] depends on dp[i][j-1], dp[i-1][j] and dp[i-1][j-1].
*/