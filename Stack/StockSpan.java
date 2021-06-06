/*
**************** Problem Description ****************
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day,
for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.
  Example : 
  Input: 
  N = 7, price[] = [100 80 60 70 60 75 85]
  
  Output:
  1 1 1 2 1 4 6
  Explanation:
  Traversing the given input span for 100 
  will be 1, 80 is smaller than 100 so the 
  span is 1, 60 is smaller than 80 so the 
  span is 1, 70 is greater than 60 so the 
  span is 2 and so on. Hence the output will 
  be 1 1 1 2 1 4 6.
*/


// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class StockSpan
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while(t-- > 0)
            {
                int n =sc.nextInt();
                int a[] = new int[n];
                
                int i = 0;
                for(i = 0; i < n; i++)
                  a[i] = sc.nextInt();
                  
                int[] s = new Solution().calculateSpan(a, n);
                
                for(i = 0; i < n; i++)
                {
                    System.out.print(s[i] + " ");
                }
                
                System.out.println();
            }
        }
        
        
        
    }// } Driver Code Ends
    
    
    
    
    
    class Solution
    {
        //Function to calculate the span of stockâ€™s price for all n days.
        public static int[] calculateSpan(int price[], int n)
        {
            int[] ans= new int[n];
            int[] ngl=new int[n];
            Stack<Integer> stack=new Stack<>();
            
            for(int i=0;i<n;i++)
            {
                while(!stack.isEmpty() && price[stack.peek()]<=price[i])
                {
                    stack.pop();
                }
                ngl[i]=stack.isEmpty()?-1:stack.peek();
                stack.push(i);
            }
            
            for(int i=0;i<n;i++)
            {
                ans[i]=i-ngl[i];
            }
             
            
            return ans;
        }
        
    }

    /*
**************** Logic ****************
Variation of Nearest Greater to Left problem. Add array index in stack instead of elements.
*/