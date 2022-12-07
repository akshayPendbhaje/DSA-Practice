/*
**************** Problem Description ****************
Given a word pat and a text txt.
Return the count of the occurences of anagrams of the word in the text.
  Example :
  Input:
  txt = forxxorfxdofr
  pat = for
  Output: 3

  Explanation: for, orf and ofr appears
  in the txt, hence answer is 3.
*/


class Solution {

    int search(String pat, String txt) {
        // code here
        int left=0;
        int right=0;
        int ans=0;

        HashMap<Character,Integer> pattern = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(char ch:pat.toCharArray())
        {
            pattern.put(ch,pattern.getOrDefault(ch,0)+1);
        }
        while(right<txt.length())
        {
            window.put(txt.charAt(right),window.getOrDefault(txt.charAt(right),0)+1);

            if(right-left+1<pat.length())
            {
                right++;
            }
            else if(right-left+1==pat.length())
            {
                if(areAnagram(pattern,window))
                    ans++;

                window.put(txt.charAt(left),window.getOrDefault(txt.charAt(left),0)-1);
                left++;
                right++;
            }
        }

        return ans;
    }

    public boolean areAnagram(HashMap<Character,Integer> pattern,HashMap<Character,Integer> window)
    {
        // System.out.println(pattern+" "+window);
        for(char ch:pattern.keySet())
        {
            if(!pattern.get(ch).equals(window.get(ch)))
                return false;
        }
        return true;
    }
}

/*
**************** Logic ****************
Sliding window. Create map for anagram to store char and frequency.
Create a count variable to store distinct char count and to avoid traversing map for checking anagram.
*/