/* 
Given a positive integer N, the task is to find all the N bit binary numbers having more than or equal 1’s than 0’s for any prefix of the number.

Example 1:

Input:  N = 2
Output: 11 10
Explanation: 11 and 10 have more than 
or equal 1's than 0's
Example 2:

Input:  N = 3
Output: 111 110 101
Explanation: 111, 110 and 101 have more 
than or equal 1's than 0's
*/

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> ans=new ArrayList<>();
    ArrayList<String> NBitBinary(int N) {
        // code here
        if(N==0)
            return ans;
            
        int ones=0;
        int zeros=0;
        helper(zeros,ones,N,"");
        return ans;
        
    }
    
    void helper(int zeros,int ones,int size,String numSoFar)
    {
        if(size==0)
        {
            ans.add(numSoFar);
            return;
        }
        
        helper(zeros,ones+1,size-1,numSoFar+"1");
        
        if(ones>zeros)
            helper(zeros+1,ones,size-1,numSoFar+"0");
        
    }
}

/*
**************** Logic ****************
until size is 0, keep adding digit recursively,
one can be added always, zero can be added only when ones are more than zeros.
maintian one zero count for this.

*/