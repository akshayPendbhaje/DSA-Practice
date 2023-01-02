/*
**************** Problem Description ****************
Given a non-negative integer x, compute and return the square root of x.
Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
    Example 1:
    Input: x = 4
    Output: 2
    Example 2:
    Input: x = 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
*/

class Solution {
    public int mySqrt(int x) {

        if(x<2) return x;

        int left=1;
        int right = x/2;
        int ans=0;
        while(left<=right)
        {
            long mid = left+(right-left)/2;

            if (mid*mid==x)
                return (int)mid;
            else if(mid*mid<=x)
            {
                ans=(int)mid;
                left=(int)mid+1;
            }
            else
            {
                right=(int)mid-1;
            }
        }
        return ans;
    }
}
/*
**************** Logic ****************
1. Using binary search from 1 to x until mid = x/mid.
*/