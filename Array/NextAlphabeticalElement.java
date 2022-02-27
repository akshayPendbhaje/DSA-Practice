/*
**************** Problem Description ****************
Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.
Note that the letters wrap around.
For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
    Example1 : 
    Input: letters = ["c","f","j"], target = "a"
    Output: "c"
    Example2 : 
    Input: letters = ["c","f","j"], target = "c"
    Output: "f"
    Example3 : 
    Input: letters = ["c","f","j"], target = "d"
    Output: "f"
    Example4 : 
    Input: letters = ["c","f","j"], target = "g"
    Output: "j"
    Example5 : 
    Input: letters = ["c","f","j"], target = "j"
    Output: "c"
*/

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int left=0;
        int right=letters.length-1; 
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            //System.out.println(left+" "+mid+" "+right);
            if(letters[mid]-'a'>target-'a')
            {
                right=mid-1;
            }
            else
            { 
                left=mid+1;
            }
        }
        left = left % letters.length;
        return letters[left];
    }
}


/*
**************** Logic ****************
Regular Binary search.
*/