/*
**************** Problem Description ****************
A peak element is an element that is strictly greater than its neighbors.
Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞.
You must write an algorithm that runs in O(log n) time.
    Example1 : 
    Input: nums = [1,2,3,1]
    Output: 2
    Explanation: 3 is a peak element and your function should return the index number 2.
    Example2 : 
    Input: nums = [1,2,1,3,5,6,4]
    Output: 5
    
    Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
*/

class Solution {
    public int findPeakElement(int[] nums) {
        
        int left=1;
        int right=nums.length-2;
        if(nums.length<=1)return 0;
        
        while(left<=right)
        {
            int mid=left+(right-left)/2; 
                if(nums[mid]>nums[mid-1]&& nums[mid]>nums[mid+1])
                {
                    return  mid ;
                } 
                else if(nums[mid]>nums[mid+1])
                {
                    right=mid-1;
                }
                else 
                {
                    left=mid+1;
                }
            System.out.println(left+" "+mid+" "+right);
        }
        
            if(nums[0]>nums[1]) return  0 ;
            else return nums.length-1 ;
        
    }
}

/*
**************** Logic ****************
If the mid is not the peak then move towards the number greater than mid.
*/
