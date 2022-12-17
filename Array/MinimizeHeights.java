/*
**************** Problem Description ****************
Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of each tower either by increasing or decreasing them by K only once.
After modifying, height should be a non-negative integer.
Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.
A slight modification of the problem can be found here.
    Example1 :
    Input:
    K = 2, N = 4
    Arr[] = {1, 5, 8, 10}
    Output: 5
    Explanation:
    The array can be modified as  {3, 3, 6, 8}. The difference between the largest and the smallest is 8-3 = 5.
    Example2 :
    Input:
    K = 3, N = 5
    Arr[] = {3, 9, 12, 16, 20}
    Output: 11
    Explanation:
    The array can be modified as {6, 12, 9, 13, 17}. The difference between the largest and the smallest is 17-6 = 11.
*/


class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        // code here

        Arrays.sort(arr);
        int ans= arr[n-1]-arr[0];
        int min = arr[0]+k;
        int max=arr[n-1]-k;

        for(int i=0;i<n-1;i++)
        {
            int curMin = Math.min(min,arr[i+1]-k);
            int curMax = Math.max(max,arr[i]+k);

            if(curMin<0) continue;
            ans = Math.min(ans,curMax - curMin);

        }
        return ans;
    }
}
