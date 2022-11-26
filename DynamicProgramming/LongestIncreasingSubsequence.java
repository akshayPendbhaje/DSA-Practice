/*
**************** Problem Description ****************
Given an integer array nums, return the length of the longest strictly increasing subsequence.
A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
    Example : 1

    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
    Example : 2

    Input: nums = [0,1,0,3,2,3]

    Output: 4
    Example : 3

    Input: nums = [7,7,7,7,7,7,7]
    Output: 1
*/
class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] dp=new int[nums.length+1];

        dp[0]=1;
        int ans=1;
        for(int i=1;i<nums.length;i++ )
        {
            int max=0;

            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                {
                    if(max<dp[j])
                        max=dp[j];
                }
            }

            max+=1;
            dp[i]=max;
            ans=Math.max(ans,max);
        }

        return ans;
    }


}


/*
**************** Logic ****************
Tabulation:
dp[i] stores the longest increasing subsequence till index i which ends at i.
The result will be the max value in the dp at the end.
*/