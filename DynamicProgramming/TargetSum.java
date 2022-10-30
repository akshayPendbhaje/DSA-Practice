/*
**************** Problem Description ****************
You are given an integer array nums and an integer target.
You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.
    Example : 1

    Input: nums = [1,1,1,1,1], target = 3
    Output: 5

    Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
    -1 + 1 + 1 + 1 + 1 = 3
    +1 - 1 + 1 + 1 + 1 = 3
    +1 + 1 - 1 + 1 + 1 = 3
    +1 + 1 + 1 - 1 + 1 = 3
    +1 + 1 + 1 + 1 - 1 = 3
    Example : 2

    Input: nums = [1], target = 1
    Output: 1
*/

class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum=0;

        if(nums.length == 1){
            if(nums[0] == Math.abs(target))
                return 1;
            else
                return 0;
        }


        for(int num :nums)
            sum+=num;

        if(((sum + target) % 2 == 1) || (target>sum)) return 0;

        target=(target+sum)/2;

        int[][] dp = new int[nums.length+1][target+1];

        for(int i=0;i<=nums.length;i++)
        {
            dp[i][0]=1;
        }

        for(int i=0;i<=nums.length;i++)
        {
            for(int j=0;j<=target;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j]=1;
                }
                else if(i==0)
                {
                    dp[i][j]=0;
                }
                else
                {
                    if(j>=nums[i-1] )
                    {
                        dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j];
                    }
                    else
                    {
                        dp[i][j]=dp[i-1][j];
                    }
                }

            }
        }


        return dp[nums.length][target];

    }
}

/*
**************** Logic ****************
Consider this example,
Input: nums = [1,1,1,1,1], target = 3
One possible solution is -1 + 1 + 1 + 1 + 1 = 3
In this, we can divide the positive and negative numbers into two sets, {1,1,1,1} with S1 = 4 and {-1} with S2 = -1.
S1 + S2 = Range ----1
S1 - S2 = Target ----2
Adding 1 and 2:
S1 = (Range + Target) / 2
Now we can find how many ways are possible to create S1 using nums array.
This is now similar to the count subset sum problem.
*/