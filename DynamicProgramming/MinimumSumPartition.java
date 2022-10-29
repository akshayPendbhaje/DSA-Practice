/*
**************** Problem Description ****************
Given an integer array arr of size N, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference.
    Example : 1

    Input: N = 4, arr[] = {1, 6, 11, 5}
    Output: 1

    Explanation:
    Subset1 = {1, 5, 6}, sum of Subset1 = 12
    Subset2 = {11}, sum of Subset2 = 11
    Example : 2

    Input: N = 2, arr[] = {1, 4}
    Output: 3
    Explanation:
    Subset1 = {1}, sum of Subset1 = 1
    Subset2 = {4}, sum of Subset2 = 4
*/

class Solution
{

    public int minDifference(int arr[], int n)
    {
        // Your code goes here

        int sum=0;

        for(int num: arr)
        {
            sum+=num;
        }

        sum=sum/2;
        boolean dp[][] = new boolean[n+1][sum+1];

        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j]=true;
                }
                else if(i==0)
                {
                    dp[i][j]=false;
                }
                else if(j==0)
                {
                    dp[i][j]=true;
                }
                else
                {
                    if(j>=arr[i-1])
                    {
                        dp[i][j]= dp[i-1][j] || dp[i-1][j-arr[i-1]];
                    }
                    else
                    {
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
        }

        int subsetSum=0;
        for(int i=sum;i>=0;i--)
        {
            if(dp[n][i])
            {
                subsetSum=i;
                break;
            }
        }
        sum=0;

        for(int num: arr)
        {
            sum+=num;
        }
        int subsetSum2= (sum-subsetSum);
        int diff = Math.abs(subsetSum2-subsetSum);
        return diff;
    }
}

/*
**************** Logic ****************
Generate a 2D array for subset sum DP. The DP table will depend on items and Range(Sum of all items).
The last row in DP table represents whether it is possible to make a given sum from 0 - Range using all items.
For each cell that is true in the last row of DP table is a possible subset1 (s1). Then s2 = Range - s1.
Check for each cell in the last row of DP table to find the minimum value of |s1 - s2|.
*/