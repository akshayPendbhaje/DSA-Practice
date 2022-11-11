/*
**************** Problem Description ****************
Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome.
Determine the fewest cuts needed for palindrome partitioning of given string.
    Example : 1

    Input: str = "ababbbabbababa"
    Output: 3
    Explaination: After 3 partitioning substrings are "a", "babbbab", "b", "ababa".
    Example : 2

    Input: str = "aaabba"
    Output: 1
    Explaination: The substrings after 1 partitioning are "aa" and "abba".
*/


class Solution{
    static int palindromicPartition(String str)
    {
        // code here
        int[][] dp= new int[str.length()+1][str.length()+1];
        return helper(str,0,str.length()-1,dp);

    }

    static int helper(String str,int left,int right,int[][] dp)
    {
        if(left>right || isPalindrome(str,left,right))
        {
            return 0;
        }
        if(dp[left][right]!=0) return dp[left][right];
        int min=Integer.MAX_VALUE;
        for(int k=left;k<right;k++)
        {
            int tempAns= helper(str,left,k,dp) + helper(str,k+1,right,dp) +1;
            min=Math.min(min,tempAns);
        }
        dp[left][right]=min;
        return min;
    }


    static boolean isPalindrome(String str,int left,int right)
    {
        while(left<right)
        {
            if(str.charAt(left)==str.charAt(right))
            {
                left++;
                right--;
            }
            else
            {
                return false;
            }
        }

        return true;

    }
}

/*
**************** Logic ****************
This problem is a variation of Matrix Chain Multiplication problem. If the string is a palindrome, then we simply return 0.
Else, like the Matrix Chain Multiplication problem, we try making cuts at all possible places, recursively calculate the cost for each cut and return the minimum value.
*/