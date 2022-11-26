/*
**************** Problem Description ****************
Given 3 strings A, B and C, the task is to find the longest common sub-sequence in all three given sequences.
    Example : 1

    Input:
    A = "geeks", B = "geeksfor",
    C = "geeksforgeeks"
    Output: 5
    Explanation: "geeks"is the longest common subsequence with length 5.
    Example : 2

    Input:
    A = "abcd", B = "efgh", C = "ijkl"
    Output: 0
    Explanation: There's no common subsequence in all the strings.
*/


class Solution
{
    int LCSof3(String A, String B, String C, int n1, int n2, int n3)
    {
        if(n1==0 || n2==0 || n3==0) return 0;
        int[][][] dp=new int[n1+1][n2+1][n3+1];
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                for(int z=0;z<=n3;z++){
                    dp[i][j][z] = -1;
                }
            }
        }

        helper(A,B,C,n1,n2,n3,dp);
        return dp[n1][n2][n3];
    }

    int helper(String A, String B, String C, int n1, int n2, int n3,int[][][] dp)
    {
        if(n1==0 || n2==0 || n3==0) return 0;
        if(dp[n1][n2][n3]!=-1) return dp[n1][n2][n3];

        if(A.charAt(n1-1)==B.charAt(n2-1) && B.charAt(n2-1)==C.charAt(n3-1))
        {
            dp[n1][n2][n3]= 1+(helper(A,B,C,n1-1,n2-1,n3-1,dp));
        }
        else
        {
            dp[n1][n2][n3]= Math.max(Math.max(helper(A,B,C,n1-1,n2,n3,dp),helper(A,B,C,n1,n2-1,n3,dp)),helper(A,B,C,n1,n2,n3-1,dp));
        }

        return dp[n1][n2][n3];
    }
}


/*
**************** Logic ****************
Same approach as LCS of 2 strings but using 3 pointers.
*/