/*
Question :
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int left=0;
        int right=0;
        
        HashMap<Character,Integer> pattern=new HashMap<>();
        HashMap<Character,Integer> text=new HashMap<>();
        
        for(int i=0;i<s1.length();i++)
        {
            pattern.put((Character)(s1.charAt(i)),(Integer)(pattern.getOrDefault(s1.charAt(i),0)+1));
        }
        
        while(right<s2.length())
        {
            
            text.put((Character)(s2.charAt(right)),(Integer)(text.getOrDefault(s2.charAt(right),0)+1));
            if(right-left+1<s1.length())
            {
                right++;
            }
            else if(right-left+1==s1.length())
            {
                if(isSubset(pattern,text))
                    return true;
                text.put((Character)(s2.charAt(left)),(Integer)(text.getOrDefault(s2.charAt(left),0)-1));
                
                left++;
                right++;
            }
            
        } 
        return false;
    }
    
    public static boolean isSubset(HashMap<Character,Integer> pattern,HashMap<Character,Integer> text)
    {
        for(Character ch: pattern.keySet())
        {
            if(!pattern.get(ch).equals(text.get(ch)))
            {
                //System.out.println(text);
                return false;
            }
        }
        return true;
    }
}

/* 
**************** Logic ****************
similar to anagram.
*/