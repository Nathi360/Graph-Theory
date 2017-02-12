//package Countach;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class WeightedAdjacencyMatrix
{
    protected enum V { A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z }

    int mSize;
    Double[][] AM;
    boolean directed;
    Boolean hasCycles;

    public WeightedAdjacencyMatrix(int big, boolean mode)
    {
        this.mSize = big;
        this.directed = mode;
        this.AM = new Double[big][big];

        for (int R = 0; R < big; R++)
        {
            for (int C = 0; C < big; C++)
            {
                AM[R][C] = 0.0;
            }
        }

        setEdgeWeights();
        PrintMatrix();

        hasCycles = cyclicOrNah();
    }

    private void setEdgeWeights()
    {
        if(directed)
        {
            System.out.println("Directed Graph\n");
        }
        else
        {
            System.out.println("Undirected Graph\n");
        }

        Scanner res = new Scanner(System.in);

        if(directed)
        {
            for (int R = 0; R < mSize; R++)
            {
                for (int C = 0; C < mSize; C++)
                {
                    System.out.print(V.values()[R] + "->" + V.values()[C] + ": ");
                    AM[R][C] = res.nextDouble();
                }
            }
        }
        else
        {
            Symmetrix trix = new Symmetrix(mSize);

            for (int T = 0; T < trix.size; T++)
            {
                System.out.print(V.values()[trix.rows[T]] + "-" + V.values()[trix.colls[T]] + ": ");
                AM[trix.rows[T]][trix.colls[T]] = AM[trix.colls[T]][trix.rows[T]] = res.nextDouble();
            }
        }

        res.close();
    }

    private void PrintMatrix()
    {
        System.out.println("\nWeightedAdjacencyMatrix: \n");

        for (int R = 0; R < mSize; R++)
        {
            if(R == 0)
            {
                System.out.print("\t    ");

                for (int D = 0; D < mSize; D++)
                {
                    System.out.print(V.values()[D] + "    ");
                }
                System.out.println();
            }

            for (int C = 0; C < mSize; C++)
            {
                if(C == 0)
                {
                    System.out.print("\t" + V.values()[R] + "  ");
                }

                System.out.print(AM[R][C] + "  ");
            }
            System.out.println();
        }
        //System.out.println();
    }

    public String getVName(int index)
    {
        return V.values()[index].name();
    }

    public int getVerticeIndex(String dest)
    {
        for (int T = 0; T < mSize; T++)
        {
            if(V.values()[T].name().equals(dest))
            {
                return T;
            }
        }

        System.out.println("404: Vertex not found");
        return -1;
    }

    private Boolean cyclicOrNah()
    {
        int count = 0;

        if(!AM.equals(null))
        {
            for (int R = 0; R < mSize; R++)
            {
                for (int C = 0; C < mSize; C++)
                {
                    if(!AM[R][C].equals(0.0))
                    {
                        count++;
                    }
                }
            }

            if((count/2) > (mSize - 1))
            {
                return true;
            }
        }

        return false;
    }
}
