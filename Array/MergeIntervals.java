/*
**************** Problem Description ****************
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.
  Example : 
  Input:
  intervals = [[1,3],[2,6],[8,10],[15,18]]
  Output: [[1,6],[8,10],[15,18]]
  Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
  Input:
  intervals = [[1,4],[4,5]]
  Output: [[1,5]]
  Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        LinkedList<int[]> merged=new LinkedList<>();
        
        for(int[] curr:intervals)
        {
            if(merged.isEmpty()||merged.getLast()[1]<curr[0])
            {
                merged.add(curr);
            }
            else
            {
                merged.getLast()[1]=Math.max(merged.getLast()[1],curr[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

/* First sort the intervals based on start time of the interval in nlog n time and
 after sorting check the end time with next satrt time

/*OR can be done with the help of stack like below*/


class Solution {
    public int[][] merge(int[][] intervals) {
        
        Pair arr[]=new Pair[intervals.length];
        
        for(int i=0;i<intervals.length;i++)
        {
            arr[i]=new Pair(intervals[i][0],intervals[i][1]);
        }
        
        Arrays.sort(arr);
        Stack<Pair> stack=new Stack<>();
        
        for(int i=0;i<arr.length;i++)
        {
            //System.out.println(arr[i].st+"  "+arr[i].et);
            
            if(i==0)
            {
                stack.push(arr[i]);
            }
            else
            { 
                Pair temp=stack.peek();
                if(arr[i].st>temp.et)
                {                     
                    stack.push(arr[i]);
                }
                else
                {
                    temp.et=Math.max(temp.et,arr[i].et);
                }
            }
        }
        
        Stack<Pair> temp=new Stack<>();
        
        while(!stack.isEmpty())
        {
            temp.push(stack.pop());
        }
                

        //System.out.println(temp.size());
        
        int ans[][]=new int[temp.size()][2];

        int s = temp.size();        
        for (int i = 0; i < s; i++) {
            Pair p=temp.pop();
            //System.out.println(i+" "+p.st+"  "+p.et);
            ans[i][0]=p.st;
            ans[i][1]=p.et;
            
            
        }
        
        return ans;
    }
    
}

class Pair implements Comparable<Pair> {
    int st;
    int et;
    
    Pair(int i,int j)
    {
        this.st=i;
        this.et=j;
    }
    
    public int compareTo(Pair p)
    {
        if(this.st!=p.st)
        {
            return this.st-p.st;
        }
        else
        {
            return this.et-p.et;
        }
    }
    
    
}