import java.util.Scanner;
public class Main {
    public static void main(String[]args)
    {
        DSAHeap test = new DSAHeap(10);
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        DSAHeap heap = new DSAHeap(7000);
        FileIO fileRead = new FileIO();

        while(choice != 5)
        {
            System.out.println("\nSelect an Option:\n\n" + "(1) Read File and insert item and sort by heapify\n"+
            "(2) Display Heap\n(3) Add item\n(4) Remove top item\n(5) Exit");
            choice = sc.nextInt();
            System.out.print("\033[H\033[2J");
            switch(choice)
            {
                case 1:
                    heap = fileRead.read(heap);
                    heap.heapSort();
                break;

                case 2:
                    heap.display();
                break;

                case 3:
                    System.out.print("Prioity Number: ");
                    int prio = sc.nextInt();
                    System.out.print("value: ");
                    String value = sc.next();
                    heap.add(prio, value);
                break;

                case 4:
                    heap.remove();
                break;
                
                case 5:
                break;
            }
        }


    }
}
