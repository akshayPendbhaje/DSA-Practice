/*
**************** Problem Description ****************
Given a binary matrix.
Find the maximum area of a rectangle formed only of 1s in the given matrix.
  Example : 
  Input: 
  n = 4, m = 4
  M[][] = {{0 1 1 0},
          {1 1 1 1},
          {1 1 1 1},
          {1 1 0 0}}
  
  Output: 8
  Explanation: For the above test case the matrix will look like
  
  0 1 1 0
  1 1 1 1
  1 1 1 1
  1 1 0 0
  the max size rectangle is 
  1 1 1 1
  1 1 1 1
  
  and area is 4 *2 = 8.
*/

public class MaxAreaRectInBinaryMatrix { 
    public int maximalRectangle(char[][] matrix) {
     
        if (matrix.length==0) return 0;
        
        int m=matrix.length;
        int n=matrix[0].length;
        int ans=Integer.MIN_VALUE;
        int temp[][]=new int[m][n];
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]=='1')
                    temp[i][j]=(i==0)?1:temp[i-1][j]+1;
            }
        }
        
        for(int i=0;i<m;i++)
        {
            ans=Math.max(ans,mah(temp[i]));
        } 
        
        return ans;
    }
    
    public static int mah(int[] heights)
    {
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
Variation of max rectangular area in histogram.
Consider each row as a histogram and calculate max area for each row.
The max value among all the rows will be the answer.
*/