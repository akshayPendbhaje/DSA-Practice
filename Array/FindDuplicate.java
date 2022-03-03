/*
**************** Problem Description ****************
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.
    Example1 : 
    Input: nums = [1,3,4,2,2]
    Output: 2
    Example2 : 
    Input: nums = [3,1,3,4,2]
    
    Output: 3
    Example3 : 
    Input: nums = [1,1]
    
    Output: 1
    Example4 : 
    Input: nums = [1,1,2]
    Output: 1
*/

class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        
        for(int i:nums)
        {
            if(seen.contains(i))
            {
                return i;
            }
            else
            {
                seen.add(i);
            }
        }
        return 0;
    }
}
