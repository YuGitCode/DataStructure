import java.io.*;

public class FileIO{
    public void read(BST tree)
    {
        String line;
        String[] split = new String[2];
        String fileName = "TreeNode.txt";
        System.out.println("Reading...TreeNode.txt"); 
        
        try
        {
            FileInputStream strm = new FileInputStream( fileName );
            InputStreamReader rdr = new InputStreamReader( strm );
            BufferedReader bfr = new BufferedReader( rdr );

            line = bfr.readLine();
            while( line != null )
            {
                split = line.split(",");
                tree.insert( split[0], split[1] );

                line = bfr.readLine();
            }
            bfr.close();

            System.out.println( "Node successfully inserted into Tree" );
        }
        catch( IOException e )
        {
           System.out.println("File Error");
        }
    }
}