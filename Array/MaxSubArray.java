/*
**************** Problem Description ****************
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
A subarray is a contiguous part of an array.
    Example : 1

    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    Example : 2

    Input: nums = [1]

    Output: 1
    Example : 3

    Input: nums = [5,4,-1,7,8]

    Output: 23
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax=Integer.MIN_VALUE;
        int localMax=0;

//         for(int i=0;i<nums.length;i++)
//         {
//              localMax += nums[i];
//              if(globalMax<localMax)
//              {
//                  globalMax=localMax;
//              }
//             localMax=Math.max(0,localMax);

//         }
//         return globalMax;

        int[][] dp= new int[nums.length+1][2];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return helper(nums,0,0,dp);

    }

    public static int helper(int[] nums,int index,int flag,int[][] dp)
    {
        if(nums.length<=index)
        {
            return (flag==1)?0: Integer.MIN_VALUE ;
        }

        if(dp[index][flag]!=-1) return dp[index][flag];

        if(flag==1)
        {
            return dp[index][flag]=Math.max(helper(nums,index+1,1,dp)+nums[index],0);  
        }
        return dp[index][flag]=Math.max(helper(nums,index+1,1,dp)+nums[index],helper(nums,index+1,0,dp));
    }

}


/*
**************** Logic ****************
DP:
Similar to 0-1 Knapsack.
1. We must pick the current element if the previous element was selected.
2. We may or may not pick the current element if the previous element was not selected.
Kadane's Algorithm:
If at any point sum becomes negative then no point keeping it because 0 is obviously greater than negative, so just make your sum 0.
*/