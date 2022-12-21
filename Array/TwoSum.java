/*
**************** Problem Description ****************
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
    Example1 :
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example2 :
    Input: nums = [3,2,4], target = 6

    Output: [1,2]
    Example3 :
    Input: nums = [3,3], target = 6
    Output: [0,1]
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            //System.out.println(Arrays.asList(map));
            if(map.containsKey(nums[i]))
            {
                return new int[] {map.get(nums[i]),i};
            }
            map.put(target-nums[i], i);
        }

        return null;
    }
}

/*
**************** Logic ****************
Iterate the nums array and for each element (nums[i]) check in map if required number (target - nums[i]) has already occured.
*/