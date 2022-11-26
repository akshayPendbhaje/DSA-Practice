/*
**************** Problem Description ****************
Given an integer N denoting the Length of a line segment.
You need to cut the line segment in such a way that the cut length of a line segment each time is either x , y or z. Here x, y, and z are integers.
After performing all the cut operations, your total number of cut segments must be maximum.
    Example : 1

    Input:
    N = 4
    x = 2, y = 1, z = 1
    Output: 4
    Explanation: Total length is 4, and the cut lengths are 2, 1 and 1.  We can make maximum 4 segments each of length 1.
    Example : 2

    Input:
    N = 5
    x = 5, y = 3, z = 2
    Output: 2
    Explanation: Here total length is 5, and the cut lengths are 5, 3 and 2. We can make two segments of lengths 3 and 2.
*/


class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
        //Your code here
        int dp[] = new int[n+1];

        helperCutter(n,x,y,z,dp);
        // System.out.println(Arrays.toString(dp));
        return (dp[n]<0)?0:dp[n];
    }

    int helperCutter(int n,int x,int y,int z,int[] dp)
    {
        if(n==0)
            return 0;
        if(n<0) return Integer.MIN_VALUE;

        if(dp[n]!=0) return dp[n];

        int c1=1+helperCutter(n-x,x,y,z,dp);
        int c2=1+helperCutter(n-y,x,y,z,dp);
        int c3=1+helperCutter(n-z,x,y,z,dp);

        dp[n]=Math.max(c1,Math.max(c2,c3));

        return dp[n];

    }
}


/*
**************** Logic ****************
For each length calculate the answer using all possible cuts (x, y, z).
*/