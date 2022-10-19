/*
**************** Problem Description ****************
Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.
*/

class Solution
{
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here

        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[V];

        for(int i=0;i<V;i++)
        {
            if(!visited[i])
                addSortedInStack(s,visited,adj,i);
        }
        int[] ans = new int[V];
        for(int i=0;i<V;i++)
        {
            ans[i]=s.pop();
        }
        //System.out.println(Arrays.toString(ans));
        return ans;
    }

    public static void addSortedInStack(Stack<Integer> s, boolean[] visited,ArrayList<ArrayList<Integer>> adj,int index )
    {
        if(visited[index]) return;

        visited[index]=true;
        for(int connected: adj.get(index))
        {
            if(!visited[connected])
                addSortedInStack(s,visited,adj,connected);
        }
        s.add(index);
    }
}
