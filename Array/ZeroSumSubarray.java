/*
**************** Problem Description ****************
Given an array of positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.
    Example1 : 
    Input:
    5
    4 2 -3 1 6
    Output: Yes
    Explanation: 2, -3, 1 is the subarray with sum 0.
    Example2 : 
    Input:
    5
    4 2 0 1 6
    Output: Yes
    Explanation: 0 is one of the element in the array so there exist a subarray with sum 0.
*/






class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        HashSet<Integer> set = new HashSet<>();
        int sumTillNow=0;
        
        //Your code here
        for(int i:arr)
        {
            if(i==0)
                return true;
            sumTillNow+=i;
            if(sumTillNow==0)
                return true;
            if(set.contains(sumTillNow))
                return true;
            set.add(sumTillNow);
        }
        return false;
    }
}


/*
**************** Logic ****************
We need to check three things:
1. If our prefix subarray sum is 0 i.e -3 1 2 => -3 + 1 + 2 is 0 
2. If in between anywhere if we got sum equals to the previous sum present inside array i.e 4 2 -3 1 6 => 4 + 2 + -3 + 1 = 4 so it means already somewhwere we got 0 as sum
3. If 0 is present as an element
*/
