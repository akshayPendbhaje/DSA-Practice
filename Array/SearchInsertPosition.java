/*
**************** Problem Description ****************
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
    Example1 : 
    Input: nums = [1,3,5,6], target = 5
    Output: 2
    Example2 : 
    Input: nums = [1,3,5,6], target = 2
    Output: 1
    Example3 : 
    Input: nums = [1,3,5,6], target = 7
    
    Output: 4
    Example4 : 
    Input: nums = [1,3,5,6], target = 0
    
    Output: 0
    Example5 : 
    Input: nums = [1], target = 0
    Output: 0
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int left=0;
        int right=nums.length-1;
        
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[mid]<target)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }

        }
        
        return left;
    }
}


/*
**************** Logic ****************
Regular Binary search.
*/
