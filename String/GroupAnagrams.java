/*
**************** Problem Description ****************
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
    Example : 1

    Input: strs = ["eat","tea","tan","ate","nat","bat"]

    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    Example : 2

    Input: strs = [""]

    Output: [[""]]
    Example : 3

    Input: strs = ["a"]
    Output: [["a"]]
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0)
            return new ArrayList();
        HashMap<String,List<String>> hm = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(String str: strs )
        {
            char[] chars= str.toCharArray();
            Arrays.sort(chars);
            String key=String.valueOf(chars);
            if(!hm.containsKey(key))
            {
                hm.put(key,new ArrayList<String>());
            }

            hm.get(key).add(str);
        }

        return new ArrayList(hm.values());
    }
}

/*
**************** Logic ****************
All the anagrams will be equal after sorting.
*/