//package Countach;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/*
    This class models a Graph Structure by translating a "WAM"
    to a collection of "Vertex's/Vertices" and then performing
    numerous graph operations on the Graph Structure.
 */

public class Graph
{
    private final WeightedAdjacencyMatrix WAM;
    private final Stack <Vertex> graph;
    private final String startV;

    protected ShortestPath SP;
    protected SpanningTree ST;
    protected TopologicalSort TS;
    protected BFS bfs;
    protected DFS dfs;

    public Graph(WeightedAdjacencyMatrix wam, String start)
    {
        WAM = wam;
        startV = start;
        graph = new Stack<>();
    }

    public void BuildGraphFromWAM()
    {
        if(WAM.directed)
        {
            System.out.println();
        }
        else
        {
            for (int A = 0; A < WAM.mSize; A++)
            {
                graph.push(new Vertex(WAM.getVName(A)));
            }

            for (int A = 0; A < graph.size(); A++)
            {
                constructEdges(graph.elementAt(A).vName);
            }
            System.out.println();
        }
    }

    private void constructEdges(String from)
    {
        int R = WAM.getVerticeIndex(from);

        for (int C = 0; C < WAM.mSize; C++)
        {
            if(!WAM.AM[R][C].equals(0.0))
            {
                setEdges(from, new Edge(WAM.AM[R][C], WAM.getVName(C)));
            }
        }
    }

    private void setEdges(String target, Edge lam)
    {
        for (int B = 0; B < graph.size(); B++)
        {
            if(graph.elementAt(B).vName.equals(target))
            {
                graph.elementAt(B).edges.push(lam);
            }
        }
    }

    public void graphState()
    {
        Iterator <Vertex> trav = graph.iterator();

        while (trav.hasNext())
        {
            trav.next().vertexDetails();
        }
        System.out.println("\nCyclic: " + WAM.hasCycles);
    }

    public void graphTraversal()
    {
        dfs = new DFS(graph, startV);
        bfs = new BFS(graph, startV);


    }
}