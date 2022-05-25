/*
**************** Problem Description ****************
Given a string s, we can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create. You can return the output in any order.
  
  
  Example 1 : 
  
  Input: s = "a1b2"
  Output: ["a1b2","a1B2","A1b2","A1B2"]
  
  
  Example 2 : 
  
  Input: s = "3z4"
  Output: ["3z4","3Z4"]
  
  
  Example 3 : 
  
  Input: s = "12345"
  Output: ["12345"]
  
  
  Example 4 : 
  
  Input: s = "0"
  Output: ["0"]
  
*/

class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        if(s == null || s.length() == 0)
        {
            return ans;
        }
        String stringSoFar="";
        helper(s,stringSoFar);
        return ans;
    }
    
    public void helper(String st,String ssf)
    {
        if(st.length()==0)
        {
            ans.add(ssf);
            return; 
        }
        
        if(Character.isDigit(st.charAt(0)))
        {
            ssf=ssf+st.charAt(0);
            st=st.substring(1);
            helper(st,ssf);
        }
        else
        {
            String ssf1=ssf+Character.toUpperCase(st.charAt(0));
            String ssf2=ssf+Character.toLowerCase(st.charAt(0));
            st=st.substring(1);
            helper(st,ssf1);
            helper(st,ssf2);
        }
    }
}

/*
**************** Logic ****************
For each character in the string except for numbers we can include it with a uppercase or lowecase.
*/