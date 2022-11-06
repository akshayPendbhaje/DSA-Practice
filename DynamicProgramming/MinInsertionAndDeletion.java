/*
**************** Problem Description ****************
Given two strings str1 and str2. The task is to remove or insert the minimum number of characters from/in str1 so as to transform it into str2.
It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.
    Example : 1

    Input: str1 = "heap", str2 = "pea"
    Output: 3
    Explanation: 2 deletions and 1 insertion p and h deleted from heap. Then, p is inserted at the beginning One thing to note,
    though p was required yet it was removed/deleted first from its position and then it is inserted to some other position.
    Thus, p contributes one to the deletion_count and one to the insertion_count.
    Example : 2

    Input : str1 = "geeksforgeeks" str2 = "geeks"
    Output: 8
    Explanation: 8 insertions
*/

class Solution
{
    public int minOperations(String str1, String str2)
    {
        // Your code goes here

        int len1=str1.length();
        int len2=str2.length();

        return helper(str1,str2,len1,len2);
    }

    int helper(String str1,String str2,int len1,int len2)
    {
        int dp[][] = new int[len1+1][len2+1];

        for(int i=1;i<=len1;i++)
        {
            for(int j=1;j<=len2;j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                {
                    dp[i][j]= dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int del=len1-dp[len1][len2];
        int add=len2-dp[len1][len2];

        return add+del;
    }
}

/*
**************** Logic ****************
-->str1 and str2 be the given strings.
-->m and n be their lengths respectively.
-->len be the length of the longest
   common subsequence of str1 and str2
-->// minimum number of deletions
   minDel = m - len
-->// minimum number of Insertions
   minInsert = n - len
*/