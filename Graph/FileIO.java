import java.io.*;
import java.util.Scanner;

public class FileIO{
    public DSAGraph read(DSAGraph graph)
    {
        String line;
        String[] split = new String[2];
        String fileName = "";
        System.out.print("Enter file name...");  
        Scanner sc = new Scanner(System.in);
        fileName = sc.nextLine();
        try
        {
            FileInputStream strm = new FileInputStream( fileName );
            InputStreamReader rdr = new InputStreamReader( strm );
            BufferedReader bfr = new BufferedReader( rdr );

            line = bfr.readLine();
            while( line != null )
            {
                split = line.split(" ");
                graph.addEdge(split[0], split[1]);
                line = bfr.readLine();
            }
            bfr.close();

            System.out.println( "Vertex successfully inserted into Tree" );
        }
        catch( IOException e )
        {
           System.out.println("File Error");
        }

        return graph;
    }

}