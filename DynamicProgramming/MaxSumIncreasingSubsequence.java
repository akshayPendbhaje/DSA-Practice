/*
**************** Problem Description ****************
Given an array arr of N positive integers, the task is to find the maximum sum increasing subsequence of the given array.
    Example : 1

    Input: N = 5, arr[] = {1, 101, 2, 3, 100}
    Output: 106
    Explanation: The maximum sum of a increasing sequence is obtained from {1, 2, 3, 100}
    Example : 2

    Input: N = 3, arr[] = {1, 2, 3}
    Output: 6
    Explanation: The maximum sum of a increasing sequence is obtained from {1, 2, 3}
*/


class Solution
{
    public int maxSumIS(int arr[], int n)
    {
        //code here.

        int[] dp = new int[n+1];
        int ans=arr[0];
        dp[0]=arr[0];

        for(int i=1;i<n;i++)
        {
            int max=0;
            for(int j=0;j<=i;j++)
            {
                if(arr[i]>arr[j])
                {
                    if(dp[j]>max)
                    {
                        max=dp[j];
                    }
                }

                dp[i]=max+arr[i];
                ans=Math.max(dp[i],ans);
            }
        }

        return ans;
    }
}

/*
**************** Logic ****************
Tabulation:
dp[i] stores the longest sum increasing subsequence till index i which ends at i.
The result will be the max value in the dp at the end.
*/