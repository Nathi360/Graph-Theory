//package Countach;

class Edge
{
    private Double edgeWeight;
    final String adjacentVertice;

    public Edge(Double l, String AV)
    {
        edgeWeight = l;
        adjacentVertice = AV;
    }

    public void setEdgeWeight(Double w)
    {
        edgeWeight = w;
    }

    public Double getEdgeWeight()
    {
        return edgeWeight;
    }
}
