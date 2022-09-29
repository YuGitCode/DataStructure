import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        DSAHashTable hashTable = new DSAHashTable(3);
        String key;
        String value;
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while(choice != 6)
        {

            System.out.println("[1] Read File\n[2] Display Table\n[3] Find by Key\n"+
        "[4] insert\n[5] remove\n[6] Exit");
            choice = sc.nextInt();
            System.out.print("\033[H\033[2J");
            switch(choice)
            {
                case 1:
                    hashTable = readFile(hashTable);
                break;

                case 2:
                    System.out.println("Displaying HashTable");
                    display(hashTable);
                break;

                case 3:
                    System.out.println("Finding By Key...");
                    System.out.print("Enter Key: ");
                    key = sc.next();
                    System.out.println("Value: "+hashTable.get(key));
                break;

                case 4:
                    System.out.println("Adding Item to HashTable");
                    System.out.print("Enter Key: ");
                    key = sc.next();
                    System.out.print("Enter Value: ");
                    value = sc.next();
                    hashTable.put(key,value);
                break;
                case 5:
                    System.out.println("Removing by key");
                    System.out.print("Enter Key: ");
                    key = sc.next();
                    hashTable.remove(key);;
                break;

                case 6:
                break;
            }
        }
        
    }

    public static DSAHashTable readFile(DSAHashTable hashTable)
    {
        FileIO fileIO = new FileIO();
        String[] split = new String[2];
        LinkedList list = fileIO.read();
        hashTable = new DSAHashTable(list.getCount());
        for(Object o: list)
        {
            try{
                String line = (String)o;
                split = line.split(",");
                hashTable.put(split[0],split[1]);    
            }catch(IllegalArgumentException e)
            {
                System.out.println(o + " Already exist in table");
            }
           
        }
        return hashTable;
    }

    public static void display(DSAHashTable table)
    {
        String[] items =  table.export();
        for(int i = 0; i< items.length; i++)
        {
            if( items[i] != null )
            {
                if(i%6==0)
                {
                    System.out.println();
                }else
                {
                    System.out.print("    " + items[i] + " | ");
                }
            }
           
        }
    }
}
