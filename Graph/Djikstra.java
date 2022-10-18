/*
**************** Problem Description ****************
Given a weighted, undirected and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
Note: The Graph doesn't contain any negative weight cycle.
*/

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        int[] ans = new int[V];
        boolean[] visited= new boolean[V];
        pq.add(new Pair(S,0));

        while(!pq.isEmpty())
        {
            Pair cur= pq.remove();

            if(visited[cur.node])
            {
                continue;
            }

            visited[cur.node] = true;
            ans[cur.node] = cur.weight;

            for(ArrayList<Integer> neighbors : adj.get(cur.node))
            {
                if(!visited[neighbors.get(0)])
                    pq.add(new Pair(neighbors.get(0),neighbors.get(1)+cur.weight));
            }
        }

        return ans;
    }


}

class Pair implements Comparable<Pair>
{
    int node;
    int weight;

    public Pair(int node,int weight)
    {
        this.node=node;
        this.weight=weight;
    }

    public int compareTo(Pair other)
    {
        return this.weight-other.weight;
    }
}

