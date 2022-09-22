import java.util.Scanner;
public class Main
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        
        BST tree = new BST();
        
        FileIO fileread = new FileIO();

        while(choice != 3)
        {
            System.out.println("\nSelect an Option:\n\n" + "(1) Read File and insert Tree Nodes\n"+
                                "(2) Display Tree\n(3) Exit");
            choice = sc.nextInt();
            System.out.print("\033[H\033[2J");
            switch(choice)
            {
                case 1:
                    fileread.read(tree);
                break;

                case 2:
                    tree.display();
                break;

                case 3:
                break;
            }
        }
        

    }
}