/*
**************** Problem Description ****************
Given a boolean expression S of length N with following symbols.
Symbols
    'T' ---> true
    'F' ---> false
and following operators filled between symbols
Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
    Example : 1

    Input:
    N = 7
    S = T|T&F^T

    Output: 4

    Explaination:
    The expression evaluates to true in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
    Example : 2

    Input:
    N = 5
    S = T^F|F

    Output: 2

    Explaination: ((T^F)|F) and (T^(F|F)) are the only ways.
*/

class Solution{
    static int countWays(int N, String S){
        // code here
        int[][][] dp= new int[N+1][N+1][2];
        for(int [][]rows: dp)
        {
            for(int []col:rows)
            {
                Arrays.fill(col,-1);
            }
        }

        return countWays(S,0,N-1,true,dp);
    }

    static int countWays(String s,int left,int right,boolean expected,int[][][] dp)
    {
        if(left>right)
            return 0;
        char expChar=(expected)?'T':'F';
        int expnum=(expected) ? 1 : 0;
        if(left==right)
        {
            if(s.charAt(left)== expChar )
                return 1;
            else
                return 0;
        }
        if(dp[left][right][expnum]!=-1) return dp[left][right][expnum];
        long ans=0;
        for(int k=left+1;k<right;k+=2)
        {
            int lt=countWays(s,left,k-1,true,dp);
            int lf=countWays(s,left,k-1,false,dp);
            int rt=countWays(s,k+1,right,true,dp);
            int rf=countWays(s,k+1,right,false,dp);

            if(s.charAt(k)=='&')
            {
                if(expected)
                    ans+=(lt*rt);
                else
                {
                    ans+=(lt*rf)+(lf*rt)+(lf*rf);
                }
            }
            else if(s.charAt(k)=='|')
            {
                if(expected)
                {
                    ans+=(lf*rt)+(lt*rf)+(lt*rt);
                }
                else
                {
                    ans+=(lf*rf);
                }
            }
            else if(s.charAt(k)=='^')
            {
                if(expected)
                {
                    ans+=(lf*rt)+(lt*rf);
                }
                else
                {
                    ans+=(lf*rf)+(lt*rt);
                }
            }

        }
        dp[left][right][expnum]=(int) (ans %1003);
        return dp[left][right][expnum];
    }
}

/*
**************** Logic ****************
For each segment find out how many ways are there to get T as result.
*/