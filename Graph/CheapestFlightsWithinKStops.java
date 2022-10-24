class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costs = new int[n];
        Arrays.fill(costs,99999);
        costs[src]=0;
        int[] temp=costs.clone();

        for(int i=0;i<=k;i++)
        {
            //temp=new int[n];
            for(int[] edge: flights )
            {
                int source= edge[0];
                int dest= edge[1];
                int cost = edge[2];

                if(temp[dest]> cost+costs[source])
                {
                    temp[dest]=cost+costs[source];
                }
            }
            //System.out.println(Arrays.toString(temp));
            //System.out.println(Arrays.toString(costs));
            costs=temp.clone();
        }
        return  costs[dst]==99999?  -1 :  costs[dst];
    }
}
