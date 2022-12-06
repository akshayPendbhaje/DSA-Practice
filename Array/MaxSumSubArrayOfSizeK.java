/*
**************** Problem Description ****************
Given an array of integers Arr of size N and a number K.
Return the maximum sum of a subarray of size K.
    Example:
    Input:
    N = 4, K = 2
    Arr = [100, 200, 300, 400]
    Output:
    700
    Explanation:
    Arr3  + Arr4 =700,
    which is maximum.
*/

class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        long ans=0l;
        int right=0;
        int left=0;
        long runningSum=0l;
        while(right<Arr.size())
        {
            runningSum+=Arr.get(right);
            if(right-left+1<K)
            {
                // System.out.println("if "+left+" "+right+" "+runningSum);
                right++;
            }
            else
            {
                ans=Math.max(ans,runningSum);
                //  System.out.println("else "+left+" "+right+" "+runningSum);
                runningSum-=Arr.get(left);
                right++;
                left++;
            }

        }

        return ans;
    }
}

/*
**************** Logic ****************
Basic fixed size sliding window.
*/