//package Countach;

/*
    This class is used in initializing an Undirected Graph.
    Since the "WAM" of an Undirected Graph is symmetrical
    about the line "y = -x" (the diagonal going from [0][0] to
    [n - 1][n - 1]), there is no need to prompt the user for
    input of all "n X n" entries of the "WAM". Instead we can
    request input for either the upper or lower half and use
    symmetry to initialize the other half.
 */

public class Symmetrix
{
    public int size;
    public final int [] rows;
    public final int [] colls;
    private final int matrixSize;

    public Symmetrix(int Z)
    {
        size = 0;   matrixSize = Z;

        for(int G = (Z - 1); G >= 1; G--)
        {
            size += G;
        }

        rows = new int[size];
        colls = new int[size];

        this.job();
    }

    public Symmetrix job()
    {
        int tC = 0;

        for (int R = 0; R < matrixSize; R++)
        {
            for (int C = 0; C < matrixSize; C++)
            {
                if(C > R)
                {
                    rows[tC] = R;
                    colls[tC] = C;
                    tC++;
                }
            }
        }

        return this;
    }
}
