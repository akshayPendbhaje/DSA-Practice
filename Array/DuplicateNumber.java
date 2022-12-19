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

        int slow=nums[0];
        int fast=nums[0];

        while(true)
        {
            slow=nums[slow];
            fast=nums[nums[fast]];

            if(slow==fast)
                break;

        }

        slow=nums[0];
        while(slow!=fast)
        {
            slow=nums[slow];
            fast=nums[fast];

        }
        return slow;
    }
}


/*
 **************** Logic ****************
 Floyd's Tortoise and Hare (Cycle Detection)
The cycle appears because nums contains duplicates. The duplicate node is a cycle entrance.

* In phase 1, hare = nums[nums[hare]] is twice as fast as tortoise = nums[tortoise]. Since the hare goes fast,
* it would be the first to enter the cycle and run around the cycle.
* At some point, the tortoise enters the cycle as well,
* and since it's moving slower the hare catches up to the tortoise at some intersection point. Now phase 1 is over, and the tortoise has lost.

In phase 2, we give the tortoise a second chance by slowing down the hare, so that it now moves at the speed of tortoise:
* tortoise = nums[tortoise], hare = nums[hare].
* The tortoise is back at the starting position, and the hare starts from the intersection point.


 */