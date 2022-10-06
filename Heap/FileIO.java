import java.io.*;

public class FileIO{
    public DSAHeap read(DSAHeap heap)
    {
        String line;
        int count = 0;
        String[] lines = new String[7000];
        String fileName = "RandomNames7000.csv";
        System.out.println("Reading...RandomNames7000.csv"); 
        
        try
        {
            FileInputStream strm = new FileInputStream( fileName );
            InputStreamReader rdr = new InputStreamReader( strm );
            BufferedReader bfr = new BufferedReader( rdr );

            line = bfr.readLine();
            while( line != null )
            {

                lines[count] = line;
                count++;
                line = bfr.readLine();
            }


            for(int i = 0; i<count; i++)
            {
                String[] temp = lines[i].split(",");
                heap.add(Integer.parseInt(temp[0]), temp[1]);//Add item to heap
            }
            bfr.close();

            System.out.println( "item successfully inserted into Heap" );
        }
        catch( IOException e )
        {
           System.out.println("File Error");
        }

        return heap;
    }
}