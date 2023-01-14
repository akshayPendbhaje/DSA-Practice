/*
**************** Problem Description ****************
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
Return any possible rearrangement of s or return "" if not possible.
    Example : 1
    Input: s = "aab"
    Output: "aba"
    Example : 2
    Input: s = "aaab"
    Output: ""

*/

class Solution {
    public String reorganizeString(String s) {
        if(s.length()<1)
            return "";
        int maxFreq=0;
        char mostFreq=s.charAt(0);
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch:s.toCharArray())
        {
            int frequency  = map.getOrDefault(ch,0);
            frequency+=1;
            if(maxFreq<frequency)
            {
                maxFreq=frequency;
                mostFreq=ch;
            }
            if(2*maxFreq-1>s.length()) return "";
            map.put(ch,frequency);
        }

        char[] ans = new char[s.length()];
        int walker = 0 ;
        while(map.get(mostFreq)>0)
        {
            ans[walker]=mostFreq;
            walker+=2;
            map.put(mostFreq,map.get(mostFreq)-1);
        }

        for(char ch:s.toCharArray())
        {
            while(map.get(ch)>0)
            {
                if(walker>=s.length())
                    walker=1;
                ans[walker]=ch;
                walker+=2;
                map.put(ch,map.get(ch)-1);
            }
        }

        for(int i=1;i<ans.length;i++)
        {
            if(ans[i-1]==ans[i])
                return "";
        }

        return String.valueOf(ans);
    }
}

/*
**************** Logic ****************
We construct the resulting string in sequence: at position 0, 2, 4, ... and then 1, 3, 5, ...
In this way, we can make sure there is always a gap between the same characters
Consider this example: "aaabbbcdd", we will construct the string in this way:
a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
a b a _ a _ b _ b // fill in "b" at position 6, 8, 1
a b a c a _ b _ b // fill in "c" at position 3
a b a c a d b d b // fill in "d" at position 5, 7
*/