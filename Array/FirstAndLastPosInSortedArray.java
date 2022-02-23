/*
**************** Problem Description ****************
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
    Example1 : 
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]
    Example2 : 
    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]
    Example3 : 
    Input: nums = [], target = 0
    Output: [-1,-1]
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=0;
        int last = nums.length-1;
        int[] ans={-1,-1};
        
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(nums[mid]==target)
            {
                ans[0]=mid;
                last=mid-1;
            }
            else if(nums[mid]<target)
            {
                first=mid+1;
            }
            else
            {
                last=mid-1;
            }
        }
         
         first=0;
         last = nums.length-1;
        
        while(first<=last)
        {
            int mid=first+(last-first)/2;
            if(nums[mid]==target)
            {
                ans[1]=mid;
                first=mid+1;
            }
            else if(nums[mid]<target)
            {
                first=mid+1;
            }
            else
            {
                last=mid-1;
            }
        }
        
        return ans;
    }
}

/*
**************** Logic ****************
User binary search twice. One to find first position and one for last position. 
*/