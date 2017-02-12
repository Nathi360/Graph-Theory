//package Countach;

import java.util.PriorityQueue;
import java.util.Stack;

public class Vertex
{
    final String vName;
    final Stack<Edge> edges;

    public Vertex(String N)
    {
        vName = N;
        edges = new Stack<>();
    }

    public void vertexDetails()
    {
        System.out.println("\tvName: " + vName + "  Neigh: " + this.getNeigh());
    }

    private String getNeigh()
    {
        String nay = "";

        for (int Y = 0; Y < edges.size(); Y++)
        {
            if(Y == (edges.size() - 1))
            {
                nay = nay.concat(edges.elementAt(Y).adjacentVertice);
            }
            else
            {
                nay = nay.concat(edges.elementAt(Y).adjacentVertice.concat(","));
            }
        }

        return nay;
    }

    private String getAdjVertex(int i)
    {
        if(i < edges.size())
        {
            return edges.elementAt(i).adjacentVertice;
        }

        return null;
    }

    public Boolean isSorted()
    {
        for (int R = 0; R < (edges.size() - 1); R++)
        {
            if(getAdjVertex(R).compareTo(getAdjVertex(R + 1)) > 0)
            {
                return false;
            }
        }

        return true;
    }
}
