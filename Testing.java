//import Countach.*;

import java.io.IOException;
import java.util.Scanner;

class Testing
{
    public static void main(String[] args)
    {
        System.out.println();
        Scanner hope = new Scanner(System.in);

        System.out.print("Number of vertices (max == 26): ");
        int big = hope.nextInt();
        vNames(big);

        System.out.print("\n\tStarting node of graph: ");
        String start = hope.next();
        System.out.println();

        WeightedAdjacencyMatrix wam = new WeightedAdjacencyMatrix(big, false);

        Graph graph = new Graph(wam, start);
        graph.BuildGraphFromWAM();
        graph.graphState();
        graph.graphTraversal();

        //disJointTests();
    }

    private static void disJointTests()
    {
        String[] command = { "xterm", "-e", "make clean" };

        try
        {
            Runtime.getRuntime().exec(command);
        }
        catch (IOException doTheTingsToMakeTheExceptionNotToBeDone)
        {
            doTheTingsToMakeTheExceptionNotToBeDone.getMessage();
        }
    }

    public static void vNames(int big)
    {
        int count = 0;  int ascii = 65;
        System.out.print("Vertices: ");

        while(count < big)
        {
            System.out.print((char) (ascii + count) + " ");
            count++;
        }
        System.out.println();
    }
}
