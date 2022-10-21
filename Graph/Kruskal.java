class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        // Add your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int ans = 0;
        int[] parent = new int[V+1];

        for(int i=0;i<V;i++)
        {
            ArrayList<ArrayList<Integer>> edges= adj.get(i);
            for(ArrayList<Integer> edge : edges)
                pq.add(new Pair(i,edge.get(0),edge.get(1)));
        }

        Arrays.fill(parent,-1);
        while(!pq.isEmpty())
        {
            Pair curr= pq.remove();
            int srcParent = getParent(curr.src,parent);
            int destParent = getParent(curr.dest,parent);

            if(srcParent!=destParent)
            {
                ans += curr.weight;


                parent[srcParent]=destParent;
            }
        }

        return ans;
    }

    static int getParent(int node,int [] parents){
        if (parents[node]<0) return node;

        return  getParent(parents[node],parents);
    }

}


class Pair implements Comparable<Pair>
{
    int src;
    int weight;
    int dest;
    public Pair(int src,int dest,int weight)
    {
        this.src=src;
        this.weight=weight;
        this.dest=dest;
    }

    public int compareTo(Pair other)
    {
        return this.weight-other.weight;
    }

    public String toString()
    {
        return "src "+this.src +" dest "+ +this.dest+" weight "+weight;
    }
}
