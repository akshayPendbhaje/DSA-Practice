/*
**************** Problem Description ****************
You are given N number of books. Every ith book has Ai number of pages. 
You have to allocate contagious books to M number of students. There can be many ways or permutations to do so.
In each permutation, one of the M students will be allocated the maximum number of pages. Out of all these permutations,
the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations and print this minimum value. 
Each book will be allocated to exactly one student. Each student has to be allocated at least one book.
Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).
    Example1 : 
    Input:
    N = 4
    A[] = {12,34,67,90}
    M = 2
    Output: 113
    Explanation: 
    Allocation can be done in following ways:
    {12} and {34, 67, 90} Maximum Pages = 191
    {12, 34} and {67, 90} Maximum Pages = 157
    {12, 34, 67} and {90}  Maximum Pages =113
    Therefore, the minimum of these cases is 113, which is selected as the output.
    Example2 : 
    Input:
    N = 3
    A[] = {15,17,20}
    M = 2
    Output: 32
    Explanation: Allocation is done as {15,17} and {20}
*/

// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java
class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        int ans=-1;
        if(M>N)
            return ans;
            
        int max=Integer.MIN_VALUE;;
        for(int i:A)
        {
            max=Math.max(max,i);
        }
        
        int sum=0;
        for(int i:A)
        {
            sum+=i;
        }
        
        while(max<=sum)
        {
            int mid=max+(sum-max)/2;
            
            if(isValid(A,N,M,mid))
            {
                ans=mid;
                sum=mid-1;
            }
            else 
            {
                max=mid+1;
            }
        }
        return ans;
    }
    
    
    public static boolean isValid(int[] Ar,int N , int M,int mid)
    {
        int student=1;
        int sum=0;
        for(int i:Ar)
        {
            sum+=i;
            if(sum>mid)
            {
                sum=i;
                student+=1;
            }
            
            if(student>M)
                return false;
        }
        return true;
    }
};

/*
**************** Logic ****************
We fix a value for the number of pages as mid of current minimum and maximum.
We initialize minimum and maximum as max of all pages and sum-of-all-pages respectively.
If a current mid can be a solution, then we search on the lower half, else we search in higher half.
*/