/*
**************** Problem Description ****************
Given an array of integers, arr[] and a number, K.You can pair two numbers of the array if the difference between them is strictly less than K.
The task is to find the maximum possible sum of such disjoint pairs (i.e., each element of the array can be used at most once).
The Sum of P pairs is the sum of all 2P elements of pairs.
    Example : 1

    Input  :
    arr[] = {3, 5, 10, 15, 17, 12, 9}
    K = 4

    Output : 62
    Explanation :
    Then disjoint pairs with difference less than K are, (3, 5), (10, 12), (15, 17) max sum which we can get is 3 + 5 + 10 + 12 + 15 + 17 = 62
    Note that an alternate way to form  disjoint pairs is,(3, 5), (9, 12), (15, 17) but this pairing produces less sum.
    Example : 2

    Input  :
    arr[] = {5, 15, 10, 300}
    K = 12
    Output : 25
*/

class Solution {
    public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K)
    {
        // Your code goes here
        int[] dp = new int[N+1];
        for(int i=0;i<=N;i++)
            dp[i]=-1;
        Arrays.sort(arr);
        return helper(arr,N,K,dp);

    }

    public static int helper(int[] arr,int index,int K ,int[] dp)
    {
        if(index<=1) return 0;
        if(dp[index]!=-1) return dp[index];

        if(arr[index-1]-arr[index-2]<K)
        {
            dp[index]= Math.max(arr[index-1]+arr[index-2]+helper(arr,index-2,K,dp),helper(arr,index-1,K,dp));
            return dp[index];
        }

        dp[index]=helper(arr,index-1,K,dp);
        return dp[index];
    }

}


**************** Logic ****************
        DP : 0-1 Knapsack approach.

        */

