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
        // code here
        int left=0;
        int right=0;
        int ans=-1;

        Map<Character,Integer> count = new HashMap<>();

        while(right<s.length() && left<=right)
        {
            count.put(s.charAt(right),count.getOrDefault(s.charAt(right),0)+1);

            if(count.size()==k)
            {
                ans=Math.max(ans,right-left+1);
                right++;
            }
            else if(count.size()<k)
            {
                right++;
            }
            else
            {
                while(count.size()>k)
                {
                    count.put(s.charAt(left),count.getOrDefault(s.charAt(left),0)-1);
                    if(count.get(s.charAt(left))<=0)
                        count.remove(s.charAt(left));
                    left++;
                }
                right++;
            }
        }

        return ans;
    }
}

/*
**************** Logic ****************
Variable size sliding window.
Use map to store frequency of characters and a count variable to store number of unique characters in a window.
*/