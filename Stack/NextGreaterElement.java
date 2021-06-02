/*
**************** Problem Description ****************
Given an array arr[ ] of size N having distinct elements,
the task is to find the next greater element for each element of the array in order of their appearance in the array.
Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If there does not exist next greater of current element,
then next greater element for current element is -1. For example, next greater of the last element is always -1.
  Example : 
  Input: 
  N = 4, arr[] = [1 3 2 4]
  
  Output:
  3 4 4 -1
  Explanation:
  In the array, the next larger element 
  to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? 
  since it doesn't exist, it is -1.
*/

public class NextGreaterElement {

    // Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n) {
        // Your code here
        long[] ans = new long[n];
        Stack<Long> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                if (stack.peek() > arr[i]) {
                    ans[i] = stack.peek();
                } else {
                    while (!stack.isEmpty() && stack.peek() < arr[i]) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        ans[i] = -1;
                    } else {
                        ans[i] = stack.peek();
                    }
                }
            }
            stack.push(arr[i]);
        }
        return ans;
    }
}

/*
**************** Logic ****************
Iterate array in reverse order. Push the elements on the right side into stack.
Pop elements until top is smaller than current element or the stack is empty.
If stack becomes empty then no greater element exists on right side.
*/