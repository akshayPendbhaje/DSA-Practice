/*
**************** Problem Description ****************
Given an array arr[] of length N and an integer X, the task is to find the number of subsets with a sum equal to X.
    Example : 1

    Input:
    N = 7
    arr[] = {3, 34, 4, 12, 5, 2, 7}
    sum = 7

    Output: 3
    Explanation: There exists 3 subsets with sum = 7, [{3,4}, {5,2}, {7}]
*/
public class Solution {
    public static int findWays(int num[], int tar) {
        // Write your code here..

        int dp[][] = new int[num.length+1][tar+1];

        for(int i=0;i<=num.length;i++)
        {
            for(int j=0;j<=tar;j++)
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
                    if(j<=num[i-1])
                    {
                        dp[i][j] = dp[i-1][j]+dp[i-1][j-num[i-1]];
                    }
                    else
                    {
                        dp[i][j]=dp[i-1][j];
                    }
                }

            }
        }
        return dp[num.length][tar];
    }
}


/*
**************** Logic ****************
The solution depends upon the required sum and the items included.
So our DP solution contains 2 states: Sum and N(items).
For each item we need to find the number of subsets possible with sum = target. There are 2 cases
1. All subsets including the current item
2. All subsets excluding the current item
Adding 1 and 2 we will get the total number of subsets.
*/