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
public class MaxSubArrSizeK {

    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int ans=Integer.MIN_VALUE;
        int sum=0;
        int i=0;
        int j=0;
        while(j<Arr.size())
        {
            sum=sum+Arr.get(j);
            if(j-i<K)
            {
                j++;
            }
            else if(j-i==K)
            {
                sum=sum-Arr.get(i);
                i++;
                j++;
            }
            
            ans=Math.max(sum,ans);
           // System.out.println(i+"  "+j+"  "+sum+"  "+ans);
        }
        return ans;
    }
}