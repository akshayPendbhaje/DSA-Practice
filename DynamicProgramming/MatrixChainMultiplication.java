/*
**************** Problem Description ****************
Given a sequence of matrices, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.
The dimensions of the matrices are given in an array arr[] of size N (such that N = number of matrices + 1) where the ith matrix has the dimensions (arr[i-1] x arr[i]).
    Example : 1

    Input: N = 5
    arr = {40, 20, 30, 10, 30}
    Output: 26000

    Explaination:
    There are 4 matrices of dimension 40x20, 20x30, 30x10, 10x30. Say the matrices are named as A, B, C, D. Out of all possible combinations,
    the most efficient way is (A*(B*C))*D. The number of operations are - 20*30*10 + 40*20*10 + 40*10*30 = 26000.
    Example : 2

    Input: N = 4
    arr = {10, 30, 5, 60}
    Output: 4500
    Explaination:
    The matrices have dimensions 10*30, 30*5, 5*60. Say the matrices are A, B and C. Out of all possible combinations,
    the most efficient way is (A*B)*C. The number of multiplications are - 10*30*5 + 10*5*60 = 4500.
*/


class Solution{
    static int ans=0;
    static int matrixMultiplication(int N, int arr[])
    {
        int leftWin=1;
        int rightWin=N-1;
        int[][] dp= new int[N+1][N+1];
        return helper(arr,leftWin,rightWin,dp);
    }

    static int helper(int[] arr,int leftWin,int rightWin,int[][] dp)
    {
        if(leftWin>= rightWin) return 0;
        if(dp[leftWin][rightWin]!=0) return dp[leftWin][rightWin];
        int min = Integer.MAX_VALUE;

        for(int k=leftWin;k<rightWin;k++)
        {
            int tempAns=helper(arr,leftWin,k,dp)+
                    helper(arr,k+1,rightWin,dp)+
                    arr[leftWin-1]*arr[k]*arr[rightWin];
            min=Math.min(min,tempAns);
        }
        dp[leftWin][rightWin] = min;
        return min;
    }
}

/*
**************** Logic ****************
A simple solution is to place parenthesis at all possible places, calculate the cost for each placement and return the minimum value.
In a chain of matrices of size n, we can place the first set of parenthesis in n-1 ways.
For example, if the given chain is of 4 matrices. let the chain be ABCD, then there are 3 ways to place first set of parenthesis outer side: (A)(BCD), (AB)(CD) and (ABC)(D).
So when we place a set of parenthesis, we divide the problem into subproblems of smaller size. Therefore, the problem has optimal substructure property and can be easily solved using recursion.
Minimum number of multiplication needed to multiply a chain of size n = Minimum of all n-1 placements (these placements create subproblems of smaller size).
*/