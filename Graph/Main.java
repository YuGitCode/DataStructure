import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        DSAGraph graph = new DSAGraph();
        Scanner sc = new Scanner(System.in);

        FileIO fileIO = new FileIO();
        
        int choice = 0;
        while(choice != 8)
        {

            System.out.println("[1] Read File\n[2] Display as List\n[3] Display as Matrix\n"+
        "[4] Depth First Search\n[5] Breadth First Search\n[6] Vertex Count\n[7] Edge Count\n[8] Exit");
            choice = sc.nextInt();
            System.out.print("\033[H\033[2J");
            switch(choice)
            {
                case 1:
                    graph = fileIO.read(graph);
                break;

                case 2:
                    System.out.println("Displaying as List");
                    graph.displayAsList();
                break;

                case 3:
                    System.out.println("Displaying as Matrix Form");
                    graph.displayAsMatrix();
                break;

                case 4:
                    System.out.println("Depth First Search");
                    graph.depthFirstSearch();
                break;
                case 5:
                    System.out.println("Breadth First Search");
                    graph.breadthFirstSearch();
                break;

                case 6:
                    System.out.println("Vertex Count: "+ graph.getVertexCount());
                    
                break;

                case 7:
                    System.out.println("Edge Count "+ graph.getEdgeCount());
                    
                break;
                case 8:
                break;
            }
        }

    }
    
}
