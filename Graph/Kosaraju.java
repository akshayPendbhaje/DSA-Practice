/*
**************** Problem Description ****************
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
First line of the custom input must contain two space separated integers V denoting the number of vertices and E denoting the number of edges.
Next E lines contains two space-separated integers denoting each edge.

    Example : 1

    Input:
    5 5
    1 0
    0 2
    2 1
    0 3
    3 4
    Output: 3
    Example : 2

    Input:
    3 3
    0 1
    1 2
    2 0
    Output: 1
*/

class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        Stack<Integer> s = new Stack<>();
        int ans=0;

        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                treverse(i,adj,visited,s);
            }
        }

        Arrays.fill(visited,false);
        ArrayList<ArrayList<Integer>> reverseAdj = new ArrayList<>(V);
        for(int i=0;i<V;i++)
        {
            reverseAdj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<V;i++)
        {
            ArrayList<Integer> original=adj.get(i);
            for(int neigh : original)
            {
                reverseAdj.get(neigh).add(i);
            }
        }

        //  System.out.println(adj);
//  System.out.println(reverseAdj);
//  System.out.println(s);

        while(!s.isEmpty())
        {
            int currentNode=s.pop();
            if(!visited[currentNode])
            {
                //  System.out.println(currentNode+" "+Arrays.toString(visited));

                ans++;
                reverseTreverse(currentNode,reverseAdj,visited);
            }

        }
        return ans;
    }

    public void treverse(int index,ArrayList<ArrayList<Integer>> adj,boolean[] visited,Stack<Integer> s) {
        if(visited[index]) return;

        visited[index]=true;
        for(int neighbor: adj.get(index))
        {
            if(!visited[neighbor])
            {
                treverse(neighbor,adj,visited,s);
            }
        }
        s.push(index);

    }

    public void reverseTreverse(int index,ArrayList<ArrayList<Integer>> reverseAdj,boolean[] visited) {
        if(visited[index]) return;
        visited[index] = true;

        // System.out.println(index+" "+reverseAdj.get(index));
        for(int neighbor: reverseAdj.get(index))
        {
            if(!visited[neighbor])
            { reverseTreverse(neighbor,reverseAdj,visited);}
        }
    }
}

/*
**************** Logic ****************
We can find all strongly connected components in O(V+E) time using Kosaraju’s algorithm. Following is detailed Kosaraju’s algorithm.
Do a DFS on the original graph, keeping track of the finish times of each vertex. This can be done with a stack, when some DFS finishes put the source vertex on the stack.
This way node with highest finishing time will be on top of the stack.
Reverse directions of all arcs to obtain the transpose graph.
Do DFS on the reversed graph, with the vertex on top of the stack and keep marking the vertices visited.
When DFS finishes, all vertices visited will form one Strongly Connected Component.
If any more vertex remains unvisited, this means there are more Strongly Connected Component's,
so pop vertices from top of the stack until a valid unvisited node is found. This step is repeated until all nodes are visited.

*/