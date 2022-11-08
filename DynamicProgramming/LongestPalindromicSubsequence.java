/*
**************** Problem Description ****************
Given a string s, find the longest palindromic subsequence's length in s.
A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
    Example : 1

    Input: s = "bbbab"
    Output: 4
    Explanation: One possible longest palindromic subsequence is "bbbb".
    Example : 2

    Input: s = "cbbd"
    Output: 2
    Explanation: One possible longest palindromic subsequence is "bb".
*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuffer sbr = new StringBuffer(s);
        String s2= sbr.reverse().toString();
        int dp[][] = new int[s.length()+1][s.length()+1];
        for(int i=1;i<=s.length();i++)
        {
            for(int j=1;j<=s.length();j++)
            {
                if(s.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s.length()][s.length()];
    }
}

/*
**************** Logic ****************
LPS = LCS(s, reverse(s))
*/