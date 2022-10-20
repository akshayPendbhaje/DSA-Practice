/*
**************** Problem Description ****************
Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors such that no two adjacent vertices of the graph are colored with the same color.
Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is possible to colour vertices and 0 otherwise.

    Example : 1

    Input:
    N = 4
    M = 3
    E = 5
    Edges[] = {(0,1),(1,2),(2,3),(3,0),(0,2)}

    Output: 1
    Explanation: It is possible to colour the given graph using 3 colours.
    Example : 2

    Input:
    N = 3
    M = 2
    E = 3
    Edges[] = {(0,1),(1,2),(0,2)}
    Output: 0
*/


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here

        int[] colors = new int[n];

        return colorGraph(graph,colors,m,n,0);
    }

    public boolean colorGraph(boolean[][] graph,int[] colors,int m ,int n,int index)
    {
        if(index==n)
            return true;

        for(int i=1;i<=m;i++)
        {
            if(isValidColor(graph,colors,n,index,i))
            {
                colors[index]=i;
                if(colorGraph(graph,colors,m,n,index+1)) return true;
                colors[index]=0;
            }
        }

        return false;
    }

    public boolean isValidColor(boolean[][] graph,int[] colors,int n,int index,int toColor)
    {
        for(int i=0;i<n;i++)
        {if(index!=i && graph[index][i] && colors[i]==toColor) return false;
        }
        return true;
    }
}

/*
**************** Logic ****************
The idea is to assign colours one by one to different vertices, starting from the vertex 0.
Before assigning a colour, we check for safety by considering already assigned colours to the adjacent vertices.
If we find a colour assignment which is safe, we mark the colour assignment as part of a solution. If we do not a find colour due to clashes then we backtrack and return false.
*/