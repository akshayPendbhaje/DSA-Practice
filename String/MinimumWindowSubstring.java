/*
**************** Problem Description ****************
Given two strings s and t of lengths m and n respectively,
return the minimum window in s which will contain all the characters in t.
If there is no such window in s that covers all characters in t, return the empty string "".
Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
    Example 1:
    Input: s = "ADOBECODEBANC", t = "ABC"
    Output: "BANC"
    Example 2:
    Input: s = "a", t = "a"
    Output: "a"
*/
class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length(), count = 0, minWindow = Integer.MAX_VALUE;;
        String res = "";
        int left = 0 ,right = 0;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (char c : t.toCharArray())
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);

        while ( right < m) {
            mapS.put(s.charAt(right), mapS.getOrDefault(s.charAt(right), 0) + 1);

            if (mapT.containsKey(s.charAt(right)) && mapS.get(s.charAt(right)) <= mapT.get(s.charAt(right)))
            {
                count++;
            }
            while (count == n) {
                if (minWindow > right - left + 1) {
                    minWindow = right - left + 1;
                    res = s.substring(left, right + 1);
                }

                char curr = s.charAt(left);

                if (mapS.get(curr) == 1) mapS.remove(curr);
                else mapS.put(curr, mapS.get(curr) - 1);

                left++;

                if (mapT.containsKey(curr) && mapS.getOrDefault(curr, 0) < mapT.get(curr)) count--;
            }
            right++;
        }
        return res;
    }
}

/*
**************** Logic ****************
Variable size sliding window.
Use map to store frequency of characters in pattern and a count variable to store character count in the window to avoid traversing the map.
If the frequency of character in map becomes 0, then decrement count. When count is equal to 0, a candidate substring is found.
*/