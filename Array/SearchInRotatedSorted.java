/*
**************** Problem Description ****************
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.
    Example1 : 
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4
    Example2 : 
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1
    Example3 : 
    Input: nums = [1], target = 0
    Output: -1
*/


class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int start=0;
        int end=n-1;
        int position=0;
        
        if(nums.length==1)
            return (nums[0]==target?0:-1);
        
        while(start<=end)
        {
            int mid=start+(end-start)/2;
          //  System.out.println(start+" "+mid+" "+end);

            if(nums[start]<nums[end])
            {
                position=start;
                break;
            }
            if(nums[mid]<nums[(mid+1)%n] && nums[mid]<nums[(mid-1+n)%n])
            {
                position =mid;
                break;
            }
            else if(nums[mid]<nums[start])
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        //System.out.println("position "+position);
        if(nums[n-1]<target)
        {
            return binSearch(nums,0,position,target);
        }
        else
        {
            return binSearch(nums,position,n-1,target);
        }
        
    }
    
    
    public static int binSearch(int []nums,int start,int end,int target)
    {
        

        
        while(start<=end)
        {
            int mid=start+(end-start)/2;
           // System.out.println(start+" "+end+" "+target);
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
            {
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return -1;
    }
}

/*

**************** Logic ****************
Find the minimum element in the array.
Now we have 2 sorted arrays [0 to min - 1] and [min to end].
Apply binary search on one of the 2 sorted arrays.

*/