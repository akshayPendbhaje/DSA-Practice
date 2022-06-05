/*
**************** Problem Description ****************
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
  
  
  Example 1 : 
  
  Input: n = 3
  Output: ["((()))","(()())","(())()","()(())","()()()"]
  
  
  Example 2 : 
  
  Input: n = 1
  Output: ["()"]
  
*/

class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        
        int openParen=n;
        int closeParen=n;
        
        helper(openParen,closeParen,"");
        return ans;
    }
    
    void helper(int openCount,int closeCount,String parSoFar)
    {
        if(openCount==0 && closeCount==0)
        {
            ans.add(parSoFar);
            return;
        }
        
        if(openCount>0)
        {
            helper(openCount-1,closeCount,parSoFar+"("); 
        }
          if(openCount<closeCount)
        {
            helper(openCount,closeCount-1,parSoFar+")"); 
        }
        
        
    }
    
}


/*
**************** Logic ****************
Size of each result will be 2 * n. For each position we can choose '(' or ')'.
For a valid result, at any instance closed parentheses count should not be greater than open parentheses count.
Also count of open or closed parentheses cannot be greater than n.
*/