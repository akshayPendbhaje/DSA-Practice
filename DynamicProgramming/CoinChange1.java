/*
**************** Problem Description ****************
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
    Example : 1

    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1
    Example : 2

    Input: coins = [2], amount = 3
    Output: -1
    Example : 3

    Input: coins = [1], amount = 0
    Output: 0
    Example : 4

    Input: coins = [1], amount = 1
    Output: 1
    Example : 5

    Input: coins = [1], amount = 2
    Output: 2
*/

class Solution {
    public int change(int amount, int[] coins) {



        int[][] dp = new int[coins.length+1][amount+1];

        for(int i=0;i<=coins.length;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j]=1;
                }
                else if(i==0)
                {
                    dp[i][j]=0;
                }
                else if(j==0)
                {
                    dp[i][j]=1;
                }
                else
                {
                    if(j>=coins[i-1])
                    {
                        dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                    }
                    else
                    {
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
        }
        return dp[coins.length][amount];

    }
}

/*
**************** Logic ****************
Variation of unbounded knapsack.
For base case use INT_MAX - 1 to avoid int overflow due to possible 1 + INT_MAX.
*/