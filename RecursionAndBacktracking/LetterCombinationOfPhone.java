/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]

*/

class Solution {
    public List<String> letterCombinations(String digits) {
         Map<String, String> phone = new HashMap<String, String>() {{
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
  }};
        
        if(digits.length()==0)
        {
            return new ArrayList<String>();
        }
        
        String curNum=String.valueOf(digits.charAt(0));
        String restNumbers=digits.substring(1);
        List<String> restOfComb=letterCombinations(restNumbers);
        ArrayList<String> ans= new ArrayList<>();
        
        String charset=phone.get(curNum); 
        for(int i=0;i<charset.length();i++)
        {
            char ch=charset.charAt(i);
            if(restOfComb.size()==0)
                ans.add(String.valueOf(ch));
            for(String s:restOfComb)
            {
                ans.add(ch+s);
            }
        }
        return ans;
    }
}

/* 
keep faith that for substring the combinations will be returned and once we get the combinations 
just add current charset in the same. 
*/