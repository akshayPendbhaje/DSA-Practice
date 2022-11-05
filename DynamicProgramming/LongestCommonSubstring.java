/*
**************** Problem Description ****************
Given two strings. The task is to find the length of the longest common substring.
    Example : 1

    Input: S1 = "ABCDGH", S2 = "ACDGHR"
    Output: 4
    Explanation: The longest common substring is "CDGH" which has length 4.
    Example : 2

    Input: S1 = "ABC", S2 = "ACB"
    Output: 1
    Explanation: The longest common substrings are "A", "B", "C" all having length 1.
*/


class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here

        if(S1==null || S2==null || n==0 || m==0) return 0;
        int[][] dp= new int[n+1][m+1];


        //   helper(S1,S2,n-1,m-1,dp);


        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(S1.charAt(i - 1) == S2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }


        int max = 0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }




    int helper(String S1, String S2, int n, int m,int[][] dp)
    {
        if(n<0 || m< 0) return 0;

        helper(S1,S2,n,m-1,dp);
        helper(S1,S2,n-1,m,dp);
        if(dp[n][m]!=0) return dp[n][m];

        if(S1.charAt(n)==S2.charAt(m))
        {
            dp[n][m]=1+helper(S1,S2,n-1,m-1,dp);
        }
        else
        {
            dp[n][m]=0;
        }

        return dp[n][m];
    }
}

/*
**************** Logic ****************
Variation of Longest Common Subsequence.
When the corresponding characters in both strings are matching then we know that the minimum length of substring will be atleast 1.
If characters do not match then the sequence is broken and we restart counting from 0.
*/
