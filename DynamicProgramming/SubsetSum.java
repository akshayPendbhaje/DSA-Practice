/*
**************** Problem Description ****************
Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
    Example : 1

    Input:
    N = 6
    arr[] = {3, 34, 4, 12, 5, 2}
    sum = 9

    Output: 1
    Explanation: Here there exists a subset with sum = 9, 4+3+2 = 9.
    Example : 2

    Input:
    N = 6
    arr[] = {3, 34, 4, 12, 5, 2}
    sum = 30
    Output: 0

    Explanation: There is no subset with sum 30.
*/

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here

        Boolean dp[][] = new Boolean[N+1][sum+1];
        for(int i=0;i<=sum;i++)
        {
            dp[0][i]=false;
        }

        for(int i=0;i<=N;i++)
        {
            dp[i][0]= true;
        }

        return helper(dp,arr,sum,N);
    }

    /*
    static boolean helper(Boolean[][] dp, int[] arr,int sum,int index)
    {
        if(sum==0) return true;

        if(dp[index][sum]!=null) return dp[index][sum];

        if(sum>=arr[index-1])
        {
            dp[index][sum] = helper(dp,arr,sum-arr[index-1],index-1) || helper(dp,arr,sum,index-1);
        }
        else
        {
            dp[index][sum] = helper(dp,arr,sum,index-1);
        }

        return dp[index][sum];
    }*/

    static boolean helper(Boolean[][] dp, int[] arr,int sum,int N) {

        for(int i=1;i<=N ; i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(j>=arr[i-1])
                {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[N][sum];
    }


}

/*
**************** Logic ****************
The solution depends upon the required sum and the items included.
So our DP solution contains 2 states: Sum and N(items).
If isSubsetSum(i,arr,sum) denotes whether there exists a subset of first ith elements of array then:
 isSubsetSum(i,arr,sum) = isSubsetSum(i-1,arr,sum) || isSubsetSum(i-1,arr,sum-arr[i-1]) .
*/