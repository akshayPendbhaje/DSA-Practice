/*
**************** Problem Description ****************
Given a string you need to print the size of the longest possible substring that has exactly K unique characters.
If there is no possible substring then print -1.
  Example:
  Input:
  S = "aabacbebebe", K = 3
  Output: 7
  Explanation: "cbebebe" is the longest 
  substring with K distinct characters.
*/


class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left=0;
        int right=0;
         int max=-1;
        while(right<s.length()  ){
            
            map.put((Character)s.charAt(right),(Integer)(map.getOrDefault(s.charAt(right),0)+1));
            
            if(map.size()<k)
            {
                right++;
            }
            else if(map.size()==k)
            {
                max=Math.max(max,right-left+1);
                right++;
            }
            else if(map.size()>k){
                while(map.size()>k)
                {
                    map.put((Character)s.charAt(left),(Integer)(map.getOrDefault(s.charAt(left),0)-1));
                    if(map.get(s.charAt(left)) <= 0)
                        map.remove(s.charAt(left));
                    left++;
                }
                right++;
            }
        }
            return max;
    }
}

/*
**************** Logic ****************
Variable size sliding window.
Use map to store frequency of characters and a count variable to store number of unique characters in a window.
*/