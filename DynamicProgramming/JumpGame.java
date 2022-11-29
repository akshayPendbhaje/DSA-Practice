/*
**************** Problem Description ****************
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.
    Example : 1

    Input: nums = [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
    Example : 2

    Input: nums = [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
*/
class Solution {
    public int jump(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }

    public int helper(int[] nums,int index,int[] dp)
    {
        if(index>=nums.length-1)
            return 0;
        if(dp[index]!=-1)return dp[index];
        int ans=Integer.MAX_VALUE-1;
        for(int i=1;i<=nums[index];i++)
        {
            int tempAns= helper(nums,index+i,dp)+1;
            ans=Math.min(ans,tempAns);
        }
        return dp[index]=ans;
    }
}

/*
**************** Logic ****************
DP : For each index try all possible jumps. Memoize the overlapping jumps.
Greedy :
"reach" means how far you can go from the starting point. For each position greedily choose the max jump possible.
*/