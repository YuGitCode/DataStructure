import java.io.*;
import java.util.Scanner;

public class FileIO{
    public LinkedList read()
    {
        String line;
        LinkedList list = new LinkedList();
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
                list.insertLast(line);
                line = bfr.readLine();
            }
            bfr.close();

            System.out.println( "File Finish Reading..." );
        }
        catch( IOException e )
        {
           System.out.println("File Error");
        }

        return list;
    }

}