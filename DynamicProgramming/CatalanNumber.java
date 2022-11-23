/*
**************** Problem Description ****************
Given a number N. The task is to find the Nth catalan number.
The first few Catalan numbers for N = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …
Note: Positions start from 0 as shown above.
    Example : 1

    Input: N = 5

    Output: 42
    Example : 2

    Input: N = 4
    Output: 14
*/

class Solution
{
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        //Your code here

        BigInteger[] dp = new BigInteger[n+1];

        dp[0]= BigInteger.valueOf(1);
        if(n>=1)
            dp[1]= BigInteger.valueOf(1);
        for(int i=2;i<=n;i++)dp[i]=BigInteger.ZERO;
        for(int i=2;i<=n;i++)
        {

            for(int j=0,k=i-1;j<n && k>=0;j++,k--)
            {
                dp[i]=dp[i].add(dp[j].multiply(dp[k]));
            }
        }

        return dp[n];
    }
}

/*
**************** Logic ****************
Catalan numbers satisfy the following recursive formula.
Cn+1 = Summation(i = 0 to n) Ci * Cn-i-1
C0 = 1
C1 = 1
C2 = C0*C1 + C1*C0
C3 = C0*C2 + C1*C1 + C2*C0
C4 = C0*C3 + C1*C2 + C2*C1 + C3*C0
...
*/