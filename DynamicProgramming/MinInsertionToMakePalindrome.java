/*
**************** Problem Description ****************
Given a string s. In one step you can insert any character at any index of the string.
Return the minimum number of steps to make s palindrome.
A Palindrome String is one that reads the same backward as well as forward.
    Example : 1

    Input: s = "zzazz"
    Output: 0
    Explanation: The string "zzazz" is already palindrome we don't need any insertions.
    Example : 2

    Input: s = "mbadm"
    Output: 2
    Explanation: String can be "mbdadbm" or "mdbabdm".
    Example : 3

    Input: s = "leetcode"
    Output: 5
    Explanation: Inserting 5 characters the string becomes "leetcodocteel".
    Example : 4

    Input: s = "g"
    Output: 0
    Example : 5

    Input: s = "no"
    Output: 1
*/

class Solution {
    public int minInsertions(String s) {

        String s2= new StringBuffer(s).reverse().toString();

        int l1= s.length();
        int l2=s.length();

        int dp[][]= new int[l1+1][l1+1];

        for(int i=1;i<=l1;i++)
        {
            for(int j=1;j<=l1;j++)
            {
                if(s.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]= Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return l1-dp[l1][l1];
    }
}

/*
**************** Logic ****************
If we figure out the longest palindromic subsequence, then we can tell the miminum number of characters to add or remove to make the string a palindrome.
*/