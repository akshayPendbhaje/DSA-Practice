/*
**************** Problem Description ****************
Given two integers n and r, find nCr. Since the answer may be very large, calculate the answer modulo 109+7.
    Example : 1
        
    Input: n = 3, r = 2
    Output: 3
    Explaination: 3C2 = 3. 
    Example : 2
    
    Input: n = 2, r = 4
    Output: 0
    
    Explaination: r is greater than n.
*/



class Solution{
    static int nCr(int n, int r)
    {
        if (r > n) return 0;
        
        if (n == r || r == 0) return 1;
        
        if (r == 1) return n;

        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        double mod = 1e9 + 7;

        for(int i=0;i<=n;i++)
        {
            ArrayList<Integer> row=new ArrayList<>();
            for(int j=0;j<=i;j++)
            {
                if(j==0 || j==i)
                {
                    row.add(1);
                }
                else
                {
                    row.add((int)((dp.get(i-1).get(j-1)+dp.get(i-1).get(j))%mod));
                }
            }
            dp.add(row);
        }
        
        return dp.get(n).get(r);
    }
}

/*
**************** Logic ****************
Use Pascal's triangle to calculate nCr.
*/
