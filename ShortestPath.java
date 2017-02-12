//package Countach;

public class ShortestPath
{
    private String start, end;
    private Double shortestPath;

    public ShortestPath()
    {

    }

    public ShortestPath(String S, String E, WeightedAdjacencyMatrix A)
    {
        start = S;
        end = E;
        shortestPath = 0.0;
    }
}
