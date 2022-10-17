/*
**************** Problem Description ****************
Given a starting vertex in graph, print the DFS traversal.
    Example : 1

    Input:
    4 6
    0 1
    0 2
    1 2
    2 0
    2 3
    3 3
    1

    Output:
    DFS Traversal Starting From Vertex 1 :
    1, 0, 2, 3,

*/

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans= new ArrayList<>();
        if(adj==null) return ans;
        boolean[] visited = new boolean[V];
        dfs(ans,visited,adj,0);

        return ans;
    }

    void dfs(ArrayList<Integer> ans,boolean[] visited,ArrayList<ArrayList<Integer>> adj,int vertex)
    {
        if(visited[vertex])
        {
            return;
        }
        ans.add(vertex);
        visited[vertex]=true;
        for(Integer connected: adj.get(vertex))
        {
            if(!visited[connected])
            {
                dfs(ans,visited, adj,connected);
            }
        }
    }
}