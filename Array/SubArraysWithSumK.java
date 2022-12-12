/*
**************** Problem Description ****************
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
    Example1:
    Input: nums = [1,1,1], k = 2
    Output: 2
    Example2:
    Input: nums = [1,2,3], k = 3
    Output: 2
*/
class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> hm = new HashMap<>();


        int right=0;
        int ans=0;
        int runningSum=0;
        hm.put(0,1);
        while(right<nums.length)
        {
            runningSum+=nums[right];
            if(hm.containsKey(runningSum-k))
            {
                ans+=hm.get(runningSum-k);
            }
            hm.put(runningSum,hm.getOrDefault(runningSum,0)+1);
            right++;
        }
        return ans;
    }
}
/*
**************** Logic ****************
Iterate over the array and keep storing the available sums in a hashmap.
sum(i,j) = sum(0,j) - sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1.
*/
