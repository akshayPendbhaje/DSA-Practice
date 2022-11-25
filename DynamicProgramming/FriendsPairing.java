/*
**************** Problem Description ****************
Given N friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once.
Find out the total number of ways in which friends can remain single or can be paired up.
Note: Since answer can be very large, return your answer mod 10^9+7.
    Example : 1

    Input:N = 3
    Output: 4
    Explanation:
    {1}, {2}, {3} : All single
    {1}, {2,3} : 2 and 3 paired but 1 is single.
    {1,2}, {3} : 1 and 2 are paired but 3 is single.
    {1,3}, {2} : 1 and 3 are paired but 2 is single.
    Note that {1,2} and {2,1} are considered same.
    Example : 2

    Input: N = 2
    Output: 2
    Explanation:
    {1} , {2} : All single.
    {1,2} : 1 and 2 are paired.
*/

class Solution
{
    static double mod=1e9+7;
    public long countFriendsPairings(int n)
    {
        long[] dp=new long[n+1];

        return countPair(n,dp);
    }


    public static long countPair(int n,long[] dp)
    {
        if(n<=1)
        {
            return 1;
        }

        if(dp[n]!=0)
            return dp[n];

        long single = countPair(n-1,dp);
        long paired = (n-1)*countPair(n-2,dp);

        dp[n]  = (long)((single + paired)%mod);

        return dp[n];
    }
}
/*
**************** Logic ****************
For n-th person there are two choices:
1) n-th person remains single, so only 1 way so  we recur
   for remaining i.e f(n - 1)   or you can say 1*f(n-1)
2) n-th person pairs up with any of the
   remaining n - 1 persons. So apart from the 2 people forming a pair for remaining n-2 persons we We get (n - 1) * f(n - 2) ways
Therefore we can recursively write f(n) as:
f(n) = f(n - 1) + (n - 1) * f(n - 2)
*/