/*
**************** Problem Description ****************
Given a string str, find the length of the longest repeating subsequence such that it can be found twice in the given string.
The two identified subsequences A and B can use the same ith character from string str if and only if that ith character has different indices in A and B.
    Example : 1

    Input:
    str = "axxxy"
    Output: 2
    Explanation:
    The given array with indexes looks like
    a x x x y
    0 1 2 3 4
    The longest subsequence is "xx".
    It appears twice as explained below.
    subsequence A
    x x
    0 1  <-- index of subsequence A
    ------
    1 2  <-- index of str
    subsequence B
    x x
    0 1  <-- index of subsequence B
    ------
    2 3  <-- index of str
    We are able to use character 'x'
    (at index 2 in str) in both subsequences
    as it appears on index 1 in subsequence A
    and index 0 in subsequence B.
    Example : 2

    Input: str = "aab"
    Output: 1
    Explanation: The longest reapting subsequenece is "a".
*/

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        String str2=str;
        int l1=str.length();
        int l2= str.length();

        int dp[][]= new int[l1+1][l2+1];

        for(int i=1;i<=l1;i++)
        {
            for(int j=1;j<=l1;j++)
            {
                if(str.charAt(i-1)==str2.charAt(j-1) && i!=j)
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[l1][l2];
    }
}
/*
**************** Logic ****************
This problem is just the modification of Longest Common Subsequence problem.
The idea is to find the LCS(str, str) where str is the input string with the restriction that when both the characters are same, they shouldn’t be on the same index in the two strings.
*/