/*
**************** Problem Description ****************
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars.
For simplicity, assume that all bars have the same width and the width is 1 unit.
  Example : 
  Input: 
  N = 7
  arr[] = {6,2,5,4,5,1,6}
  
  Output:
  12
*/

public class MaxAreaHistogram {
     
    public int largestRectangleArea(int[] heights) {
        int area=0;
        int n=heights.length;
        int[] nsl=new int[n];
        int[] nsr=new int[n];
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<n;i++)
        {
            
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
            {
                stack.pop();
            }
            nsl[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);            
        }
        
        stack.clear();
        
        
        for(int i=n-1;i>=0;i--)
        {
            
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
            {
                stack.pop();
            }
            nsr[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);            
        }
        
        stack.clear();
        
      //  System.out.println(Arrays.toString(nsr));
        //System.out.println(Arrays.toString(nsl));
        
        
        for(int i=0;i<n;i++)
        {
            //System.out.println(((nsr[i]-nsl[i])-1)*heights[i]);
            area=Math.max(area,(((nsr[i]-nsl[i])-1)*heights[i]));
        }
        
        return area;
        
        
    }
}

/*
**************** Logic ****************
Variation of Nearest Smaller to Left and Right problem.
Find nearest smaller to left and right for each index to calculate max rect width for each index.
*/
